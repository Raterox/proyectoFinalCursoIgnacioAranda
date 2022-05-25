package clases;

public class Alergeno {
	private char simbolo;
	
	public Alergeno(char simbolo) {
		super();
		this.simbolo = simbolo;
	}

	public char getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(char simbolo) {
		this.simbolo = simbolo;
	}

	@Override
	public String toString() {
		return "Simbolo del Alergeno: " + getSimbolo();
	}
	
	
}
