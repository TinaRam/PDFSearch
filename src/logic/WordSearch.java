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
		System.out.println("finished word search");
	}

	private void search() {
		int row = 0;
		for (PdfFile file : files) {
			file.setStatus("UNSEARCHED");
			String[] r = { file.getFilePath().toString(), file.getStatus() };
			panel.updateTable(row, r);
			row++;
		}
		
		row = 0;
		for (PdfFile file : files) {
			try {

				// TODO: kan vi f� til en s�nn status som endrer antall punktum??
				file.setStatus("SEARCHING...");
				String[] r = { file.getFilePath().toString(), file.getStatus() };
				panel.updateTable(row, r);
				// ---------

				PDDocument document = PDDocument.load(file.getFile());
				String documentText = new PDFTextStripper().getText(document);

				file.setSearchResult(documentText.indexOf(searchWord) > -1);
				document.close();

				String[] r2 = { file.getFilePath().toString(), file.getStatus() };
				panel.updateTable(row, r2);
			} catch (IOException e) {
				e.printStackTrace();
			}
			row++;
		}
	}

}
