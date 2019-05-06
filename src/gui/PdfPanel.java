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
	private DefaultTableModel tableModel;
	protected JTable pdfTable;
	protected JScrollPane scrollPane;
//	private AnimatedJLabel jl = new AnimatedJLabel();

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

		scrollPane = new JScrollPane(pdfTable);
		add(scrollPane, BorderLayout.NORTH);
//		add(jl = new JLabel("Searching..."));
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
//		jl.setText(s);
		updateUI();
	}

// Prøvde å finne en enkel måte å animere Searching.  ..  ..
// Men denne forstyrrer thread'en som allerede holder på
// Lar den ligge litt, kanskje et eple faller på hodet mitt i løpet av uka
// Kanskje jeg kan bruke javax.swing.Timer med actionListener???
// -TinaHodepina-

//	public void animateJL() {
//		int n = 3;
//		while (n > 0) {
//			jl.setText("Searching");
//			try {
//				Thread.sleep(600);
//			} catch (InterruptedException e1) {
//				e1.printStackTrace();
//			}
//			jl.setText("Searching.");
//			try {
//				Thread.sleep(600);
//			} catch (InterruptedException e1) {
//				e1.printStackTrace();
//			}
//			jl.setText("Searching..");
//			try {
//				Thread.sleep(300);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			jl.setText("Searching...");
//			try {
//				Thread.sleep(300);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			n--;
//		}
//	}

}
