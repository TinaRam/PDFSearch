package gui;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchField extends JPanel {

	public SearchField() {
		setLayout(new BorderLayout());
	}

	public void showSearch() {
		JTextField textField = new JTextField();
		add(textField, BorderLayout.SOUTH);
	}
}
