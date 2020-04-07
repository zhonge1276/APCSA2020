package FinalLabAssessment;

import java.util.ArrayList;
import java.util.Scanner;


public class Statistics {
	private String gender;
	private int weight;
	private boolean tooOld;
	private ArrayList<Integer> speed; 
	
	
	public Statistics() {
		gender = "Female";
		weight = 1130;
		tooOld = false;
		speed = new ArrayList<Integer>();
	}
	public Statistics(String g, int w, boolean t, int [] speed) {
		this.speed = new ArrayList<Integer>();
		gender = g;
		weight = w;
		tooOld = t;
		for (int i : speed) {
			this.speed.add(i);
		}
	}
	public void changeStat(boolean  b) {
		tooOld = b;
	}
	public int getFastestSpeed() {
		int s = speed.get(0);
		for (int i = 0; i < speed.size(); i++) {
			if(speed.get(i) > s) {
				s = speed.get(i);
			}
		}
		return s;
	}
	
	public int getAverageSpeed() {
		int sum = 0;
		for (int d : speed) {
			sum += d;
		}
		return sum/speed.size();
	}
	public int getSlowestSpeed() {
		int s = speed.get(0);
		for (int i = 0; i < speed.size(); i++) {
			if(speed.get(i) < s) {
				s = speed.get(i);
			}
		}
		return s;
	}
	public int recordDays() {
		int count = 0;
		for (int d : speed) {
			if(d > 40) 
				count++;
		}
		return count;
			
		
	}
	public String getGender() {
		return gender;
	}
	public int getWeight() {
		return weight;
	}
	public boolean getTooOld() {
		return tooOld;
	}
	public boolean tooOld() {
		return tooOld;
	}
	public ArrayList <Integer> getSpeedList(){
		return speed;
	}
}
