package Unit7;
//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import java.util.Scanner;
import static java.lang.System.*;

public class RPSRunner
{
	public static void main(String args[])
	{
		System.out.println ("\nTest 2:");
	    Scanner keyboard = new Scanner (System.in);
	    System.out.println ("Enter your choice [r, p, s] ::");
	    String r = keyboard.next();
	    RockPaperScissors rps = new RockPaperScissors(r);
	    System.out.println(rps);		
	}
}



