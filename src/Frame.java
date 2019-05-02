import javax.swing.JFrame;

public class Frame extends JFrame {

	public Frame() {
		setSize(800, 600);
		setTitle("Pdf file operations");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setJMenuBar(new Menu(this));
		setVisible(true);
	}
	
	public void createCard() {
		add(new Card());
	}
	
}
