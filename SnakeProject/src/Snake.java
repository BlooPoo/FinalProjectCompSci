import java.util.ArrayList;

public class Snake {

	// create an ArrayList of BodyParts to dynamically add or remove new Parts
	private ArrayList<BodyPart> bodyPart = new ArrayList<>();

	public Snake(int i, int j) {
		// set the first part to the current position of the snake
		bodyPart.add(new BodyPart(i, i));
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
	 * move the snake to the left by three steps and changes head and tail position
	 * if the current moving direction was right and if the snake only consist of
	 * one part it just moves
	 */
	public void moveLeft() {

		if (bodyPart.size() > 1) {
			if (!isHeadOnRightSide()) {
				for (BodyPart b : bodyPart) {
					b.setX(b.getX() - 3);
				}
			} else {
				// save the x position to a variable so it doesn't get lost on the swap
				int x = getHead().getX();
				// swap head and tail
				getHead().setX(bodyPart.get(bodyPart.size() - 1).getX());
				bodyPart.get(bodyPart.size() - 1).setX(x);
			}
		} else {
			getHead().setX(getHead().getX() - 3);
		}

	}

	/**
	 * move the snake to the right by two steps and changes head and tail position
	 * if the current moving direction was left if the snake only consist of one
	 * part it just moves
	 */
	public void moveRight() {
		if (bodyPart.size() > 1) {
			if (isHeadOnRightSide()) {
				for (BodyPart b : bodyPart) {
					b.setX(b.getX() + 2);
				}
			} else {
				// save the x position to a variable so it doesn't get lost on the swap
				int x = getHead().getX();
				// swap head and tail
				getHead().setX(bodyPart.get(bodyPart.size() - 1).getX());
				bodyPart.get(bodyPart.size() - 1).setX(x);
			}
		} else {
			getHead().setX(getHead().getX() + 2);
		}
	}

	/**
	 * move the snake up one position
	 */
	public void moveUp() {
		for (BodyPart b : bodyPart) {
			b.setY(b.getY() + 1);
		}
	}

	/**
	 * move the snake down one position
	 */
	public void moveDown() {
		for (BodyPart b : bodyPart) {
			b.setY(b.getY() - 1);
		}
	}

	/**
	 * return the first {@link BodyPart} of the snake which is the head
	 * 
	 * @return bodyPart
	 */
	public BodyPart getHead() {
		return bodyPart.get(0);
	}

	/**
	 * check whether the head is on the right side of the snake
	 * 
	 * @return false when on the left side
	 */
	public Boolean isHeadOnRightSide() {
		if (getHead().getX() > bodyPart.get(bodyPart.size() - 1).getX()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * add a new {@link BodyPart} at the end of the {@link Snake}
	 */
	public void eat() {
		// save the position of the last BodyPart and adds one to it
		int x, y;
		if (isHeadOnRightSide()) {
			x = bodyPart.get(bodyPart.size() - 1).getX() - 1;
			y = bodyPart.get(bodyPart.size() - 1).getY();
		} else {
			x = bodyPart.get(bodyPart.size() - 1).getX() + 1;
			y = bodyPart.get(bodyPart.size() - 1).getY();
		}

		bodyPart.add(new BodyPart(x, y));
	}

}
