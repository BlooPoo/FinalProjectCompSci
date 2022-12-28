import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Game {

	// define the constants for the size of the game board and the
	// number of food pieces
	private static final int BOARD_WIDTH = 10;
	private static final int BOARD_HEIGHT = 10;
	private static final int NUM_FOOD = 5;

	// define some instance variables for the game board, the snake,
	// and the food pieces
	private char[][] board;
	private Snake snake;
	private ArrayList<Food> food;

	private Scanner scanner;

	// the constructor for this class will initialize the board, snake, and food
	// pieces
	public Game() {
		// initialize the board to be an empty 2D array of
		// characters
		board = new char[BOARD_WIDTH][BOARD_HEIGHT];

		// scanner is used to get input to move the snake
		scanner = new Scanner(System.in);

		// create a new instance of the snake class and place it in
		// the center of the board
		snake = new Snake(BOARD_WIDTH / 2, BOARD_HEIGHT / 2);

		// create an array of FOOD objects and place them randomly on
		// the board.
		food = new ArrayList<>();

		for (int i = 0; i < NUM_FOOD; i++) {
			placeFood();
		}
	}

	/**
	 * place {@link Food} at random points on the {@value board} repeats the method
	 * if there is already {@link Food} on this spot
	 */
	private void placeFood() {
		int x = (int) (Math.random() * BOARD_WIDTH);
		int y = (int) (Math.random() * BOARD_HEIGHT);
		if (food.size() != 0) {
			for (Food f : food) {
				int xPos = f.getX();
				int yPos = f.getY();
				if (xPos == x || yPos == y) {
					placeFood();
					return;// important stops the whole method from continuing
				}
			}
		}
		food.add(new Food(x, y));
	}

	/**
	 * create a loop for the game which stops when the {@link checkGameOver} is true
	 */
	public void run() {

		System.out.println("Type in start to begin");
		
		while (true) {

			// first getInput to set the current position of the snake
			// (if called at the end the new position will
			// be updated after this turn)
			getInput();
			//check if the new position is out of bounds
			if(checkGameOver()) {
				break;
			}
			// then update the board with the new position
			updateBoard();

			// next print out the board
			printBoard();
			
		}
	}

	/**
	 * click into the console and type something in to start the moving process 
	 * press enter each time to set the position
	 */
	private void getInput() {
		char s = scanner.nextLine().charAt(0);
		switch (s) {
		case 'a':
			snake.moveLeft();
			return;
		case 'd':
			snake.moveRight();
			return;
		case 'w':
			snake.moveUp();
			return;
		case 's':
			snake.moveDown();
			return;
		}

	}

	/**
	 * check if the game is over
	 * 
	 * @return true if the border is touched or all the food is eaten
	 */
	private boolean checkGameOver() {
		Boolean gameOver = false;
		int x = snake.getHead().getX();
		int y = snake.getHead().getY();
		//
		if (x < 0 || x >= BOARD_WIDTH) {
			gameOver = true;
			System.out.println("GAME OVER");
		}
		if (y < 0 || y >= BOARD_HEIGHT) {
			gameOver = true;
			System.out.println("GAME OVER");
		}
		if (food.size() == 0) {
			gameOver = true;
			System.out.println("YOU WON");

		}

		return gameOver;
	}

	/**
	 * updating the board with the current positions of the snake and food pieces
	 */
	private void updateBoard() {
		// clear out any existing characters on the board by setting each
		// element to a space character
		for (int x = 0; x < BOARD_WIDTH; x++) {
			for (int y = 0; y < BOARD_HEIGHT; y++) {
				board[x][y] = ' ';
			}
		}
		// add in 'F' for each food piece
		for (Food f : food) {
			int x = f.getX();
			int y = f.getY();
			board[x][y] = 'F';
		}
		// add in characters for each part of the snakes body
		// 'H' for head and 'T' for tail
		for (BodyPart part : snake.getBody()) {
			int x = part.getX();
			int y = part.getY();
			if (part == snake.getHead()) {
				board[x][y] = 'H';
			} else {
				board[x][y] = 'T';
			}
		}

		for (Food f : food) {
			int x = f.getX();
			int y = f.getY();
			int sx = snake.getHead().getX();
			int sy = snake.getHead().getY();
			if (sx == x && sy == y) {
				snake.eat();
				food.remove(f);
				break;
			}
		}
	}

	/**
	 * print out the current state of the board to the console
	 */
	private void printBoard() {
		// print out a line of dashes to seperate each row of charachters on
		// the board ('-')
		for (int x = 0; x < BOARD_WIDTH + 2; x++) {
			System.out.print('-');
		}

		System.out.println();

		// loop through each row on the board and print out each character
		// followed by a line break. ('\n')
		for (int y = 0; y < BOARD_HEIGHT; y++) {
			System.out.print('|');

			for (int x = 0; x < BOARD_WIDTH; x++) {
				System.out.print(board[x][y]);
			}
		}
		System.out.println();
	}

}
