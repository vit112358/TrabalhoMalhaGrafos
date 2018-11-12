import Control.GraphOP.Controls;
import Control.IO.Leitura;
import Model.AuxStruct.Voo;
import Model.Estrutura;

import java.io.File;
import java.time.LocalTime;
import java.util.List;
import java.util.Locale;

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
    }
}
