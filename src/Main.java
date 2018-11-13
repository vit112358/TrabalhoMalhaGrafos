import Control.GraphOP.Controls;
import Control.GraphOP.rotaCaixeiro.GeneticAlgorithm;
import Control.GraphOP.rotaCaixeiro.Populacao;
import Control.GraphOP.rotaCaixeiro.RotaManager;
import Control.IO.Leitura;
import Model.AuxStruct.Aeroporto;
import Model.AuxStruct.Voo;
import Model.Estrutura;
import Model.GraphRota.Vertex;

import javax.swing.JOptionPane;
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

        System.out.println("==============Programa de Demonstração de Rotas Aéreas============================");
        System.out.println("\n");
        System.out.println("==============Por Vitor Fernandes e Patricia Pieroni==============================");
        System.out.println("\n");
        System.out.println("==================================Menu============================================");
        System.out.println("==============11 -> Mostrar Rotas e Voos ========================================");
        System.out.println("==============12 -> Mostrar Rota enre 2 aeroportos ==============================");
        System.out.println("==============2 -> Mostrar Voos Diretos ==========================================");
        System.out.println("==============3 -> Viagem de Menor Custo entre 2 destinos ========================");
        System.out.println("==============4 -> Cobertura de Aeroportos =======================================");
        System.out.println("==============5 -> Tempo Minímo ==================================================");
        System.out.println("==============0 -> Sair ==========================================================");
        int op=-1;
        while(op!=0){
            op = Integer.parseInt(JOptionPane.showInputDialog("Digite o Código"));
            switch (op){
                case 11:
                    break;
                case 12:
                    List<Voo> v=c.buscaVoosDiretos(e);
                    for (Voo voo:v) {
                        System.out.println(voo.toString());
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    for (Map.Entry<String, Vertex> aeroporo: e.getRotas().getVertices().entrySet()) {
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
                    break;
                case 0:
                    break;
            }
        }
    }
}
