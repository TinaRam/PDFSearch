package logic;

import java.io.File;
import gui.FileList;

public class PDFSearch {

	private File directory = null;
	private FileList fl;
	private int numberOfPdfFiles;

	public PDFSearch(File dir) {
		directory = dir;
		fl = new FileList();
	}

	public void goFish() {
		findPDFs(directory);
	}

	private void findPDFs(File file) {
		if (file.isDirectory()) {
			File[] folder = file.listFiles();
			if (folder != null) {
				for (File f : folder) {
					findPDFs(f);
				}
			}
		} else if (file.getAbsolutePath().endsWith(".pdf")) {
			fl.addPdf(file);
			numberOfPdfFiles++;
		}
	}

	public int getNumberOfPdfFiles() {
		return numberOfPdfFiles;
	}

}
