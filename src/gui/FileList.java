package gui;

import java.awt.BorderLayout;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import logic.PDFSearch;

public class FileList extends JPanel {
	
	private SearchField search;
	
	public FileList(File[] fileList) {
		add(search = new SearchField());
		
		ArrayList<File> pdfs = new ArrayList<File>();
		
		pdfs = new PDFSearch().getPDFs(fileList);
		
		
		
		if (pdfs.isEmpty()) {
			remove(search);
			add(new JLabel("No pdfs found"), BorderLayout.SOUTH);
		} else {
			displayData();
	        search.showSearch();
		}
		
	}
	
	private void displayData() {
		// Data to be displayed in the JTable 
        String[][] data = { 
            { "Kundan Kumar Jha", "CSE" }, 
            { "Anand Jha", "IT" } 
        }; 
  
        // Column Names 
        String[] columnNames = { "Path", "Search result"}; 
  
        // Initializing the JTable 
        JTable j = new JTable(data, columnNames); 
		
        JScrollPane sp = new JScrollPane(j); 
        add(sp);
        
	}

}
