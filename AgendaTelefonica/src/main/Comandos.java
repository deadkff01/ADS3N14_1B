package main;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Estrutura.ListaOrdenada;
import Estrutura.Nodo;
import Estrutura.Pessoa;


public class Comandos {
    
    private BufferedReader br;
    public static Scanner sc;

    public ListaOrdenada<String> lista;
    
    public static final int ADICIONAR = 1;
    public static final int MOSTRAR_LISTA = 2;
    public static final int PESQUISAR = 3;
    public static final int NAVEGAR = 4;
    public static final int DELETAR = 5;
    public static final int PESQUISA_BINARIA = 6;
    public static final int SAIR = 7;
	
	
    public void showMenu()
    {
	System.out.println("Comandos: Adicionar, Mostrar Lista (mostra a lista inteira), "
		+ "Pesquisar Letra, Navegar (avancar , voltar), Deletar, Pesquisa Binaria e Sair.\n");
    }
    
    public void readAction(String cmd) throws IOException{
	cmd = cmd.toLowerCase();
	
	switch(translateCommand(cmd)){
	
	case ADICIONAR:
	    	
	    	add();
	    
	    	break;
	case MOSTRAR_LISTA: 
	    	
	    	showList();
	    
	    break;
	case PESQUISAR:
	    	
	    	String letraPesquisa;
	    	System.out.println("Entre com o caractere:");
	    	letraPesquisa= sc.nextLine();
	    	char letra = letraPesquisa.charAt(0);
	    	findByChar(letra);
	   
	    	break;
	case NAVEGAR:
	    
	    	surfIntoList();
	    
	    break;
	case DELETAR:  
	    
	    	String nome;
	    	System.out.println("Entre com o nome para ser removido:");
	    	nome= sc.nextLine();
	    	removeLineFromFile(nome);
	    	refreshList();
	    	System.out.println("Contato removido!");
	    
	    	break;
	case PESQUISA_BINARIA:
	    	
	    	String pesquisaNome;
	    	System.out.println("Entre com o nome (nome completo) para pesquisar:");
	    	pesquisaNome= sc.nextLine().toLowerCase();
	    	BinarySearch(pesquisaNome);
	    
	    	break;
	case SAIR:
	    	
	    	System.out.println("Programa Encerrado...");
	    	System.exit(0);
	    
	    	break;
	}

     }

    
    public int translateCommand(String cmd){
	
	if(cmd.equals("adicionar")){
	    return  ADICIONAR;
	}
	 if(cmd.equals("mostrar lista")){
	    return  MOSTRAR_LISTA;
	    
	}
	 if(cmd.equals("pesquisar letra")){
	    return  PESQUISAR; 
	}
	 if(cmd.equals("navegar")){
	    return   NAVEGAR;
		
	}
	 if(cmd.equals("deletar")){
	    return  DELETAR;  
	}
	 if(cmd.equals("pesquisa binaria")){
	    return   PESQUISA_BINARIA;  
	}
	 if(cmd.equals("sair")){
	    return  SAIR;
	}
	
	return 0;
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
	 System.out.println();
    }
    
  public void showList() throws IOException{
	
      		System.out.println("----------------");
		lista.print();
		System.out.println();
    }
   
  

  
  	public void findByChar(char c) throws IOException{
  	  
 		System.out.println("----------------");
 		lista.printUniqueChar(c);
 		System.out.println();
  }
  
