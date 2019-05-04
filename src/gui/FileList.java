package gui;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JPanel;
import logic.PdfFile;

public class FileList extends JPanel {

	private ArrayList<PdfFile> pdfs = new ArrayList<PdfFile>();

	public FileList() {

	}

	public void addPdf(File pdf) {
		pdfs.add(new PdfFile(pdf));
	}

}
