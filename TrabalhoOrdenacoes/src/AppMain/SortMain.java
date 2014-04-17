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
		
		int[] testArray = createArray(10);
		
		
		//4 42 23 16 8  15 = 5
		//4 8  23 16 42 15 = 4
		//4 8  15 16 42 23 = 3
		//4 8  15 16 42 23 = 2
		//4 8  15 16 23 42 = 2
		
		System.out.println("Selection Sort: ");
		
		rdmz.randomize(testArray);
		System.out.println();
		System.gc();
		long startTime = System.nanoTime();
		
		SelectionSort select = new SelectionSort(testArray);
		select.selectionSort();
		
	
		
		long elapsedTime = System.nanoTime() - startTime;
		double time = (double) elapsedTime / 1000000000;
		select.print();
		
		System.out.println("selection sort time: " + time);
		System.out.println("Number of comparisons: "+select.getComparisonsCounter());
		System.out.println("Number of swaps: "+select.getSwapCounter());
		
		
		
	

		System.out.println("\nHeap Sort:");
		System.gc();
		startTime = System.nanoTime();
		
		HeapSort heap = new HeapSort(testArray);
		heap.heapSort();
		
		 elapsedTime = System.nanoTime() - startTime;
		 time = (double) elapsedTime / 1000000000;
		
		
		heap.print();
		System.out.println("heap sort time: " + time);
		System.out.println("Number of comparisons: "+heap.getComparisonscounter());
		System.out.println("Number of swaps: "+heap.getSwapCounter());
		
	}
}
