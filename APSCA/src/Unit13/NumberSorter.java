package Unit13;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays; 
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberSorter
{
	//instance variables and other methods not shown

	private static int getNumDigits(int number)
	{
		int count = 0;
		int temp = number;
		while (temp > 0) {
			temp = temp / 10;
			count++;
		}
		return count;
	}

	public static int[] getSortedDigitArray(int number)
	{
		int length = getNumDigits(number);
		int[] sorted = new int[length];
		int d = 0;
		
		while (number > 0) {
			sorted[d] = number % 10;
			number /= 10;
			d++;
		}
		
		for (int i=1; i<sorted.length; i++) {
			int j = i;
			while (j > 0 && sorted[j] < sorted[j-1]) {
				int temp = sorted[j];
				sorted[j] = sorted[j-1];
				sorted[j-1] = temp;
				j--;
			}
		}
		
		return sorted;
	}
}