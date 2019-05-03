package gui;

import java.awt.BorderLayout;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class FolderChooser extends JPanel {

	public FolderChooser() {
		setLayout(new BorderLayout(20, 20));
		File currentFolder = new File(".");
		JFileChooser fileChooser = new JFileChooser(currentFolder); // instansierer filechooser med default directory "."
		fileChooser.setApproveButtonText("Search for pdf's"); // velger knappetekst
		fileChooser.setFileSelectionMode(1); // kun velge mapper
		add(fileChooser);
		
		int choice = fileChooser.showOpenDialog(FolderChooser.this);
		if (choice == JFileChooser.CANCEL_OPTION) {
			// Bruker har avbrutt
			
		} else if(choice == JFileChooser.APPROVE_OPTION) {
			// Bruker har valgt mappe
			currentFolder = fileChooser.getCurrentDirectory()
		}
	}

}
