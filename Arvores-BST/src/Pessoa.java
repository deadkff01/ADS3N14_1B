
public class Pessoa implements Comparable<Pessoa>{
	
	private String nome;
	private String telefone;

	public String getNome(){
		return nome;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

	public String getTelefone(){
		return telefone;
	}

	public void setTelefone(String telefone){
		this.telefone = telefone;
	}
	
	@Override
	public String toString(){
		return this.getNome()+" "+this.getTelefone();
	}
	
	@Override
	public int compareTo(Pessoa pessoa) {
		return this.getNome().compareToIgnoreCase(pessoa.getNome());
	}
	

}