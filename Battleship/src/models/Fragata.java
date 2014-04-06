
package models;

public class Fragata extends Navio {

	public Fragata() {
		this.length = 3;
	}

	@Override
	public String getNavioType() {
		return "Fragata";
	}

}
