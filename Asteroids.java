import java.util.ArrayList;

import javafx.scene.canvas.*;
import javafx.scene.image.Image;

public class Asteroids {

	private ArrayList<Image> filename;
	private double velocityY;
	private double positionY;
	private double positionX; 
	private Image image;
	
	public Asteroids()
	{
		filename = new ArrayList<>();
		filename.add(new Image("Asteroid1.gif", 150, 200, true, false));
		filename.add(new Image("asteroid.png", 64, 64, true, false));
		filename.add(new Image("asteroid.png", 64, 64, true, false));
		filename.add(new Image("asteroid.png", 64, 64, true, false));
		filename.add(new Image("asteroid.png", 64, 64, true, false));
		filename.add(new Image("asteroid.png", 64, 64, true, false));
		filename.add(new Image("asteroid.png", 64, 64, true, false));
		velocityY = 0;
		positionY = 0;
		positionX = Math.random()*800;
	//	image = filename.get((int)(Math.random()*7));
		image = filename.get(6);
	}

	public void setVelocity(double y) // sets the velocity of the asteriod
	{
		velocityY = y;
	}
	public double getPositionX() // gets the x position of the asteroid
	{
		return positionX;
	}
	public double getPositionY() // gets the y position of the asteroid
	{
		return positionY;
	}
	public void newPosition(double t) // gets the new position after t time has passed
	{
		positionY += (velocityY*t);
	}
	public void render(GraphicsContext g) // draws the asteroid
	{
		g.drawImage(image, positionX, positionY);
	}
}
