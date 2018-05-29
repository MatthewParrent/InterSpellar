
public class ScoreSorter implements Comparable
{
	private String name;
	private int score;
	public ScoreSorter(String a, int b)
	{
		name = a;
		score = b;
	}
	
	@Override
	public int compareTo(Object b) // compares two scores
	{
		ScoreSorter a = (ScoreSorter)b;
		if(this.getScore()>a.getScore())
			return -1;
		else if(this.getScore()<a.getScore())
			return 1;
		else if(this.getName().compareTo(a.getName())<0)
			return -1;
		else if(this.getName().compareTo(a.getName())>0)
			return 1;
		return 0;
	}
	
	public String getName() // gets the name of the person who scored a certain score
	{
		return name;
	}
	
	public int getScore() // gets the score of a person who scored a certain score
	{
		return score;
	}

}
