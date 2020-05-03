package Pong;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private int leftScore;
	private int rightScore;
	
	private Wall leftWall;
	private Wall rightWall;
	private Wall topWall;
	private Wall bottomWall;


	public Pong()
	{
		//set up all variables related to the game
		
		ball = new Ball(100,100,20,20,Color.CYAN,1,1);
		
		ball = new BlinkyBall(100,100,20,20,Color.CYAN,1,1);
		
		ball = new InvisibleBall(100,100,20,20,Color.CYAN,1,1);
		
		ball = new SpeedUpBall(100,100,20,20,Color.CYAN,1,1);
		
		leftPaddle = new Paddle(20,10,20,100,Color.BLUE,4);
		
		rightPaddle = new Paddle(770,10,20,100,Color.BLUE,4);
		
		leftWall = new Wall(10,0,10 , 800, Color.white);
		rightWall = new Wall(790, 0, 10, 800, Color.white);
		
		topWall = new Wall(0,0,800,10, Color.green);
		bottomWall = new Wall(0,460,800,10, Color.green);


		keys = new boolean[4];

		leftScore = 0;
		rightScore = 0;
    	setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
   public void update(Graphics window){
	   paint(window);
   }

   public void paint(Graphics window)
   {
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();


		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);
		
		leftWall.draw(graphToBack);
		rightWall.draw(graphToBack);
		topWall.draw(graphToBack);
		bottomWall.draw(graphToBack);

		


		//see if ball hits left wall or right wall
		if(ball.didCollideLeft(rightWall) || ball.didCollideRight(leftWall))
		{
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			
			if (ball.didCollideRight(leftWall)) {
				rightScore++;
			}
			else {
				leftScore++;
			}
			
			graphToBack.setColor(Color.white);
			graphToBack.fillRect(350, 480, 100, 60);
			graphToBack.setColor(Color.black);

			graphToBack.drawString("Right Score: " + rightScore , 350, 500); 
			graphToBack.drawString("Left Score: " + leftScore , 350, 520); 
			ball.erase(graphToBack);
			ball.setXSpeed(1);
			ball.setYSpeed(1);
			ball.setX(390);
			ball.setY(200);
		}
		graphToBack.setColor(Color.black);
		graphToBack.drawString("Right Score: " + rightScore , 350, 500); 
		graphToBack.drawString("Left Score: " + leftScore , 350, 520);
	

		//see if the ball hits the top or bottom wall 

		if(ball.didCollideBottom(topWall) || ball.didCollideTop(bottomWall))
		{
			ball.setYSpeed(-ball.getYSpeed());
		}

		

		
		
		if (ball.didCollideRight(leftPaddle)) {
			ball.setXSpeed(ball.getXSpeed() * -1);
			
		}
		else if (ball.didCollideTop(leftPaddle) || ball.didCollideBottom(leftPaddle)) {
			ball.setYSpeed( ball.getYSpeed() * -1);
		}
		
	
		
		
		if (ball.didCollideLeft(rightPaddle))  {
			ball.setXSpeed(ball.getXSpeed() * -1);
		}
		else if (ball.didCollideTop(rightPaddle) || ball.didCollideBottom(rightPaddle)) {
			ball.setYSpeed( ball.getYSpeed() * -1);
		}
		

		//see if the paddles need to be moved

		if(keys[0] == true)
		{
			//move left paddle up and draw it on the window
			if (leftPaddle.getY()  + leftPaddle.getHeight() <= bottomWall.getY()) {
				leftPaddle.moveUpAndDraw(graphToBack);
			}
		}
		if(keys[1] == true)
		{
			//move left paddle down and draw it on the window
			if (leftPaddle.getY() >= topWall.getY() + topWall.getHeight() ) {
				leftPaddle.moveDownAndDraw(graphToBack);
			}

		}
		if(keys[2] == true)
		{
			
			if (rightPaddle.getY()  + rightPaddle.getHeight() <= bottomWall.getY()) {
				rightPaddle.moveUpAndDraw(graphToBack);
			}

		}
		if(keys[3] == true)
		{
			if (rightPaddle.getY() >= topWall.getY() + topWall.getHeight() ) {
				rightPaddle.moveDownAndDraw(graphToBack);
			}

		}


		
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'Z' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'M' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'Z' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'M' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}