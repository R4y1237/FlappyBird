/*
Ray Wang and Jimmy Liu
11/11/2020
Teacher: Mr.Gugliemli
This program will create the game Flappy Bird
*/

import java.awt.*;
import hsa.Console;
import javax.swing.*;

// The "KeyPress" class.
public class KeyPress extends Thread
{
    Console c;
    boolean running, pressed, quit;
    ImageDisplayer bird;
    char key;
    int up; // The number of pixels the bird needs to move up

    int birdY;

    public KeyPress (Console con)
    {

	c = con;
	birdY = 250;

    }

//This method will wait for a keypress while the program is running
//No parameters 
//No return methods
    public void waitForKey ()
    {

	key = c.getChar ();

	if (key == 'q')
	{

	    quit = true;

	}
	else if (key == ' ' && up < 8)
	{
	    up = 10;
	    pressed = true;
	}
	try
	{
	    sleep (100);
	}
	catch (Exception e)
	{
	}

    }

//This method will just run the code
//No parameters
//No return methods
    public void control ()
    {

	while (running) // controlled by main thread
	{

	    waitForKey ();

	}

    }


    public void pauseGame ()
    {

	JFrame f = new JFrame ();

	JOptionPane.showMessageDialog (f, "The game is currently paused. Press \"ok\" to continue.");

    }


    public void run ()
    {

	running = true;
	key = 0;
	quit = false;
	control ();

    }
} // KeyPress class
