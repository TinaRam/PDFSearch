package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.Timer;
import gui.Card;
import gui.FolderChooser;
import gui.PdfPanel;

public class PdfSearch extends Thread {

	private File directory;
	private PdfPanel pdfPanel;
	private int numberOfPdfFiles;
	private TimeTracker trackTime;
	private Card card;

	public PdfSearch(File dir, FolderChooser f) {
		card = f.getCard();
		trackTime = new TimeTracker();
		directory = dir;
		pdfPanel = new PdfPanel(card);
		f.add(pdfPanel);
	}

	@Override
	public void run() {
		ActionListener al = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				pdfPanel.updateJLabel(numberOfPdfFiles, trackTime.getFormattedElapsedTime());
			}
		};
		trackTime.startTimer();
		Timer timer = new Timer(1, al);
		timer.start();

		card.setTitle("<html><b>Searching...</b></html>");
		findPDFs(directory);
		card.setTitle("Search complete!");

		trackTime.stopTimer();
		timer.stop();

		pdfPanel.showSearchResult(numberOfPdfFiles, trackTime.getFormattedTimeTot());
		if (getNumberOfPdfFiles() > 0) {
			pdfPanel.addSearchField();
		} else {
			String[] r = { "", "No PDFs found" };
			pdfPanel.addTableRow(r);
		}
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
