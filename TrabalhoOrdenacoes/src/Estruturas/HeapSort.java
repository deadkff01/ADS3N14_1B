package Estruturas;

public class HeapSort {
	
	private int comparisonscounter;
	private int swapCounter;
	
	private int[] data;
	private int length;

	
	public HeapSort(int[] data) {
		
		this.data = data;
		length = data.length;
	}
	
	public void heapSort()
    {
      buildMaxHeap();
      int n = length;

      for (int i = length - 1; i > 0; i--)
      {
         swap( i , 0);
         maxHeapify( 0, --n);
      }
    }
    private  void buildMaxHeap()
    {
       for (int i = length/2 - 1; i >= 0; i--)
          maxHeapify( i , length);
    }
    private  void maxHeapify(int pos, int n)
    {
       int maxi;
       int l = 2 * pos + 1;
       int right = 2 * pos + 2;
     
       if ( (l < n) && (data[l] > data[pos]) )
       { 
          maxi = l;
          comparisonscounter++;
       }
       
       else
       {
          maxi = pos;
          comparisonscounter++;
       }
       
       if (right < n && data[right] > data[maxi])
       {
          maxi = right;
          comparisonscounter++;
       }
  
       if (maxi != pos)
       {    
    	   comparisonscounter++;
          swap (pos, maxi);
          maxHeapify(maxi, n);
       }
      
      
    }

    public  void swap (int j, int aposJ)
    {
       int aux = data[j];
       data[j] = data [aposJ];
       data[aposJ] = aux;
       
       swapCounter++;
    }
    
	   public void print() {
			for (int i = 0; i < length; i++) {
				System.out.print(data[i] + " ");
			}
			System.out.println();
		}
    
	public int getSwapCounter() {
		return swapCounter;
	}

	public int getComparisonscounter() {
		return comparisonscounter;
	}

}
