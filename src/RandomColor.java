import java.awt.Color;
import java.util.Random;

public class RandomColor {
	
	public Color getRandomColor() {
		Random random = new Random();
	    int red = random.nextInt(256);
	    int green = random.nextInt(256);
	    int blue = random.nextInt(256);
		return new Color(red, green, blue);
	}

}
