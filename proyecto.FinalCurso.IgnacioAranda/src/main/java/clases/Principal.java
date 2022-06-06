package clases;

import java.util.ArrayList;
import exception.NombreVacioException;
import exception.PrecioCeroException;

public class Principal extends Producto{
	
	public Principal(String nombre, float precio, ArrayList<Alergeno> alergenos)
			throws NombreVacioException, PrecioCeroException {
		super(nombre, precio, alergenos);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "Principal\n\t: " + super.toString();
	}
	
}
