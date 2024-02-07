import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BallTest {

	private Ball ball;
	
	@BeforeEach
	public void setUp() {
		ball = new Ball();
	}
	
	
	@Test
	public void testBallConstructor() {
		// ensure that the ball is initialised with the correct width and height
		assertEquals(Settings.BALL_WIDTH, ball.getWidth());
		assertEquals(Settings.BALL_HEIGHT, ball.getHeight());
	}
	
	
	@Test
	public void testResetPosition() {
		// Reset the ball position
		ball.resetPosition();
		
		// Ensure that the ball is reset to the initial position
		assertEquals(Settings.INITIAL_BALL_X, ball.getX());
		assertEquals(Settings.INITIAL_BALL_Y, ball.getY());
	}
	
	
	@Test
	public void testUpdate() {
		// Save the initial position
		int initialX = ball.getX();
		int initialY = ball.getY();
	
		/// update the ball
		ball.update();
		
		// ensure that the ball has moved based on its velocity
		assertEquals(initialX + ball.getXVelocity(), ball.getX());
		assertEquals(initialY + ball.getYVelocity(), ball.getY());
	}
	
	
	@Test
	public void testBounceOffLeftSide() {
		// move the ball to the left edge of the screeen
		ball.setX(0);
		
		// set the velocity to make the ball go left
		ball.setXVelocity(-1);
		
		// update the ball
		ball.update();
		
		// ensure that the ball bounces off the left side
		assertEquals(1, ball.getXVelocity());
	}
	
	
	@Test
	public void testBounceOffRightSide() {
		// move the ball to the right edge of the screen
		ball.setX(Settings.WINDOW_WIDTH - Settings.BALL_WIDTH);
		
		// set the velocity to make the ball go right
		ball.setXVelocity(1);
		
		// update the ball
		ball.update();
		
		// ensure that the ball bounces off the left side
		assertEquals(-1, ball.getXVelocity());
	}
	
	
    @Test
    public void testSetXVelocity() {
        // Set a new x velocity
        int newXVelocity = 2;
        ball.setXVelocity(newXVelocity);

        // Ensure that the x velocity is updated
        assertEquals(newXVelocity, ball.getXVelocity());
    }

    
    @Test
    public void testSetYVelocity() {
        // Set a new y velocity
        int newYVelocity = 2;
        ball.setYVelocity(newYVelocity);

        // Ensure that the y velocity is updated
        assertEquals(newYVelocity, ball.getYVelocity());
    }
}
