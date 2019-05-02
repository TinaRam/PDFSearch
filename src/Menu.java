import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar {
	
	public Menu(Frame f) {
		JMenu file = new JMenu("File");
		JMenu tools = new JMenu("Tools");
		
		JMenuItem exit = new JMenuItem("Exit");
		JMenuItem newCard = new JMenuItem("Create a new search card");
		
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		newCard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				f.createCard();
			}
		});
		
		file.add(exit);
		tools.add(newCard);
		tools.addSeparator();
		
		add(file);
		add(tools);		
	}

}
