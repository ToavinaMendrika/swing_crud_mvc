package views;

import controller.PersonneCotroller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class WindowEdit extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private static JComboBox comboBoxNum;
	private static JTextField fieldNom;
	private static JTextField fieldPrenom;
	private static JTextField fieldAge;
	public WindowEdit() {
		super("Modification");
		
		/******* PANEL PRINCIPAL ********/
		JPanel mainPanel = (JPanel) this.getContentPane();
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		
		/******* NUMERO ********/
		JLabel labelNum = new JLabel("Numéro");
		labelNum.setBounds(15, 15, 100, 25);
		panel1.add(labelNum);
        PersonneCotroller pc = new PersonneCotroller();
        Integer[] nums = pc.ids();
		final JComboBox comboNum = new JComboBox(nums);
        comboNum.setBounds(85, 15, 70, 25);
		panel1.add(comboNum);

		
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
                PersonneCotroller pc = new PersonneCotroller();
                pc.update(fieldNom.getText(),fieldPrenom.getText(),Integer.parseInt(fieldAge.getText()), (Integer) comboNum.getSelectedItem());
            }
        });
		panel1.add(btnEnregistrer);
		
		mainPanel.add(panel1);
        ////////////////------------ ACTION DU COMBOBOX --------------//////////////
        comboNum.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonneCotroller pc = new PersonneCotroller();
                String[] person = pc.first((Integer) comboNum.getSelectedItem());
                showPerson(person);

            }
        });
		this.setJMenuBar(MenuBar.createMenuBar());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500, 650);
		this.setLocationRelativeTo(null);
	}

	public void showPerson(String[] person){
	    fieldNom.setText(person[0]);
	    fieldPrenom.setText(person[1]);
	    fieldAge.setText(person[2]);
    }
	////////////////////// ------ BOUTON ENREGISTRER ACTION ----- //////////////


}
