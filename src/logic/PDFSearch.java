package logic;

import java.io.File;
import java.util.ArrayList;

public class PDFSearch {
	
	public ArrayList<File> getPDFs(File[] fileList) {
		ArrayList<File> pdfs = new ArrayList<File>();
		
		for (File file : fileList ) {
			if (file.getAbsolutePath().endsWith(".pdf")) {
				pdfs.add(file);
			}		    
		}
		return pdfs;
	}

}
