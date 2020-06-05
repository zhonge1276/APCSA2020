package Wackamole;

import javax.swing.*;
import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.*;

//figured out some JFrame components with help from Elevens
public class Game extends JFrame implements ActionListener{
	private static final int MAX_MOLES = 4; 
	private static final String SCORE_PREFIX = "Score: "; 
	private static final String TIME_PREFIX = "Time: "; 
	private static final double LENGTH_OF_GAME = .25*60000;
	private static final int TARGET_SCORE = 200; 
	private static final int MAX_LEVEL = 4;
	private static final int MOLES_PER_LEVEL = 6;   
	private static Random rand = new Random(); 
	private static  int numOfMoles = 6; 
	private static int level = 1; 
	static int score;
	static JLabel scoreLabel; 
	static JLabel timeLabel; 
	public static int molesAlive;
	
	Mole[] moles;  
	
	
	
	//found how to do message dialogs (for my introductory screen) on this site https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
	public static void main(String[] args) {
		Game this_game = new Game(); 
		JOptionPane.showMessageDialog(this_game, "Welcome to Wack-a-Mole! This game is made by Emily Zhong. \nInstructions: Click on a green space to get 10 points.\nThere are " + MAX_LEVEL + 
												" levels. Each level will last 15 seconds.\nYou need to get " + TARGET_SCORE + " points to move onto the next level. Good luck!");
		
		while(true) {
			
			while(level <= MAX_LEVEL) {
				
				JOptionPane.showMessageDialog(this_game, "Level " + level + "\n Number of Moles: " + numOfMoles + "\n Press OK to begin level.");
				
				this_game.playGame(); 
				
				if(score < TARGET_SCORE) {
					JOptionPane.showMessageDialog(this_game, "Level " + level + " Score: " + score + "\n Did not get to " + TARGET_SCORE + " points.  Game Over");
					break; 
					}
				
				nextLevel();
				
				if(level <= MAX_LEVEL) {
					this_game.dispose();
					this_game = new Game();
				}   	
			}
			
			if(level > MAX_LEVEL)
				JOptionPane.showMessageDialog(this_game, "Congratulations, you have won the game!");
			
			int response = JOptionPane.showConfirmDialog(this_game, "Thank you for playing!\n Do you want to play again?", "Play Again?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if (response == JOptionPane.NO_OPTION || response == JOptionPane.CLOSED_OPTION) 
				break; 
			
			resetLevel(); 
			this_game.dispose();
			this_game = new Game();
		
		}
		 
		this_game.dispose(); 
		 

	}
	
	public static void update_time(double timeRemaining) {
		timeLabel.setText(TIME_PREFIX + NumberFormat.getInstance().format(timeRemaining/1000)); 		
	}
	
		public static void update_score() {
			score += 10; 
			scoreLabel.setText(SCORE_PREFIX + score); 		
		}
	
	public Game() {
		setSize(500, 500); 
		setLayout(new BorderLayout()); 
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Whack-a-Mole"); 
		
		score = 0; 
		molesAlive = 0; 
		
		JPanel top = intitialize_top(); 
		add(top, BorderLayout.NORTH);
		
		JPanel field = intitialize_field(); 
		add(field, BorderLayout.CENTER);
		
		this.setVisible(true); 
		
		
	}
	 
	private JPanel intitialize_field() {
		JPanel field = new JPanel(); 
		field.setLayout(new GridLayout(4,3, 5, 5)); 
		moles = new Mole[numOfMoles]; 
		for(int x = 0; x < moles.length; x++) {
			moles[x] = new Mole();
			moles[x].addActionListener(this); 
			field.add(moles[x]); 	
		}
		return field; 
		
	}
	
	private JPanel intitialize_top() { 
		
		JPanel top = new JPanel(); 
		top.setLayout(new GridLayout(1,2)); 
		
		scoreLabel = new JLabel(); 
		timeLabel = new JLabel(); 
		scoreLabel.setText(SCORE_PREFIX);
		timeLabel.setText(TIME_PREFIX);
		top.add(scoreLabel); 
		top.add(timeLabel); 
		
		return top; 
	}
	
	private void playGame() {
		double startTime = new Date().getTime();   
		double currentTime = startTime;
		double timeRemaining = LENGTH_OF_GAME; 
		
		while(( LENGTH_OF_GAME - timeRemaining) < LENGTH_OF_GAME) {
			
			long time = System.currentTimeMillis();
			
			reviveMoles(); 
			updateMoles(); 
			
			try{
				long delay = Math.max(0, 32-(System.currentTimeMillis()-time));
				
				Thread.sleep(delay);
				}
			catch(InterruptedException e)
			{
					
			}
			
			currentTime = new Date().getTime(); 
			 
			timeRemaining = LENGTH_OF_GAME - (currentTime - startTime);
			
			update_time(timeRemaining); 
			
			
		}
		
		
	}
	
	private void updateMoles() {
		for(int x = 0; x < moles.length; x++)
			moles[x].update(); 
	}
	
	private void reviveMoles() {
		if (molesAlive < MAX_MOLES) {
			int randomMole = rand.nextInt(numOfMoles); 
			if(!moles[randomMole].getIsAlive()) {
				moles[randomMole].revive(); 
				molesAlive++; 
			}
		}
	}
	
	private static void nextLevel() {
		level++; 
		numOfMoles = MOLES_PER_LEVEL * level; 
	}
	
	private static void resetLevel() {
		level = 1; 
		numOfMoles = MOLES_PER_LEVEL; 
	}
	

	public void actionPerformed(ActionEvent event) {
		Mole clickedMole = (Mole) event.getSource();
		
		if(clickedMole.getIsAlive()) {
			clickedMole.kill();
			update_score(); 
		}
		
	}
	
}
