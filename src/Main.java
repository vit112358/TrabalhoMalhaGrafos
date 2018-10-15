import Control.IO.Leitura;
import Model.t;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Leitura l = new Leitura();

        List<t> result = new ArrayList<>();
        
        File f = new File("C:\\Users\\vitor\\Downloads\\2017113_125442_map.txt");
        
        result = l.readFile(f);

        for (t item: result
             ) {
            System.out.println("Item: "+item.getN1()+" "+item.getN2()+" "+item.getN3()+" ");
        }

        System.out.println("Tamanho: "+result.size());
    }
}
