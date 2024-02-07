import java.awt.Rectangle;

public class Sprite {
	
	protected int x,y,width,height;
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) { 
		this.y = y;
	}
	public void setWidth(int width) { 
		this.width = width;
	}
	public void setHeight(int height) { 
		this.height = height;
	}
	public int getX() { 
		return this.x;
	}
	public int getY() { 
		return this.y;
	}
	public int getWidth() { 
		return this.width;
	}
	public int getHeight() { 
		return this.height;
	}
	
	Rectangle getRectangle() {
		return new Rectangle(x, y, width, height);
	}
}
