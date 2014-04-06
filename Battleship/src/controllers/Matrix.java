

package controllers;

import models.Destroyer;
import models.EmptyMatrix;
import models.Fragata;
import models.Navio;
import models.PortaAvioes;
import models.Submarino;
import models.Torpedeiro;
import models.Player;

public class Matrix {
	
	private static final int LINHA = 10; 
	private static final int COLUNA = 10; 
	
	public Navio[][] navios = new Navio[LINHA][COLUNA];

	public boolean[][] localValidoToNavio = new boolean[LINHA][COLUNA];
	
	
    	public Player player = new Player();
	
    	  //boolean PedacoDeNavioAcertado = false;
	 
	
    	int tirosCount;

	int AcertoCount;

	int naviosAfundados;

	Navio[] listaNavios = new Navio[13];

	public Matrix() {
		
		this.tirosCount = 0;
		this.AcertoCount = 0;
		this.naviosAfundados = 0;
		
		this.listaNavios[0] = new PortaAvioes();
		this.listaNavios[1] = new Fragata();
		this.listaNavios[2] = new Fragata();
		this.listaNavios[3] = new Destroyer();
		this.listaNavios[4] = new Destroyer();
		this.listaNavios[5] = new Submarino();
		this.listaNavios[6] = new Submarino();
		this.listaNavios[7] = new Submarino();
		this.listaNavios[8] = new Submarino();
		this.listaNavios[9] = new Torpedeiro();
		this.listaNavios[10] = new Torpedeiro();
		this.listaNavios[11] = new Torpedeiro();
		this.listaNavios[12] = new Submarino();
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
			    navios[i][j] = new EmptyMatrix();
			    navios[i][j].nextLinha = i;
			    navios[i][j].nextColuna = j;
			    navios[i][j].horizontal = true;
			    localValidoToNavio[i][j] = true;
			}
		}
	}

	/**
	 * Aleatoriamente coloca tada a frota de navios de forma que todos os navios caibam 
	 * E navios não vão ser posicionados lado a lado..
	 */
	public void inserirTodosNaviosRandomicamente() {
		for (Navio navio : listaNavios) {
		    navio.findValidNavioCoordenadas(this);
		    navio.insereNavioLocal(navio.getNextLinha(), navio.getNextColuna(),
			    	navio.isHorizontal(), this);
			refreshValidLocalNavio();
		}
	}

	/**
	 Determina se ha um navio nas coordenadas indicadas
	 */
	boolean isOcupado(int linha, int coluna) {
		return !(navios[linha][coluna] instanceof EmptyMatrix);
	}

	/**
	 *Determina se um tiro conta como um acerto. Se a coordenada esta ocupada
	 *E verifica se o navio nao esta afundado. 
	 *
	 *Eeste metodo adicona a Acertos e a afundado quando 
	 *ha sucesso na verificacao...
	 *
	 */
	public boolean atirarLocal(int linha, int coluna) {
	    
	    	
		Navio navioAtual = navios[linha][coluna];
		boolean acertouNavio = isOcupado(linha, coluna) && !navioAtual.isAfundado();
		
		 
		if (acertouNavio)
		    	AcertoCount++;
			tirosCount++;

		return acertouNavio;
	}

	/**
	 * Retorna o numero de tiros dados pelo player
	 */
	public int getTirosDados() {
		return tirosCount;
	}

	/**
	 * Retorna o numero de vezes que o player acertou um tiro ou navio, 
	 * se ele ainda não foi afundado
	 * 
	 * 
	 */
	public int getAcertosCount() {
		return AcertoCount;
	}

	/**
	 * Determina o numero de navios afundados
	 */
	public int getNaviosAfundados() {
		int numeroDeNaviosAfundadods = 0;
		for (Navio navio : listaNavios) {
			if (navio.isAfundado()){
			    numeroDeNaviosAfundadods++;
			    
			}
		}
		
		
		
		return numeroDeNaviosAfundadods;
	}

	
	/**
	 * Determina se o jogo acaba, quando o player afunda todos os navios
	 */
	public boolean isGameOver() {
		return getNaviosAfundados() == 13 || player.points == 0;
	}

	/*retorna um array contendo objetos da clase Navio correspondendo por vada coordenada
	 * 
	
	 
	Navio[][] getListaNavios() {
		return this.navios;
	}*/

	/**
	 * Atualiza um array de booleans indicando se a linha ou coluna estao 
	 * populadas por um navio adjacente. Se estiver esse ponto é considerado invalido
	 * para a colocao do proximo navio
	 * 
	 */
	void refreshValidLocalNavio() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				
			    	boolean isTopLinha = i == 0;
				boolean isBottomLinha = i == 9;
				boolean isLeftColuna = j == 0;
				boolean isRightColuna = j == 9;
				
				if (!(this.navios[i][j] instanceof EmptyMatrix)) 
				{
					
					this.localValidoToNavio[i][j] = false;
					
				} else if (!isTopLinha
						&& !(this.navios[i - 1][j] instanceof EmptyMatrix)) 
				{
					
					this.localValidoToNavio[i][j] = false;
					
				} else if (!isBottomLinha
						&& !(this.navios[i + 1][j] instanceof EmptyMatrix)) 
				{
					
					this.localValidoToNavio[i][j] = false;
				} 
				else if (!isLeftColuna
						&& !(this.navios[i][j - 1] instanceof EmptyMatrix)) 
				{
					this.localValidoToNavio[i][j] = false;
				} 
				else if (!isRightColuna
						&& !(this.navios[i][j + 1] instanceof EmptyMatrix)) 
				{
					this.localValidoToNavio[i][j] = false;
				} 
				else if (!isTopLinha && !isLeftColuna
						&& !(this.navios[i - 1][j - 1] instanceof EmptyMatrix)) 
				{
					this.localValidoToNavio[i][j] = false;
				} 
				else if (!isTopLinha && !isRightColuna
						&& !(this.navios[i - 1][j + 1] instanceof EmptyMatrix))
				{
					this.localValidoToNavio[i][j] = false;
				} 
				else if (!isBottomLinha && !isLeftColuna
						&& !(this.navios[i + 1][j - 1] instanceof EmptyMatrix)) 
				{
					this.localValidoToNavio[i][j] = false;
				} 
				else if (!isBottomLinha && !isRightColuna
						&& !(this.navios[i + 1][j + 1] instanceof EmptyMatrix)) 
				{
					this.localValidoToNavio[i][j] = false;
				}
			}
		}
	}
/*
	public void printValidLocalNavios() { 
	    //Some test ------
		int linhaCounter = 0;
		System.out.println("  0 1 2 3 4 5 6 7 8 9");
		for (int i = 0; i < 10; i++) {
			System.out.print(linhaCounter + " ");
			for (int j = 0; j < 10; j++) {
				System.out.print(localValidoToNavio[i][j] + " i");
			}
			linhaCounter++;
			System.out.print("\n");
		}
	}
	*/

	public void print() {
		int linhaCounter = 0;
		
		System.out.print("  ");
		for (int i = 0; i < 10; i++) {
			System.out.print((char)(65 + i) + " ");
		}System.out.println();
		for (int i = 0; i < 10; i++) {
			System.out.print(linhaCounter + " ");
			for (int j = 0; j < 10; j++) {
				Navio navioAtual = navios[i][j];
				int navioIndex = navioAtual.getNavioLocalIndex(i, j);
				
			 System.out.print(navioAtual.toString().charAt(navioIndex) + " ");
			}
			linhaCounter++;
			System.out.print("\n");
		}
	}

}
