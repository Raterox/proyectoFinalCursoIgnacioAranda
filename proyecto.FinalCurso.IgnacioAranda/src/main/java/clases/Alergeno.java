package clases;

public class Alergeno extends EntidadConNombre{
	private char simbolo;
	
	public Alergeno(String nombre,char simbolo) {
		super(nombre);
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
