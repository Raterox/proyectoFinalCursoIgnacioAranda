package clases;
//TODO IMPLEMENTAR DAO
import java.util.ArrayList;

public class Postre extends Producto{

	public Postre(String nombre, float precio, ArrayList<Alergeno> alergenos) {
		super(nombre, precio, alergenos);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "Postre\n\t: " + super.toString();
	}
	
	
}
