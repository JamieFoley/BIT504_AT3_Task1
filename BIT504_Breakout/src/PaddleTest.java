import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaddleTest {

    private Paddle paddle;

    
    @BeforeEach
    public void setUp() {
        paddle = new Paddle();
    }

    
    @Test
    public void testPaddleConstructor() {
        // Ensure that the paddle is initialised with the correct width and height
        assertEquals(Settings.PADDLE_WIDTH, paddle.getWidth());
        assertEquals(Settings.PADDLE_HEIGHT, paddle.getHeight());
    }

    
    @Test
    public void testResetPosition() {
        // Reset the paddle position
        paddle.resetPosition();

        // Ensure that the paddle is reset to the initial position
        assertEquals(Settings.INITIAL_PADDLE_X, paddle.getX());
        assertEquals(Settings.INITIAL_PADDLE_Y, paddle.getY());
    }

    
    @Test
    public void testUpdate() {
        // Reset the paddle to its initial position
        paddle.resetPosition();
        
        // set the initial position integer
        int initialX = paddle.getX();

        // Update the paddle with a positive velocity
        paddle.setXVelocity(1);
        paddle.update();

        // Ensure that the paddle has moved to the right based on its velocity
        assertEquals(initialX + paddle.getXVelocity(), paddle.getX());

        // Reset the paddle to its initial position	
        paddle.resetPosition();
        // Update the paddle with a negative velocity
        paddle.setXVelocity(-1);
        paddle.update();

        // Ensure that the paddle has moved to the left based on its velocity
        assertEquals(initialX + paddle.getXVelocity(), paddle.getX());
    }

    
    @Test
    public void testPreventMovingOutsideScreen() {
        // Move the paddle to the right edge of the screen
        paddle.setX(Settings.WINDOW_WIDTH - Settings.PADDLE_WIDTH);
        paddle.setXVelocity(1);

        // Update the paddle
        paddle.update();

        // Ensure that the paddle stays at the right edge of the screen
        assertEquals(Settings.WINDOW_WIDTH - Settings.PADDLE_WIDTH, paddle.getX());

        // Move the paddle to the left edge of the screen
        paddle.setX(0);
        paddle.setXVelocity(-1);

        // Update the paddle
        paddle.update();

        // Ensure that the paddle stays at the left edge of the screen
        assertEquals(0, paddle.getX());
    }


    @Test
    public void testSetXVelocity() {
        // Set a new x velocity
        int newXVelocity = 2;
        paddle.setXVelocity(newXVelocity);

        // Ensure that the x velocity is updated
        assertEquals(newXVelocity, paddle.getXVelocity());
    }
}
