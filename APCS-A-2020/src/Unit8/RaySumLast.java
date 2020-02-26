package Unit8;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class RaySumLast
{
	public static int go(int[] ray)
	{
		int one = ray.length;
		int two = ray[one-1];
		int sum = 0;
		
		if (one == 0){
			return -1;
		}
		
		for(int i=0; i<one; i++)
			if (ray[i]>two) {
				sum = sum +ray[i];
			}
	
		if (sum == 0) {
			return -1;
		}
		return sum;	
	}
}