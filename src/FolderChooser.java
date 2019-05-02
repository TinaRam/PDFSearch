import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class FolderChooser extends JPanel {
	
	public FolderChooser() {
		setLayout(new BorderLayout(20, 20));
		add(new JFileChooser());
	}

}
