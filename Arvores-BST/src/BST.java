/**Trabalho da arvore binaria..
 * 
 * @author Dennis Kaffer

 * @version 1.0

 */
import java.util.*;

public class BST<T extends Comparable<T>>  implements BSTInterface<T>{
	
	private Node<T> root;
	
	private int length = 0;
	
	private int comparisonsCounterDFS = 0;
	
	private int comparisonsCounterBFS = 0;
	
	private int treeHeight = 0;
	
	private boolean found = false;
	
	public ArrayList<String> insertionOrder = new ArrayList<>();

	public String elements = null;
	
	public BST(){
		root = null;
		length = 0;
		
	}
	
	

	@Override
	public void add(Node<T> data){
		
		root = recAdd(data.getData(), this.root);
		length +=1;
	
		treeHeight = treeHeight(this.root);

	}


	public Node<T> recAdd(T data, Node<T> tree){
		
		Pessoa addp = (Pessoa)data;
		
		if(tree == null){
			
			// System.out.println("  Inserted " + data + " to head " + tree.getData());

			tree = new Node<T>(data);
			
			insertionOrder.add(addp.getNome()+";"+addp.getTelefone());
			
			return tree;
		}
	
		 
		if(data.compareTo(tree.getData()) <= 0){
			if(tree.getLeft() != null){
				recAdd(data, tree.getLeft());
			
			}else{
				tree.setLeft(recAdd(data, tree.getLeft()));
			//	System.out.println("  Inserted " + data + " to left of node " + tree.data);
			}
		 }
		 else if(data.compareTo(tree.getData()) > 0){
			 if(tree.getRight()!=null){
				 recAdd(data, tree.right);
				
			 }else{
				 tree.setRight(recAdd(data, tree.getRight()));
			//	System.out.println("  Inserted " + data + " to right of node " + tree.data);
			 }
		 }
		

		 
	
		return tree;
	}
	
	public String getElements(){
		for(String x : insertionOrder){
			
			if(elements == null){
				
				elements =	x+"\n";
				}else{
					elements +=	x+"\n";
				}
		
		}
		return elements;
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

	
	@Override
	public boolean remove(String data) throws EmptyBSTException {
		// TODO Auto-generated method stub
		
		elements = null;
		if (!isEmpty()) {
			try {
				found = false;
				root = recRemove(data, this.root);
			
			} catch (DataNotFoundException  e) {
				// TODO Auto-generated catch block

			}
		} else {
			throw new EmptyBSTException("BST is empty!");
		}
		
		length -= 1;
		return found;
	}
	
	
	
	private Node<T> recRemove(String data, Node<T> tree) throws EmptyBSTException, DataNotFoundException {
		
		if (tree == null) { 
			return null;
		}
		
		Pessoa currentPessoa = (Pessoa)tree.getData();
		
			if(data.equalsIgnoreCase(currentPessoa.getNome())){
				
				insertionOrder.remove(currentPessoa.getNome()+";"+currentPessoa.getTelefone());
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

	private Node<T> removeNode(Node<T> tree) throws EmptyBSTException, DataNotFoundException  {

		if (tree.getLeft() == null) {		//node com um filho pra direita
			return tree.getRight();
		} else if (tree.getRight() == null) {//node com um filho pra esquerda
			return tree.getLeft();
		} else {//node com dois filhos
			
			Node<T> temp = findHighestLeft(tree.getLeft());
			// Subistitui a raiz com o nodo mais a esquerda possivel..
		
			tree.setData(temp.getData());
			//remove o nodo mais a esquerda e muda a referencia pra ele 
	
			tree.setLeft(recRemove(temp.getData().toString(), tree.getLeft()));
		}
		return tree;
	}

	private Node<T> findHighestLeft(Node<T> tree) {

		while (tree.getRight() != null) {
			tree = tree.getRight();
		}
		return tree;
	}

	
	/*
	String aaa = root.getData().toString();
	String vt[] = aaa.split(":");
System.out.println(root.getData().toString());
	*/

	//Search mode DSF	
	@Override
	public String containsDFS(String data){
		
		return recContainsDFS(data, this.root);
	}
	
	private String recContainsDFS(String data, Node<T> root) {
		if (root == null) {
			return null;
		}
		
		Stack<Node <T>> stack = new Stack<Node <T>>();
		stack.push(root);
		
		while (!stack.isEmpty()){
			 Node<T> tempNode;
			 tempNode = stack.pop( );
			 comparisonsCounterDFS++;
			Pessoa currentPessoa = (Pessoa)tempNode.getData();
			
			  if(data.equalsIgnoreCase(currentPessoa.getNome())){
		
				return currentPessoa.getNome()+" "+currentPessoa.getTelefone();
				
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
	
	
	/*//Busca recursiva simples..
	public boolean contains(Node<T> data){
	
		return recContains(data.getData(), this.raiz);
	}
	
	private boolean recContains(T data, Node<T> root) {

		//System.out.println("ent"+data);
		//System.out.println(root.getLeft());
		
		if (root == null) {
			return false;
		}
			if(data == root.getData()){
		
				return true;
				
			}else if(root.getLeft() != null){
			
				return recContains(data, root.getLeft());
				
			}
			
			else if(root.getRight() != null){
		
				return recContains(data, root.getRight());
				
			}
			else{
				
			return false;
			
			}
	}
	
*/
	
//Search mode BSF
	@Override
	public String containsBFS(String data){
		return recContainsBFS(data, this.root);
	}
	
	public String recContainsBFS (String data, Node<T> root) {
	  if (root == null){
	    return null;
	    }
	  
	 
	  Queue<Node<T>> q = new LinkedList<>();
	  Node<T> tempNode;
	  q.add(root);

	  while (!q.isEmpty()){
	    
		  tempNode = q.remove();
	      Pessoa currentPessoa = (Pessoa)tempNode.getData();
	      comparisonsCounterBFS++;
	      
	    if (data.equalsIgnoreCase(currentPessoa.getNome())) {
	      return currentPessoa.getNome() +" "+currentPessoa.getTelefone();
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

	@Override
	public int getSize(){
		return length;
	}
	@Override
	public int getTreeHeight(){
		return treeHeight;
	}
	
	@Override
	public int getComparisonsDFS(){
		return comparisonsCounterDFS;
	}
	@Override
	public int getComparisonsBFS(){
		return comparisonsCounterBFS;
	}
	@Override
	public boolean isEmpty(){
		return (root == null);
	}
	
	
	String bstList = "";
	@Override
	public String infixa(){
		 bstList = "";
		 return infixa(this.root);
	}
	

	public String infixa(Node<T> arvore){

		if(arvore != null){
			infixa(arvore.getLeft());
			bstList += arvore.getData()+ "\n";
			infixa(arvore.getRight());
		}
		
		return bstList;
	}
	
	@Override
	public String prefixa(){
		 bstList = "";
		 return prefixa(this.root);
	}
	
	public String prefixa(Node<T> branch){
		
		String toReturn = "";
		//raiz
		toReturn += branch.getData().toString()+"\n"; 
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
	
	@Override
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
		toReturn += branch.getData().toString()+ "\n"; 
		
		return toReturn;
	}
	
}
