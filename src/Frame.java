import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Frame extends JFrame {
	
	public Frame() {
		setTitle("Pdf file operations");
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addMenuBar();
	}
	
	private void addMenuBar() {
		MenuBar menubar = new MenuBar();
		
		Menu file = new Menu("File");
	    Menu tools = new Menu("Tools");
	    
	    MenuItem exit = new MenuItem("Exit");
	    MenuItem newCard = new MenuItem("Create a new search card");
	    
	    exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
	    });

	    newCard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// new card
				System.out.println("New card");
			}
	    });
	    
	    file.add(exit);
	    tools.add(newCard);	    
	    
	    menubar.add(file);
	    menubar.add(tools);	    
	    
		setMenuBar(menubar);
	}

}
