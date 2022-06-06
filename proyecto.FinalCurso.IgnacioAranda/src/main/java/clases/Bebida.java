package clases;

import java.util.ArrayList;

import enums.Alcoholica;
import exception.NombreVacioException;
import exception.PrecioCeroException;

public class Bebida extends Producto{
	private Alcoholica alcoholica;
	
	public Bebida(String nombre, float precio, ArrayList<Alergeno> alergenos)
			throws NombreVacioException, PrecioCeroException {
		super(nombre, precio, alergenos);
		// TODO Auto-generated constructor stub
	}

	public Alcoholica isAlcoholica() {
		return alcoholica;
	}

	public void setAlcoholica(Alcoholica alcoholica) {
		this.alcoholica = alcoholica;
	}

	@Override
	public String toString() {
		return "Bebida: \n\t" + super.toString() + "\tAlcoholica: " + isAlcoholica();
	}

	
	
	
	
	
}
