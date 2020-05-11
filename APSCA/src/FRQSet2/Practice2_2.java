package FRQSet2;

public class Practice2_2 {
public static int getPeakIndex(int[] array) {
	for (int k=1; k<array.length-1; k++) {
		if (array[k-1] < array[k] && array[k] > array[k+1])
			return k;
	}
	return -1;
}

public static boolean isMountain(int[] array) {
	int peak = getPeakIndex(array);
	return (peak != -1) && isIncreasing(array, peak) && isDecreasing(array, peak);
}

}
