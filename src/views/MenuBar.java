package views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBar {
	public static JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menuFile = new JMenu("Action");
		menuFile.setForeground(Color.BLUE);
		menuFile.setMnemonic('A');
		
		JMenuItem newRec = new JMenuItem("Nouvel enregistrement");
		newRec.setMnemonic('N');
		newRec.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		//newFile.setIcon(new ImageIcon("icons/newfile.png"));

		
		JMenuItem itemSet = new JMenuItem("Midifier");
		itemSet.setMnemonic('E');
		itemSet.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
		//itemSet.setIcon(new ImageIcon("icons/open.png"));

		JMenuItem itemList = new JMenuItem("Lister");
		itemList.setMnemonic('L');
		itemList.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_DOWN_MASK));
		//itemList.setIcon(new ImageIcon("icons/open.png"));

		
		/* Ajout de menuFile dans menuBar et des items dans menuFile */
		menuBar.add(menuFile);
		menuFile.add(newRec);
		menuFile.addSeparator();
		menuFile.add(itemSet);
		menuFile.addSeparator();
		menuFile.add(itemList);
		
		return menuBar;
	}
}
