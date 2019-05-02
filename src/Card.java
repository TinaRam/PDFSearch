import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Card extends JPanel implements ActionListener {

	private Color color;
	private FolderChooser folderChooser;
	private JButton button;

	public Card() {
		this.color = new RandomColor().getRandomColor();

		setLayout(new BorderLayout(20, 20));
		setBackground(this.color);

		add(button = new JButton("Select directory") {

			{
				addActionListener(Card.this);
			}
		}, BorderLayout.NORTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		button.setEnabled(false);
		add(new FolderChooser());
		updateUI();
	}

	public Color getColor() {
		return this.color;
	}

}
