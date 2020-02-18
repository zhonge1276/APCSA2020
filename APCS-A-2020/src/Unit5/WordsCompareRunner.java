package Unit5;
//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

import java.util.Scanner;

public class WordsCompareRunner
{
   public static void main( String args[] )
   {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a word::");
		String one = keyboard.next();
		
		System.out.print("Enter a second word::");
		String two = keyboard.next();
		
		WordsCompare str = new
		WordsCompare(one, two);
		System.out.println(str);

	}
}