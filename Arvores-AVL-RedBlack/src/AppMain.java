
public class AppMain {

	public static void main(String[] args) {
		
		//testando a avl..
		AvlTree<Integer> t = new AvlTree<Integer>();
		
		t.addAVL (3);
		t.addAVL (4);
		t.addAVL (5);
		
		System.out.println ("Travessia Infixa:");
	System.out.println(t.infixa());
	t.remove(4);
	System.out.println(t.infixa());

	RedBlackTree<Integer> rb = new RedBlackTree<Integer>();
	
	rb.addRBT(3);
	rb.addRBT(5);
	rb.addRBT(4);
	
	System.out.println(rb.infixa());
	rb.remove(4);
	System.out.println(rb.infixa());
	}

}
