package PipeGame;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class RectangleImage extends Rectangle {

	public BufferedImage img;
	
	public RectangleImage(BufferedImage img, int x, int y) {
		this.x = x;
		this.y = y;
		this.img = img;
		this.width = img.getWidth();
		this.height = img.getHeight();
	}
	
}
