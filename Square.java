/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.0, Mar 2013
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * A basic game object displayed as a black square, starting in the upper left
 * corner of the game court.
 * 
 */
public class Square extends GameObj /*implements ActionListener*/ {
	public static final String img_file = "normalmushroom 2.png";
	public static int width = 20;
	public static int height = 20;
	public static boolean hasItBeenClicked = true;
	public static String name = "square";
	private static BufferedImage img;

	/**
	 * Note that, because we don't need to do anything special when constructing
	 * a Square, we simply use the superclass constructor called with the
	 * correct parameters
	 */
	public Square(int courtWidth, int courtHeight) {
		super(0, 0, width, height, courtWidth,
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
		g.setColor(Color.BLACK);
		//System.out.println(pos_x);
		//g.fillRect(this.pos_x, this.pos_y, width, height);
		g.drawImage(img, pos_x, pos_y, width, height, null);

	}
	/*
	public void draw(Graphics g) {
		if (hasItBeenClicked = false) {

			g.setColor(Color.BLACK);
			g.fillRect(pos_x, pos_y, width, height);

		} else if (hasItBeenClicked = true) {
			g.setColor(Color.white);
			System.out.println("Hi");
			g.fillRect(pos_x, pos_y, width, height);
		}
	}
*/
	
	@Override
	public void remove() {
		hasItBeenClicked = false;
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
