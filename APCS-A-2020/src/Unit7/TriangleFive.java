package Unit7;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;
import java.util.Scanner;

public class TriangleFive
{
  private char letter;
  private int amount;

	public TriangleFive()
	{
    letter = ' ';
    amount = 0;
	}

	public TriangleFive(char c, int amt)
	{
    letter = c;
    amount = amt;
	}

	public void setLetter(char c)
	{
    letter = c;
	}

	public void setAmount(int amt)
	{
    amount = amt;
	}

	public String toString()
	{
		String output="";
    for (int i = 0; i < amount; i++) { //rows
      for (int j = amount; j > i; j--) { //columns
        char c = (char)(letter + amount - j);
        if (c > 'Z') {
          c = (char)(c-26);
        }
        for (int r = 0; r < j; r++) { //# of char groups 
          output += "" + c;
        }
        output += " ";
      }
      output += "\n";
    }
		return output;
	}
} 