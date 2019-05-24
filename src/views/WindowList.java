package views;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class WindowList extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public static JTable tabInfoPerson;

	public WindowList() {
		super("Liste");
		
		/******* PANEL PRINCIPAL ********/
		JPanel mainPanel = (JPanel) this.getContentPane();
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout(0, 0));
		
		/************ TABLE CLIENT ******************/
		tabInfoPerson = new JTable();
		tabInfoPerson.setBounds(0, 0, 80, 25);
		panel1.add(new JScrollPane(tabInfoPerson));
		getList();
		
		mainPanel.add(panel1);
		
		this.setJMenuBar(MenuBar.createMenuBar());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500, 650);
		this.setLocationRelativeTo(null);
	}
	
	private static void getList() {
		DefaultTableModel listOfPerson = new	DefaultTableModel();		
		ResultSet result = null;

	 }
	
	////////ACTUALISATION DE LA TABLE --- BEGIN //////////////
	public static void refreshTable() {
		DefaultTableModel model = (DefaultTableModel)tabInfoPerson.getModel();
		model.setRowCount(0);
		getList();
	}
	//////// ACTUALISATION DE LA TABLE --- END //////////////
	
}