  	public void surfIntoList() throws IOException{

  	
  		System.out.println("----------------");
		
  		System.out.println("Digite (W) para VOLTAR e (S) para AVANCAR ou (VOLTAR) para voltar ao menu inicial.\n");
		do{
		    
		    try{
			System.out.println("Digite o comando:");
		    String s = sc.nextLine().toLowerCase();
		
		   // s.toLowerCase();
		    
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
  	
  	
  	public void sendQuery() throws IOException{
  	  Pessoa ps = new Pessoa();
  	
  	 lista = new ListaOrdenada<String>();
 	
 	 Reader fileReader = new FileReader("registros.txt");
 	 br = new BufferedReader(fileReader);
 	
       
       String line = null;

 	
 	 while ((line = br.readLine()) != null) {
 		
 	     String[] breakLine = line.split(";");
 	     
 	     //	System.out.println(line);
 		
 			 String nomePessoa = breakLine[0];//nome
 			 String telefonePessoa = breakLine[1];//telefone
 			 
 			// nomePessoa.toLowerCase();
 	 			 
 			 ps.setNome(nomePessoa.toLowerCase());
 			 ps.setTelefone(telefonePessoa);
 			 
 			 lista.insert(new Nodo<String>(ps.getNome().toLowerCase()+" - "+ps.getTelefone()));

 	 }
  	    
  	}
  	
  	
  	
  	
  	
  	  public void removeLineFromFile(String lineToRemove) throws IOException {


  	      File inFile = new File("registros.txt");
  	          
  	      File tempFile = new File(inFile.getAbsolutePath() + ".csv");
  	      
  	      BufferedReader br = new BufferedReader(new FileReader("registros.txt"));
  	      PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
  	      
  	      String line = null;

  	        while ((line = br.readLine()) != null) {
  	        
  	        if (!line.trim().startsWith(lineToRemove)) {

  	          pw.println(line);
  	          pw.flush();
  	        }
  	      }
  	      pw.close();
  	      br.close();
  	  }
  	  
  	  
  	  public void refreshList() throws IOException{
  	    
  	      
  		 Reader fileReader = new FileReader("registros.txt.csv");
  		 
  		 BufferedReader br = new BufferedReader(fileReader);
  		 
  		 Writer fileWriter = new FileWriter("registros.txt",false);
  		 
  		 String line;
  		
  		 while ((line = br.readLine()) != null) {
  			
  		    	fileWriter.write(line);
  			fileWriter.append("\n");
  					
  	 	 }
  		 fileWriter.close();
  		 br.close();
  	  }
  	  
  	  /**Implementação do 2 trabalho...
  	   *
  	   * Binary Search..
  	  @author Dennis Kaffer
          @version 1.0
  	   * */
  	  

    	public void BinarySearch(String nome){
    	   //lista.getHead();
    	    Nodo <?> nodo = lista.getHead();
    	   // Nodo<?> anterior = null;
    	    List<String> novaLista = new ArrayList<>();
    	  
    	   String find = null;
    	  	
    	  while(nodo != null){
    	      
    	    String temp1 = nodo.getData().toString();
    	    novaLista.add(temp1);
    	    nodo = nodo.getNext();
    	  }
    	  
    	int metade = novaLista.size()/2;
    	int comparacoes = 0;
    	   	
    	//String umaString = novaLista.get(metade).split("-");
    	if((novaLista.get(metade).split(" - ")[0]).compareTo(nome) == 0)
    	{
    	    comparacoes++;
    	  find = novaLista.get(metade);
    	 
    	}
    	else if ((novaLista.get(metade).split(" - ")[0]).compareTo(nome) > 0 )
    	
    	{    
    	    for(int i = metade; i >=0; i--){
    		comparacoes++;
    		if((novaLista.get(i).split(" - ")[0]).compareTo(nome) == 0 )
    		{    
    		  find = novaLista.get(i);
    		  break;
    		}
    		
    	    }
    	  
    	}
    	else{
    	    for(int i = metade; i < novaLista.size(); i++){
    		comparacoes++;
    		if((novaLista.get(i).split(" - ")[0]).compareTo(nome) == 0)
    		{
    		  find = novaLista.get(i);
    		  break;
    		}
    	
    	    }
    	}
    	if(find != null){
    	    System.out.println(find+" Numero de comparacoes feitas: "+comparacoes);
    	System.out.println();
    	}else{
    	  System.out.println("Nenhum registro encontrado...");
    	System.out.println();
    	}
    	
    	
    	//System.out.println(temp1);
    	// for(String x : novaLista){
    	//      System.out.println(x.split(" - ")[0]);
    	// }
    	
    	}
  	
    	

    	
}
