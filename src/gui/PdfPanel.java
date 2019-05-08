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
	
	private Card card;

	public PdfPanel(Card c) {
		card = c;
		setLayout(new BorderLayout(20, 20));
		tableModel = new DefaultTableModel(columns, 0) {

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		pdfTable = new JTable(tableModel);
		pdfTable.getColumnModel().getColumn(1).setCellRenderer(new TableCellRenderer());
		scrollPane = new JScrollPane(pdfTable);
		add(scrollPane, BorderLayout.NORTH);
		jl = new JLabel();
		add(jl, BorderLayout.WEST);
	}
	
	public Card getCard() {
		return card;
	}

	public void addPdf(File pdf) {
		pdfs.add(new PdfFile(pdf));
	}

	public ArrayList<PdfFile> getPdfList() {
		return pdfs;
	}

	public void updateJLabel(int n, String timeFromStart) {
		jl.setText("<html><br>Found <b>" + n + "</b> pdfs in <b>" + timeFromStart + "</b></html>");
		updateUI();
	}

	public void showSearchResult(int n, String time) {
		jl.setText("<html><b>Search complete!</b><br>Found <b>" + n + "</b> pdfs in <b>" + time + "</b></html>");
		updateUI();
	}

	public void addSearchField() {
		searchField = new SearchField(this);
		add(searchField, BorderLayout.EAST);
		updateUI();
	}

	public void finishWordSearch() {
		searchField.enableSearchButton(true);
		searchField.enableResetButton(true);
		searchField.enableTextField(true);
	}

	public void addTableRow(String[] row) {
		tableModel.addRow(row);
	}

	public void updateTable(int row, String[] data) {
		tableModel.removeRow(row);
		tableModel.insertRow(row, data);
	}

}
