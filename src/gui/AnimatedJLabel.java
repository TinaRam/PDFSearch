package gui;

import javax.swing.JLabel;

public class AnimatedJLabel {

	protected JLabel label;
	protected String text;
	protected boolean stop = false;

	public AnimatedJLabel(String txt) {
		text = txt;
		label = new JLabel(txt);
		this.animateDots();
	}

	public void animateDots() {
		while (stop == false) {

		}
	}
}
