package logic;

import java.awt.Color;
import java.util.Random;

public class RandomColorPicker {

	public Color getRandomColor() {
		Random r = new Random();
		return new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
	}

}
