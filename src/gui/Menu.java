package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Menu extends JMenuBar {

	private JMenu tools;
	private Frame frame;

	public Menu(Frame f) {
		frame = f;
		JMenu file = new JMenu("File");
		tools = new JMenu("Tools");
		JMenuItem exit = new JMenuItem("Exit");
		JMenuItem newCard = new JMenuItem("Create a new search card");

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		newCard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.createCard();
			}
		});

		file.add(exit);
		tools.add(newCard);
		//tools.addSeparator();
		add(file);
		add(tools);
	}

	public void addMenuItem(Color color, CardLayout layout, JPanel panel) {
		JMenuItem item = new JMenuItem("Go to this card");
		item.setBackground(color);
		item.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//layout.show(panel, color.toString());
			}
		});
		tools.add(item);
	}

}
