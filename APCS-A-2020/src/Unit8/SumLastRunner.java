package Unit8;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class SumLastRunner
{
	public static void main( String args[] )
	{	
		int[] ray1 = {-99,1,2,3,4,5,6,7,8,9,10,5};
		int[] ray2 = {10,9,8,7,6,5,4,3,2,1,-99};
		System.out.println(RaySumLast.go(ray1));
		System.out.println(RaySumLast.go(ray2));	
	}
}