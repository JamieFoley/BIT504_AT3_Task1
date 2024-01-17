import java.awt.Graphics;

public class Paddle extends Sprite {

	private int xVelocity;
	
	public Paddle() {
		// TODO: Set width to Settings.PADDLE_WIDTH
		setWidth(Settings.PADDLE_WIDTH);
		// TODO: Set width to Settings.PADDLE_HEIGHT
		setHeight(Settings.PADDLE_HEIGHT);
		// TODO: Call resetPosition
		resetPosition();
	}
	
	public void resetPosition() {
		// TODO: Set initial position x and y (use INITIAL_PADDLE_X/Y)
		// Note: Check Ball.java for a hint
		setX(Settings.INITIAL_PADDLE_X);
		setY(Settings.INITIAL_PADDLE_Y);
	}
	
	public void update() {
		x += xVelocity;
		// TODO: Prevent the paddle from moving outside of the screen
		// This can be done using two if statements (one for the left side of the screen and one for the right)
		if (x > Settings.WINDOW_WIDTH - Settings.PADDLE_WIDTH) {
	        setX(Settings.WINDOW_WIDTH - Settings.PADDLE_WIDTH);
		}
		if (x < 0) {
			setX(0);
		}
	}
	
	public void paint(Graphics g) {
		g.setColor(Settings.PADDLE_COLOUR);
		g.fillRect(x, y, Settings.PADDLE_WIDTH, Settings.PADDLE_HEIGHT);
	}
	
	public void setXVelocity(int vel) {
		// TODO: Set x velocity
		xVelocity = vel;
	}
}
