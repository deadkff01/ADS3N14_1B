/**Trabalho das arvore AVL e RBT
 * 
 * @author Dennis Kaffer

 * @version 1.0

 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BsTree<T extends Comparable<T>> {

    protected Node<T> root;
	
	private int length = 0;
	
	private int comparisonsCounterDFS = 0;
	
	private int comparisonsCounterBFS = 0;
	
	public int comparisonsInsert = 0;
	
	private int treeHeight = 0;
	
	private boolean found = false;
		
	public BsTree(){
		
		root = null;
		length = 0;	
	}
	
	public void add(T data){
		
		Node<T> n = new Node<T>(data);
		recAdd(n, this.root);
		length +=1;
		comparisonsInsert = 0;
		treeHeight = treeHeight(this.root);
	}

	public void recAdd(Node<T> newNode, Node<T> tree){
	
		if(tree == null){
			
			// System.out.println("  Inserted " + data + " to head " + tree.getData());
			this.root = newNode;
			
		}else{
			
		  //Se o novo nodo for menor, inseri a esquerda 
		   if(newNode.data.compareTo(tree.data) <= 0) {
			   comparisonsInsert++;
		    if(tree.left == null) {
		    	tree.left = newNode;
		    	newNode.parent = tree;
		   
		    	
		    //	System.out.println("  Inserted " + newNode.data + " to left of node " + tree.data);
		    } else {
		    	 recAdd(newNode, tree.left);
		    	
		    }
		    
		   } else if(newNode.data.compareTo(tree.data) > 0) {
			   comparisonsInsert++;
		    if(tree.right == null) {
		    	tree.right = newNode;
		    	newNode.parent = tree;
		     
		    	
		    //	System.out.println("  Inserted " + newNode.data + " to right of node " + tree.data);
		    } else {
		    	recAdd(newNode, tree.right);
		    	
		    }
		
		   }
		   }	
	}
	
	
	public int treeHeight(Node<T> tree){

		if (tree == null){
			return 0;
		}
		
		int heightLeft = treeHeight(tree.getLeft());
		int heightRight = treeHeight(tree.getRight());

		if(heightLeft > heightRight)
		return heightLeft +1;
		else
		return heightRight +1;
		}

	
	public boolean removeBST(T data)  {
		// TODO Auto-generated method stub
	
		if (!isEmpty()) {
			try {
				found = false;
				root = recRemove(data, this.root);
			
			} catch (Exception  e) {
				// TODO Auto-generated catch block

			}
		} else {
			System.out.println("BST is empty!");
		}
		
		length -= 1;
		return found;
	}
	
	
	
	private Node<T> recRemove(T data, Node<T> tree)  {
		
		if (tree == null) { 
			return null;
		}
		
			if(data.compareTo(tree.getData()) == 0){
						
				found = true;
				tree = removeNode(tree);
				return tree;
			}  
			
			 if(tree.getLeft() != null){
				 tree.setLeft(recRemove(data, tree.getLeft()));
			}
			
			 if(tree.getRight() != null){
				tree.setRight(recRemove(data, tree.getRight()));	
			}
			 
			return tree;
	}

	private Node<T> removeNode(Node<T> tree)   {

		if (tree.getLeft() == null) {		//node com um filho pra direita
			return tree.getRight();
		} else if (tree.getRight() == null) {//node com um filho pra esquerda
			return tree.getLeft();
		} else {//node com dois filhos
			
			Node<T> temp = findHighestLeft(tree.getLeft());
			// Subistitui a raiz com o nodo mais a esquerda possivel..
		
			tree.setData(temp.getData());
			//remove o nodo mais a esquerda e muda a referencia pra ele 
	
			tree.setLeft(recRemove(temp.getData(), tree.getLeft()));
		}
		return tree;
	}

	private Node<T> findHighestLeft(Node<T> tree) {

		while (tree.getRight() != null) {
			tree = tree.getRight();
		}
		return tree;
	}

	//Search mode DSF	
	
	public String containsDFS(T data){
		
		return recContainsDFS(data, this.root);
	}
	
	private String recContainsDFS(T data, Node<T> root) {
		if (root == null) {
			return null;
		}
		
		Stack<Node <T>> stack = new Stack<Node <T>>();
		stack.push(root);
		
		while (!stack.isEmpty()){
			 Node<T> tempNode;
			 tempNode = stack.pop( );
			 comparisonsCounterDFS++;
	
			  if(data.compareTo(tempNode.data) == 0){
		
				return data+" altura:"+stack.size();
				
			} 
			   if(tempNode.getLeft() != null){
			
				stack.push(tempNode.getLeft() );
			}
			
			   if(tempNode.getRight() != null){
		
				stack.push(tempNode.getRight());
			}
		  }
			
			return null;
	}
	
//Search mode BSF	
	public T containsBFS(T data){
		return recContainsBFS(data, this.root);
	}
	
	public T recContainsBFS (T data, Node<T> root) {
	  if (root == null){
	    return null;
	    }
	   
	  Queue<Node<T>> q = new LinkedList<>();
	  Node<T> tempNode;
	  q.add(root);

	  while (!q.isEmpty()){
	    
		  tempNode = q.remove();
	     
	      comparisonsCounterBFS++;
	      
	    if (data.compareTo(tempNode.getData()) == 0) {
	      return data;
	      }
	    else {
	      if (tempNode.getLeft() != null)
	      q.add(tempNode.getLeft());

	      if (tempNode.getRight() != null)
	      q.add(tempNode.getRight());
	    }
	  }
	  return null;
	}

	
	public int getSize(){
		return length;
	}

	public int getTreeHeight(){
		return treeHeight;
	}
	

	public int getComparisonsDFS(){
		return comparisonsCounterDFS;
	}

	public int getComparisonsBFS(){
		return comparisonsCounterBFS;
	}

	public boolean isEmpty(){
		return (root == null);
	}
	
	
	String bstList = "";

	public String infixa(){
		 bstList = "";
		 return infixa(this.root);
	}
	

	public String infixa(Node<T> arvore){

		if(arvore != null){
			infixa(arvore.getLeft());
			bstList += arvore.getData()+ " ";
			infixa(arvore.getRight());
		}
		
		return bstList;
	}
	
	
	public String prefixa(){
		 bstList = "";
		 return prefixa(this.root);
	}
	
	public String prefixa(Node<T> branch){
		
		String toReturn = "";
		//raiz
		toReturn += branch.getData().toString()+" "; 
		//esquerda
		if(branch.getLeft() != null){
			toReturn += prefixa(branch.getLeft());
		}
		//direita
		if(branch.getRight()!=null){
			toReturn += prefixa(branch.getRight());
		}
		
		return toReturn;
	}
	
	
	public String posfixa(){
		 bstList = "";
		 return posfixa(this.root);
	}
	
	public String posfixa(Node<T> branch){
		
		String toReturn = "";
		//esquerda
		if(branch.getLeft() != null){
			toReturn += posfixa(branch.getLeft())+ " ";
		}
		//direita
		if(branch.getRight()!=null){
			toReturn += posfixa(branch.getRight())+ " ";
		}
		//raiz
		toReturn += branch.getData().toString(); 
		
		return toReturn;
	}
	
}
