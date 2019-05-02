import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Card extends JPanel {
	
	private Color color;
	
	public Card() {
		this.color = getRandomColor();
		
		setLayout(new BorderLayout(20, 20));
		setBackground(this.color);
		
		JButton button = new JButton("Select directory");
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO select directory
			}			
		});
		
		add(button, "North");
	}
	
	private Color getRandomColor() {
		Random random = new Random();
	    int red = random.nextInt(256);
	    int green = random.nextInt(256);
	    int blue = random.nextInt(256);
		return new Color(red, green, blue);
	}
	
	public Color getColor() {
		return this.color;
	}

}
