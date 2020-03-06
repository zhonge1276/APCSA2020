package Unit11;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import static java.lang.System.*;

public class TriangleWord
{
	//instance variables and constructors could be present, but are not necessary
		
	public static void printTriangle(String word)
	{
		 int len = word.length();
		    for (int i = 1; i <= len; i++) { //row
		      for (int j = 1; j <= i; j++) { //repetition
		        System.out.print(word.substring(0, i));
		      }
		      System.out.println();
		    }
	}
}