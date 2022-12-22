import java.util.Scanner.*; 


public class SnakeGame {

	public static void main(String[] args) {
		//Here we create a new instance of the game and call its run() method.

	Game game = new Game();
	game.run();	
	
	}
}

//Next we will create a class called Game, this class will contain all the logic for the game. 

public class Game {

//Here we'll define some constants for the size of the game board and the number of food pieces. 
	
private static final int BOARD_WIDTH = 10; 
private static final int BOARD_HEIGHT = 10; 
private static final int NUM_FOOD = 5; 

//Next, we also defined some instance variables for the game board, the snake, and the food pieces. 

private char[][]board;
private Snake snake; 
private Food[]food;

//The constructor for this class will initialize the board, snake, and food pieces. 

}