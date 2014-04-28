import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;


public class AppMain {
	
	static Scanner sc = new Scanner(System.in);
	static BST<Pessoa> arvoreBinaria = new BST<Pessoa>();
	private static BufferedReader br;
	
	public static void main(String [] args) throws IOException{
		
	
		readFile("registros.csv");

		while(true){
					
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
			if(entrada.equalsIgnoreCase("pesquisar largura")){
				pesquisarLar();
			}
			
		}

	}
	
 static void showMenu(){
		
		System.out.println("Comandos: Adicionar, Mostrar Lista (Ex: mostrar infixa, mostrar prefixa, mostrar posfixa), "
				+ "\npesquisar altura, pesquisar largura, Deletar e sair");
		
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
	}
	
     static void mostrarLista(){
	   String selectMode;
	   
	   System.out.println("Digite (mostrar infixa, mostrar prefixa ou mostrar posfixa): \n");
	   Scanner scc = new Scanner(System.in);
	   
	   selectMode = scc.nextLine();
	   
	   if(selectMode.equals("mostrar infixa")){
		   System.out.println(arvoreBinaria.infixa());
	   }
	   if(selectMode.equalsIgnoreCase("mostrar prefixa")){
		   System.out.println(arvoreBinaria.prefixa());
	   }
	   if(selectMode.equalsIgnoreCase("mostrar posfixa")){
		   System.out.println(arvoreBinaria.posfixa());
	   }else{
		   System.out.println("opçao inexistente");
	   }
	   System.out.println(selectMode);
   }
   
    
    static void pesquisarAlt(){
  	   System.out.println("Digite o nome para pesquisar por ALTURA: \n");
     	String nome;
     	nome = sc.nextLine();
  		
     if(arvoreBinaria.containsDFS(nome).equals(null))
  		System.out.println("Contato inexistente ou nome invalido..");
     else
    	 System.out.println(arvoreBinaria.containsDFS(nome));
     System.out.println("Comparacoes feitas: "+arvoreBinaria.getComparisonsDFS());
     }
     
     
    static void pesquisarLar(){
 	   System.out.println("Digite o nome para pesquisar por LARGURA: \n");
 		String nome;
 	  nome = sc.nextLine();
 	  
      if(arvoreBinaria.containsDFS(nome).equals(null))
    		System.out.println("Contato inexistente ou nome invalido..");
      else
 		System.out.println(arvoreBinaria.containsBSF(nome));
      System.out.println("Comparacoes feitas: "+arvoreBinaria.getComparisonsBFS());
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
		
	}
    
}
