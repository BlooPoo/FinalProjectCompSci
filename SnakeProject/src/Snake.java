
import java.util.ArrayList;

public class Snake {

	// create an ArrayList of BodyParts to dynamically add or remove new Parts
	private ArrayList<BodyPart> bodyPart = new ArrayList<>();
	private Direction direction;

	public Snake(int i,int j) {
		// set the first part to the current position of the snake
		bodyPart.add(new BodyPart(i, j));
		direction = direction.UP;
	}
	/**
	 * return the list with all {@link BodyPart} in it
	 * 
	 * @return bodyPart
	 */
	public ArrayList<BodyPart> getBody() {
		return bodyPart;
	}
	/**
	 * move the snake to {@link Direction}
	 * set the {@link BodyPart} to the position of its front {@link BodyPart}
	 * changes only the direction of the head
	 */
	public void move() {
		for (int i = bodyPart.size() - 1; i > 0; i--) {
			int x = bodyPart.get(i - 1).getX();
			int y = bodyPart.get(i - 1).getY();
			bodyPart.get(i).setX(x);
			bodyPart.get(i).setY(y);
		}
		int headX = getHead().getX();
		int headY = getHead().getY();

		switch (direction) {
		case DOWN:
			getHead().setY(headY + 10);
			break;
		case LEFT:
			getHead().setX(headX - 10);
			break;
		case RIGHT:
			getHead().setX(headX + 10);
			break;
		case UP:
			getHead().setY(headY - 10);
			break;
		}
	}

	/**
	 * add a new {@link BodyPart} at the end of the {@link Snake}
	 */
	public void eat() {
		// save the position of the last BodyPart and adds one to it
		int x, y;
		x = bodyPart.get(bodyPart.size() - 1).getX();
		y = bodyPart.get(bodyPart.size() - 1).getY();

		switch (direction) {
		case DOWN:
			y -= 10;
			break;
		case LEFT:
			x += 10;
			break;
		case RIGHT:
			x -= 10;
			break;
		case UP:
			y += 10;
			break;
		default:
			break;

		}
		bodyPart.add(new BodyPart(x, y));
	}

	/**
	 * return the head of the sneak
	 * 
	 * @return {@link BodyPart}
	 */
	public BodyPart getHead() {
		return bodyPart.get(0);
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction d) {
		direction = d;
	}

}
