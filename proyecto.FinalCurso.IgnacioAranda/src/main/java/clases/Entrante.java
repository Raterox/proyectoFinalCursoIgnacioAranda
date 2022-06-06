package clases;

import java.sql.SQLException;
import java.util.ArrayList;

import exception.NombreVacioException;
//TODO IMPLEMENTAR DAO
public class Entrante extends Producto{

	public Entrante(String nombre, float precio, ArrayList<Alergeno> alergenos) throws SQLException, NombreVacioException {
		super(nombre, precio, alergenos);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Bebida: \n\t" + super.toString();
	}
	
	
}
