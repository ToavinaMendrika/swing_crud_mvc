package views;

import controller.PersonneCotroller;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowDel extends JFrame {
    public WindowDel(){
        super("Suppression");

        /******* PANEL PRINCIPAL ********/
        final JPanel mainPanel = (JPanel) this.getContentPane();

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);

        /******* NUMERO ********/
        JLabel labelNum = new JLabel("Numéro");
        labelNum.setBounds(15, 15, 100, 25);
        panel1.add(labelNum);

        final PersonneCotroller pc = new PersonneCotroller();
        Integer[] nums = pc.ids();

        final JComboBox comboNum = new JComboBox(nums);
        comboNum.setBounds(85, 15, 70, 25);
        panel1.add(comboNum);

        JButton btnDel = new JButton("Supprimer");
        btnDel.setBounds(75, 195, 150, 35);
        panel1.add(btnDel);
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pc.delete((Integer) comboNum.getSelectedItem());
                comboNum.removeItemAt(comboNum.getSelectedIndex());
                JOptionPane.showMessageDialog(null,"Suppression réussie");
            }
        });


        mainPanel.add(panel1);
        this.setJMenuBar(MenuBar.createMenuBar());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 650);
        this.setLocationRelativeTo(null);
    }
}
