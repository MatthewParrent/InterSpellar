import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Rocket
{
	private Image image;
	private String fileName; // name of file containing picture
	private double velocityX;
	private double positionX;
	private int armor;
	
	public Rocket(String s)
	{
		fileName = s;
		velocityX = 0;
		positionX = 425;
		armor = 0;
		image = new Image(fileName);
	}
	
	public void setVelocity(double a)
	{
		velocityX = a;
	}
	
	public double getPosition()
	{
		return positionX;
	}
	
	public double getVelocity()
	{
		return velocityX;
	}
	
	public void newPosition(double t)
	{
		positionX += velocityX*t;
	}
	public void render(GraphicsContext g) //draws the rocket
	{
		g.drawImage(image, positionX, 426);
	}
}
