package Pong;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200);
		xSpeed = 3;
		ySpeed = 1;
	}
	
	

	//add the other Ball constructors
   

   public Ball(int x, int y) {
		super(x,y);
		this.xSpeed = 3;
		this.ySpeed = 1;
		
		
	}



   public Ball(int x, int y, int width, int height) {
	   super(x, y, width, height);
	   this.xSpeed = 3;
	   this.ySpeed = 1;
	      
   }



   public Ball(int x, int y, int width, int height, Color col) {
	// TODO Auto-generated constructor stub
	   super(x, y, width, height, col);
	   
	   this.xSpeed = 3;
	   this.ySpeed = 1;
	
   }



   public Ball(int x, int y, int width, int height, Color col, int xSpeed, int ySpeed ) {
	   super(x, y, width, height, col);
	   this.xSpeed = xSpeed;
	   this.ySpeed = ySpeed;
	}
   //add the set methods
   
   


   public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location
	   window.setColor(Color.white);
	   window.fillRect(getX(), getY(), getWidth(), getHeight());

      setX(getX()+xSpeed);
      setY(getY()+ySpeed);
		//setY
      window.setColor(getColor());
	  window.fillRect(getX(), getY(), getWidth(), getHeight());
		//draw the ball at its new location
	  
	 
	 
   }
   
   public void erase(Graphics window) {
	   window.setColor(Color.white);
	   window.fillRect(getX(), getY(), getWidth(), getHeight());
   }
   
	public int getXSpeed() {
		return xSpeed;
	}



	public void setXSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}



	public int getYSpeed() {
		return ySpeed;
	}



	public void setYSpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}



	public boolean equals(Ball obj)
	{
		
		if (this.getColor() == obj.getColor() && this.getHeight() == obj.getHeight() && this.getWidth() == obj.getWidth()) {
			
			return true;
		}
		

		return false;
	}   
	
	public String toString() {
		return xSpeed + ", " + ySpeed;
	}



	@Override
	public boolean didCollideLeft(Object obj) {
		// TODO Auto-generated method stub
		Block thing = (Block) obj;
		if (thing.getX() <= getX() + getWidth() && getY() >= thing.getY() && getY() <= thing.getY() + thing.getHeight()) {
			return true;
		}
		return false;
	}

		

	@Override
	public boolean didCollideRight(Object obj) {
		// TODO Auto-generated method stub
		Block thing = (Block) obj;
		if (thing.getX() + thing.getWidth() >= getX() && getY() >= thing.getY() && getY() <= thing.getY() + thing.getHeight()) {
			return true;
		}
		return false;
	}
	
	

	@Override
	public boolean didCollideTop(Object obj) {
		
		Block thing = (Block) obj;
		
		if( getY() + getHeight() >= thing.getY() && getX() >= thing.getX() && getX() <= thing.getX() + thing.getWidth()) {
			return true;
		}
		return false;
	}



	@Override
	public boolean didCollideBottom(Object obj) {
		
		Block thing = (Block) obj;
		if (getY() <= thing.getY()  && getX() >= thing.getX() && getX() <= thing.getX() + thing.getWidth()) {
			return true;
		}
		return false;
	}


   //add a toString() method
}