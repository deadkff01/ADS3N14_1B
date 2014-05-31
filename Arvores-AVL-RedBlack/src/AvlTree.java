/**Trabalho das arvores AVL e RBT
 * 
 * @author Dennis Kaffer

 * @version 1.0

 */
public class AvlTree<T extends Comparable<T>> 
extends BsTree<T> {
	 
	
	
	 public int countRotations;
	 public int countRotationsInsertRemove;
	 public int countComparisonsRemove;
	 public int avlTreeHeight;
	 
	 public AvlTree(){
		 //root inheritance variable...
		 root = null;
		 countRotations = 0;
		
	 }
	 
	 public void addAVL(T data) {
	  // cria um novo node apartir do dado recebido..
		 comparisonsInsert = 0;
		 countRotationsInsertRemove = 0;
		 Node<T> n = new Node<T>(data); 
		 recAdd(n, this.root);//bst inheritance method..
	  //nodo inserido, agora e checado o balanceamento da arvore
	  recursiveBalance(n);
	 
	  avlTreeHeight = treeHeight(this.root);
	 }
	 
	 /**
	  * Checa o balanco para cada vez que metodos recursivos que fazem alteracoes nos nodes, esse metodo 
	  * e necessario para equilibrar a arvore AVL ate que o node raiz seja alcancado..
	  * @param cur e o node que sera verificado
	  */

	 public void recursiveBalance(Node<T> cur) {

	  setBalance(cur);
	  int balance = cur.balance;
	  
	  //checa o balanceamento
	  if(balance==-2) {
	   
	   if(height(cur.left.left) >= height(cur.left.right)) {
	    cur = rotateRight(cur);
	    countRotations++;
	    countRotationsInsertRemove++;
	   } else {
	    cur = doubleRotateLeftRight(cur);
	    countRotations+=2;
	    countRotationsInsertRemove+=2;
	   }
	  } else if(balance == 2) {
	   if(height(cur.right.right) >= height(cur.right.left)) {
	    cur = rotateLeft(cur);
	    countRotations++;
	    countRotationsInsertRemove++;
	   } else {
	    cur = doubleRotateRightLeft(cur);
	    countRotations+=2;
	    countRotationsInsertRemove+=2;
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

	 

	 public void removeAVL(T data) {
		 //Primeiro e preciso encontar o node, depois e possivel deleta-lo..
		 countComparisonsRemove = 0;
		 countRotationsInsertRemove = 0;
		 recRemoveAVL(data, this.root);
	 }
	 
	 /**
	  * Encontra o node e passa uma instancia para o metodo removeFoundNode
	  * remover fisicamente o node.
	  * @param data a data conteudo do node.
	  * @param tree O node no qual e comecada a busca.
	  */
	 public void recRemoveAVL(T data, Node<T> tree) {
	  if(tree == null) {
	   //O valor nao existe na arvore
	   return;
	  } else {
	   if(tree.data.compareTo(data) > 0)  {
		   countComparisonsRemove++;
		   recRemoveAVL(data, tree.left);
	   } else if(tree.data.compareTo(data) < 0) {
		   countComparisonsRemove++;
		   recRemoveAVL(data, tree.right);
	   } else if(tree.data.compareTo(data) == 0) {
		   countComparisonsRemove++;
	    //O node foi encontrado, aqui e executado o metodo pra remover
	    removeFoundNode(tree);
	   }
	  }
	 }
	 
	 /**
	  * Remove o node da AVL, enquando o balanceamento da mesma e feito se necessario.
	  * 
	  * @param branch O node que vai ser removido.
	  */
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
	   // branch tem dois ramos(filhos)--> quer sera substituido pelo sucessor
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
	 /**
	  * Rotacao para esquerda usando o node adquirido pela instancia

	  * @param n O node para rotacao.
	  * 
	  * @return A raiz da arvore apos a rotacao.
	  */

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
	 
	 /**
	  * Rotacao para direita usando o node adquirido pela instancia

	  * @param n O node para rotacao.
	  * 
	  * @return A raiz da arvore apos a rotacao.
	  */
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
	 
	 /** 
	  * @param u O node para rotacao
	  * @return O node depois de deus rotacoes
	  */
	 public Node<T> doubleRotateLeftRight(Node<T> u) {
	  u.left = rotateLeft(u.left);
	  
	  return rotateRight(u);
	 }
	 /** 
	  * @param u O node para rotacao
	  * @return O node depois de deus rotacoes
	  */
	 public Node<T> doubleRotateRightLeft(Node<T> u) {
	  u.right = rotateRight(u.right);

	  return rotateLeft(u);
	 }
	 
	 /**
	  * Retorna o sucessor de um determinado node da arvore passado na instancia
	  * (pesquisa recursiva).
	  * 
	  * @param q The predecessor.
	  * @return The successor of node q.
	  */
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
	 /**
	  * Calcula a "altura" do node
	  * 
	  * @param cur
	  * @return A altura do node (-1, se ele nao existe ou for NULL).
	  */
	
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
	 
	 /**
	  * Retorna o valor maximo entre dois inteiros
	  */
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
	 
}
