/**
 * @author Dennis Kaffer
 * 
 * */

package models;

public class Player {

    public int points = 15;
    
    
    public void acrescentarPontosAcerto(){
	this.points = this.points+3;
	
    }
    
    public void acrescentarPontosNaviofundado(){
	this.points = this.points+5;
    }
    public void subtairPontoPorTiro(){
	this.points -= 1;
    }
    
    
    public String toString(){
	return "Player status -- Misseis Disponivies:"+ this.points;
    }
    
    
}
