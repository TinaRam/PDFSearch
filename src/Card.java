import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class Card extends JPanel {
	
	private Color color;
	private FolderChooser folderChooser;
	
	public Card() {
		this.color = new RandomColor().getRandomColor();
		
		setLayout(new BorderLayout(20, 20));
		setBackground(this.color);
		
		JButton button = new JButton("Select directory");
		


		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO FÅ DRITEN TIL Å FUNKE???
				button.setEnabled(false);
				add(new FolderChooser());
				new FolderChooser();
			}			
		});
		
		// DETTE FUNKER??
		add(new FolderChooser());


		add(button, "North");
		
	}
	
	public Color getColor() {
		return this.color;
	}

}
