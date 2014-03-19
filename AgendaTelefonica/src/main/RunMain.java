/**Trabalho da agenda..
 * 
 * @author Dennis Kaffer

 * @version 1.0

 */

package main;



import java.io.IOException;
import java.util.Scanner;

public class RunMain {

	

	public static void main(String [] args) throws IOException{

	  
	    
	    while(true){
		  
	    Comandos cmds = new Comandos();
	    
	    cmds.showMenu();
	    
	    String Entrada;
	    Comandos.sc = new Scanner(System.in);
	    
	    Entrada = Comandos.sc.nextLine();
	    

	    cmds.readAction(Entrada);
	    
	}   
		
	
	
	}

}
