import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

public class CardIcon implements Icon {
	
	private Color color;
	
	public CardIcon(Color color) {
		this.color = color;
	}
	
	@Override
	public int getIconHeight() {
		return 10;
	}

	@Override
	public int getIconWidth() {
		return 10;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		g.setColor(color);
		g.fillRect(x, y, 10, 10);		
	}

}
