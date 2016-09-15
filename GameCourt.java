
/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.0, Mar 2013
 */

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

/**
 * GameCourt
 * 
 * This class holds the primary game logic for how different objects interact
 * with one another. Take time to understand how the timer interacts with the
 * different methods and how it repaints the GUI on every tick().
 * 
 */
@SuppressWarnings("serial")
public class GameCourt extends JPanel {

	// the state of the game logic
	private Square square; // the Black Square, keyboard control
	private Circle snitch; // the Golden Snitch, bounces
	private Poison poison; // the Poison Mushroom, doesn't move

	public boolean playing = false; // whether the game is running
	private JLabel status = new JLabel(); // Current status text (i.e.
											// Running...)

	private HighScoreFinder highScoreFinder;

	// Game constants
	public static final int COURT_WIDTH = 600;
	public static final int COURT_HEIGHT = 600;
	public static final int INTERVAL = 300;
	private int mousex;
	private int mousey;
	private ArrayList<GameObj> differentShapes = new ArrayList<GameObj>();
	private int timePassed = 0;
	private int score = 0;
	private String userName;
	private void tick() {
		if (playing == true && timePassed > 2000) {
			playing = false;
			if (score > highScoreFinder.getHighestScore()) {
				status.setText("Time's up, your score is " + score +  ". Congrats! You have the"
						+ " highest score!");
			}
			else {status.setText("Time's up, your score is " + score +  "; the highest score is " + 
			highScoreFinder.getHighestScore() + " by user " + highScoreFinder.getHighestScoreName());
			}
			timer.stop();
			repaint();
		}

		Random ran = new Random();

		int randomGeneratedNumber = ran.nextInt(3);
		if (randomGeneratedNumber == 0) {
			Square newSquare = new Square(COURT_WIDTH, COURT_HEIGHT);
			int x = ran.nextInt(600);
			int y = ran.nextInt(600);
			newSquare.setxValue(x);
			newSquare.setyValue(y);
			differentShapes.add(newSquare);
		} else if (randomGeneratedNumber == 1) {
			Poison newPoison = new Poison(COURT_WIDTH, COURT_WIDTH);
			int x = ran.nextInt(600);
			int y = ran.nextInt(600);
			newPoison.setxValue(x);
			newPoison.setyValue(y);
			differentShapes.add(newPoison);
		} else if (randomGeneratedNumber == 2) {
			Circle newCircle = new Circle(COURT_WIDTH, COURT_HEIGHT);
			int x = ran.nextInt(600);
			int y = ran.nextInt(600);
			newCircle.setxValue(x);
			newCircle.setyValue(y);
			differentShapes.add(newCircle);
		}
		repaint();

		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (playing == true) {
				mousex = e.getX();
				mousey = e.getY();
				ArrayList<GameObj> objectsToRemove = new ArrayList<GameObj>();
				for (GameObj element : differentShapes) {
					if (element.pos_x < mousex & mousex < (element.pos_x + element.width) & element.pos_y < mousey
							& mousey < element.pos_y + element.width) {
						if (element instanceof Square) {
							score = score + 1;
						} else if (element instanceof Circle) {
							score = score + 2;
						} else if (element instanceof Poison) {
							score = score - 1;
						}
						objectsToRemove.add(element);
					}
				}
				differentShapes.removeAll(objectsToRemove);
				repaint();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});
	}

	Timer timer = new Timer(INTERVAL, new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			timePassed = timePassed + 35;
			tick();
		}
	});

	public GameCourt(JLabel status) {
		String Name = JOptionPane.showInputDialog(null,
				 "Enter your name?",
				 JOptionPane.QUESTION_MESSAGE);
		userName = Name;
		JOptionPane.showMessageDialog(status, "Clicking the normal mushroom gives you points"
				+ ", clicking the one-up mushroom gives you more points and clicking the"
				+ " poison mushroom makes you lose points. GOOOOOOO!!");
		try {
			Reader in = new FileReader("High Scores List");
			highScoreFinder = new HighScoreFinder(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		timer.start();
		this.status = status;
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

	/**
	 * (Re-)set the game to its initial state.
	 */
	public void reset() {
		highScoreFinder.updateScoreList(score, userName);
		differentShapes.clear();
		score = 0;
		timePassed = 0;
		timer.restart();
		playing = true;
		status.setText("Running...");
	}

	/**
	 * This method is called every time the timer defined in the constructor
	 * triggers.
	 */

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (GameObj element : differentShapes) {
			element.draw(g);
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(COURT_WIDTH, COURT_HEIGHT);
	}
}
