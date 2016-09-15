/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.0, Mar 2013
 */

import java.awt.Graphics;

/** An object in the game. 
 *
 *  Game objects exist in the game court. They have a position, 
 *  velocity, size and bounds. Their velocity controls how they 
 *  move; their position should always be within their bounds.
 */
public class GameObj {

	/** Current position of the object (in terms of graphics coordinates)
	 *  
	 * Coordinates are given by the upper-left hand corner of the object.
	 * This position should always be within bounds.
	 *  0 <= pos_x <= max_x 
	 *  0 <= pos_y <= max_y 
	 */
	public String name;
	public int pos_x; 
	public int pos_y;

	/** Size of object, in pixels */
	public int width;
	public int height;
	
	
	/** Velocity: number of pixels to move every time move() is called */

	

	/** Upper bounds of the area in which the object can be positioned.  
	 *    Maximum permissible x, y positions for the upper-left 
	 *    hand corner of the object
	 */
	public int max_x;
	public int max_y;

	/**
	 * Constructor
	 */

	public GameObj(int pos_x, int pos_y, 
			int width, int height, int court_width, int court_height){
		
			this.pos_x = pos_x;
			this.pos_y = pos_y;
			this.width = width;
			this.height = height;
			
			// take the width and height into account when setting the 
			// bounds for the upper left corner of the object.
			this.max_x = court_width - width;
			this.max_y = court_height - height;
		}


	/**
	 * Moves the object by its velocity.  Ensures that the object does
	 * not go outside its bounds by clipping.
	 */

	/**
	 * Prevents the object from going outside of the bounds of the area 
	 * designated for the object. (i.e. Object cannot go outside of the 
	 * active area the user defines for it).
	 */ 
	public void clip(){
		if (pos_x < 0) pos_x = 0;
		else if (pos_x > max_x) pos_x = max_x;

		if (pos_y < 0) pos_y = 0;
		else if (pos_y > max_y) pos_y = max_y;
	}

	/**
	 * Determine whether this game object is currently intersecting
	 * another object.
	 * 
	 * Intersection is determined by comparing bounding boxes. If the 
	 * bounding boxes overlap, then an intersection is considered to occur.
	 * 
	 * @param obj : other object
	 * @return whether this object intersects the other object.
	 */

	/**
	 * Determine whether this game object will intersect another in the
	 * next time step, assuming that both objects continue with their 
	 * current velocity.
	 * 
	 * Intersection is determined by comparing bounding boxes. If the 
	 * bounding boxes (for the next time step) overlap, then an 
	 * intersection is considered to occur.
	 * 
	 * @param obj : other object
	 * @return whether an intersection will occur.
	 */

	
	/** Update the velocity of the object in response to hitting
	 *  an obstacle in the given direction. If the direction is
	 *  null, this method has no effect on the object. */

	/** Determine whether the game object will hit a 
	 *  wall in the next time step. If so, return the direction
	 *  of the wall in relation to this game object.
	 *  
	 * @return direction of impending wall, null if all clear.
	 */

	/** Determine whether the game object will hit another 
	 *  object in the next time step. If so, return the direction
	 *  of the other object in relation to this game object.
	 *  
	 * @return direction of impending object, null if all clear.
	 */

	/**
	 * Default draw method that provides how the object should be drawn 
	 * in the GUI. This method does not draw anything. Subclass should 
	 * override this method based on how their object should appear.
	 * 
	 * @param g 
	 *	The <code>Graphics</code> context used for drawing the object.
	 * 	Remember graphics contexts that we used in OCaml, it gives the 
	 *  context in which the object should be drawn (a canvas, a frame, 
	 *  etc.)
	 */
	public void draw(Graphics g) {
		
	}


	public void remove() {
		// TODO Auto-generated method stub
		
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
