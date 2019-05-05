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
	private DefaultTableModel tableModel = new DefaultTableModel(columns, 1);
	protected JTable pdfTable = new JTable(tableModel);

	public PdfPanel() {
		setLayout(new BorderLayout());
		add(new JScrollPane(pdfTable));
	}

	public void addPdf(File pdf) {
		pdfs.add(new PdfFile(pdf));
	}

	public void searchComplete() {
		System.out.println("PdfPanel.java --> searchComplete");
		for (PdfFile pdf : pdfs) {
			String[] r = { pdf.getFilePath().toString(), pdf.getStatus() };
			tableModel.addRow(r);
		}
	}

	public ArrayList<PdfFile> getPdfList() {
		return pdfs;
	}

}