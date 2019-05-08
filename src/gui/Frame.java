package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Frame extends JFrame {

	private JPanel panel;
	private Menu menu;
	private CardLayout layout;
	
	private JTabbedPane tab;

	public Frame() {
		setTitle("PDF search");
		panel = new JPanel(layout = new CardLayout(20, 20));
		add(panel);
		setSize(800, 640);
		setResizable(false);
		setJMenuBar(menu = new Menu(this));
		setLocationRelativeTo(null); // sentrerer Frame til midten av skjermen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		
		tab = new JTabbedPane();
		
		
		
		panel.add(tab, BorderLayout.CENTER);
	}

	public void createCard() {
		Card card = new Card();
		
		tab.addTab("Go to this card", card);
		tab.setBackgroundAt(tab.getTabCount() - 1, card.getColor());
		tab.setSelectedIndex(tab.getTabCount() - 1);
		//panel.add(card, card.getColor().toString());
		//menu.addMenuItem(card.getColor(), layout, panel);
		//layout.show(panel, card.getColor().toString());
		card.updateUI();
	}
	
	public void showTab(JComponent c) {
		tab.setSelectedComponent(c);
	}

}
