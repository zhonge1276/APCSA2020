package Unit10;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;
import java.util.Scanner;

public class ToyRunner
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
	   	String choice="";
			do{
				out.print("\nEnter the toy:: ");
				String toy = keyboard.next();
		
				out.print("Enter the count:: ");
	 			int count = keyboard.nextInt();			
				
				System.out.println(toy+" " + count);
				System.out.print("\nDo you want to enter another toy? ");
				choice=keyboard.next();			
			}while(choice.equals("Y")||choice.equals("y"));		
	}
	
}