import Control.IO.Leitura;
import Model.t;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Leitura l = new Leitura();

        File f = new File("C:\\Users\\vitor\\Downloads\\voos.txt");
        
        l.readFile(f);
    }
}
