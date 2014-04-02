import java.util.ArrayList;
import java.util.Random;


public class AppMain {
    
    public static final int LINHA = 5;
    public static final int COLUNA = 5;
    public static final String x[][] = null;
    private static String matrix [][] = new String [LINHA][COLUNA];
    
    public static void main(String[] args) {
	
	
	//matrix [1][1] = "2";
	//matrix [0][0] = "3";
	
	//insert(matrix,1,1);
	//insert(matrix,0,0);
	
	
	

	populateMatrix();
	//insertRandom(matrix,"3");
	//insertRandom(matrix,"4");
	display(matrix);
	
	
	/*
	char a = 'a';
	 System.out.println((char)65);
	 System.out.println((int)'A');
	      int i,j;
	        for (i=1; i<=5; i++) 
	        {
	            for (j=1; j<=i; j++) 
	            {
	                System.out.print((char)(j+64) + "  ");
	            }   
	            System.out.println();
	        }
*/	
	
	

	
    }
    public static void display(String x[][]){
	
	int coluna = 0;
	  
	  System.out.print("  ");
	for( coluna = 0; coluna < 3; coluna++){
	   
	    System.out.print(coluna+"\t");
	
	}System.out.println();

	for (int row = 0; row < x.length; row++){
	    
	    System.out.print((char)(65 + row) + " ");
		
	    for(coluna = 0; coluna < x[row].length; coluna++){
		 
		   // x = insert("2");
		    
		String symbol = ".";
		
		    if(x[row][coluna] == null){
			 x[row][coluna] = symbol;
		  }
		    
			System.out.printf(x[row][coluna]+ "\t");
			
		}
		System.out.println();
	}
	
	
	
    }
  
    public static void populateMatrix(){
	

	String entrada = "3";
	
	Navio navio = new Navio(1);
	navio.health = "2";

	
	    insertRandom(matrix, navio.health ,0,0);
	    insertRandom(matrix, entrada ,0,1);
	    insertRandom(matrix, entrada ,0,3);
	
	
    }
    
    
    
   
    
 
    public static void insertRandom(String x[][], String valor, int l, int c){
	

	int aux = 0;
	
	for (int row = 0; row < x.length; row++){
	
	    for(int coluna = 0; coluna < x[row].length; coluna++){
		for(int i = 0; i < 2; i ++){
		
		    x[l][c] = valor;
	
		    
		    
		    matrix = x;
		 
		}

	
		}
		
	}
	
	
    
    
    
    }


    
    

	

    
    /*
    public static void insert(String x[][], int c, int l){
	
	for (int row = 0; row < x.length; row++){
	   	
	    for(int coluna = 0; coluna < x[row].length; coluna++){
		 
		    x[l][c] = "5";
		    
		    matrix = x;
			
		}
		
	}
	
      }
      */
    

    public static String[][] insert(String a){
	
	String matrix2 [][]  = new String [LINHA][2];; 
	
	Random gerador = new Random(1);
	
	
	   for (int i = 0; i < matrix2.length; i++){
	       int rdm = gerador.nextInt();
	       matrix2[rdm][1] = a ;
	    }

	
	return matrix2;
	
    }
    
   
  


   
}
