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
 * A basic game object displayed as a yellow circle, starting in the upper left
 * corner of the game court.
 * 
 */
public class Circle extends GameObj {

	public static final String img_file = "NSMBWii1upMushroom.png";
	public static final int width = 20;
	public static final int height = 20;
	public static boolean state = true;
	public static String name = "circle";
	private static BufferedImage img;

	public Circle(int courtWidth, int courtHeight) {
		super(0, 0, width, height,
				courtWidth, courtHeight);
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
		g.setColor(Color.YELLOW);
		g.drawImage(img, pos_x, pos_y, width, height, null);
	}
	
	@Override
	public void remove() {
		state = false;
	}
	
	
	
	public void setxValue (int value) {
		pos_x = value;
	}
	
	public void setyValue (int value) {
		pos_y = value;
	}
	

}
