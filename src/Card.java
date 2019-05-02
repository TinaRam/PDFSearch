import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Card extends JPanel {
	
	public Card() {
		setLayout(new BorderLayout(20, 20));
		setBackground(Color.red);
		
		JButton button = new JButton("Select directory");
		//add(button);
	}

}
