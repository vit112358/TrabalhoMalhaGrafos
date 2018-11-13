import Control.GraphOP.Controls;
import Control.GraphOP.rotaCaixeiro.GeneticAlgorithm;
import Control.GraphOP.rotaCaixeiro.Populacao;
import Control.GraphOP.rotaCaixeiro.RotaManager;
import Control.IO.Leitura;
import Model.AuxStruct.Aeroporto;
import Model.AuxStruct.Voo;
import Model.Estrutura;
import Model.GraphRota.Vertex;

import java.io.File;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Leitura l = new Leitura();

        File f = new File("C:\\Users\\vitor\\Documents\\NetBeansProjects\\TrabalhoED2\\voos.txt");
        
        Estrutura e = l.readFile(f);
        Controls c = new Controls();
        List<Voo> v=c.buscaVoosDiretos(e);

        for (Voo vo:v) {
            System.out.println(vo.toString());
        }

        System.out.println("Tamanho: "+ v.size());

        LocalTime a = LocalTime.of(11,00);
        LocalTime b = LocalTime.of(12,01);

        System.out.println(c.calculaDiferencaTempo(b,a));

        List<Aeroporto> aero = new ArrayList<>();

        for (Map.Entry<String, Vertex> aeroporo: e.getRotas().getVertices().entrySet()) {
           //aero.add(aeroporo.getValue().getAeroporto());
            RotaManager.addAirport(aeroporo.getValue().getAeroporto());
        }

        Populacao p = new Populacao(50, true, e);

        System.out.println("Distância inicial: " + (int)p.getFittest().getDistance());

        //Evoluí a população por 200 gerações
        for (int i = 0; i < 200; i++) {
            p = GeneticAlgorithm.evolvePopulation(p);
        }

        //Imprime o comprimento da melhor rota da população final
        System.out.println("Distância final: " + (int)p.getFittest().getDistance());
        //Imprime a solução encontrada para o problema
        System.out.println("Solução:");
        System.out.println(p.getFittest());
    }
}
