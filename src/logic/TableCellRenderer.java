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

		if (status == "SEARCHING...") {
			label.setForeground(new Color(173, 138, 12));
		} else if (status == "NOTFOUND") {
			label.setForeground(new Color(188, 32, 32));
		} else if (status == "FOUND") {
			label.setForeground(new Color(28, 117, 54));
		} else {
			label.setForeground(Color.BLACK);
		}
		return label;
	}

}