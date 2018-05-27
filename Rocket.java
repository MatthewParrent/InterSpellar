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
	
	public void setVelocity(double a)
	{
		velocityX = a;
	}
	
	public double getPosition()
	{
		return positionX;
	}
	
	public void setBought(boolean b)
	{
		bought = b;
	}
	public boolean getBought()
	{
		return bought;
	}
	public double getVelocity()
	{
		return velocityX*vM;
	}
	
	public void newPosition(double t)
	{
		positionX += velocityX*t*vM;
	}
	public void render(GraphicsContext g) //draws the rocket
	{
		g.drawImage(image, positionX, positionY);
	}
	
	public String getRocketName()
	{
		return name;
	}
	
	public void addArmor()
	{
		armor++;
	}
	
	public int getArmor()
	{
		return armor;
	}
	
	public int getHitX()
	{
		return hitX;
	}
	
	public int getHitY()
	{
		return hitY;
	}
}
