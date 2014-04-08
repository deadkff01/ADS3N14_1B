package Estruturas;

public class SelectionSort {

	int counter;
	
	   public void selectionSort(int[] numbers) {
			int outer, inner, min;
			for (outer = 0; outer < numbers.length - 1; outer++) {
				min = outer;
				for (inner = outer + 1; inner < numbers.length; inner++) {
					if (numbers[inner] < numbers[min]) {
						min = inner;
						counter++;
					}
				}
				
				counter++;
				int temp = numbers[outer];
				numbers[outer] = numbers[min];
				numbers[min] = temp;
			System.out.print(numbers[outer]+" ");
			}
		}
	
	
	   
	   public int getCounter(){
		   
		   return counter;
	   }
}
