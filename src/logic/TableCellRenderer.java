package logic;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class TableCellRenderer extends DefaultTableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int col) {

		JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

		String status = (String) tableModel.getValueAt(row, 1);
		System.out.println(status);
		

		if (status == "SEARCHING...") {
			label.setForeground(Color.yellow);
		} else if (status == "NOTFOUND") {
			label.setForeground(Color.red);
		} else if (status == "FOUND") {
			label.setForeground(Color.green);
		} else {
			label.setForeground(Color.black);
		}
		return label;
	}

}