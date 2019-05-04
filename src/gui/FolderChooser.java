package gui;

import java.awt.BorderLayout;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import logic.PDFSearch;

public class FolderChooser extends JPanel {

	private File directory = new File(".");
	private PDFSearch ps;

	public FolderChooser() {
		setLayout(new BorderLayout(20, 20));

		JFileChooser fileChooser = new JFileChooser(directory);
		fileChooser.setFileSelectionMode(1);
		fileChooser.setDialogTitle("Select Folder");
		add(fileChooser);

		int returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			directory = fileChooser.getSelectedFile(); // path'en til valgt mappe
			ps = new PDFSearch(directory);
			ps.goFish(); // Any PDFs? - Go fish! (TinaGirDegHodepina)

			System.out.println("Antall PDF'er funnet i mappen " + directory + ": " + ps.getNumberOfPdfFiles());
		}
	}

	public String getDirectory() {
		return directory.getAbsolutePath();
	}

}
