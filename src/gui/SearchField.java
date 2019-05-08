package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import logic.WordSearch;

public class SearchField extends JPanel {

	private JTextField textField;
	private JButton search;
	private JButton reset;
	private PdfPanel panel;

	public SearchField(PdfPanel p) {
		panel = p;
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(380, 20));
		textField.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					search();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		add(textField);

		reset = new JButton("X");
		reset.setBorder(null);
		reset.setContentAreaFilled(false);
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				resetTextField();
			}
		});
		add(reset);

		search = new JButton("Search");
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				search();
			}
		});
		add(search);
	}

	private void search() {
		enableSearchButton(false);
		enableResetButton(false);
		enableTextField(false);
		new WordSearch(panel, getSearchWord());
	}

	public String getSearchWord() {
		return textField.getText();
	}

	public void enableSearchButton(boolean b) {
		search.setEnabled(b);
	}

	public void enableResetButton(boolean b) {
		reset.setEnabled(b);
	}

	public void enableTextField(boolean b) {
		textField.setEnabled(b);
	}

	private void resetTextField() {
		textField.setText("");
	}

}
