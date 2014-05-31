/**Trabalho das arvores AVL e RBT
 * 
 * @author Dennis Kaffer

 * @version 1.0

 */

import java.util.*;

public class AppMain {

	private static Scanner sc;

	public static void main(String[] args) {
		
		//testando a avl..
		AvlTree<Integer> avlNormalInsertion = new AvlTree<Integer>();
		RedBlackTree<Integer> rbNormalInsertion = new RedBlackTree<Integer>();
		
		int n = 50;
		int[] newArray = new int[n];
	    Random rd = new Random();
	    System.out.print("Vetor inserido: ");
	   //cria array de inteiro randomico 
	  for(int i = 0; i < newArray.length; i++){
		newArray[i] = rd.nextInt(100);
        if(i > 0)
            for(int j=0; j <= i-1; j++)
                if(newArray[j] == newArray[i])
                    i--;
    }
    
	  for(int k = 0; k < newArray.length; k++){
	    System.out.print(newArray[k]+" ");
		avlNormalInsertion.addAVL(newArray[k]);
		rbNormalInsertion.addRBT(newArray[k]);
	}

	  System.out.println();
	        System.out.println("-AVL- INSERCAO NORMAL ");
		    System.out.println("PRINT AVL INFIXA:  "+avlNormalInsertion.infixa());
	
		    System.out.println("PRINT AVL PREFIXA: "+avlNormalInsertion.prefixa());
	        System.out.println("PRINT AVL POSFIXA: "+avlNormalInsertion.posfixa());
	        
	        System.out.println("Rotacoes feitas pela AVL para inserir todos os elementos: "+avlNormalInsertion.countRotations+ 
	        		" | Altura da AVL: "+ avlNormalInsertion.avlTreeHeight);
	 	   
	        System.out.println();
	
	        System.out.println("-REDBLACK- INSERCAO NORMAL ");
			System.out.println("PRINT RBT INFIXA:  "+rbNormalInsertion.infixa());
			//avl.removeAVL(4);
			System.out.println("PRINT RBT PREFIXA: "+rbNormalInsertion.prefixa());
		    System.out.println("PRINT RBT POSFIXA: "+rbNormalInsertion.posfixa());
		    System.out.println();
		    System.out.println("Rotacoes feitas pela RBT para inserir todos os elementos: "+rbNormalInsertion.countRotations+
		    		" | Altura da RBT: "+ rbNormalInsertion.rbTreeHeight);
		    System.out.println();
		    if(avlNormalInsertion.countRotations < rbNormalInsertion.countRotations ){
		    	System.out.println("A AVL é melhor que a RBT com esse vetor de tipo embaralhado!!");
		    }else{
		    	System.out.println("A RBT é melhor que a AVL com esse vetor de tipo embaralhado!!");
		    }
		    if(avlNormalInsertion.countRotations == rbNormalInsertion.countRotations){
		    	
		    	System.out.println("Empate, as duas arvores mostraram a mesma eficiencia..");
		    }
		    System.out.println("------------------------------------------");
		    
   
   AvlTree<Integer> avlInOrderInsertion = new AvlTree<Integer>();
   RedBlackTree<Integer> rbInOrderInsertion = new RedBlackTree<Integer>();

   //ordena o array randomico
	Arrays.sort(newArray);
	for (int i = 0; i < n; i++) {
	
		//System.out.print(newArray[i] );
		avlInOrderInsertion.addAVL(newArray[i]);
		rbInOrderInsertion.addRBT(newArray[i]);
	}
	
	
	     System.out.println("-AVL- INSERCAO ORDENADA ");
		 System.out.println("PRINT AVL INFIXA:  "+avlInOrderInsertion.infixa());
		 System.out.println("PRINT AVL PREFIXA: "+avlInOrderInsertion.prefixa());
	     System.out.println("PRINT AVL POSFIXA: "+avlInOrderInsertion.posfixa());
	     System.out.println("Rotacoes feitas pela AVL: "+avlInOrderInsertion.countRotations+ 
	        		" | Altura da AVL: "+ avlInOrderInsertion.avlTreeHeight);
	     System.out.println();
	   
	     System.out.println("-REDBLACK- INSERCAO ORDENADA ");
		 System.out.println("PRINT RBT INFIXA:  "+rbInOrderInsertion.infixa());
		 System.out.println("PRINT RBT PREFIXA: "+rbInOrderInsertion.prefixa());
		 System.out.println("PRINT RBT POSFIXA: "+rbInOrderInsertion.posfixa());
		 System.out.println();
		  System.out.println("Rotacoes feitas pela RBT para inserir todos os elementos: "+rbInOrderInsertion.countRotations+
		    		" | Altura da RBT: "+ rbInOrderInsertion.rbTreeHeight);
		  System.out.println();
		  
		    if(avlInOrderInsertion.countRotations < rbInOrderInsertion.countRotations ){
		    	System.out.println("A AVL é melhor que a RBT com esse vetor de tipo ordenado!!");
		    }else{
		    	System.out.println("A RBT é melhor que a AVL com esse vetor de tipo ordenado!!");
		    }
		    if(avlInOrderInsertion.countRotations == rbInOrderInsertion.countRotations){
		    	
		    	System.out.println("Empate, as duas arvores mostraram a mesma eficiencia..");
		    }
		 System.out.println("------------------------------------------");
	    
	    
    AvlTree<Integer> avlRevertedInsertion = new AvlTree<Integer>();
    RedBlackTree<Integer> rbRevertedInsertion = new RedBlackTree<Integer>();
  //reverte a ordenacao do array
    for(int i=newArray.length-1;i>=0;i--){
		
		//System.out.print(newArray[i]);
    	avlRevertedInsertion.addAVL(newArray[i]);
    	rbRevertedInsertion.addRBT(newArray[i]);
		
	}
        System.out.println("-AVL- INSERCAO INVERSA ");
	    System.out.println("PRINT AVL INFIXA:  "+avlRevertedInsertion.infixa());
	//avl.removeAVL(4);
	    System.out.println("PRINT AVL PREFIXA: "+avlRevertedInsertion.prefixa());
        System.out.println("PRINT AVL PREFIXA: "+avlRevertedInsertion.posfixa());
        System.out.println("Rotacoes feitas pela AVL: "+avlRevertedInsertion.countRotations+ 
        		" | Altura da AVL: "+ avlRevertedInsertion.avlTreeHeight);
        System.out.println();
   ///System.out.println(avlNormal.containsDFS(3));
	
        System.out.println("-REDBLACK- INSERCAO INVERSA ");
	    System.out.println("PRINT RBT INFIXA:  "+rbRevertedInsertion.infixa());
		//avl.removeAVL(4);
	    System.out.println("PRINT RBT PREFIXA: "+rbRevertedInsertion.prefixa());
	    System.out.println("PRINT RBT POSFIXA: "+rbRevertedInsertion.posfixa());
	    System.out.println();
	    System.out.println("Rotacoes feitas pela RBT para inserir todos os elementos: "+rbRevertedInsertion.countRotations+
	    		" | Altura da RBT: "+ rbRevertedInsertion.rbTreeHeight);
	    System.out.println();
	    if(avlRevertedInsertion.countRotations < rbRevertedInsertion.countRotations ){
	    	System.out.println("A AVL é melhor que a RBT com esse vetor de tipo odernado inversamente!!");
	    }else{
	    	System.out.println("A RBT é melhor que a AVL com esse vetor de tipo odernado inversamente!!");
	    }
	    if(avlRevertedInsertion.countRotations == rbRevertedInsertion.countRotations){
	    	
	    	System.out.println("Empate, as duas arvores mostraram a mesma eficiencia..");
	    }
	    
	    System.out.println("------------------------------------------");
    
	System.out.println();

	
	
	
	RedBlackTree<Integer> rb = new RedBlackTree<Integer>();
	AvlTree<Integer> avl = new AvlTree<Integer>();

	System.out.println("Teste as estruturas");
	boolean endProgram = false;
	sc = new Scanner(System.in);
	String readCmd;
	while(!endProgram){
		
		System.out.println("Comandos: Testar AVL, Testar RBT ou sair");
		readCmd = sc.nextLine();
		
		if(readCmd.equalsIgnoreCase("testar avl")){
			
		
			while(!readCmd.equalsIgnoreCase("voltar")){
				System.out.println("Comandos AVL: adicionar, remover, mostrar e voltar");
			readCmd = sc.next();
			
			if(readCmd.equalsIgnoreCase("adicionar")){
                boolean repeat = false;
				
				while(!repeat){
					System.out.println("Insira o numero ou (-1) para voltar:");
				int readInt = sc.nextInt();
				if(readInt == -1){
					repeat = true;
				}else{
				avl.addAVL(readInt);
			System.out.println("Comparacoes feitas: "+avl.comparisonsInsert+
					" Rotacoes feitas: "+avl.countRotationsInsertRemove +" Tamanho da arvore: " +avl.avlTreeHeight);
				}
				}
				
			}
			if(readCmd.equalsIgnoreCase("remover")){
				   boolean repeat = false;
					
					while(!repeat){
				System.out.println("Insira o numero para remover ou (-1) para voltar:");
				int readInt = sc.nextInt();
				if(readInt == -1){
					repeat = true;
				}else{
				avl.removeAVL(readInt);
				System.out.println("Comparacoes feitas: "+avl.countComparisonsRemove+
						" Rotacoes feitas: "+avl.countRotationsInsertRemove +" Tamanho da arvore: " +avl.avlTreeHeight);
				}
				}
				
			}
			if(readCmd.equalsIgnoreCase("mostrar")){

				
				System.out.println("-AVL- ");
			    System.out.println("PRINT AVL INFIXA:  "+avl.infixa());
			//avl.removeAVL(4);
			    System.out.println("PRINT AVL PREFIXA: "+avl.prefixa());
		        System.out.println("PRINT AVL POSFIXA: "+avl.posfixa());
			}
			}
		}
		
		///////////////////////RBT
	if(readCmd.equalsIgnoreCase("testar rbt")){
		while(!readCmd.equalsIgnoreCase("voltar")){
			System.out.println("Comandos RBT: adicionar, remover, mostrar e sair..");
			readCmd = sc.next();
			
			if(readCmd.equalsIgnoreCase("adicionar")){
				boolean repeat = false;
				
				while(!repeat){
					System.out.println("Insira o numero ou (-1) para voltar:");
				int readInt = sc.nextInt();
				if(readInt == -1){
					repeat = true;
				}else{
				rb.addRBT(readInt);
			System.out.println("Comparacoes feitas: "+rb.comparisonsInsert+
					" Rotacoes feitas: "+rb.countRotationsInsertRemove +" Tamanho da arvore: " +rb.rbTreeHeight);
				}
			
				}
				
			}
			if(readCmd.equalsIgnoreCase("remover")){
				boolean repeat = false;
				while(!repeat){
					System.out.println("Insira o numero para remover ou (-1) para voltar:");
				int readInt = sc.nextInt();
				if(readInt == -1){
					repeat = true;
				}else{
				rb.removeRBT(readInt);
			System.out.println("Comparacoes feitas: "+rb.comparisonsInsert+
					" Rotacoes feitas: "+rb.countRotationsInsertRemove +" Tamanho da arvore: " +rb.rbTreeHeight);
				}
				}
				
			}
			if(readCmd.equalsIgnoreCase("mostrar")){

				
				System.out.println("-REDBLACK- ");
			    System.out.println("PRINT RBT INFIXA:  "+rb.infixa());
			    System.out.println("PRINT RBT PREFIXA: "+rb.prefixa());
			    System.out.println("PRINT RBT POSFIXA: "+rb.posfixa());
			}
			
		    }
			
			}
	if(readCmd.equalsIgnoreCase("sair")){
		endProgram = true;
		  System.out.println("Programa encerrado!");
	}
		
	
		}
		
	
	/*
	BsTree<Integer> bst = new BsTree<Integer>();
	bst.add(2);
	bst.add(1);
	bst.add(3);
	bst.add(4);
	bst.add(0);
	bst.removeBST(0);
	System.out.println(bst.prefixa());
	*/
	
	}
}
