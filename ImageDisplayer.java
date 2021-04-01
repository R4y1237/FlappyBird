/*
Ray Wang and Jimmy Liu
11/11/2020
Teacher: Mr.Gugliemli
This program will create the game Flappy Bird
*/

import java.awt.*;
import hsa.Console;
import java.awt.image.*;
public class ImageDisplayer implements ImageObserver
{
    public Image Pic; 
    private Toolkit tk;
    private int xPos, yPos;
    private Console c; 
    public ImageDisplayer (Console con, String imgName)
    {
	tk = Toolkit.getDefaultToolkit ();
	Pic = tk.getImage (imgName);
	c = con;
 
    }
    public void display(int x, int y) {
	try {Thread.sleep(15);}catch(Exception e){}
	xPos = x; yPos = y;
	c.drawImage (Pic, x, y, this);
    }
 
    public boolean imageUpdate (Image img, int infoflags, int x, int y, int width, int height)
    {
	if (infoflags == 32)
	{
	    c.drawImage (Pic, xPos, yPos, null);
 
	}
 
	return true;
    }
 
 
 
}
