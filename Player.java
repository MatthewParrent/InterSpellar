import java.util.ArrayList;

public class Player // class with info about the player
{
	private String name; // name of player
	private ArrayList<Integer> scores; // ArrayList of scores
	private int highScore;
	private ArrayList<Rocket> rockets;
	private Rocket primaryRocket;
	private int coins;
	
	//constructor
	public Player(String n) // gets passed the players name
	{
		// initiliazes instance variables
		name = n; //sets passed name to this
		scores = new ArrayList<>();
		highScore = 0;
		AllPlayers.addPlayer(this); // adds this player to the arraylist of players
		rockets = new ArrayList<Rocket>();
		buyBaseRocket();
		coins = 0;
	}
	
	//returns high Score
	public int getHighScore()
	{
		return highScore;
	}
	
	// returns player name
	public String getName()
	{
		return name;
	}
	
	// adds score and updates the high score
	public void addScore(int s)
	{
		scores.add(s); //adds the latest score
		coins += s;
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
	
	public void changePrimaryRocket(int i)
	{
		primaryRocket = rockets.get(i);
	}
	
	public void buyBaseRocket()
	{
		rockets.add(new BaseRocket("briefcase.png"));
		primaryRocket = rockets.get(rockets.size()-1);
	}
	
	public Rocket getPrimaryRocket()
	{
		return primaryRocket;
	}
}
