package FRQSet1;

import java.io.*;

public class Practice1_1{
	public class NumberCube{
		
		public int toss() {
			return (int)(Math.random()*6);
		}
		
	}
	
	public static int[] getCubeTosses (NumberCube cube, int numTosses) {
		int[] tosses = new int[numTosses];
		for(int i=0; i<numTosses; i++) {
			tosses[i] = cube.toss();
		}
		return tosses;
	}
	
	public static int getLongestRun(int [] values) {
		int index = -1;
		int longestRun = 0;
		int curCount = 0;
		int previousInt = 0;
		for(int i=0; i<values.length; i++) {
			if(values[i] == previousInt) {
				curCount++;
				if(curCount > longestRun) {
					longestRun = curCount;
					index = i;
				}
			} else {
				curCount = 0;
			}
			previousInt = values[i];
		}
		return index;
	}
}