package Unit11;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import static java.lang.System.*;

public class TriangleWordRunner
{
	public static void main( String args[] )
	{
		 Scanner keyboard = new Scanner(System.in);
		    System.out.print("Enter a word :: ");
		    String word = keyboard.next();

		    TriangleWord.printTriangle(word);
	}
}