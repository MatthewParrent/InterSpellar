import java.util.ArrayList;

import javafx.scene.canvas.*;
import javafx.scene.image.Image;

public class Asteroids {

	private ArrayList<String> filename;
	private double velocityY;
	private double positionY;
	private double positionX;
	
	public Asteroids()
	{
		filename = new ArrayList<>();
		filename.add("moneybag.png");
		filename.add("moneybag.png");
		filename.add("moneybag.png");
		filename.add("moneybag.png");
		filename.add("moneybag.png");
		filename.add("moneybag.png");
		filename.add("moneybag.png");
		velocityY = 0;
		positionY = 0;
		positionX = Math.random()*800;
		
	}
	
	public void setVelocity(double y)
	{
		velocityY = y;
	}
	public double getPositionX()
	{
		return positionX;
	}
	public double getPositionY()
	{
		return positionY;
	}
	public void newPosition(double t)
	{
		positionY += (velocityY*t);
	}
	public void render(GraphicsContext g)
	{
		g.drawImage(new Image(filename.get((int)(Math.random()*filename.size()))), positionX, positionY);
	}
}
