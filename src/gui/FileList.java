package gui;

import java.awt.BorderLayout;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JPanel;
import logic.PdfFile;

public class FileList extends JPanel {

	private ArrayList<PdfFile> pdfs = new ArrayList<PdfFile>();

	public FileList() {
		setLayout(new BorderLayout());
	}

	public void addPdf(File pdf) {
		pdfs.add(new PdfFile(pdf));
	}

}
