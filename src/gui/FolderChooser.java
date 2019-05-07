package gui;

import java.awt.BorderLayout;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import logic.PdfSearch;

public class FolderChooser extends JPanel {

	private File directory = new File(".");
	private PdfSearch ps;

	public FolderChooser() {
		setLayout(new BorderLayout(20, 20));

		JFileChooser fileChooser = new JFileChooser(directory);
		fileChooser.setFileSelectionMode(1);
		fileChooser.setDialogTitle("Select Folder");
		add(fileChooser);

		int returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			directory = fileChooser.getSelectedFile();
			ps = new PdfSearch(directory, this);
			ps.start();
		}
	}

	public String getDirectory() {
		return directory.getAbsolutePath();
	}

}
