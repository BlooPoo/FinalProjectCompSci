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

public Game()
{
	//First we're going to initialize the board to be an empty 2D array of characters
	board = new char[BOARD_WIDTH][BOARD_HEIGHT];
	
	//then we're going to create a new instance of the snake class and place it in the center of the board
	snake = new Snake(BOARD_WIDTH / 2, BOARD_HEIGHT / 2);
	
	//Finally, we will create an array of FOOD objects and place them randomly on the board. 
	food = new Food[NUM_FOOD];
	for (int i = 0; i < NUM_FOOD; i++)
	{
		int x = (int)(Math.random() * BOARD_WIDTH);
		int y = (int)(Math.random() * BOARD_HEIGHT);
		food[i] = new Food(x,y); 
	}
}

//The run() method is where all of the game logic will go, it will contain a loop that runs until you die, or the game is over. 
public void run()
{
	//First, we will setup a boolean variable to keep track of whether or not the game is over. 
	boolean isGameOver = false;
	
	//here we enter our first loop that runs until the game is over.
	while(!isGameOver)
	{
		//Inside this loop, we will first update the board by calling upon the updateBoard method
		updateBoard();
		
		//then we will print out the board by calling on the printBoard method
		printBoard(); 
		
		//next, we will get input from the user by calling our getInput method
		getInput();
		
		//finally, we will check if the game is over by calling our checkGameOver() method. 
		isGameover = checkGameOver(); 
	}
}

//The updateBoard method is responsible for updating the board with the current positions of the snake and food pieces. 
private void updateBoard()
{
	//first we'll clear out any existing characters on the board by setting each element to a space charachter 
	for (int x  = 0; x < BOARD_WIDTH; x++)
	{
		for (int y  = 0; y < BOARD_HEIGHT; y++);
		{
			board[x][y] = ' '; 
		}
	}
	
	//next we will add in charachters for each part of the snakes body by looping through all of its boty parts and setting 
	/* each element on the board to whatever charachter, we'll use an S */
	for (BodyPart part: snake.getBody())
	{
		int x = part.getX();
		int y = part.getY();
		board[x][y] = 'S';
	}
	
	//finally we will add in charachters for each food piece by looping through them and setting each element on the board 
	/* to an F character */ 
	for (Food f: food)
	{
		int x = f.getX();
		int y = f.getY();
		board[x][y] = 'F'; 
	}
}

//The printBoard method is responsible for printing out the current state of the board to the console 

private void printBoard()
{
	//first we'll print out a line of dashes to seperate each row of charachters on the board ('-')
	for (int x = 0; x < BOARD_WIDTH + 2; x++)
	{
		System.out.print('-');
	}
	
	System.out.println();
	
	
	//next we will loop through each row on the board and print out each character followed by a line break. ('\n')
	for (int y = 0; y < BOARD_HEIGHT; y++)
	{
		System.out.print('|');
		
		for (int x = 0; x < BOARD_WIDTH; x++)
		{
			System.out.print(board[x][y]);
		}
	}
}

}