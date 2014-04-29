/**Trabalho da arvore binaria..
 * 
 * @author Dennis Kaffer

 * @version 1.0

 */


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;


public class AppMain {
	
	static Scanner sc = new Scanner(System.in);
	static BST<Pessoa> arvoreBinaria = new BST<Pessoa>();
	private static BufferedReader br;
	
	public static void main(String [] args) throws IOException{
		
	
		readFile("registros.csv");
	
		while(true){
		
			//System.out.println(arvoreBinaria.getElements());	
			
			showMenu();
			String entrada;
			entrada = sc.nextLine();
			
			
			
			if(entrada.equalsIgnoreCase("adicionar")){
				adicionar();
			}
			if(entrada.equalsIgnoreCase("Mostrar Lista")){
				mostrarLista();
			}
			if(entrada.equalsIgnoreCase("pesquisar altura")){
				pesquisarAlt();
			}
			if(entrada.equalsIgnoreCase("pesquisar largura")){
				pesquisarLar();
			}
			if(entrada.equalsIgnoreCase("deletar")){
				deletar();
			}
			if(entrada.equalsIgnoreCase("sair")){
				System.exit(0);
				System.out.println("Programa Encerrado...");
			}
		}

	}
	
 static void showMenu(){
		
		System.out.println("Comandos: Adicionar, Mostrar Lista, "
				+ "\npesquisar altura, pesquisar largura, Deletar e sair.");
		
	}
	
	 static void adicionar(){

		   System.out.println("Digite o nome da pessoa:");
		String nome = sc.nextLine();
		 System.out.println("Digite o telefone da pessoa:");
		String telefone = sc.nextLine();
		
		Pessoa pessoa = new Pessoa();
		
		pessoa.setNome(nome);
		
		pessoa.setTelefone(telefone);
		
		arvoreBinaria.add(new Node<Pessoa>(pessoa));
	
	System.out.println("Quntidade de elementos: "+arvoreBinaria.getSize());
	System.out.println("Altura da arvore: "+arvoreBinaria.getTreeHeight());
	System.out.println();
	
	try {
		sendToFile("registros.csv");
		System.out.println("Alteracoes salvas!");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
     static void mostrarLista(){
	   String selectMode;
	   
	   System.out.println("Digite (mostrar infixa, mostrar prefixa ou mostrar posfixa): \n");
	 
	   selectMode = sc.nextLine();
	   
	   if(selectMode.equals("mostrar infixa")){
		   System.out.println(arvoreBinaria.infixa());
	   }
	   else if(selectMode.equalsIgnoreCase("mostrar prefixa")){
		   System.out.println(arvoreBinaria.prefixa());
	   }
	   else if(selectMode.equalsIgnoreCase("mostrar posfixa")){
		   System.out.println(arvoreBinaria.posfixa());
	   }else{
		   System.out.println("opçao inexistente");
	   }
	   System.out.println(selectMode);
   }
   
    
    static void pesquisarAlt(){
  	   System.out.println("Digite o nome para pesquisar por ALTURA: \n");
     	String nome = null;
     	nome = sc.nextLine();

     	  System.out.println((arvoreBinaria.containsDFS(nome) == null) ? "Contato inexistente" 
    			   : "Contato encontrado > "+arvoreBinaria.containsDFS(nome)
    			    +"\nComparacoes feitas: "+arvoreBinaria.getComparisonsDFS()
    			   );
  		
  
   System.out.println("----------");
     }
     
     
    static void pesquisarLar(){
 	   System.out.println("Digite o nome para pesquisar por LARGURA: \n");
 		String nome = null;
 	  nome = sc.nextLine();
 	  

 	   System.out.println((arvoreBinaria.containsBFS(nome) == null) ? "Contato inexistente" 
 			   : "Contato encontrado > "+arvoreBinaria.containsBFS(nome)
 			    +"\nComparacoes feitas: "+arvoreBinaria.getComparisonsBFS()
 			   );
 		
 	   System.out.println("----------");
    }
     
    
    static void deletar(){
    	System.out.println("Digite o nome do contato para ser deletado:");
    	String nome = null;
    	nome = sc.nextLine();
    	
    	try {
    		
    	 	   System.out.println((arvoreBinaria.remove(nome)) ? "Contato removido com sucesso!"  : "Contato inexistente ou nome invalido..");
    	 		
		} catch (EmptyBSTException e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
		}
    	
    	
    	try {
			sendToFile("registros.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		System.out.println("Alteracoes salvas!");
    	
    	 System.out.println("----------");
    }
    
    static void sendToFile(String filename) throws IOException{
    	
   	 Reader fileReader = new FileReader(filename);
	 br = new BufferedReader(fileReader);
	 Writer fileWriter = new FileWriter(filename,false);
	 
	 fileWriter.write(arvoreBinaria.getElements());
	 
	 fileReader.close();
	 fileWriter.close();
		 br.close();
    }
    
    
     static void readFile(String filename) throws IOException {
		
		 Reader fileReader = new FileReader(filename);
		 br = new BufferedReader(fileReader);
	 	
		
		String line = null;
		
		Pessoa ps = new Pessoa();
		
		while((line = br.readLine()) != null){
			
			String[] breakLine = line.split(";");
			
			 String nomePessoa = breakLine[0];//nome
			 String telefonePessoa = breakLine[1];//telefone
			 
			 ps.setNome(nomePessoa);
			 ps.setTelefone(telefonePessoa);
			 
			arvoreBinaria.add(new Node<Pessoa>(ps));
			ps = new Pessoa();
		}	
		
		fileReader.close();
		 br.close();
		
	}
    
}
