package Estruturas;

public class SelectionSort {

	int comparisonscounter;
	int swapCounter = 0;

	private int[] data;
	private int length;


	public SelectionSort(int[] data) {
	
		this.data = data;
		length = data.length;
	}
	 

	   public void selectionSort() {
			int outer, inner, min;
		
			for (outer = 0; outer <= length -1; outer++) {
				min = outer;
				
				for (inner = outer + 1; inner < length; inner++) {
					
					if (data[inner] < data[min]) {

						min = inner;
						swapCounter++;
					
					}
		
					comparisonscounter++;
				}
				
				int temp = data[outer];
				data[outer] = data[min];
				data[min] = temp;
				
			}
			
			
		}
	
	   public void print() {
			for (int i = 0; i < length; i++) {
				System.out.print(data[i] + " ");
			}
			System.out.println();
		}
	   
	   public int getComparisonsCounter(){
		   
		   return comparisonscounter;
	   }
	   
   public int getSwapCounter(){
		   
		   return swapCounter;
	   }
}
