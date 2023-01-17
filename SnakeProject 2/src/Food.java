import java.awt.Color;
import java.awt.Graphics;

public class Food {
	
	private int x,y;
	
	// define x and y between a function argument and a class member.
	
	public Food(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//here we draw a rectangle on x,y position with the size 9,9 to fit in the grid
	
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
