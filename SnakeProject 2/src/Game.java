import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener {

	// here we define the constants for the size of the game board and the number of food pieces
	private final int BOARD_WIDTH = 400, BOARD_HEIGHT = 400;
	private final int rows = 40, columns = 40;

	// then we define some instance variables for the game board, the snake, and the food pieces
	public Snake snake;
	private Food food;
	private ArrayList<Point> position = new ArrayList<>();

	private boolean run;
	private Timer timer;

	// the constructor for this class will initialize the board, snake, and food pieces
	public Game() {
		setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));

		// set the input focus to the window with the game in it
		setFocusable(true);

		createPositions();
		placeFood();
		snake = new Snake(position.get(100).x, position.get(600).y);
		addKeyListener(new Input(snake));

		run = true;
		timer = new Timer(80, this);
		timer.start();
	}

	//spawn Food randomly on the grid
	
	private void placeFood() {
		int pos = (int) (Math.random() * 1600);
		food = new Food(position.get(pos).x, position.get(pos).y);
	}

	//create a grid with positions for the food to be drawn on
	
	private void createPositions() {
		for (int k = 0; k < rows; k++) {
			for (int l = 0; l < columns; l++) {
				position.add(new Point(l * 10 + 1, k * 10 + 1));
			}
		}
	}

	/**
	 * check in the snake either collides with a wall, eats food, or collides with itself, stops
	 * the game if = true
	 */
	private void checkCollision() {
		int headX = snake.getHead().getX();
		int headY = snake.getHead().getY();

		// check if the head collides with a wall
		if (headX >= BOARD_WIDTH || headX < 0 || headY < 0 || headY >= BOARD_HEIGHT) {
			run = false;
			System.out.println("GAME OVER");
		}

		// check if the head collides with its own body
		for (int i = snake.getBody().size() - 1; i > 0; i--) {
			int x = snake.getBody().get(i).getX();
			int y = snake.getBody().get(i).getY();
			if (headX == x && headY == y) {
				run = false;
				System.out.println("GAME OVER");
			}
		}
		// check if the head eats the food
		if (headX == food.getX() && headY == food.getY()) {
			snake.eat();
			placeFood();
		}
	}

	// Overrides method from JComponent
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// create and draw the grid
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				g.fillRect(j * 10, i * 10, 1, 1);
			}
		}

		// draw the snake on the grid
		for (int i = 0; i < snake.getBody().size(); i++) {
			snake.getBody().get(i).draw(g);
		}

		// draw the food on the grid
		food.draw(g);

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (run) {
			snake.move();
			checkCollision();
		}
		// this is important so the method gets repeated and everything is redrawn after it
		// moved
		repaint();
	}

}
