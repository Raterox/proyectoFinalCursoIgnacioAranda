package clases;

import java.util.ArrayList;
//TODO IMPLEMENTAR DAO
public class Entrante extends Producto{

	public Entrante(String nombre, float precio, ArrayList<Alergeno> alergenos) {
		super(nombre, precio, alergenos);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Bebida: \n\t" + super.toString();
	}
	
	
}
