/**
 * @author Dennis Kaffer
 * 
 * */


package models;

public class Destroyer extends Navio {

    public Destroyer() {
		this.length = 4;
	}

	@Override
	public String getNavioType() {
		return "Destroyer";
	}

}
