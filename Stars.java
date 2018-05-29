import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Stars
{
	private double positionY;
	private double velocityY;
	private double positionX;
	private Image image;
	public Stars()
	{
		positionY = 0;
		velocityY = 10;
		positionX = Math.random()*840;
		image = new Image("star.png", 15,15,true, false);
		
	}
	
	public void setVelocity(double y) // sets velocity of stars
	{
		velocityY = y;
	}
	public double getPositionX() // gets the x position of the star
	{
		return positionX;
	}
	public double getPositionY() // gets the y position of the star
	{
		return positionY;
	}
	
	public void newPosition(double t) // gets the new position after t time of the star
	{
		positionY += velocityY*t;
	}
	
	public void render(GraphicsContext g) //draws the star
	{
		g.drawImage(image, positionX, positionY);
	}
}
