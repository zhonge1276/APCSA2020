package Unit11;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;

public class Doggies
{
	private Dog[] pups;

	public Doggies(int size)
	{
		pups = new Dog[size];
		
	}
	
	public void set(int spot, int age, String name)
	{
		//put a new Dog in the array at spot 
		if (spot < pups.length) {
			pups[spot] = new Dog(age, name);
		}
		//make sure spot is in bounds		
	}

	public String getNameOfOldest()
	{
		int max = 0;
		String maxName = "";
		for (int i = 0; i<pups.length; i++) {
			if (pups[i].getAge() > max)
			{
				max = pups[i].getAge();
				maxName = pups[i].getName();
			}
		}
		return maxName;
	}

	public String getNameOfYoungest()
	{
		int min = pups[0].getAge();
		String minName = pups[0].getName();
		for (int i=0; i<pups.length; i++) {
			if (pups[i].getAge() < min) {
				min = pups[i].getAge();
				minName = pups[i].getName();
			}
		}
		return minName;
	}

	public String toString()
	{
		return ""+Arrays.toString(pups);
	}
}