import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Rocket
{
	private Image image;
	private String fileName; // name of file containing picture
	private double velocityX;
	private double positionX;
	private int armor;
	private boolean bought;
	private String name;
	private double positionY;
	private int hitX;
	private int hitY;
	private double vM;
	
	public Rocket(String s)
	{
		fileName = s;
		velocityX = 0;
		positionX = 425;
		armor = 0;
		bought = false;
		positionY = 360;
		hitX = 45;
		hitY = 340;
		
		if(fileName.equals("RocketShip.gif"))
		{	
			name = "Apollo '18";
			image = new Image(fileName, 70, 100, false, false);
			vM = 1;
		}
		if(fileName.equals("FXWing.gif"))
		{	
			name = "FX - Wing";
			image = new Image(fileName, 80, 100, false, false);
			vM = 1.5;
		}
		if(fileName.equals("Rocket3.gif"))
		{	
			name = "Black One";
			image = new Image(fileName, 70,100, false, false);
			vM = 2;
		}
		if(fileName.equals("MilleniumHawk.gif"))
		{	name = "Millenium Hawk";
			image = new Image(fileName, 80,100, false, false);
			vM = 2.5;
		}
		if(fileName.equals("DebtStar.png"))
		{
			name = "Debt Star";
			image = new Image(fileName, 100, 100, false, false);
			vM = 3;
		}
	}
	
	public void setVelocity(double a) // changes velocity of rocket
	{
		velocityX = a;
	}
	
	public double getPosition() // gets position of rocket
	{
		return positionX;
	}
	
	public void setBought(boolean b) // sets whether the rocket is bought or not
	{
		bought = b;
	}
	public boolean getBought() // tells whether rocket is bought or not
	{
		return bought;
	}
	public double getVelocity() // gets velocity of rocket
	{
		return velocityX*vM;
	}
	
	public void newPosition(double t) // sets the new position of the rocket
	{
		positionX += velocityX*t*vM;
	}
	public void render(GraphicsContext g) //draws the rocket
	{
		g.drawImage(image, positionX, positionY);
	}
	
	public String getRocketName() // gets the name of the rocket
	{
		return name;
	}
	
	public void addArmor() // adds armor to rocket
	{
		armor++;
	}
	
	public int getArmor() // gets the armor of the rocket
	{
		return armor;
	}
	
	// Next two methods help define hitbox
	public int getHitX() // gets where the asteroid should hit the rocket in the x position
	{
		return hitX;
	}
	
	public int getHitY() // gets where the asteroid should hit the rocket in the y position
	{
		return hitY;
	}
}
