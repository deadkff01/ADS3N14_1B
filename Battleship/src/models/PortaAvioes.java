
package models;

public class PortaAvioes extends Navio {

	public PortaAvioes() {
		this.length = 5;
	}

	@Override
	public String getNavioType() {
		return "PortaAvioes";
	}

}
