
import java.util.ArrayList;

public class Snake {

 // create an ArrayList of BodyParts to dynamically add or remove new Parts
	
	private ArrayList<BodyPart> bodyPart = new ArrayList<>();
	private Direction direction;

	public Snake(int i,int j) {
	
	// set the first bodypart to the current position of the snake
	
		bodyPart.add(new BodyPart(i, j));
		direction = direction.UP;
	}
	//returns the list with all bodyparts in it
	
	public ArrayList<BodyPart> getBody() {
		return bodyPart;
	}
	
	/**
	 * moves the snake in a Direction
	 * sets the bodypart to the position of its front bodypart
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

	// adds a new bodypart at the end of the snake
	
	public void eat() {
	
	// saves the position of the last BodyPart and adds one to it
	
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

	// returns to the head of the snake
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
