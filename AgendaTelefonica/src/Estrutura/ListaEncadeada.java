package Estrutura;

import static java.lang.System.out;



public class ListaEncadeada<T extends Comparable<T>> {

	private Nodo<T> head; // will be a Nodo
	private Nodo<T> tail; // will be a Nodo
	public  int upDown = 0;
	public static String nomeEx;
	
	public    Nodo<T> ant;
	public static  String giveTail = null;
	public Nodo<T> getHead()
	{
		return head;
	}

	public void print()
	{
		Nodo<?> nodo = head;
		
		do {
		    String temp1 = nodo.getData().toString();
		
		    out.println(temp1);
			nodo = nodo.getNext();
		
		} while (nodo != null);
	}

	//printando por caracteres
	public void printUniqueChar(char character)
	{
	    String letra = Character.toString(character).toLowerCase();
	    char c = letra.charAt(0);
	    
		Nodo<?> nodo = head;
		do {
		    String temp = nodo.getData().toString();
		    if(temp.charAt(0) == c){
			out.println(nodo.getData());
			
		    }
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


	public void printAgain()
	{
		Nodo<?> nodo = head;
	
		String temp1 = null;
		
		 int i = 0;
		 do{
		  
		     
		     temp1 = nodo.getData().toString();
			nodo = nodo.getNext();
					
			i++;
			
		 }while(i<upDown && nodo != null);
			
		//	out.println(temp2);
		 out.println(temp1);
	}
	


}