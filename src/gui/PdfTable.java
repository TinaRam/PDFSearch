package gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import logic.TableCellRenderer;

public class PdfTable extends JPanel {

	private DefaultTableModel tableModel;
	protected JScrollPane scrollPane;
	private String[] columns = { "Path", "Status" };
	private JTable table;

	public PdfTable() {
		setLayout(new BorderLayout(20, 20));

		tableModel = new DefaultTableModel(columns, 0) {
			// set cell uneditable
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(tableModel);
		table.getColumnModel().getColumn(1).setCellRenderer(new TableCellRenderer());

		scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.NORTH);
	}

	public void addTableRow(String[] row) {
		tableModel.addRow(row);
	}

	public void updateTable(int row, String[] data) {
		tableModel.removeRow(row);
		tableModel.insertRow(row, data);
	}

}
