/**Trabalho da agenda..
 * 
 * @author Dennis Kaffer

 * @version 1.0

 */

package main;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RunMain {

	

	public static void main(String [] args) throws IOException{
	
	    while(true){
		   
	    Comandos cmds = new Comandos();
 
	    cmds.showMenu();
	    cmds.sendQuery();
	  
	    String Entrada;
	    Comandos.sc = new Scanner(System.in);
	    
	    Entrada = Comandos.sc.nextLine();
	    
	    cmds.readAction(Entrada);
	    
	}     
		
	
	
	}


    	
}
