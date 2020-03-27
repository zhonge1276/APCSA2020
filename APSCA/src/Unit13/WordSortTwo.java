package Unit13;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class WordSortTwo
{
	private String[] wordRay;

	public WordSortTwo(String sentence)
	{
		wordRay = sentence.split(" ");
	}

	public void sort()
	{
		for (int i=1; i<wordRay.length; i++) {
			int j=i;
			while (j > 0 && wordRay[j].compareTo(wordRay[j-1]) < 0) {
				String temp = wordRay[j];
				wordRay[j] = wordRay[j-1];
				wordRay[j-1] = temp;
				j--;
			}
		}
	}

	public String toString()
	{
		String output="";
		for (int i=0; i<wordRay.length; i++) {
			output += wordRay[i] + "\n";
		}
		return output+"\n\n";
	}
}