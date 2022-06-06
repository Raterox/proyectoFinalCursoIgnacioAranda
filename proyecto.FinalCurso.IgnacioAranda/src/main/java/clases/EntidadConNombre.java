package clases;

import java.sql.SQLException;
import java.sql.Statement;
import exception.NombreVacioException;
import utils.UtilsDB;

public class EntidadConNombre {
	private String nombre;
	
	public EntidadConNombre(short id,String nombre) throws SQLException, NombreVacioException {
		setNombre(id,nombre);
	}
	public EntidadConNombre() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(short id, String nombre) throws SQLException, NombreVacioException {
		if (nombreVacio(nombre)) {
			throw new NombreVacioException("El nombre no puede estar vacia.");
		}
		Statement smt = UtilsDB.conectarBD();

		smt.executeUpdate(
				"UPDATE empleado SET nombre='" + nombre + "' WHERE id='" + id+ "'");

		UtilsDB.desconectarBD();

		this.nombre = nombre;
	}
	private boolean nombreVacio(String nom) {
		return nom.isBlank();
	}

	@Override
	public String toString() {
		return "Nombre: " + getNombre();
	}
	
	
}
