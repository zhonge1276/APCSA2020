package Unit6;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class Perfect
{
   private int number;

   public Perfect() {
	   number = 0;
   }
   
   public Perfect(int n) {
	   number = n;
   }

	public boolean isPerfect()
	{
		int sum = 0;
		for (int i = 1; i <= number/2; i++)
		{
	
			if (number % i == 0) {  //i is a divisor
		        sum = sum + i;
		      }
		    }
		    return sum == number; // == means it is perfect
			}
	 public String toString () {
		    String msg = " is not ";
		    if (isPerfect()) {
		      msg = " is ";
		    }
		    return number + msg + "perfect.";
		  }
}