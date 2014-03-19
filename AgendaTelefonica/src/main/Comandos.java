package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

import Estrutura.ListaOrdenada;
import Estrutura.Nodo;
import Estrutura.Pessoa;

public class Comandos {

    private BufferedReader br;
    public static Scanner sc;


    public void showMenu(){
	System.out.println("Comandos: Adicionar, Mostrar Lista (mostra a lista inteira), Pesquisar Letra, Navegar (avancar , voltar) e Sair.\n");

	
    }
    
    public void readAction(String cmd) throws IOException{
	cmd = cmd.toLowerCase();
	if(cmd.equals("adicionar")){
	    add();
	}
	
	if(cmd.equals("mostrar lista")){
	    showList();
	}
	if(cmd.equals("pesquisar letra")){
	    String letraPesquisa;
	    System.out.println("Entre com o caractere:");
	    letraPesquisa= sc.nextLine();
	  char letra = letraPesquisa.charAt(0);
	    findByChar(letra);
	}
	
	if(cmd.equals("navegar")){
	    surfIntoList();
	}
	
	
	if(cmd.equals("sair")){
	    System.out.println("Programa Encerrado...");
	    System.exit(0);
	}
     }
    
    public void add() throws IOException{
	
		 Reader fileReader = new FileReader("registros.txt");
		
		 br = new BufferedReader(fileReader);
		
		 String nome = null;
		 String telefone;
		
		
		 sc = new Scanner(System.in);
		
		 Writer fileWriter = new FileWriter("registros.txt", true);
	
		
		 System.out.println("Digite o nome: ");

		 nome = sc.nextLine()+";".toLowerCase();
		
		
	    //inserir ddd!!
	System.out.println("Digite o telefone: ");
	telefone = sc.nextLine();
	
	/*Inserindo os valores no arquivo .txt
	 * 
	 * **/
	boolean insertion = false;

	while (insertion!=true) {
	    
	    	fileWriter.write(nome+" "+telefone);
		fileWriter.append("\n");
		insertion = true;
	}
	
	fileWriter.close();
	
    }
    
  public void showList() throws IOException{
	
      Pessoa ps = new Pessoa();
	
 	 ListaOrdenada<String> lista = new ListaOrdenada<String>();
	
	 Reader fileReader = new FileReader("registros.txt");
	 br = new BufferedReader(fileReader);
	
      
      String line = null;

	
	 while ((line = br.readLine()) != null) {
		
	     String[] breakLine = line.split(";");
	     
	     //	System.out.println(line);
		
			 String nomePessoa = breakLine[0];//nome
			 String telefonePessoa = breakLine[1];//telefone
			 
			 nomePessoa.toLowerCase();
	 			 
			 ps.setNome(nomePessoa.toLowerCase());
			 ps.setTelefone(telefonePessoa);
			 
			 lista.insert(new Nodo<String>(ps.getNome().toLowerCase()+" "+ps.getTelefone()));
		
			
	 }
		System.out.println("----------------");
		lista.print();
      
    }
   
  

  
  	public void findByChar(char c) throws IOException{
  	  
  	  Pessoa ps = new Pessoa();
  	
  	 ListaOrdenada<String> lista = new ListaOrdenada<String>();
 	
 	 Reader fileReader = new FileReader("registros.txt");
 	 br = new BufferedReader(fileReader);
 	
       
       String line = null;

 	
 	 while ((line = br.readLine()) != null) {
 		
 	     String[] breakLine = line.split(";");
 	     
 
 			 String nomePessoa = breakLine[0];//nome
 			 String telefonePessoa = breakLine[1];//telefone
 			nomePessoa.toLowerCase();
 			
 					 
 			 ps.setNome(nomePessoa.toLowerCase());
 			 ps.setTelefone(telefonePessoa);
 			 
 			 lista.insert(new Nodo<String>(ps.getNome().toLowerCase()+" "+ps.getTelefone()));	
 			
 	 }
 		System.out.println("----------------");
 		lista.printUniqueChar(c);
  }
  
  	public void surfIntoList() throws IOException{

  	     Pessoa ps = new Pessoa();
  		
  	 	 ListaOrdenada<String> lista = new ListaOrdenada<String>();
  		
  		 Reader fileReader = new FileReader("registros.txt");
  		 br = new BufferedReader(fileReader);
  		
  	      
  	      String line = null;

  		
  		 while ((line = br.readLine()) != null) {
  			
  		     String[] breakLine = line.split(";");
  		     
  		     //	System.out.println(line);
  			
  				 String nomePessoa = breakLine[0];//nome
  				 String telefonePessoa = breakLine[1];//telefone
  				nomePessoa.toLowerCase();
  	 				 
  				 ps.setNome(nomePessoa.toLowerCase());
  				 ps.setTelefone(telefonePessoa);
  				 
  				 lista.insert(new Nodo<String>(ps.getNome().toLowerCase()+" "+ps.getTelefone()));
  			
  				
  		 }
  			
  		System.out.println("----------------");
		
  		System.out.println("Digite (W) para VOLTAR e (S) para AVANCAR ou (VOLTAR) para voltar ao menu inicial.\n");
		do{
		    
		    try{
			System.out.println("Digite o comando:");
		    String s = sc.nextLine();
		
		    s.toLowerCase();
		    
		    if(s.equals("s")){
		   lista.upDown++;
		    lista.printAgain();
		 
		}if(s.equals("w")){
		    lista.upDown--;
		    lista.printAgain();
		 
		}
		if(s.equals("voltar")){
		    break;
		 
		}
		   
		    }catch(Exception e){
		    System.out.println("Entrada Inválida...");
		}
		}while(true);
  	}
  	
  	
}
