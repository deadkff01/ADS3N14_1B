package ListaTel2;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaEncadeada<T extends Comparable<T>> {

	private Nodo<T> head; // will be a Nodo
	private Nodo<T> tail; // will be a Nodo
	public  int upDown = 0;
	public static int readNumberOflines = 0;
	
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
			readNumberOflines++;
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

	/*
	  public void exibirListaPorLetra()
	  {//todo
		
		  No temp = primeiro;
		 
		  String valores ="";
		  int contador = 1;
		 
		  
		  while (contador <= getTotalNos())
		  {
			  String tmp = temp.nomePessoa.toString();
	
			  
			  if(tmp.charAt(0) == 'b'){
				  valores += "Nome: "+temp.nomePessoa+"\n"
						  +"Telefone: "+temp.telefonePessoa+"\n";
			  
			  }
			  temp = temp.prox;
			  contador++;
			  
			  // tmp  = temp.toString();
		  }
	
	*/
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
	public void waveNext(String s)
	{
	    Nodo<T> nodo = head;
		    Nodo<T> nodo2 = head;
	    String  tmp = null;    String  tmp2 = null; String  tmp3 = null;
	    Nodo<?> prox = null;
	    Nodo<T> ant = null;
	    Nodo<?> anterior = null;
	    anterior = nodo2;
	  
	    ant = nodo;
	    if(s.equals("s")){
	    if(nodo!=null){
		
		
		
		 ant = nodo;
		
		nodo= nodo.getNext();
		head = nodo;
		prox = nodo;
		
	    
	    } else{
		nodo = head;
	
	    }
	    } 
	    if(s.equals("d")){
		//head = ant;
		//nodo=head;
		// = nodo;
	    }
	    tmp  = prox.getData().toString();
	    tmp2  = ant.getData().toString();
	    tmp3  = anterior.getData().toString();
	    System.out.println("antt ant"+tmp3);
	    System.out.println("antt "+tmp2);
	    System.out.println("atual "+tmp);
	    
	
	} 

	
*/
	public void printAgain()
	{
		Nodo<?> nodo = head;
	
		String temp1;
		
		 int i = 0;
		 do{
		     temp1 = nodo.getData().toString();
			nodo = nodo.getNext();
					
			i++;
			
		 }while(i<upDown && nodo != null);
			
		//	out.println(temp2);
		 out.println(temp1);
	}
	
	//public void action()
//

	public static void main(String[] args)
	{
		ListaEncadeada<String> lista = new ListaEncadeada<String>();

		lista.insert(new Nodo<String>("Rafael"));
		lista.insert(new Nodo<String>("Dennis"), lista.getHead());
		lista.append(new Nodo<String>("Mauro"));
		lista.insert(new Nodo<String>("Carlos"));

		lista.print();
		
		System.out.println("--------");
		Scanner sc = new Scanner(System.in);
		/*
		do{
		    String s = sc.nextLine();
		if(s.equals("s")){
		    upDown++;
		    lista.printAgain();
		 
		}if(s.equals("d")){
		    upDown--;
		    lista.printAgain();
		 
		}
		}while(true);
		
		//lista.printAgain();
		
		//lista.waveNext();
	*/
		
	}
	
}