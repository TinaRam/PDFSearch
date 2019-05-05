package logic;

import java.io.File;
import java.util.ArrayList;
import gui.PdfPanel;

public class PDFSearch extends Thread {

	private File directory;
	private PdfPanel pdfPanel;
	private int numberOfPdfFiles;
	public boolean searchComplete = false;

	public PDFSearch(File dir) {
		directory = dir;
		pdfPanel = new PdfPanel();
	}

	@Override
	public void run() {
		findPDFs(directory);
		if (searchComplete) {
			pdfPanel.searchComplete();
		}
	}

	public boolean isSearchComplete() {
		return searchComplete;
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
			pdfPanel.addPdf(file);
			numberOfPdfFiles++;
			System.out.println("PDFSearch.java --> numberOfPdfFiles: " + numberOfPdfFiles);
		}
		searchComplete = true;
	}

	public int getNumberOfPdfFiles() {
		return numberOfPdfFiles;
	}

	public ArrayList<PdfFile> getResult() {
		return pdfPanel.getPdfList();
	}

}
