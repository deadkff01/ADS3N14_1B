import java.util.ArrayList;

public class AvlTree<T extends Comparable<T>> {
	 
	 protected Node<T> root; 
	 public int countSingleRotations;
	 public int countDoubleRotations;

	 
	 public AvlTree(){
		 root = null;
		 countSingleRotations = 0;
		 countDoubleRotations = 0;
	 }
	 
	 public void addAVL(T data) {
	  // cria um novo node apartir do dado recebido..
		 Node<T> n = new Node<T>(data);
	  
	  recAddAVL(n, this.root);
	 }
	 

	 public void recAddAVL(Node<T> newNode, Node<T> tree) {

	  if(tree == null) {
	   this.root = newNode;
	  } else {
	   
		  //Se o novo nodo for menor, inseri a esquerda 
	   if(newNode.data.compareTo(tree.data)<=0) {
	    if(tree.left == null) {
	    	tree.left = newNode;
	    	newNode.parent = tree;
	   
	     //nodo inserido, agora e checado o balanceamento da arvore
	     recursiveBalance(tree);
	    } else {
	    	recAddAVL(newNode, tree.left);
	    }
	    
	   } else if(newNode.data.compareTo(tree.data)>0) {
	    if(tree.right == null) {
	    	tree.right = newNode;
	    	newNode.parent = tree;
	     
	     //nodo inserido, agora e checado o balanceamento da arvore
	     recursiveBalance(tree);
	    } else {
	    	recAddAVL(newNode, tree.right);
	    }
	   }
	  }
	 }
	 

	 public void recursiveBalance(Node<T> cur) {

	  setBalance(cur);
	  int balance = cur.balance;
	  
	  //checa o balanceamento
	  if(balance==-2) {
	   
	   if(height(cur.left.left) >= height(cur.left.right)) {
	    cur = rotateRight(cur);
	   } else {
	    cur = doubleRotateLeftRight(cur);
	   }
	  } else if(balance == 2) {
	   if(height(cur.right.right) >= height(cur.right.left)) {
	    cur = rotateLeft(cur);
	   } else {
	    cur = doubleRotateRightLeft(cur);
	   }
	  }
	  
	  //A raiz nao foi atingida ainda
	  if(cur.parent!=null) {
	   recursiveBalance(cur.parent);
	  } else {
	   this.root = cur;
	  //System.out.println("------------ Balancing finished! ----------------");
	  }
	 }

	 

	 public void remove(T data) {
		 //Primeiro e preciso encontar o node, depois e possivel deleta-lo..
	  removeAVL(data, this.root);
	 }
	 

	 public void removeAVL(T data, Node<T> tree) {
	  if(tree == null) {
	   //O valor nao existe na arvore
	   return;
	  } else {
	   if(tree.data.compareTo(data) > 0)  {
	    removeAVL(data, tree.left);
	   } else if(tree.data.compareTo(data) < 0) {
	    removeAVL(data, tree.right);
	   } else if(tree.data.compareTo(data) == 0) {
	    //O node foi encontrado, aqui e executado o metodo pra remover
	    removeFoundNode(tree);
	   }
	  }
	 }
	 

	 public void removeFoundNode(Node<T> branch) {
		 Node<T> temp1;
	  //Pelo menos um ramo de q sera removido diretamente
	 
	  if(branch.left == null || branch.right == null) {
	   //A raiz e eliminada..
	   if(branch.parent == null) {
	    this.root = null;
	    branch = null;
	    return;
	   }
	   temp1 = branch;
	  } else {
	   // q tem dois ramos(filhos)--> quer sera substituido elo sucessor
		  temp1 = successor(branch);
	   branch.data = temp1.data;
	  }
	  
	  Node<T> temp2;
	  if(temp1.left != null) {
		  temp2 = temp1.left;
	  } else {
		  temp2 = temp1.right;
	  }
	  
	  if(temp2 != null) {
		  temp2.parent = temp1.parent;
	  }
	  
	  if(temp1.parent == null) {
	   this.root = temp2;
	  } else {
	   if(temp1 == temp1.parent.left) {
		   temp1.parent.left = temp2;
	   } else {
		   temp1.parent.right = temp2;
	   }
	   // O balanceamento deve ser feito ate que a raiz seja alcancada...
	   recursiveBalance(temp1.parent);
	  }
	  temp1 = null;
	 }
	 

	 public Node<T> rotateLeft(Node<T> n) {
	  
		 Node<T> temp = n.right;
		 temp.parent = n.parent;
	  
	  n.right = temp.left;
	  
	  if(n.right != null) {
	   n.right.parent=n;
	  }
	  
	  temp.left = n;
	  n.parent = temp;
	  
	  if(temp.parent != null) {
	   if(temp.parent.right == n) {
		 temp.parent.right = temp;
	   } else if(temp.parent.left == n) {
		   temp.parent.left = temp;
	   }
	  }
	  
	  setBalance(n);
	  setBalance(temp);
	  
	  return temp;
	 }
	 

	 public Node<T> rotateRight(Node<T> n) {
	  
		 Node<T> temp = n.left;
		 temp.parent = n.parent;
	  
	  n.left = temp.right;
	  
	  if(n.left != null) {
	   n.left.parent = n;
	  }
	  
	  temp.right = n;
	  n.parent = temp;
	  
	  if(temp.parent != null) {
	   if(temp.parent.right == n) {
		   temp.parent.right = temp;
	   } else if(temp.parent.left == n) {
		   temp.parent.left = temp;
	   }
	  }
	  
	  setBalance(n);
	  setBalance(temp);
	  
	  return temp;
	 }

	 public Node<T> doubleRotateLeftRight(Node<T> u) {
	  u.left = rotateLeft(u.left);
	  return rotateRight(u);
	 }
	 

	 public Node<T> doubleRotateRightLeft(Node<T> u) {
	  u.right = rotateRight(u.right);
	  return rotateLeft(u);
	 }
	 

	 public Node<T> successor(Node<T> q) {
	  if(q.right != null) {
		  Node<T> r = q.right;
	   while(r.left != null) {
	    r = r.left;
	   }
	   return r;
	  } else {
		  Node<T> p = q.parent;
	   while(p != null && q == p.right) {
	    q = p;
	    p = q.parent;
	   }
	   return p;
	  }
	 }
	 
	
	 private int height(Node<T> cur) {
		 //balance factor
	  if(cur == null) {
	   return -1;
	  }
	  if(cur.left == null && cur.right == null) {
	   return 0;
	  } else if(cur.left == null) {
	   return 1 + height(cur.right);
	  } else if(cur.right == null) {
	   return 1 + height(cur.left);
	  } else {
	   return 1 + maximum(height(cur.left), height(cur.right));
	  }
	 }
	 
	
	 private int maximum(int a, int b) {
	  if(a >= b) {
	   return a;
	  } else {
	   return b;
	  }
	 }


	 private void setBalance(Node<T> cur) {
	  cur.balance = height(cur.right) - height(cur.left);
	 }
	 

	 final protected ArrayList<T> infixa() {
	  ArrayList<T> ret = new ArrayList<T>();
	  infixa(root, ret);
	  return ret;
	 }
	 
     protected void infixa(Node<T> n, ArrayList<T> io) {
	  if (n == null) {
	   return;
	  }
	  infixa(n.left, io);
	  io.add(n.data);
	  infixa(n.right, io);
	 }
	
}
