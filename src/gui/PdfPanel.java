package gui;

import java.awt.BorderLayout;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JPanel;

import logic.PdfFile;

public class PdfPanel extends JPanel {

	private ArrayList<PdfFile> pdfs = new ArrayList<PdfFile>();
	private SearchField searchField;
	private PdfTable table = new PdfTable();

	public PdfPanel() {
		setLayout(new BorderLayout(20, 20));
		add(table);
	}

	public void addPdf(File pdf) {
		pdfs.add(new PdfFile(pdf));
	}

	public ArrayList<PdfFile> getPdfList() {
		return pdfs;
	}

	public void addSearchField() {
		searchField = new SearchField(this);
		add(searchField, BorderLayout.SOUTH);

		updateUI();
		System.out.println("Search complete");
	}

	public void finishWordSearch() {
		searchField.enableSearchButton(true);
		searchField.enableResetButton(true);
		searchField.enableTextField(true);

		System.out.println("finished word search");
	}

	public void addTableRow(String[] row) {
		table.addTableRow(row);
	}

	public void updateTable(int row, String[] data) {
		table.updateTable(row, data);
	}

}
