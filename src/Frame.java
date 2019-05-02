import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
	
	private JPanel panel;
	private Menu menu;
	private CardLayout layout;

	public Frame() {
		setTitle("Pdf file operations");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel(layout = new CardLayout(20, 20));
		add(panel);
		setSize(800, 600);

		setJMenuBar(menu = new Menu(this));
		setVisible(true);
	}
	
	public void createCard() {
		Card card = new Card();
		panel.add(card, card.getColor().toString());
		
		menu.addMenuItem(card.getColor());
		card.updateUI();
		layout.show(panel, card.getColor().toString());		
	}
	
}
