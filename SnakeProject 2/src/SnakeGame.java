
import javax.swing.JFrame;

public class SnakeGame {
	
	static JFrame window = new JFrame();

	public static void main(String[] args) {
		// creating a new instance of the game
		// and setting the window to Game size
		Game game = new Game();
		// end the application when window is closed
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(game);
		// pack the window with the information of the GamePanel
		window.pack();
		// place the window in the middle of the screen
		window.setLocationRelativeTo(null);
		
		window.setVisible(true);
		window.setResizable(false);
	}

}
