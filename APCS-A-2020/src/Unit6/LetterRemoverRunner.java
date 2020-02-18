package Unit6;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class LetterRemoverRunner
{
	public static void main( String args[] )
	{
	    LetterRemover rm = new LetterRemover ();
	    rm.setRemover("I am Sam I am", 'a');
	    System.out.println(rm);  
	    rm.setRemover("Hello World I am here to see you go", 'o');
	    System.out.println(rm);		
											
	}
}