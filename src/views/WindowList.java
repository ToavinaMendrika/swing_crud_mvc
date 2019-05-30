package views;

import controller.PersonneCotroller;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class WindowList extends JFrame{
	private static final long serialVersionUID = 1L;
	private PersonneCotroller pc;
	
	public static JTable tabInfoPerson;

	public WindowList() {
		super("Liste");
		
		/******* PANEL PRINCIPAL ********/
		JPanel mainPanel = (JPanel) this.getContentPane();
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout(0, 0));
		
		/************ TABLE CLIENT ******************/
		String[] entetes = {"Prénom", "Nom", "age"};
		pc = new PersonneCotroller();
		String[][] persons = pc.all();
		JTable tabInfoPerson = new JTable(persons,entetes);

		tabInfoPerson.setBounds(0, 0, 80, 25);
		panel1.add(new JScrollPane(tabInfoPerson));

		
		mainPanel.add(panel1);
		
		this.setJMenuBar(MenuBar.createMenuBar());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500, 650);
		this.setLocationRelativeTo(null);
	}
	
	private void getList(){
		DefaultTableModel listOfPerson = new DefaultTableModel();
		pc = new PersonneCotroller();
        Object[][] persons = pc.all();

	 }
	
	////////ACTUALISATION DE LA TABLE --- BEGIN //////////////
	public static void refreshTable() {
		DefaultTableModel model = (DefaultTableModel)tabInfoPerson.getModel();
		model.setRowCount(0);

	}
	//////// ACTUALISATION DE LA TABLE --- END //////////////
	
}
