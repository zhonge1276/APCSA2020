package Unit6;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*; 
import java.util.Scanner;
public class PerfectRunner
{
	public static void main( String args[] )
	{
		 Scanner keyboard = new Scanner(System.in);
			System.out.print("Enter an integer :: ");
			int i = keyboard.nextInt();	
	    
	    Perfect perf = new Perfect(i);
	    System.out.println(perf);
																
	}
}