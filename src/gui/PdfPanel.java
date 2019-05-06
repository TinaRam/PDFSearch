package gui;

import java.awt.BorderLayout;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import logic.PdfFile;

public class PdfPanel extends JPanel {

	private ArrayList<PdfFile> pdfs = new ArrayList<PdfFile>();
	private String[] columns = { "Path", "Status" };
	private DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
	protected JTable pdfTable = new JTable(tableModel);
	protected JScrollPane scrollPane;

	private SearchField searchField;

	public PdfPanel() {
		setLayout(new BorderLayout(20, 20));
		scrollPane = new JScrollPane(pdfTable);
		add(scrollPane, BorderLayout.NORTH);
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

		System.out.println("finished word search");
	}

	public void addTableRow(String[] row) {
		tableModel.addRow(row);
	}

	public void updateTable(int row, String[] data) {
		tableModel.removeRow(row);
		tableModel.insertRow(row, data);
	}

}
