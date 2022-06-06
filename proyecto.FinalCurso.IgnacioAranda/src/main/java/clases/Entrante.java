package clases;

import java.util.ArrayList;
import exception.NombreVacioException;
import exception.PrecioCeroException;

public class Entrante extends Producto{
	
	public Entrante(String nombre, float precio, ArrayList<Alergeno> alergenos)
			throws NombreVacioException, PrecioCeroException {
		super(nombre, precio, alergenos);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "Bebida: \n\t" + super.toString();
	}
	
	
}
