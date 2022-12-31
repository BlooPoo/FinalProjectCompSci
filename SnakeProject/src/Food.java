import java.awt.Color;
import java.awt.Graphics;

public class Food {
	
	private int x,y;
	
	/**
	 * create a {@link Food} 
	 * @param x the x position 
	 * @param y the y position
	 */
	public Food(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * draw a rectangle on x,y position with the size 9,9 to fit in the grid
	 * @param g
	 */
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, 9, 9);
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
