package clases;

import java.util.ArrayList;

public class Bebida extends Producto{
	private boolean alcoholica;

	public Bebida(String nombre, float precio, ArrayList<Alergeno> alergenos, boolean alcoholica) {
		super(nombre, precio, alergenos);
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
		return "Bebida [alcoholica=" + alcoholica + ", getPrecio()=" + getPrecio() + ", getAlergenos()="
				+ getAlergenos() + ", toString()=" + super.toString() + ", getNombre()=" + getNombre() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}

	
	
	
	
	
}
