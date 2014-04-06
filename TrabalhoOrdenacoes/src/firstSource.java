
import java.util.Random;

public class firstSource {


    public static void selectionSort(int[] numbers) {
	int outer, inner, min;
	for (outer = 0; outer < numbers.length - 1; outer++) {
		min = outer;
		for (inner = outer + 1; inner < numbers.length; inner++) {
			if (numbers[inner] < numbers[min]) {
				min = inner;
			}
		}
		int temp = numbers[outer];
		numbers[outer] = numbers[min];
		numbers[min] = temp;
	}
}
    
    
	public static void randomize(int[] array) {
		java.util.Random rand = new java.util.Random();
		for (int i = array.length; i > 1; i--) {
			int choice = rand.nextInt(i);
			int temp = array[choice];
			array[choice] = array[i - 1];
			array[i - 1] = temp;
		}
	}


	public static int[] createArray(int n) {
		int[] newArray = new int[n];
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			newArray[i] = random.nextInt(n);
		}
		return newArray;
	}
    
    
    public static void main(String [] args){
	
	int[] testArray = createArray(100000);
	
	randomize(testArray);
	System.gc();
	long startTime = System.nanoTime();
	selectionSort(testArray);
	long elapsedTime = System.nanoTime() - startTime;
	Double time = (double) elapsedTime / 1000000000;
	System.out.println("selection sort: " + time);
	
	
    }
    
    
}
