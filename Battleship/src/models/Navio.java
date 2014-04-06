

package models;
import java.util.Random;

import controllers.Matrix;

public abstract class Navio {

    	public Matrix player;
    
	public int nextLinha;

	public int nextColuna;

	public int length;

	public boolean horizontal;

	boolean[] maxAcertos = new boolean[5];

	/**
	 * Retorna o tamanho de todos os navios
	 */
	int getLength() {
		return length;
	}

	/**
	 * retorna a proxima linha
	 */
	public int getNextLinha() {
		return nextLinha;
	}

	/**
	 * Retorna a proxima coluna
	 */
	public int getNextColuna() {
		return nextColuna;
	}

	/**
	 * Retorna se navio esta na horizontal
	 */
	public boolean isHorizontal() {
		return horizontal;
	}

	/**
	 * Ajusta o valor da proxima linha
	 */
	void setNextLinha(int row) {
		this.nextLinha = row;
	}

	/**
	 * Ajusta o valor para a proxima coluna
	 */
	void setNextColuna(int column) {
		this.nextColuna = column;
	}

	/**
	 * Define se a orientação do navio é horizontal
	 */
	void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	/**
	 * Retona o nome do tipo de navio
	 *
	 */
	public String getNavioType() {
		return "";
	}

	/**
	 *  
	 * Tenta encontrar as proximas linhas e colunas aletorias, e orienta ate um local valido,
	 * (Isso esta programado para que os navios nao fiquem lado a lado)
	 * Em seguida ele atualiza as coordenadas e orientacao do navio em conformidade
	 * com a validacao..
	 * 
	 */
	public void findValidNavioCoordenadas(Matrix grid) {
		boolean foundSpot = false;
		int linha = 0;
		int coluna = 0;
		boolean horizontal = false;
		
		Random gerador = new Random();
		
		while (!foundSpot) {
			horizontal = gerador.nextBoolean();
			linha = gerador.nextInt(10);
			coluna = gerador.nextInt(10);
			foundSpot = okToPlaceShipAt(linha, coluna, horizontal, grid);
		}
		setNextLinha(linha);
		setNextColuna(coluna);
		setHorizontal(horizontal);
	}

	/**
	 * Checa se o navio foi colocado com as novas coordenadas adquirdas por nextLinha e nextColuna..
	 * 
	 */
	boolean navioEncaixaOnGrid(int linha, int coluna, boolean horizontal, Matrix grid) {
		if (horizontal) {
			return linha < grid.navios.length
					&& coluna + this.length <= grid.navios[0].length;
		} else {
			return coluna < grid.navios[0].length
					&& linha + this.length <= grid.navios.length;
		}
	}

	/**
	 * 
	 * A utilizacao das determinadas nextLinha e nextColuna.
	 * Este metode e usado para avaliar a colocao aleatoria de um navio ou recuperar suas coordenadas
	 * 
	 */
	int[][] geradorNavioCoordenadas(int linha, int coluna, boolean horizontal) {
		int[][] shipCoordinates = new int[this.length][2];
		for (int i = 0; i < this.length; i++) {
			if (horizontal) {
				shipCoordinates[i][0] = linha;
				shipCoordinates[i][1] = coluna + i;
			} else {
				shipCoordinates[i][0] = linha + i;
				shipCoordinates[i][1] = coluna;
			}
		}
		return shipCoordinates;
	}

	/**
	 *  Verifica se o navio foi coloca em determinada posicao e se nao 
	 *  teriam navios adjacentes..
	 *  
	 */
	boolean checkIfHaveNaviosAdjacentes(int[][] navioCoordenadas, Matrix grid) {
		int validSpots = 0;
		for (int i = 0; i < navioCoordenadas.length; i++) {
			if (grid.localValidoToNavio[navioCoordenadas[i][0]][navioCoordenadas[i][1]]) {
				validSpots++;
			}
		}
		return validSpots == this.length;
	}

	/**
	 * 
	 * 
	 * Verifica se o navio pode ser colocado no grid com as coordenadas dadas pela nextLinha e nextColuna e orientacao horizontal ou nao
	 * ele retorna se o navio se encaixa no grid e nao fica ao lado de outros navios..
	 * 
	 */
	boolean okToPlaceShipAt(int linha, int coluna, boolean horizontal, Matrix grid) {
		return navioEncaixaOnGrid(linha, coluna, horizontal, grid)
				&& checkIfHaveNaviosAdjacentes(
					geradorNavioCoordenadas(linha, coluna, horizontal), grid);
	}

	/**
	 * 
	 * Define coordenadas linha, coluna e orientacao..
	 * 
	 *
	 */
	public void insereNavioLocal(int linha, int coluna, boolean horizontal, Matrix grid) {
	    setNextLinha(linha);
	    setNextColuna(coluna);
		setHorizontal(horizontal);
		int[][] navioCoordenadas = geradorNavioCoordenadas(linha, coluna,
				horizontal);
		for (int i = 0; i < navioCoordenadas.length; i++) {
		    grid.navios[navioCoordenadas[i][0]][navioCoordenadas[i][1]] = this;
		}
	}

	/**
	 * 
	 * Verifica se o tiro nas coordenadas especificas atingio o navio.
	 * Onavio deve estar localizado e nao pode estar afundado.
	 * Este metodo proporciona o boolean para o metodo Navio.atirarLocal
	 * 
	 */
	boolean checkAcerto(int linha, int coluna) {
		boolean acerto = false;
		if (!isAfundado()) {
			int[][] navioCoordenadas = this.geradorNavioCoordenadas(nextLinha,
				nextColuna, horizontal);
			for (int i = 0; i < navioCoordenadas.length; i++) {
				if (linha == navioCoordenadas[i][0]
						&& coluna == navioCoordenadas[i][1]) {
				    acerto = true;
				}
			}
		}
		return acerto;
	}

	/**
	 * Retorna a localizacao do navio..
	 * Esete metodo fornece o indice para o metodo Navio.AtirarLocal
	 * 
	 */
	public int getNavioLocalIndex(int linha, int coluna) {
		int navioLocalIndex = 0;
		int[][] navioCoordenadas = this.geradorNavioCoordenadas(nextLinha,
			nextColuna, horizontal);
		for (int i = 0; i < navioCoordenadas.length; i++) {
			if (linha == navioCoordenadas[i][0] && coluna == navioCoordenadas[i][1]) {
			    navioLocalIndex = i;
			}
		}
		return navioLocalIndex;
	}

	/**
	 *  boolean que testa se o navio foi atingido, e atualiza o Navio.maxAcertos [] 
	 * array accordingly
	 */
	public boolean atirarLocal(int linha, int coluna) {
	 
		boolean acerto = checkAcerto(linha, coluna);
		
		if (acerto) {
			int navioIndex = this.getNavioLocalIndex(linha, coluna);
			this.maxAcertos[navioIndex] = true;
		}
		return acerto;
	}

	/**
	 * Determina se o navio foi afundado
	 * e atribui um acrescimo na variavel contadora de acertos e rotorna a mesma..
	 */
	public boolean isAfundado() {
		int acertoCounter = 0;
		for (int i = 0; i < this.length; i++) {
			if (maxAcertos[i])
			    acertoCounter++;
			
		}
		return acertoCounter == this.length;
	}

	@Override
	public String toString() {
		String print = "";
		for (int i = 0; i < this.length; i++) {
			if (this.isAfundado())
			    print += 'O';
			else if (this.maxAcertos[i])
			    print += 'S';
			
			else
			    print += '.';
		}
		return print;
	}

}
