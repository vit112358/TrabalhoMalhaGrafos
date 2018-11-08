package Control.IO;

import Model.AuxStruct.Aeroporto;
import Model.Graph.Edges;
import Model.Graph.Graph;
import Model.Graph.Vertex;
import org.jetbrains.annotations.NotNull;

import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Leitura {

    private String tipoLeitura = "";

    public Graph readFile(File caminho){
        String tipo;
        Map<String, Vertex> vertices = new HashMap<>();
        List<Edges> arestas = new ArrayList<>();
        Graph rota = new Graph(1,"rotas", vertices, arestas,false);

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
                                Aeroporto a = new Aeroporto(valores[0], valores[1], Integer.parseInt(valores[2]),Integer.parseInt(valores[3]), valores[4]);
                                Vertex vertice = new Vertex(a.getAbreviation(),a);
                                vertices.put(a.getAbreviation(),vertice);
                            }
                            break;
                        case("rota"):
                            if((!(linha.contains("!"))) && (!(linha.equals("")))){
                                String[] valores = linha.split("\\s+");
                                Vertex origem = vertices.get(valores[0]);
                                Vertex destino = vertices.get(valores[1]);
                                Edges aresta = new Edges(arestas.size()+1,origem,destino, (long)0);
                                arestas.add(aresta);
                            }
                            break;
                        case("agenda"):
                            if(!(linha.startsWith("#"))){

                            }
                            break;
                        default:
                            break;
                    }
                }
                rota.setVertices(vertices);
                rota.setArestas(arestas);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler o Caminho! "
                    + "Verifique o caminho", "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Leitura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Leitura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rota;
    }

    private String confereTipo(@NotNull String linha){
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
}
