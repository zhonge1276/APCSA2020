package Unit10;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ToyStore5
{
	private ArrayList<Toy> toyList;
	
	public ToyStore5(String toys)
	{
		toyList = new ArrayList<Toy>();
		loadToys(toys);
	}

	public void myName(){
		System.out.println("Emily Zhong");
		}
	
	public void loadToys( String toys )
	{
		Scanner scan = new Scanner(toys);
		while(scan.hasNext())
		{
			String t = scan.next();
			Toy wassup = getThatToy(t);
			if(wassup == null) 
			{
				Toy ne = new Toy(t);
				toyList.add(ne);
			}
			else
			{
				wassup.setCount(wassup.getCount()+1);
			}
		}
	}
  
  	public Toy getThatToy( String nm )
  	{
  		for(Toy i : toyList)
  		{
  			if(i.getName().equals(nm)) 
  			{
  				return i;
  			}
  		}
  		return null;
  	}
  
  	public Toy getMostFrequentToy()
  	{
  		int max = toyList.get(0).getCount();
  		Toy max2 = toyList.get(0);
  		for(Toy i : toyList)
  		{
  			if (i.getCount() > max) 
  			{
  				max = i.getCount();
  				max2 = i;
  			}
  		}
  		return max2;
  	}  
  	
  	public ArrayList<Toy> sortToysByCount()
  	{
  		ArrayList<Toy> temp = new ArrayList<Toy>();
  		while(toyList.size() > 0)
  		{
  			temp.add(getMostFrequentToy());
  			toyList.remove(getMostFrequentToy());
  		}
  		return temp;
  	}  
  	  
	public String toString()
	{
		return toyList.toString() + "\nmax == " + getMostFrequentToy() + "\nSorted by count:" + sortToysByCount();
	}
}