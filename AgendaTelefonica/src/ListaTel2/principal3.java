package ListaTel2;


import java.io.IOException;
import java.util.Scanner;

public class principal3 {

	

	public static void main(String [] args) throws IOException{

	  
	    
	    while(true){
		  
	    Comandos cmds = new Comandos();
	    
	    cmds.showMenu();
	    
	    String Entrada;
	    Comandos.sc = new Scanner(System.in);
	    
	    Entrada = Comandos.sc.nextLine();
	    
	   
	    
	    
	    cmds.readAction(Entrada);
	    
	}   
		
		//lista.printUniqueChar();
		
		//minhaLista.exibirListaPorLetra();
	
	}

}
