
public class BodyPart {
	private int x,y;
	
	/**
	 * create a {@link BodyPart} 
	 * @param x the x position 
	 * @param y the y position
	 */
	public BodyPart(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setX(int x) {
		this.x = x;
	}
}
