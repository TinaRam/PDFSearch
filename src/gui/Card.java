package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import logic.RandomColorPicker;

public class Card extends JPanel implements ActionListener {

	private Color color;
	private JButton button;
	public JMenuItem item = null;

	public Card() {
		setBackground(color = new RandomColorPicker().getRandomColor());
		setLayout(new BorderLayout(20, 20));

		add(button = new JButton("Select Folder") {

			{
				addActionListener(Card.this);
			}
		}, BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FolderChooser fc = new FolderChooser(this);
		add(fc);
		button.setText(fc.getDirectory());
		button.setEnabled(false);
		updateUI();
	}

	public Color getColor() {
		return color;
	}
	
	public void setMenuItem(JMenuItem i) {
		item = i;
	}
	
	public void setTitle(String title) {
		//System.out.println(item != null);
		item.setText(title);
		updateUI();
	}

}
