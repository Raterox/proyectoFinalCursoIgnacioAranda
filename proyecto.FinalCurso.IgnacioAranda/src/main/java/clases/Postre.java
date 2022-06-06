package clases;
import java.util.ArrayList;
import exception.NombreVacioException;
import exception.PrecioCeroException;

public class Postre extends Producto{

	public Postre(String nombre, float precio, ArrayList<Alergeno> alergenos)
			throws NombreVacioException, PrecioCeroException {
		super(nombre, precio, alergenos);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "Postre\n\t: " + super.toString();
	}
	
	
}
