package Wackamole;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Mole extends JButton{
	
	private static final int MIN_LIFE = 50;  
	private static final int MAX_LIFE = 300;
	private ImageIcon image;
	private JLabel label;
	static Random rand = new Random(); 
	
	private boolean isAlive;
	private int life_count; 
	private int final_life; 
	
	public Mole() {
		isAlive = false; 
		this.setBackground(Color.RED); 
		life_count = 0; 	
	}
	
	public boolean getIsAlive() {
		return isAlive; 
	}
	public void revive() {
		if(!isAlive) {
			final_life = MIN_LIFE + rand.nextInt(MAX_LIFE - MIN_LIFE + 1); //set final life 
			isAlive = true; 
			this.setBackground(Color.GREEN); 
			ImageIcon image = new ImageIcon(getClass().getResource("mole.png"));
			Image imagehold = image.getImage();
			Image image2 = imagehold.getScaledInstance(350, 200, java.awt.Image.SCALE_SMOOTH);
			image = new ImageIcon(image2);
			label = new JLabel(image);
			add(label);
			
		}	
	}
	
	public void kill() {
			isAlive = false;
			this.setBackground(Color.RED); 
			remove(label);
			life_count = 0; 
			Game.molesAlive--; 
	}
	
	public void update() {
		if(isAlive) {
			life_count++; 
			 
			if(life_count == final_life) 
				this.kill();
		}
	}
}
