package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controller.PersonneCotroller;

public class WindowRec extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private static JComboBox comboBoxNum;
	private static JTextField fieldNom;
	private static JTextField fieldPrenom;
	private static JTextField fieldAge;
	private static PersonneCotroller Pc = new PersonneCotroller();
	public WindowRec() {
		super("Enregistrement");
		
		/******* PANEL PRINCIPAL ********/
		JPanel mainPanel = (JPanel) this.getContentPane();
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);

		
		/******* NOM ******/
		JLabel labelNom = new JLabel("Nom");
		labelNom.setBounds(15, 60, 70, 25);
		panel1.add(labelNom);
		
		fieldNom = new JTextField();
		fieldNom.setBounds(85, 60, 150, 25);
		panel1.add(fieldNom);
		
		/******* PRENOM ******/
		JLabel labelPrenom = new JLabel("Prénom");
		labelPrenom.setBounds(15, 105, 70, 25);
		panel1.add(labelPrenom);
		
		fieldPrenom = new JTextField();
		fieldPrenom.setBounds(85, 105, 150, 25);
		panel1.add(fieldPrenom);
		
		/******* AGE ******/
		JLabel labelAge = new JLabel("Âge");
		labelAge.setBounds(15, 150, 50, 25);
		panel1.add(labelAge);
		
		fieldAge = new JTextField();
		fieldAge.setBounds(85, 150, 150, 25);
		panel1.add(fieldAge);
		
		/******* BOUTON ENREGISTRER *******/
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setBounds(75, 195, 150, 35);
		btnEnregistrer.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                Pc.insert(fieldNom.getText(),fieldPrenom.getText(),Integer.parseInt(fieldAge.getText()));
                fieldNom.setText("");
                fieldPrenom.setText("");
                fieldAge.setText("");
                JOptionPane.showMessageDialog(null,"Enregistrement réussie");
            }
        });
		panel1.add(btnEnregistrer);
		
		mainPanel.add(panel1);
		
		this.setJMenuBar(MenuBar.createMenuBar());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500, 650);
		this.setLocationRelativeTo(null);
	}
	

	
	////////////////------------ ACTION DU COMBOBOX --------------//////////////
	private static void comboBoxIdPersonAction(ActionEvent e) {
		ResultSet infoPesron;
		String nomPerson = new String();
		String prenomPerson = new String();
	}

}
