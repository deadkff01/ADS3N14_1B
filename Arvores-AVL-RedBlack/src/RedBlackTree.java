/**Trabalho das arvore AVL e RBT
 * 
 * @author Dennis Kaffer

 * @version 1.0

 */
public class RedBlackTree<T extends Comparable<T>>
extends BsTree<T> {  
	

   static final int BLACK = 1;
   static final int RED = 0;
   private static final int NEGATIVE_RED = -1;
   private static final int DOUBLE_BLACK = 2;

    public int countRotations;
    public int countComparisonsRemove;
    public int countRotationsInsertRemove;
	public int rbTreeHeight;
	
   public RedBlackTree(){  
      root = null;
      countRotations = 0;     
   }
 
   public void addRBT(T data) {  
	   
	   comparisonsInsert = 0;
	   countRotationsInsertRemove=0;
	   Node<T> newNode = new Node<T>(data);
	   recAdd(newNode, this.root); 
    
      fixAfterAdd(newNode);
      rbTreeHeight = treeHeight(this.root);
   }


   public void removeRBT(T data){
      //Encontra o nodo para remove-lo
	   countComparisonsRemove = 0;
	   countRotationsInsertRemove = 0;
	   Node<T> toBeRemoved = root;
      boolean found = false;
      while (!found && toBeRemoved != null)
      {
      
         if (toBeRemoved.data.compareTo(data) == 0) { 
        	 countComparisonsRemove++;
        	 found = true; 
        	 }
         else {
            if (toBeRemoved.data.compareTo(data) > 0) { 
            	countComparisonsRemove++;
            	toBeRemoved = toBeRemoved.left; 
            	}
            else { 
            	toBeRemoved = toBeRemoved.right; 
            	}
         }
      }

      if (!found){ 
    	  return; 
    	  }

      // toBeRemoved contem data

      //Se um filho é null, usa o outro
    

      if (toBeRemoved.left == null || toBeRemoved.right == null)
      {
    	  Node<T> newChild;
         if (toBeRemoved.left == null) { 
        	 newChild = toBeRemoved.right; 
        	 }
         else { 
        	 newChild = toBeRemoved.left; 
        	 }

         fixBeforeRemove(toBeRemoved); 
         
         if (toBeRemoved.parent == null) { 
        	 root = newChild; 
        	 } //Encontrado na raiz
         else { 
        	 toBeRemoved.replaceWith(newChild); 
        	 }
         return;
      }
      
      // Nem a subarvore esta vazia
   
      // Encontra o menor elemento da direita da subarvore

      Node<T> smallest = toBeRemoved.right;
      while (smallest.left != null) {
         smallest = smallest.left;
      }

      //o menor elemento tem o menor filho
     
      // move o conteudo para tirar a referencia do filho


      toBeRemoved.data = smallest.data;
      fixBeforeRemove(smallest);
      smallest.replaceWith(smallest.right);
   }
   
   /**
   Restaura a arvore depois que e adicionado um novo node
   @param newNode e um novo node que foi adicionado
*/
   private void fixAfterAdd(Node<T> newNode){
      if (newNode.parent == null) 
      { 
         newNode.color = BLACK; 
      }
      else {
         newNode.color = RED;
         if (newNode.parent.color == RED) { 
        	 fixDoubleRed(newNode); 
        	 
        	 }
      }
      
   }

   /** Corrige a arvore apos um node ser removido	
    *@param O node tem que ter sido removido
 */
   private void fixBeforeRemove(Node<T> removed) {
      if (removed.color == RED) { return; }

      if (removed.left != null || removed.right != null) // Se nao for uma folha
      {
         // cor da ciranca e preta
         if (removed.left == null) { 
        	 removed.right.color = BLACK;
        	 }
         else { 
        	 removed.left.color = BLACK; 
         }
      }	   
      else { 
    	  bubbleUp(removed.parent); 
    	  }
   }
   
   
   
   /**
    * Move 2 filhos de um pai
    *@param pai um node com 2 filhos, se for null nada acontece
  */
   private void bubbleUp(Node<T> parent) {
      if (parent == null) { 
    	  return; 
    	  }
      parent.color++;
      parent.left.color--;
      parent.right.color--;
	   
      Node<T> child = parent.left;
      if (child.color == NEGATIVE_RED) { 
    	  fixNegativeRed(child); 
    	  return; 
    	  }
      else if (child.color == RED){
         if (child.left != null && child.left.color == RED){ 
            fixDoubleRed(child.left); 
            return; 
         }
         if (child.right != null && child.right.color == RED) { 
            fixDoubleRed(child.right); return; 
         }
      }
   
      child = parent.right;
      if (child.color == NEGATIVE_RED) { 
    	  fixNegativeRed(child); return;
    	  }
      else if (child.color == RED){
         if (child.left != null && child.left.color == RED) { 
            fixDoubleRed(child.left); 
            return; 
         }
         if (child.right != null && child.right.color == RED){ 
            fixDoubleRed(child.right); 
            return; 
         }
      }
	  
      if (parent.color == DOUBLE_BLACK) { 
         if (parent.parent == null) { 
        	 parent.color = BLACK;
        	 }
         else { 
        	 bubbleUp(parent.parent);
         }
      }
   }
   
   /**
   Corrige a violacao de dois vermelhos
   @param filho com um dos pais vermelhos
*/

   private void fixDoubleRed(Node<T> child){
	   Node<T> parent = child.parent;      
	   Node<T> grandParent = parent.parent;
	   countRotations++;
	   countRotationsInsertRemove++;
	   if (grandParent == null) { 
		   parent.color = BLACK;
		   
		   return; 
		   
		   }
      
      Node<T> n1, n2, n3, t1, t2, t3, t4;
      
      if (parent == grandParent.left){
         n3 = grandParent; t4 = grandParent.right;
         if (child == parent.left)
         {
            n1 = child; n2 = parent;
            t1 = child.left; t2 = child.right; t3 = parent.right;
           
         }
         else {
            n1 = parent; n2 = child;
            t1 = parent.left; t2 = child.left; t3 = child.right; 
           
         }
        
      }
      else{
         n1 = grandParent; t1 = grandParent.left;
        
         if (child == parent.left)
         {
            n2 = child; n3 = parent;
            t2 = child.left; t3 = child.right; t4 = parent.right;
          
         }
         else
         {
            n2 = parent; n3 = child;
            t2 = parent.left; t3 = child.left; t4 = child.right;
            
         }
      
      }
      
      if (grandParent == root){
         root = n2;
         n2.parent = null;
        
      }
      else{
         grandParent.replaceWith(n2);
        
      }
      
      n1.setLeftChild(t1);
      n1.setRightChild(t2);
      n2.setLeftChild(n1);
      n2.setRightChild(n3);
      n3.setLeftChild(t3);
      n3.setRightChild(t4);
      n2.color = grandParent.color - 1; 
      n1.color = BLACK;
      n3.color = BLACK;

      if (n2 == root){
         root.color = BLACK;
         
      }
      else if (n2.color == RED && n2.parent.color == RED){
         fixDoubleRed(n2);
        
      }
      
   }
   
   /**Corrige a violacao de vermelho negativo
 
   @param negRed o node vermelho negativo
*/
   private void fixNegativeRed(Node<T> negRed) {	
	   Node<T> n1, n2, n3, n4, t1, t2, t3, child;
	   Node<T> parent = negRed.parent;
      
	   countRotations++;
	   countRotationsInsertRemove++;
	   if (parent.left == negRed)
      {
         n1 = negRed.left;
         n2 = negRed;
         n3 = negRed.right;
         n4 = parent;
         t1 = n3.left;
         t2 = n3.right;
         t3 = n4.right;
         n1.color = RED;
         n2.color = BLACK;
         n4.color = BLACK;
         n2.setRightChild(t1);
         
         T temp = n4.data; n4.data = n3.data; n3.data = temp;
         
         n3.setLeftChild(t2);
         n3.setRightChild(t3);
         n4.setRightChild(n3);
         child = n1;
      }
      else
      {
         n4 = negRed.right;
         n3 = negRed;
         n2 = negRed.left;
         n1 = parent;
         t3 = n2.right;
         t2 = n2.left;
         t1 = n1.left;
         n4.color = RED;
         n3.color = BLACK;
         n1.color = BLACK;
         n3.setLeftChild(t3);
         
         T temp = n1.data; n1.data = n2.data; n2.data = temp;
         
         n2.setRightChild(t2);
         n2.setLeftChild(t1);
         n1.setLeftChild(n2);
         child = n4;
      }
	   
      if (child.left != null && child.left.color == RED) { 
         fixDoubleRed(child.left); 
         
         return; 
      }
      if (child.right != null && child.right.color == RED) { 
         fixDoubleRed(child.right);  
             
      }
      
   }
  
}
