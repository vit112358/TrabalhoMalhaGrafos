package Control.IO;

import Model.t;

import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Leitura {

    public List<t> readFile(File Caminho){
        List<t> ts = new ArrayList<>();
        try {
            try (BufferedReader meu_buffer = new BufferedReader(new FileReader(Caminho))) {
                String linha;
                try {
                    //enquanto eu conseguir ler o arquivo faço algo
                    while (meu_buffer.ready()) {

                        //lendo a linha
                        linha = meu_buffer.readLine();

                        //quebrando a linha
                        String[] valores = linha.split(" ");
                        t aux = new t(Integer.parseInt(valores[0]),Integer.parseInt(valores[1]), Integer.parseInt(valores[2]));
                        ts.add(aux);

                    }
                } catch (IOException ex) {
                    Logger.getLogger(Leitura.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler o Caminho! "
                    + "Verifique o caminho", "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Leitura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Leitura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ts;
    }
}
