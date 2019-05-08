package gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {

	private JPanel panel;
	private Menu menu;
	private CardLayout layout;

	public Frame() {
		setTitle("PDF search");
		panel = new JPanel(layout = new CardLayout(20, 20));
		add(panel);
		setSize(800, 620);
		setResizable(false);
		setJMenuBar(menu = new Menu(this));
		setLocationRelativeTo(null); // sentrerer Frame til midten av skjermen
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				new Popup(Frame.this).showExitPopup();
			}
		});
	}


	public void createCard() {
		Card card = new Card();
		panel.add(card, card.getColor().toString());
		menu.addMenuItem(card.getColor(), layout, panel);
		layout.show(panel, card.getColor().toString());
		card.updateUI();
	}

}
