import java.awt.Graphics;

public class Ball extends Sprite {

	private double xVelocity = 2, yVelocity = -2;
	
	// Constructor
	public Ball() {
		setWidth(Settings.BALL_WIDTH);
		setHeight(Settings.BALL_HEIGHT);
		resetPosition();
	}
	
	/**
	 * Resets the ball to the initial position
	 * Uses Settings.INITIAL_BALL_X/Y to set the position of the ball
	 */
	public void resetPosition() {
		setX(Settings.INITIAL_BALL_X);
		setY(Settings.INITIAL_BALL_Y);
	}
	
	public void update() {
		x += xVelocity;
		y += yVelocity;
		
		// Bounce off left side of screen
		if(x <= 0) {
			// Set x to 0 so it does not leave the screen
			setX(0);
			// Change the x velocity to make the ball go right
			setXVelocity(2);
		}
		
		// Bounce off right side of screen
		if(x >= Settings.WINDOW_WIDTH - Settings.BALL_WIDTH * 2) {
			// Set x to the right edge of the screen (see the above if condition)
			setX(Settings.WINDOW_WIDTH - Settings.BALL_WIDTH * 2);
			// Change the x velocity to make the ball go left
			setXVelocity(-2);
		}
		
		// Bounce off top of screen
		if(y <= 0) {
			// Set y to 0 so it does not leave the screen
			setY(0);
			// Change the y velocity to make the ball go downward
			setYVelocity(2);
		}
		
	}
	
	public void setXVelocity(double x) {
		// Set the x velocity
		xVelocity = x;
	}
	public void setYVelocity(double y) {
		// Set the y velocity
		yVelocity = y;
	}
	
	public double getXVelocity() {
		return xVelocity;	
	}
	public double getYVelocity() {
		return yVelocity;
	}
	
	public void paint(Graphics g) {
		g.setColor(Settings.BALL_COLOUR);
		g.fillOval(x, y, Settings.BALL_WIDTH, Settings.BALL_HEIGHT);
	}
}
