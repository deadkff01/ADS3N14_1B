
package models;

public class EmptyMatrix extends Navio {
	
	public EmptyMatrix() {
		this.length = 1;
	}
	
	@Override
	public boolean atirarLocal(int row, int column) {
		if (checkAcerto(row, column)) this.maxAcertos[0] = true;
		return false;
	}
	
	@Override
	public boolean isAfundado() {
		return false;
	}
	
	@Override
	public String toString() {
		if(this.maxAcertos[0]) return "-";
		else return ".";
	}
	
	@Override
	public String getNavioType() {
		return "Mar vazio";
	}

}
