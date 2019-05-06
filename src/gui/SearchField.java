package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logic.WordSearch;

public class SearchField extends JPanel {

	private JTextField textField;
	private JButton search;
	private JButton reset;

	public SearchField(PdfPanel panel) {
		setLayout(new BorderLayout(20, 20));
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(600, 20));
		add(textField, BorderLayout.LINE_START);

		reset = new JButton("X");
		reset.setBorder(null);
		reset.setContentAreaFilled(false);
		add(reset, BorderLayout.CENTER);
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				resetTextField();
			}
		});

		search = new JButton("Search");
		add(search, BorderLayout.LINE_END);

		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				enableSearchButton(false);
				enableResetButton(false);
				new WordSearch(panel, getSearchWord());
			}
		});

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

	private void resetTextField() {
		textField.setText("");
	}

}
