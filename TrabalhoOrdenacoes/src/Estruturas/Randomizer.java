package Estruturas;


import java.util.Random; 

public class Randomizer {
	
	public void randomize(int[] array) {
		
		Random rand = new Random();
		
		for (int i = array.length; i >= 1; i--) {
			int choice = rand.nextInt(i);
			int temp = array[choice];
			array[choice] = array[i - 1];
			array[i - 1] = temp;
		System.out.print(array[i-1]+" ");
		}
	
	}
}
