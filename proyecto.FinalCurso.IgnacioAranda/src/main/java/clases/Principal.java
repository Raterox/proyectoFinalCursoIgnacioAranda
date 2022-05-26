package clases;
//TODO IMPLEMENTAR DAO
import java.util.ArrayList;

public class Principal extends Producto{

	public Principal(String nombre, float precio, ArrayList<Alergeno> alergenos) {
		super(nombre, precio, alergenos);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Principal\n\t: " + super.toString();
	}
	
}
