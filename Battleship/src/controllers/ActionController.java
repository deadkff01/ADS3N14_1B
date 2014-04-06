package controllers;

import java.util.Scanner;

import controllers.Matrix;
import views.MenuView;




public class ActionController {

    	private Scanner scanner;
	private MenuView view1;
	
	protected Matrix grid = new Matrix();
	
    
    public void run() {
	scanner = new Scanner(System.in);
	
	 view1 = new MenuView();
	 view1.EntranceMessage();
	

	grid.inserirTodosNaviosRandomicamente();
	grid.print();
	

	while (!grid.isGameOver()) {
	    	
	    	view1.playerStatus(grid.player);
	    
		System.out.println("Entre com as coordenadas:");
		String input = scanner.nextLine();
		String[] parts = input.split("\\W+");
		
		int linhaTiro;
		int colunaTiro;
		int navioAfundado = grid.getNaviosAfundados();
		
		try {
		 
			checkCoordenadaFormat(parts);
			
			char num = parts[1].charAt(0);
			
			num = Character.toUpperCase(num);
			
			int column = ((int)(num-65)); 
			
			
			linhaTiro = Integer.parseInt(parts[0]);
			colunaTiro = column;
			
			refreshAcertoOuErro(linhaTiro, colunaTiro, grid);
			
			grid.navios[linhaTiro][colunaTiro].atirarLocal(linhaTiro, colunaTiro);
			
			printNavioAfundadoMessage(linhaTiro, colunaTiro, navioAfundado, grid);
			
			view1.menuSubStatus(grid.getTirosDados(), grid.getAcertosCount(),grid.getNaviosAfundados() );
			
			grid.print();
			
		} catch (RuntimeException e) {
			if (e.getMessage() != null) {
				System.out.println(e.getMessage());
			} else {
			    view1.invalidFormatCoordenada();
			}
		}
	}
	if(grid.getNaviosAfundados() == 13 ){
	
	
	view1.allShipsSunk(grid.getTirosDados());
	
	}else {
	    
	    view1.youFailedGameOver();
	}
	String input;
	do {
		input = scanner.nextLine();
		if (input.toUpperCase().equals("S"))
			this.run();
		else if (input.toUpperCase().equals("N"))
			System.exit(0);
		else
		    
		    view1.reloadGame();
			
	} while (input != "S" && input != "N");
    }


    /**
     * Checa o acerto e atualiza os contadores e mensagens..
     */
    private void refreshAcertoOuErro(int linha, int coluna, Matrix grid) {
    
	grid.player.subtairPontoPorTiro();
  
	if (grid.atirarLocal(linha, coluna)) {
	    		
	    		view1.tiroLocalAcerto();
	    
			grid.player.acrescentarPontosAcerto();
		    
		} else
		view1.tiroLocalErro();
    	}

    
    /**
 	 * Metodo que veridfica se o usu�rio inseriu as coordenadas corretamente.. 
 	 */
 	public void checkCoordenadaFormat(String[] parts) {
 		if (parts.length != 2) {
 			throw new RuntimeException(
 					"Coordenada invalida, tente por exemplo: 2 B");
 		}
 	}
    
    
	/**
	 * Imprime o infrmacoes sobre navio afundado...
	 */
	private void printNavioAfundadoMessage(int linha, int coluna, int navioAfundado,
		Matrix grid) {
	if (grid.getNaviosAfundados() > navioAfundado) {
	    
	    grid.player.acrescentarPontosNaviofundado();
	    
	    view1.afundouNavioPrint(grid.navios[linha][coluna].getNavioType() );
	}
}
    

    
}
