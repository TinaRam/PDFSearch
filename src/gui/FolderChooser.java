package gui;

import java.awt.BorderLayout;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import logic.PDFSearch;

public class FolderChooser extends JPanel {

	private File directory = new File(".");
	private PDFSearch ps;
	protected PdfPanel pdfPanel;

	public FolderChooser() {
		setLayout(new BorderLayout(20, 20));

		JFileChooser fileChooser = new JFileChooser(directory);
		fileChooser.setFileSelectionMode(1);
		fileChooser.setDialogTitle("Select Folder");
		add(fileChooser);

		int returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			directory = fileChooser.getSelectedFile(); // path'en til valgt mappe
			ps = new PDFSearch(directory, this);
			//add(new PdfPanel());
			ps.start(); // Any PDFs? - Go fish! (TinaGirDegHodepina)

//			while (!ps.isSearchComplete()) {
//				add
//			}
//			add(new PdfPanel());
			System.out.println("Antall PDF'er funnet i mappen " + directory + ": " + ps.getNumberOfPdfFiles());

//			System.out.println("Søk ferdig? --> " + ps.isSearchComplete());
//			System.out.println("Lever tråden? --> " + ps.isAlive());
		}
	}

	public String getDirectory() {
		return directory.getAbsolutePath();
	}

}
