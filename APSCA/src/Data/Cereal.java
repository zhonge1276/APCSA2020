package Data;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Cereal {

	private String name;
	private int protein;
	private float carbohydrates;
	private double rating;

	public Cereal() {

	}

	public Cereal(String newName, int newProtein, float newCarbs, double newRating) {
		name = newName;
		protein = newProtein;
		carbohydrates = newCarbs;
		rating = newRating;
	}

	public Cereal(String newName, int newProtein, float newCarbs) {
		name = newName;
		protein = newProtein;
		carbohydrates = newCarbs;
	}

	public static void main(String[] args) {
		ArrayList<Cereal> cerealsArray = new ArrayList<Cereal>();
		
		try {
			Scanner input = new Scanner(new File("src/dataLab/cereal.csv"));

			while (input.hasNextLine()) {
				input.nextLine();
				String[] temp = input.nextLine().split(",");
				cerealsArray.add(new Cereal(temp[0], Integer.parseInt(temp[4]), Float.parseFloat(temp[8])));
				// System.out.println(temp);
			}
		} catch (Exception e) {
			System.out.println("the CSV failed.");
		}
		for (Cereal cer : cerealsArray) {
			System.out.println(cer);
		}

		Cereal best = cerealsArray.get(0);
		for (int i = 1; i < cerealsArray.size(); i++) {
			if (cerealsArray.get(i).getProtein() - cerealsArray.get(i).getCarbohydrates() > best.getProtein()
					- best.getCarbohydrates()) {
				best = cerealsArray.get(i);
			}
		}
		System.out.println("\nThe best cereal for a low-carb, high-protein diet is " + best.getName() + ", with "
				+ best.getProtein() + " grams of protein per serving and only " + best.getCarbohydrates()
				+ " grams of complex carbohydrates per serving.");

	}// end main()

	public static Cereal carbProtein(ArrayList<Cereal> cereals) {
		Cereal bestCereal = cereals.get(0);
		for (int i = 1; i < cereals.size(); i++) {
			if (cereals.get(i).getProtein() - cereals.get(i).getCarbohydrates() >= bestCereal.getProtein()
					- bestCereal.getCarbohydrates()) {
				bestCereal = cereals.get(i);
			}
		}
		return bestCereal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProtein() {
		return protein;
	}

	public void setProtein(int protein) {
		this.protein = protein;
	}

	public float getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(float carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public String toString() {
		return name + " has " + protein + " grams of protein, " + carbohydrates
				+ " grams of carbohydrates.";
	}
}