package gui;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JPanel;

public class FileList extends JPanel {
	
	public FileList(File[] fileList) {
		SearchField search = new SearchField();
		add(search);
		
		ArrayList<File> pdfs = new ArrayList<File>();
		
		PDFSearch pdfSearch = new PDFSearch();
		pdfs = pdfSearch.getPDFs(fileList);
		
		for (File f : pdfs) {
			System.out.println(f.getName());
		}
		
	}

}
