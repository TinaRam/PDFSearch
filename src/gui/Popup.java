package gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Popup {
	
	private JFrame frame;
	
	public Popup(JFrame f) {
		frame = f;
	}
	
	public void showExitPopup() {
		int a = JOptionPane.showConfirmDialog(frame, "Are you sure?");
		if (a == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}