package FinalLabAssessment;

import java.util.ArrayList;
import java.util.Scanner;

public class Team {
	private String name;
	private int numHorses;
	private ArrayList<Horse> horseList;

	public Team() {
		name = "Legendary Race Team";
		numHorses = 0;
		horseList = new ArrayList<Horse>();
	}

	public Team(String n, int nh) {
		name = n;
		numHorses = nh;
		horseList = new ArrayList<Horse>();
	}

	public void addHorse(Horse h) {
		horseList.add(h);
	}

	public void addHorse(Horse h, int spot) {
		horseList.add(spot, h);
	}

	public void sort() {
		for (int i = 0; i < horseList.size(); i++) {
			String n = horseList.get(i).getName();
			for (int j = 0; j < horseList.size(); j++) {
				if (n.charAt(0) < horseList.get(j).getName().charAt(0)) {
					Horse speed = horseList.get(i);
					horseList.set(i, horseList.get(j));
					horseList.set(j, speed);
				} else if (n.charAt(1) < horseList.get(j).getName().charAt(1)
						&& n.charAt(0) == horseList.get(j).getName().charAt(0)) {
					Horse speed = horseList.get(i);
					horseList.set(i, horseList.get(j));
					horseList.set(j, speed);
				}
			}
		}
	}
	public Horse getHorse(String hName) {
		sort();
		ArrayList<Horse> sort = horseList;
		int first = 0;
		int last = sort.size() - 1;
		int mid = 0;
		while (first <= last) {
			mid = (first + last) / 2;
			if (sort.get(mid).getName().equals(hName) ) {
				return sort.get(mid);
			} else if (sort.get(mid).getName().charAt(0) < hName.charAt(0)) {
				first = mid + 1;
			} else if(sort.get(mid).getName().charAt(1) < hName.charAt(1) && sort.get(mid).getName().charAt(0) == hName.charAt(0)) {
				first = mid + 1;
			}
				else {
				last = mid - 1;
			}

		}
		return sort.get(mid);
	}
	public ArrayList<Horse> getList(){
		return horseList;
	}
	public Horse getHorse(int i ) {
		return horseList.get(i);
	}
	public void listSpeed() {
		ArrayList <Horse> forSpeed = horseList;
		for (int i = 0; i < getNumHorses(); i++) {
			int t = horseList.get(i).getStats().getAverageSpeed();
			for (int j = 0; j < getNumHorses(); j++) {
				if(t > horseList.get(j).getStats().getAverageSpeed()) {
					Horse speedVar = forSpeed.get(i);
					forSpeed.set(i, horseList.get(j));
					forSpeed.set(j, speedVar);
				}
			}
		}
		for (Horse horse : forSpeed) {
			System.out.println(horse.speedAna());
		}
	}
	public String getTeamName() {
		return name;
	}

	public int getNumHorses() {
		return numHorses;
	}

}