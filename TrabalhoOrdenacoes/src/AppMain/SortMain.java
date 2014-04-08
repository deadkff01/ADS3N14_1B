package AppMain;

import java.util.Random;

import Estruturas.*;

public class SortMain {
	
	
	public static int[] createArray(int n) {
		int[] newArray = new int[n];
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			newArray[i] = random.nextInt(n);
		}
		return newArray;
	}
    
    
	
	public static void main(String [] args){
		
		
		Randomizer rdmz = new Randomizer();
		
		SelectionSort select = new SelectionSort();
		
		int[] testArray = createArray(11);
		
		
		rdmz.randomize(testArray);
		System.out.println();
		System.gc();
		
		long startTime = System.nanoTime();
		select.selectionSort(testArray);
		System.out.println();
		
		
		long elapsedTime = System.nanoTime() - startTime;
		
		Double time = (double) elapsedTime / 1000000000;
		System.out.println("selection sort time: " + time);
		
		System.out.println("Number of comparisons: "+select.getCounter());
		
	    
		
	}
}
