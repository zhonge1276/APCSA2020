package FinalLabAssessment;

import java.util.Scanner;



public class Horse {
	private String name;
	private Statistics stats;
	
	public Horse() {
		name =  "";
		stats =  new Statistics();
	}
	public Horse(String n, String g, int w, boolean t, int [] speed) {
		name = n;
		stats = new Statistics(g, w, t, speed);
	}
	
	public String getName() {
		return name;
	}
	public void changeStat(boolean b){
		stats.changeStat(b);
	}
	
	public boolean tooOld() {
		return stats.tooOld();
	}
	public int fastestSpeed() {
		return stats.getFastestSpeed();
	}
	public int slowestSpeed() {
		return stats.getSlowestSpeed();
	}
	public int recordDays() {
		return stats.recordDays();
	}
	public Statistics getStats() {
		return stats;
	}
	public String speedAna() {
		return "\n"+name + "\nSlowest Speed: " + stats.getSlowestSpeed()
		+ "\nFastest Speed: " + stats.getFastestSpeed()
		+ "\nAverage Speed: " + stats.getAverageSpeed();
	}
	public String recordNumber() {
		return "\n"+name+": "+ stats.recordDays();
	}
	public String toString() {
		String tString =  "";
		for (int d : stats.getSpeedList()) {
			tString += d  + " ";
		}
		return "\n"+name + "\nGender: " + stats.getGender()
				+ "\nWeight: " + stats.getWeight()
				+ "\nTooOld: " + stats.getTooOld()
				+ "\nWeek Speed Records (mph): " + tString;
	}
}