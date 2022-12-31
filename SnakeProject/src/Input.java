import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Input extends KeyAdapter {

	Snake snake;

	public Input(Snake s) {
		this.snake = s;
	}

	@Override
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {

		case KeyEvent.VK_W:
			if (snake.getDirection() != Direction.DOWN) {
				snake.setDirection(Direction.UP);
			}
			break;

		case KeyEvent.VK_A:
			if (snake.getDirection() != Direction.RIGHT) {
				snake.setDirection(Direction.LEFT);
			}
			break;

		case KeyEvent.VK_D:
			if (snake.getDirection() != Direction.LEFT) {
				snake.setDirection(Direction.RIGHT);
			}
			break;

		case KeyEvent.VK_S:
			if (snake.getDirection() != Direction.UP) {
				snake.setDirection(Direction.DOWN);
			}
			break;
		}
	}
}
