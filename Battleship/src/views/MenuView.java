/**
 * @author Dennis Kaffer
 * 
 * */

package views;

import models.Player;
import static java.lang.System.out;

public class MenuView {

    
    public void EntranceMessage()
    {
    out.println("Comecou a batalha!!!\n"
		+ "Entre com as coordenadas"
		+ " exemplo( 1 A  ou 2 d ):  (LINHA, COLUNA)");
    }
    
    
 
    public void menuSubStatus(int tirosCounter, int acertousCounter, int naviosAfundadosCounter)
    {
	out.println("Misseis lancados: " + tirosCounter
		+ "   " + "Acertos: " + acertousCounter + "   "
		+ "Navios afundados: " + naviosAfundadosCounter);
    
    }
     public void playerStatus(Player player)
     {
	 out.println(player);
     }
     
     public void invalidFormatCoordenada()
     {
	 out.println("Formato de coordenada invalido...");
   	    }
    
     
     
     public void youFailedGameOver(){
		out.println("Voce ficou sem municoes e perdeu a Batalha naval!");
	    }
	    
     
     public void reloadGame(){
 		out.println("Entre com 'S' para jogar de novo, ou 'N' para sair.");
 	    }
     
     public void allShipsSunk(int tirosCounter){
	 System.out.println("GAME OVER. Voce erradicou todos os navios do grid, total de misseis lancados: "
			+ tirosCounter
			+ "\nEntre com 'S' para jogar de novo, ou 'N' para sair.");
	 
     }
     
     public void tiroLocalAcerto(){
	 out.println("\nAcertou!!");
  	 
       }
     public void tiroLocalErro(){
	 out.println("\nErrou!! =/");
  	 
       }
     
     
     public void afundouNavioPrint(String getNavioInformatio){
	 out.println("Voce afundou um "+ getNavioInformatio + "!!!");
     	 
          }
     
     
}
