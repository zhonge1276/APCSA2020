package Pong;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class InvisibleBall extends Ball
{
	private int randomNumber;
	private Color chosen;
	
   //constructors
   public InvisibleBall()
   {
		super(100,100);
   }

   public InvisibleBall(int x, int y)
   {

	   super(x,y);
	   randomNumber =(int) (Math.random() * 300);
	   chosen = Color.black;

   }

   public InvisibleBall(int x, int y, int wid, int ht)
   {

	   super(x,y,wid,ht);
	   randomNumber =(int) (Math.random() * 300);
	   chosen = Color.black;


   }

   public InvisibleBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {

	   super(x,y,wid,ht,Color.blue,xSpd,ySpd);
	   randomNumber =(int) (Math.random() * 300);
	   chosen = Color.black;


   }

   public InvisibleBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {

	   super(x,y,wid,ht,col,xSpd,ySpd);
	   randomNumber =(int) (Math.random() * 300);
	   chosen = Color.black;



   }

  

   public void moveAndDraw(Graphics window)
   {
	   
	   window.setColor(Color.white);
	   window.fillRect(getX(), getY(), getWidth(), getHeight());
	   
	   setX(getX()+getXSpeed());
	   setY(getY()+getYSpeed());

	   if (randomNumber >= 0) {
		   window.setColor(chosen);
		   randomNumber--;
	   }
	   else {
		   window.setColor(chosen);
		   randomNumber = (int) (Math.random() * 300);
		   double rand = Math.random();
		   
		   if (rand >=.5) {
			   chosen = Color.white;
		   }
		   else {
			   chosen = Color.black;
		   }
	   }
	   window.fillRect(getX(), getY(), getWidth(), getHeight());
   }
   
   public void erase(Graphics window) {
	   
	   window.setColor(Color.white);
	   window.fillRect(getX(), getY(), getWidth(), getHeight());
	   
   }
}
