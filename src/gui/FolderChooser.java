package gui;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class FolderChooser extends JPanel {

	File directory = new File(".");

	public FolderChooser() {
		setLayout(new BorderLayout(20, 20));

		JFileChooser fileChooser = new JFileChooser(directory);
		fileChooser.setFileSelectionMode(1);
		fileChooser.setDialogTitle("Choose directory");

		add(fileChooser);

		int returnValue = fileChooser.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			directory = fileChooser.getSelectedFile();

			// this is where the magic happens
			File[] filesInDirectory = fileChooser.getSelectedFile().listFiles();

			add(new FileList(filesInDirectory));


		} else if (returnValue == JFileChooser.CANCEL_OPTION) {
			// cancel
		}
	}

}
