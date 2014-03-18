package ListaTel2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class principal3 {
	
	public static boolean testString1;
	public static boolean testString2;
	public static boolean finalSolution;
	
	public static String aa = "";
	public static String bb = "";
	public static String result = "";
	
	public static void main(String [] args) throws IOException{

		Pessoa ps = new Pessoa();
		
		ListaOrdenada<String> lista = new ListaOrdenada<String>();
		
		Reader fileReader = new FileReader("registros.txt");
		Reader fileReader2 = new FileReader("registros.txt");
		
		BufferedReader br = new BufferedReader(fileReader);
		
		String nome;
		String telefone;
		
		Scanner sc = new Scanner(System.in);
		Writer fileWriter = new FileWriter("registros.txt", true);
		
		
		
		System.out.println("Digite o nome: ");
		nome = sc.next();
		
		System.out.println("Digite o telefone: ");
		telefone = sc.next();
		
		BufferedReader brb = new BufferedReader(fileReader2);
	
		String line2 = null;
		
		
		int id = 0;
		boolean insertion = false;
		/*
		while ((line2 = brb.readLine()) != null) {
			
			id++;
		}
	
		*/
		while (insertion!=true) {
		
			fileWriter.write(nome+" "+telefone);
			fileWriter.append("\n");
			insertion = true;
		}
		
		fileWriter.close();
		int i = 0;
		
		String line = null;

		 ArrayList<String> pessoalista = new ArrayList<String>();
		
		 while ((line = br.readLine()) != null) {
			System.out.println(line);
			
			String pessoa;
		
			pessoa = String.valueOf(line);
			
			Scanner input = new Scanner(pessoa.toLowerCase());
			

				 
				 String nomePessoa = input.next();//nome
				 String telefonePessoa = input.next();//telefone
				 
				 String finalx = nomePessoa;
				
				 //aa = nomePessoa;
				// bb = nomePessoa;
				 
			     ps.setNome(nomePessoa);
				 ps.setTelefone(telefonePessoa);
				 
				 //pessoalista.add(ps.getNome());
				 
				// minhaLista.inserirNoFim(new No(ps.getNome(),ps.getTelefone()));
				
				 lista.insert(new Nodo<String>(ps.getNome()+" "+ps.getTelefone()));
				 
				// matchTwoStrings(aa, bb);
		
			i++;
		}
		System.out.println(i);
		// for(String o : pessoalista){
		//System.out.println(o);
        //}
		
		System.out.println("----------------");
		lista.print();
		//minhaLista.exibirListaPorLetra();
	
	//minhaLista.exibirListaPorOrdemAlfabetica();
	}

}
