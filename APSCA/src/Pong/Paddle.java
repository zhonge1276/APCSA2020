package Pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variables
   private int speed;

   public Paddle()
   {
	  super(10,10);
      speed = 5;
   }


   //add the other Paddle constructors



   public Paddle(int x, int y) {
	// TODO Auto-generated constructor stub
	   super(x, y);
	   
	   speed = 5;
   }


   public Paddle(int x, int y, int width) {
	// TODO Auto-generated constructor stub
	   super(x,y);
	   setWidth(width);
	   
	   speed = 5;
	}


   public Paddle(int x, int y, int width, int height, int speed) {
	// TODO Auto-generated constructor stub
	   
	   super(x,y,width,height);
	   
	   setColor(Color.RED);
	   
	   this.speed = speed;
}


   public Paddle(int x, int y, int width, int height, Color col, int speed) {
	// TODO Auto-generated constructor stub
	   
	   super(x,y,width,height,col);
	   this.speed = speed;
   }


   public void moveUpAndDraw(Graphics window)
   {

	  window.setColor(Color.white);
	  window.fillRect(getX(), getY(), getWidth(), getHeight());

      setY(getY()+speed);
      window.setColor(getColor());
	  window.fillRect(getX(), getY(), getWidth(), getHeight());

   }

   public void moveDownAndDraw(Graphics window)
   {
	   window.setColor(Color.white);
	   window.fillRect(getX(), getY(), getWidth(), getHeight());

	   setY(getY()-speed);
	   window.setColor(getColor());
	   window.fillRect(getX(), getY(), getWidth(), getHeight());

   }


   public int getSpeed() {
	return speed;
   }


   public void setSpeed(int speed) {
	this.speed = speed;
   }
   
   

   //add get methods
   
   public String toString() {
	   return "The Speed is " + speed;
   }
   
   
   //add a toString() method
}