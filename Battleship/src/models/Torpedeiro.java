
package models;

public class Torpedeiro extends Navio {

    public Torpedeiro() {
		this.length = 2;
	}

	@Override
	public String getNavioType() {
		return "Torpedeiro";
	}

}
