package logic;

import java.io.File;

public class PdfFile {

	private File file;
	protected String status;
	private String searchString;

	public PdfFile(File pdf) {
		file = pdf;
		status = "UNSEARCHED";
	}

	public File getFile() {
		return file;
	}

	public String getFilePath() {
		return file.getAbsolutePath();
	}

	public String getSearchString() {
		return searchString;
	}

	public void searchInFile(String searchString) {
		status = "SEARCHING";
		// Legge inn kode for å sende fil til søke-klasse
	}

	public void setSearchResult(boolean result) {
		status = result ? "FOUND" : "NOTFOUND";
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String s) {
		status = s;
	}

}
