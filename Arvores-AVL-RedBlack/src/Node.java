
	public class Node <T extends Comparable<T>> {
	 
		
	 public Node<T> left;
	 public Node<T> right;
	 public Node<T> parent;
	 public T data;
	 public int balance;
	 //redblack implementation..
	 public int color;
	 
	 public Node() {
		 
	 }
     //avl implementation..     
	 public Node(T data) {
	  left = right = parent = null;
	  balance = 0;
	  this.data = data;
	 }

	 public String toString() {
	  return "" + data;
	 }

	 
	 //redbalck implementation..
	 
	 public void setLeftChild(Node<T> child){
        left = child;
        if (child != null) { 
        	child.parent = this; 
        	}
     }
     
     public void setRightChild(Node<T> child){
        right = child;
        if (child != null) { 
        	child.parent = this; 
        	}
     }
     
     public void replaceWith(Node<T> replacement){
   	  if (parent == null) return;
   	  if (this == parent.left) parent.setLeftChild(replacement);
   	  else parent.setRightChild(replacement);
     }

	 
	}