package Unit6;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name

import static java.lang.System.*;
import java.util.Scanner;

public class WordRunner
{
	public static void main ( String[] args )
	{
		 Scanner keyboard = new Scanner(System.in);
			System.out.print("Enter a word :: ");
			String s = keyboard.next();	
	    
	    Word str = new Word(s);
	    System.out.println(str);		
	}
}