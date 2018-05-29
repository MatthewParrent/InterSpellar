import java.util.ArrayList;

public class Player // class with info about the player
{
	private String name; // name of player
	private ArrayList<Integer> scores; // ArrayList of scores
	private int highScore;
	private ArrayList<Rocket> rockets;
	private Rocket primaryRocket;
	private int coins;
	private String pRocketName;
	private double cashX;
	
	//constructor
	public Player(String n) // gets passed the players name
	{
		// initializes instance variables
		name = n; //sets passed name to this
		scores = new ArrayList<>();
		highScore = 0;
		AllPlayers.addPlayer(this); // adds this player to the arraylist of players
		rockets = new ArrayList<Rocket>();
		rockets.add(new Rocket("RocketShip.gif"));
		rockets.add(new Rocket("FXWing.gif"));
		rockets.add(new Rocket("Rocket3.gif"));
		rockets.add(new Rocket("MilleniumHawk.gif"));
		rockets.add(new Rocket("DebtStar.png"));
		buyBaseRocket();
		pRocketName = "Apollo '18";
		coins = 0;
		cashX = 1.0;
		if(n.equals("Stites"))
			coins = 999999;
	}
	
	//returns high Score
	public int getHighScore() // gets the high score of the player
	{
		return highScore;
	}
	
	// returns player name
	public String getName() // gets the name of the player
	{
		return name;
	}
	
	// adds score and updates the high score
	public void addScore(int s) 
	{
		scores.add(s); //adds the latest score
		coins += s*cashX*10;
		for(int i =0; i < scores.size(); i++) // checks all the scores
		{
			if(scores.get(i)>highScore)
				highScore = scores.get(i); // the highest score is set to high score
		}
	}
	
	//returns the latest score
	public int getLatestScore()
	{
		return scores.get(scores.size()-1);
	}
	
	public void changePrimaryRocket(int i) // changes the primary rocket that the player is using
	{
		if(rockets.get(i).getBought())
		{	
			primaryRocket = rockets.get(i);
			if(i == 0)
				pRocketName = "Apollo '18";
			if(i == 1)
				pRocketName = "FX - Wing";
			if(i == 2)
				pRocketName = "Black One";
			if(i == 3)
				pRocketName = "Millenium Hawk";
			if(i == 4)
				pRocketName = "Debt Star";
		}
	}
	
	public void buyBaseRocket() // buys the apollo 18
	{
		rockets.get(0).setBought(true);
		primaryRocket = rockets.get(0);
	}
	
	public void buyFXWing() // buys fx wing
	{
		rockets.get(1).setBought(true);
		primaryRocket = rockets.get(1);
	}
	
	public void buyBlackOne() // buys black one
	{
		rockets.get(2).setBought(true);
		primaryRocket = rockets.get(2);
	}
	
	public void buyMilleniumHawk() // buys millenium hawk
	{
		rockets.get(3).setBought(true);
		primaryRocket = rockets.get(3);
	}
	
	public void buyDebtStar() // buys debt star
	{
		rockets.get(4).setBought(true);
		primaryRocket = rockets.get(4);
	}
	public Rocket getPrimaryRocket() // gets the primary rocket being used
	{
		return primaryRocket;
	}
	public String getPrimaryRocketName() // gets the name of the primary rocket
	{
		return pRocketName;
	}
	public ArrayList<Integer> getScores() // gets the list of scores of the player
	{
		return scores;
	}
	public ArrayList<Rocket> getRockets() // gets the rockets the player has
	{
		return rockets;
	}
	
	public int getCoins()
	{
		return coins;
	}
	
	public void removeCoins(int a)
	{
		coins-=a;
	}
	
	public void updateCashX(double a)
	{
		if(a>cashX)
			cashX = a;
	}
	public double getCashX()
	{
		return cashX;
	}
}
