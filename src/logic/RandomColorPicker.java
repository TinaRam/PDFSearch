package logic;

import java.awt.Color;
import java.util.Random;

public class RandomColorPicker {

	public Color getRandomColor() {
		return new Color(getRandIntOver30(), getRandIntOver30(), getRandIntOver30());
	}

	private int getRandIntOver30() {
		int n = new Random().nextInt(256);
		while (n < 100) {
			n = new Random().nextInt(256);
		}
		return n;
	}

}
