package views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.EventListener;

import javax.swing.*;

public class MenuBar {
    protected static WindowList listWin;
    protected static WindowEdit editWin;
    protected static WindowDel delWin;
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
		itemSet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editWin = new WindowEdit();
                editWin.setVisible(true);
            }
        });

		JMenuItem itemList = new JMenuItem("Lister");
		itemList.setMnemonic('L');
		itemList.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_DOWN_MASK));
		//itemList.setIcon(new ImageIcon("icons/open.png"));
        itemList.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                listWin = new WindowList();
                listWin.setVisible(true);
            }
        });

        JMenuItem itemDel = new JMenuItem("Supprimer");
        itemDel.setMnemonic('D');
        itemDel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK));
        //itemList.setIcon(new ImageIcon("icons/open.png"));
        itemDel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                delWin = new WindowDel();
                delWin.setVisible(true);
            }
        });
		
		/* Ajout de menuFile dans menuBar et des items dans menuFile */
		menuBar.add(menuFile);
		menuFile.add(newRec);
		menuFile.addSeparator();
		menuFile.add(itemSet);
		menuFile.addSeparator();
		menuFile.add(itemList);
        menuFile.add(itemDel);
		
		return menuBar;
	}
}
