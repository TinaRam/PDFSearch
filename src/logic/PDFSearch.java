package logic;

import java.io.File;
import java.util.ArrayList;
import gui.FolderChooser;
import gui.PdfPanel;

public class PDFSearch extends Thread {

	private File directory;
	private PdfPanel pdfPanel;
	private int numberOfPdfFiles;
	public boolean searchComplete = false; // denne er public i master og private i findPDFs. Bytta, men det endra
											// ingenting...
	private TimeTracker time;

	public PDFSearch(File dir, FolderChooser f) {
		time = new TimeTracker();
		directory = dir;
		pdfPanel = new PdfPanel();
		f.add(pdfPanel);
	}

	@Override
	public void run() {
		System.out.println("Started search");
		time.startTimer();
		findPDFs(directory);
		yield();
		time.stopTimer();
		pdfPanel.addTimeField(time.getFormattedTimeTot());
		if (getNumberOfPdfFiles() > 0) {
			pdfPanel.addSearchField();
		} else {
			String[] r = { "", "No PDFs found" };
			pdfPanel.addTableRow(r);
		}
		searchComplete = true;
		System.out.println("Search complete!");
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
			String[] r = { file.getAbsolutePath().toString(), "UNSEARCHED" };
			pdfPanel.addTableRow(r);
		}
	}

	public int getNumberOfPdfFiles() {
		return numberOfPdfFiles;
	}

	public ArrayList<PdfFile> getResult() {
		return pdfPanel.getPdfList();
	}

}
