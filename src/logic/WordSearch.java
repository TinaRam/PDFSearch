package logic;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import gui.PdfPanel;

public class WordSearch extends Thread {

	private PdfPanel panel;
	private String searchWord;
	private ArrayList<PdfFile> files;

	public WordSearch(PdfPanel p, String sw) {
		panel = p;
		searchWord = sw;
		files = panel.getPdfList();
		if (!searchWord.equals("")) {
			start();
		}
	}

	@Override
	public void run() {
		search();
		panel.finishWordSearch();
	}

	private void search() {
		int row = 0;
		for (PdfFile file : files) {
			updateFileStatus(file, row, "UNSEARCHED");
			row++;
		}

		row = 0;
		for (PdfFile file : files) {
			updateFileStatus(file, row, "SEARCHING...");
			try {
				PDDocument document = PDDocument.load(file.getFile());
				String documentText = new PDFTextStripper().getText(document);
				updateFileStatus(file, row, documentText.indexOf(searchWord) > -1 ? "FOUND" : "NOTFOUND");
				document.close();
			} catch (IOException e) {
				updateFileStatus(file, row, "NOTFOUND");
				e.printStackTrace();
			}
			row++;
		}
	}

	private void updateFileStatus(PdfFile file, int row, String status) {
		file.setStatus(status);
		String[] r = { file.getFilePath().toString(), file.getStatus() };
		panel.updateTable(row, r);
	}

}
