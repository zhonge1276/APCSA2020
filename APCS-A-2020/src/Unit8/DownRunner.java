package Unit8;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class DownRunner
{
	public static void main( String args[] )
	{	
		int[] ray1 = {7,1,5,3,11,5,6,7,8};
		int[] ray2 = {40,30,20,10,9,8,7,5,2,1};
		int[] ray3 = {1};
		int[] ray4 = {1,2};
		System.out.println(RayDown.go(ray1));
		System.out.println(RayDown.go(ray2));
		System.out.println(RayDown.go(ray3));
		System.out.println(RayDown.go(ray4));
	}
}