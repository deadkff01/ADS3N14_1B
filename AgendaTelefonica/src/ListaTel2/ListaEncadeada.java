package ListaTel2;

import static java.lang.System.out;

public class ListaEncadeada<T extends Comparable<T>> {

	private Nodo<T> head; // will be a Nodo
	private Nodo<T> tail; // will be a Nodo

	public Nodo<T> getHead()
	{
		return head;
	}

	public void print()
	{
		Nodo<?> nodo = head;
		do {
			out.println(nodo.getData());
			nodo = nodo.getNext();
		} while (nodo != null);
	}

	public void insert(Nodo<T> novo)
	{
		novo.setNext(head);
		head = novo;

		if (tail == null)
			tail = head;
	}

	public void insert(Nodo<T> novo, Nodo<T> anterior)
	{
		if (anterior == tail) {
			tail.setNext((Nodo<T>)novo);
			tail = novo;
		} else {
			novo.setNext(anterior.getNext());
			anterior.setNext(novo);
		}
	}

	public void append(Nodo<T> novo)
	{
		tail.setNext(novo);
		tail = novo;
	}
/*
	public static void main(String[] args)
	{
		ListaEncadeada<String> lista = new ListaEncadeada<String>();

		lista.insert(new Nodo<String>("Rafael"));
		lista.insert(new Nodo<String>("Dennis"), lista.getHead());
		lista.append(new Nodo<String>("Mauro"));
		lista.insert(new Nodo<String>("Carlos"));

		lista.print();
	}
	*/ 
}