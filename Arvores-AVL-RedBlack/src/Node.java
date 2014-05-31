/**Trabalho das arvore AVL e RBT
 * 
 * @author Dennis Kaffer

 * @version 1.0

 */
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
	 /**
	  * Muda o filho da esquerda e atualiza a sua referencia ao pai
     *@param novo filho da esquerda
  */
	 public void setLeftChild(Node<T> child){
        left = child;
        if (child != null) { 
        	child.parent = this; 
        	}
     }
	 /**
	  * Muda o filho da direita e atualiza a sua referencia ao pai
     *@param novo filho da direita
  */
     public void setRightChild(Node<T> child){
        right = child;
        if (child != null) { 
        	child.parent = this; 
        	}
     }
     /**Atualiza as ligacoes do node de substituicao quando esse node e substituido
      * @param node que substituiu esse node
      */
     public void replaceWith(Node<T> replacement){
   	  if (parent == null) return;
   	  if (this == parent.left) parent.setLeftChild(replacement);
   	  else parent.setRightChild(replacement);
     }

	 
     //BST generic implementation
     
 	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}
     
     
	}