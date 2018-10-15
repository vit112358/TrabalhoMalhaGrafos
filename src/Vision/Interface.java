/*
 * Created by JFormDesigner on Sat Oct 13 17:21:41 BRT 2018
 */

package Vision;

import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author Vitor Fernandes
 */
public class Interface extends JPanel {
    public Interface() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Vitor Fernandes
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        label1 = new JLabel();
        btn_rotas = new JButton();
        btn_voos = new JButton();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("Arquivo");
            }
            menuBar1.add(menu1);
        }
        add(menuBar1, "cell 0 0");

        //---- label1 ----
        label1.setText("Controle de Tr\u00e1fego A\u00e9reo");
        add(label1, "cell 0 1 2 1");

        //---- btn_rotas ----
        btn_rotas.setText("Mostrar Rotas");
        add(btn_rotas, "cell 1 14");

        //---- btn_voos ----
        btn_voos.setText("Mostrar Voos");
        add(btn_voos, "cell 2 14");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Vitor Fernandes
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JLabel label1;
    private JButton btn_rotas;
    private JButton btn_voos;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
