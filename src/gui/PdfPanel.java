package gui;

import java.awt.BorderLayout;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import logic.PdfFile;
import logic.TableCellRenderer;

public class PdfPanel extends JPanel {

	private ArrayList<PdfFile> pdfs = new ArrayList<PdfFile>();
	private String[] columns = { "Path", "Status" };
	private DefaultTableModel tableModel;
	private JTable pdfTable;
	private JScrollPane scrollPane;
	private JLabel jl;
	private SearchField searchField;

	public PdfPanel() {
		setLayout(new BorderLayout(20, 20));

		tableModel = new DefaultTableModel(columns, 0) {

			// set cell uneditable
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		pdfTable = new JTable(tableModel);
		pdfTable.getColumnModel().getColumn(1).setCellRenderer(new TableCellRenderer());

		scrollPane = new JScrollPane(pdfTable);
		add(scrollPane, BorderLayout.NORTH);
		jl = new JLabel("Searching...");
		add(jl);
	}

	public void addPdf(File pdf) {
		pdfs.add(new PdfFile(pdf));
	}

	public ArrayList<PdfFile> getPdfList() {
		return pdfs;
	}

	public void addSearchField() {
		add(new SearchField(this), BorderLayout.SOUTH);
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
		tableModel.addRow(row);
	}

	public void updateTable(int row, String[] data) {
		tableModel.removeRow(row);
		tableModel.insertRow(row, data);
	}

	public void addTimeField(String s) {
		jl.setText(s);
		updateUI();
	}

}
