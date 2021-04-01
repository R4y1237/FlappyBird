// The "Pipes" class.
/*
Ray Wang and Jimmy Liu
11/11/2020
Teacher: Mr.Gugliemli
This program will create the game Flappy Bird
*/

import java.awt.*;
import hsa.Console;

public class Pipes extends Thread
{
    Console c;           // The output console

    // Instance variables
    int height, xPos, score;
    boolean running, paused, counted, started = false; // started will be initialized at compile time
    final int pipeSpeed = 2;

    public Pipes (Console con)
    {
	c = con;
    }

//This method will set the pipes to a random height
//No parameters
//Returns variable random
    private int getRandomHeight ()
    {

	int random = (int) (Math.random () * 270) + 30;
	return random;

    }

//This method will create a new pipe so the game continues
//No parameters
//No return values
    public void newPipe ()
    {

	xPos = c.getWidth () - 20;
	height = getRandomHeight ();
	counted = false;

    }

//This method will display the pipes
//No parameters
//no return values
    public void display ()
    {

	c.setColor (new Color (0, 204, 0));
	c.fillRect (xPos, c.getHeight () - height, 70, height);
	c.fillRect (xPos, 0, 70, c.getHeight () - height - 175);

    }

//This method will do the collion detection for the pipes and ground
//2 parameters: int birdX, birdY
//2 return value: variable true and false
    public boolean collision (int birdX, int birdY)
    {

	// If the bird hit the ground
	if (birdY >= c.getHeight () - 52)
	{
	    return true;
	}

	// Checking to see if the bird is above the bottom of the top pipe
	if (birdY <= c.getHeight () - height - 205)
	{

	    if (birdX >= xPos - 50 && birdX <= xPos + 120)
	    {
		return true;
	    }

	}

	// Checking to see if the bird is below the top of the bottom pipe
	if (birdY >= c.getHeight () - height - 13)
	{

	    if (birdX >= xPos - 50 && birdX <= xPos + 120)
	    {
		return true;
	    }

	}

	return false;

    }


// Method run when the thread is started
//No parameters
//no return values
    public void run ()
    {

	started = true;
	newPipe ();
	running = true;
	while (running)
	{

	    if (!paused)
	    {
		display ();
		xPos -= pipeSpeed;

		if (xPos <= 195 && !counted) {
		    counted = true;
		    score++;
		}
		
		try
		{
		    sleep (5);
		}
		catch (Exception e)
		{
		}

		if (xPos <= 0)
		{
		    newPipe ();
		}
	    }

	}

    }
} // Pipes class
