package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Card extends JPanel implements ActionListener {

	private Color color;
	private JButton button;

	public Card() {
		setBackground(color = new ColorPicker().getRandomColor());
		setLayout(new BorderLayout(20, 20));

		add(button = new JButton("Select Folder") {

			{
				addActionListener(Card.this);
			}
		}, BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FolderChooser fc = new FolderChooser();
		add(fc);
		button.setText(fc.getDirectory());
		button.setEnabled(false);
		updateUI();
	}

	public Color getColor() {
		return color;
	}

}
