package FinalLabAssessment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		Scanner a;
		try {
			a = new Scanner(new File("src/FinalLabAssessment/stat.dat"));
			String name = a.nextLine();
			int num = Integer.parseInt(a.nextLine());
			Team t = new Team(name, num);
			System.out.print(name + ": " + num + " horses\n");
			for (int i = 0; i < num; i++) {
				String hName =  a.nextLine();
				String [] info = a.nextLine().split(" ");
				String [] speed  = a.nextLine().split(" ");
				int [] speedAlt = new int [3];
				for (int j = 0; j < speedAlt.length; j++) {
					speedAlt[j] = Integer.parseInt(speed[j]);
				}
				t.addHorse(new Horse(hName, info[0], Integer.parseInt(info[1]), info[2].equals("old"), speedAlt) );
				
				System.out.print("\n\n"+hName);
				System.out.println("\nGender: " + info[0]
						+ "\nWeight: " + Integer.parseInt(info[1])
						+ "\ntooOld: " + info[2]);
				System.out.print("Season Speed List (mph): ");
				Arrays.stream(speedAlt).forEach(s -> System.out.print(s + " "));
			}
			
			System.out.println("\n\n\nHorses in Alphabetical Order:");
			t.sort();
			ArrayList <Horse> list = t.getList();
			for (Horse horse : list) {
				System.out.println(horse.toString());
			}
			
			System.out.println("\n\n\nAnalysis of speed (mph) of each horse over the Season: ");
			for (int i = 0; i < t.getNumHorses(); i++) {
				System.out.println(t.getHorse(i).speedAna());
			}
			
			System.out.println("\n\n\nHorses Ranked From Fastest to Slowest (mph): ");
			t.listSpeed();
			
			System.out.println("\n\n\nNumber of Record Breaking Days for each Horse (Over 40 mph Days!): ");
			for (int i = 0; i < t.getNumHorses(); i++) {
				System.out.println(t.getHorse(i).recordNumber());
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
