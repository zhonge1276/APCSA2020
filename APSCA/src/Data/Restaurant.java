package Data;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

//import core.data.DataSource;

public class Restaurant {
	private String name;
	private int zipcode;
	private String neighborhood;
	private int councilDistrict;
	private String policeDistrict;
	private String address;

	public Restaurant() {

	}

	public Restaurant(String newName, int newZip, String newHood, int newCouncil, String newPolice, String newAddress) {
		name = newName;
		zipcode = newZip;
		neighborhood = newHood;
		councilDistrict = newCouncil;
		policeDistrict = newPolice;
		address = newAddress;
	}

	public Restaurant(String newName, int newZip, String newHood, int newCouncil, String newPolice) {
		name = newName;
		zipcode = newZip;
		neighborhood = newHood;
		councilDistrict = newCouncil;
		policeDistrict = newPolice;
	}

	public Restaurant(String newName) {
		name = newName;

	}

	public static void main(String[] args) {

		ArrayList<Restaurant> places = loadXML();
		// System.out.println(places);
		System.out.println("Enter a neighborhood of Baltimore, MD. Example Hampden");
		Scanner keyboard = new Scanner(System.in);
		System.out.println(findByHood(keyboard.nextLine(), places));
		chainRestaurants(places);
		keyboard.close();
	}

	public static String findByHood(String passedHood, ArrayList<Restaurant> passedPlaces) {
		int count = 0;
		for (Restaurant rest : passedPlaces) {
			if (rest.getHood().equalsIgnoreCase(passedHood)) {
				count++;
			}
		}
		return "There are " + count + " restaurants in " + passedHood + ".";
	}

	public static void chainRestaurants(ArrayList<Restaurant> passedPlaces) {
		ArrayList<Restaurant> allChains = new ArrayList<Restaurant>();
		ArrayList<Integer> allChainsCounts = new ArrayList<Integer>();
		for (int i = 1; i < passedPlaces.size(); i++) {
			try {
				// if the restaurant's 0-8 is equal to the previous,
				if (passedPlaces.get(i).getName().substring(0, 8)
						.equalsIgnoreCase(passedPlaces.get(i - 1).getName().substring(0, 8))) {
					// if the list of chain restaurants already has it
					if (chainListContains(allChains, passedPlaces.get(i).getName().substring(0, 8))) {
						// set the allChainsCounts to be the value at the chainListIndex plus one
						allChainsCounts.set(chainListIndex(allChains, passedPlaces.get(i).getName().substring(0, 8)),
								allChainsCounts.get(
										chainListIndex(allChains, passedPlaces.get(i).getName().substring(0, 8))) + 1);
					} else {
						allChains.add(passedPlaces.get(i));
						allChainsCounts.add(2);
					}
				}
			} catch (Exception e) {
				// System.out.println("Error at i: " + i);
			}
		}
		System.out.println("\nHere is some information about the most popular restaurant names in Baltimore.");
		System.out.println(allChains);
		System.out.println(allChainsCounts);
		System.out.println();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("How many popular restaurant names do you want to find?");
		int numberToFind = scan.nextInt()+1;
		scan.close();
		

		for (int j = 1; j < numberToFind; j++) {
			int high = 0;
			int index = 0;
			for (int i = 0; i < allChainsCounts.size(); i++) {
				if (allChainsCounts.get(i) > high) {
					high = allChainsCounts.get(i);
					index = i;
				}
			}
			
			System.out.println("The rank " + j + " most popular name is: " + allChains.get(index).getName().toUpperCase()
					+ ", with a total of " + allChainsCounts.get(index) + " restaurants of that chain in Baltimore.");
			allChains.remove(index);
			allChainsCounts.remove(index);
		}
	}

	public static boolean chainListContains(ArrayList<Restaurant> chainList, String nameToCheck) {
		for (int i = 0; i < chainList.size(); i++) {
			if (chainList.get(i).getName().substring(0, 8).equalsIgnoreCase(nameToCheck)) {
				return true;
			}
		}
		return false;
	}

	public static int chainListIndex(ArrayList<Restaurant> chainList, String nameToCheck) {
		for (int i = 0; i < chainList.size(); i++) {
			if (chainList.get(i).getName().substring(0, 8).equalsIgnoreCase(nameToCheck)) {
				return i;
			}
		}
		return -1;
	}

	public static ArrayList<Restaurant> loadXML() {

		DataSource ds = DataSource.connect("https://data.baltimorecity.gov/api/views/k5ry-ef3g/rows.xml").load();
		// System.out.println(ds.getFullPathURL());
		// System.out.println(ds.getDataAccess());
		ArrayList<Restaurant> places = ds.fetchList(Restaurant.class, "row/row/name", "row/row/zipcode",
				"row/row/neighborhood", "row/row/councildistrict", "row/row/policedistrict", "row/row/location_1");

		return places;
	}

	public static ArrayList<Restaurant> loadCSV() {
		ArrayList<Restaurant> places = new ArrayList<Restaurant>();
		try {
			Scanner input = new Scanner(new File("src/dataLab/Restaurants.csv"));

			for (int i = 0; i < 48; i++) {
				input.nextLine();
			}

			while (input.hasNextLine()) {
				input.nextLine();
				// String[] temp = input.nextLine().split(",");

				ArrayList<String> temps = new ArrayList<String>();
				String better = input.nextLine();
				int betterIndex = 0;
				boolean alreadyQuote = false;
				for (int i = 0; i < better.length(); i++) {
					// System.out.print(better.charAt(i));
					if (better.charAt(i) == '"') {
						if (alreadyQuote == false) {
							alreadyQuote = true;
						} else {
							alreadyQuote = false;
						}
					} else if (better.charAt(i) == ',' && !alreadyQuote) {
						try {
							temps.add(better.substring(betterIndex, i));
						} catch (IndexOutOfBoundsException f) {
							System.out.println("Caught here");
							temps.add(better.substring(betterIndex));
						}
						betterIndex = i + 1;
					}
				}
				temps.add(better.substring(betterIndex));

				/*
				 * setName(temp[0]); zipcode = Integer.parseInt(temp[1]); neighborhood =
				 * temp[2]; councilDistrict = Integer.parseInt(temp[3]); policeDistrict =
				 * temp[4]; address = temp[5];
				 */

				// THE OUT OF BOUNDS IS ON TEMPs!
				// System.out.println(temps.size());
				// System.out.println("\n"+temps);
				// System.out.println(new
				// Restaurant(temps.get(0),Integer.parseInt(temps.get(1)),temps.get(2),Integer.parseInt(temps.get(3)),temps.get(4),temps.get(5).concat(",
				// Baltimore, MD\"")));
				places.add(new Restaurant(temps.get(0), Integer.parseInt(temps.get(1)), temps.get(2),
						Integer.parseInt(temps.get(3)), temps.get(4), temps.get(5).concat(", Baltimore, MD\"")));
				// sentiment.put(temp[0], Double.parseDouble(temp[1]));

			}
			input.close();
		} catch (Exception e) {
			System.out.println(/* "Error reading or parsing cleanSentiment.csv" */e);
		}
		return places;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}

	public String getHood() {
		return neighborhood;
	}

	public void setHood(String newHood) {
		neighborhood = newHood;
	}

	public String toString() {
		return name + " is in " + neighborhood;
	}
}
