package clases;
import java.sql.SQLException;
//TODO IMPLEMENTAR DAO
import java.util.ArrayList;

import exception.NombreVacioException;

public class Principal extends Producto{

	public Principal(String nombre, float precio, ArrayList<Alergeno> alergenos) throws SQLException, NombreVacioException {
		super(nombre, precio, alergenos);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Principal\n\t: " + super.toString();
	}
	
}
