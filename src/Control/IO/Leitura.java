package Control.IO;

import Control.GraphOP.Ponto;
import Model.AuxStruct.Aeroporto;
import Model.AuxStruct.Voo;
import Model.Estrutura;
import Model.GraphRota.Edges;
import Model.GraphRota.Graph;
import Model.GraphRota.Vertex;
import Model.graphVoos.GraphVoo;

import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Leitura {

    private String tipoLeitura = "";

    public Estrutura readFile(File caminho){
        String tipo;
        Map<String, Vertex> vertices = new HashMap<>();
        List<Edges> arestas = new ArrayList<>();
        Graph rota = new Graph(1, vertices, arestas);
        List<Voo> listaVoos = new ArrayList<>();
        GraphVoo voos = new GraphVoo(2, listaVoos);
        Estrutura estruturaGrafos = new Estrutura();
        try {
            try (BufferedReader meuBuffer = new BufferedReader(new FileReader(caminho))) {
                String linha;
                //enquanto eu conseguir ler o arquivo faço algo
                while (meuBuffer.ready()) {
                    //lendo a linha
                    linha = meuBuffer.readLine();

                    tipo = confereTipo(linha);

                    switch (tipo){
                        case("aeroporto"):
                            if (!(linha.startsWith("#"))){
                                //quebrando a linha
                                String[] valores = linha.split("\\s+");
                                if (valores.length>5){
                                    StringBuilder sb = new StringBuilder();
                                    for (int i = 4;i<valores.length;i++){
                                        sb.append(valores[i]);
                                        sb.append(" ");
                                    }
                                    valores[4] = sb.toString();
                                }
                                Ponto p = new Ponto(Integer.parseInt(valores[2]),Integer.parseInt(valores[3]));
                                Aeroporto a = new Aeroporto(valores[0], valores[1], p, valores[4]);
                                Vertex vertice = new Vertex(a.getAbreviation(),a);
                                vertices.put(a.getAbreviation(),vertice);
                            }
                            break;
                        case("rota"):
                            if((!(linha.contains("!"))) && (!(linha.equals("")))){
                                String[] valores = linha.split("\\s+");
                                Vertex origem = vertices.get(valores[0]);
                                Vertex destino = vertices.get(valores[1]);
                                Edges aresta = new Edges(arestas.size()+1,origem,destino);
                                arestas.add(aresta);
                            }
                            break;
                        case("agenda"):
                            if(!(linha.startsWith("#"))){
                                String[] valores = linha.split("\\s+");
                                LocalTime lt1 = converteStringToDateTime(valores[3]);
                                LocalTime lt2 = converteStringToDateTime(valores[5]);
                                Voo v = new Voo(valores[0],valores[1],findAeroporto(valores[2],vertices),lt1,findAeroporto(valores[4],vertices),lt2,Integer.parseInt(valores[7]));
                                listaVoos.add(v);
                            }
                            break;
                        default:
                            break;
                    }
                }
                rota.setVertices(vertices);
                rota.setArestas(arestas);
                voos.setArestas(listaVoos);
                estruturaGrafos.setRotas(rota);
                estruturaGrafos.setVoos(voos);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler o Caminho! "
                    + "Verifique o caminho", "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Leitura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Leitura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estruturaGrafos;
    }

    private String confereTipo(String linha){
        if (linha.contains("#Airport information - USA")){
            tipoLeitura = "aeroporto";
        }else if(linha.startsWith("!")){
            tipoLeitura = "rota";
        }else if(linha.contains("#Airplane information")){
            tipoLeitura = "aviao";
        }else if(linha.contains("#Airline Flight Schedule - USA")){
            tipoLeitura = "agenda";
        }

        return tipoLeitura;
    }

    private LocalTime converteStringToDateTime(String hora){
        char[] parteHoras = hora.toCharArray();
        int pHora = 0;
        int pMin = 0;
        if(parteHoras[parteHoras.length-1] == 'P'){
            if(Integer.parseInt(hora.substring(0,hora.length()-3))+12 == 24){
                pHora = 0;
            }else{
                pHora = Integer.parseInt(hora.substring(0,hora.length()-3))+12;
            }
            pMin = Integer.parseInt(hora.substring(hora.length()-3,hora.length()-1));
        }else{
            pHora = Integer.parseInt(hora.substring(0,hora.length()-3));
            pMin = Integer.parseInt(hora.substring(hora.length()-3,hora.length()-1));
        }
        return  LocalTime.of(pHora,pMin);
    }

    private Aeroporto findAeroporto(String codAeroporto, Map<String, Vertex> vertices){
        return vertices.get(codAeroporto).getAeroporto();
    }
}
