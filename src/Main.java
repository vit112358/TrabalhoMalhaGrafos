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

        System.out.println("==============Programa de Demonstração de Rotas Aéreas============================");
        System.out.println("\n");
        System.out.println("==============Por Vitor Fernandes e Patricia Pieroni==============================");
        System.out.println("\n");
        System.out.println("==================================Menu============================================");
        System.out.println("==============1.1 -> Mostrar Rotas e Voos ========================================");
        System.out.println("==============1.2 -> Mostrar Rota enre 2 aeroportos ==============================");
        System.out.println("==============2 -> Mostrar Voos Diretos ==========================================");
        System.out.println("==============3 -> Viagem de Menor Custo entre 2 destinos ========================");
        System.out.println("==============4 -> Cobertura de Aeroportos =======================================");
        System.out.println("==============5 -> Tempo Minímo ==================================================");

        int op=-1;

    }
}
