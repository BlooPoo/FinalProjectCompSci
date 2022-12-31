import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

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
	
	/**
	 * draw a rectangle on x,y position with the size 9,9 to fit in the grid
	 * @param g
	 */
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, 9, 9);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
