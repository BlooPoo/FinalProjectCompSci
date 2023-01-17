import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Input extends KeyAdapter {

	Snake snake;

	public Input(Snake s) {
		this.snake = s;
	}

	@Override
	public void keyPressed(KeyEvent e) {

//here we're going to use e.getKeyCode to detect if a key is being pressed, and give it a function
		
		switch (e.getKeyCode()) {

	//if the snake is not moving downwards, then when W is pressed the snake will move Upwards	
		
		case KeyEvent.VK_W:
			if (snake.getDirection() != Direction.DOWN) {
				snake.setDirection(Direction.UP);
			}
			break;

	//if the snake is not moving Right, then when A is pressed the snake will move Left	
			
		case KeyEvent.VK_A:
			if (snake.getDirection() != Direction.RIGHT) {
				snake.setDirection(Direction.LEFT);
			}
			break;
			
	//if the snake is not moving Left, then when D is pressed the snake will move Right			

		case KeyEvent.VK_D:
			if (snake.getDirection() != Direction.LEFT) {
				snake.setDirection(Direction.RIGHT);
			}
			break;
			
	//if the snake is not moving Up, then when S is pressed the snake will move Down			

		case KeyEvent.VK_S:
			if (snake.getDirection() != Direction.UP) {
				snake.setDirection(Direction.DOWN);
			}
			break;
		}
	}
}
