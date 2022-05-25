package clases;

public class Bebida {
	private boolean alcoholica;
	
	public Bebida(boolean alcoholica) {
		super();
		this.alcoholica = alcoholica;
	}

	public boolean isAlcoholica() {
		return alcoholica;
	}

	public void setAlcoholica(boolean alcoholica) {
		this.alcoholica = alcoholica;
	}

	@Override
	public String toString() {
		return "Es Alcoholica? " + isAlcoholica() ;
	}
	
	
}
