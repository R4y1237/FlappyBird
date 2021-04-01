// The "Player" class.]
/*
Ray Wang & Jimmy Liu
11/16/2020
Teacher: Mr. Guglielmi
This program will create the game Flappy Bird
*/
public class Player implements Comparable
{

    private int score;
    private String name;

    public Player (int score, String name)
    {

	this.score = score;
	this.name = name;

    }

//This method will assign a score to a player
//1 parameter: Object other
//Returns 0,-1,1,or score-b.score
    public int compareTo (Object other)
    {
	if (this == null && other == null) {
	    return 0;
	} else if (this == null) {
	    return -1;
	} else if (other == null) {
	    return 1;
	} else {
	    Player b = (Player) other;
	    return score - b.score;
	}

    }

//This methods will return the score
//no parameters
//Returns score
    public int getScore ()
    {
	return score;
    }

//This method will return the name
//No parameters
//Return name
    public String getName ()
    {
	return name;
    }
} // Player class
