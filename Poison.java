/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.0, Mar 2013
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * A game object displayed using an image.
 * 
 * Note that the image is read from the file when the object is constructed, and
 * that all objects created by this constructor share the same image data (i.e.
 * img is static). This important for efficiency: your program will go very
 * slowing if you try to create a new BufferedImage every time the draw method
 * is invoked.
 */
public class Poison extends GameObj {
	public static final String img_file = "poison.png";
	public static final int SIZE = 60;
	public static String name = "poison";


	private static BufferedImage img;

	public Poison(int courtWidth, int courtHeight) {
		super(0, 0, SIZE, SIZE, courtWidth,
				courtHeight);
		
		try {
			if (img == null) {
				img = ImageIO.read(new File(img_file));
			}
		} catch (IOException e) {
			System.out.println("Internal Error:" + e.getMessage());
		}
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(img, pos_x, pos_y, width, height, null);
	}

	public String getName() {
		return name;
	}
	
	public void setxValue (int value) {
		pos_x = value;
	}
	
	public void setyValue (int value) {
		pos_y = value;
	}
	
	
}
