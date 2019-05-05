package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logic.WordSearch;

public class SearchField extends JPanel {

	private JTextField textField;

	public SearchField(PdfPanel panel) {
		setLayout(new BorderLayout(20, 20));
		textField = new JTextField();
		add(textField, BorderLayout.CENTER);
		
		JButton search = new JButton("Search");
		add(search, BorderLayout.LINE_END);

		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new WordSearch(panel, getSearchWord());
			}
		});
	}

	public String getSearchWord() {
		return textField.getText();
	}

}
