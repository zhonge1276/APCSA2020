package Pong;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Wall extends Block 
{
	

	public Wall()
	{
		super(200,200);
		
	}
	
	

	//add the other Ball constructors
   

   public Wall(int x, int y) {
		super(x,y);
	
		
		
	}



   public Wall(int x, int y, int width, int height) {
	   super(x, y, width, height);
	  
	      
   }



   public Wall(int x, int y, int width, int height, Color col) {
	// TODO Auto-generated constructor stub
	   super(x, y, width, height, col);
	   
	
   }


   //add the set methods
   
   


   
   
   public void erase(Graphics window) {
	   window.setColor(Color.white);
	   window.fillRect(getX(), getY(), getWidth(), getHeight());
   }
  


	public boolean equals(Wall obj)
	{
		
		if (this.getColor() == obj.getColor() && this.getHeight() == obj.getHeight() && this.getWidth() == obj.getWidth()) {
			
			return true;
		}
		

		return false;
	}   
	
	
}
