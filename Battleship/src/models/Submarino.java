
package models;

public class Submarino extends Navio {

    public Submarino() {
		this.length = 1;
	}

	@Override
	public String getNavioType() {
		return "Submarino";
	}

}
