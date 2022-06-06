package clases;

import java.sql.SQLException;
import java.sql.Statement;
import exception.NombreVacioException;
import utils.UtilsDB;

public class EntidadConNombre {
	private String nombre;
	
	public EntidadConNombre(String nombre) throws SQLException, NombreVacioException {
		setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws SQLException, NombreVacioException {
		if (nombreVacio(nombre)) {
			throw new NombreVacioException("El nombre no puede estar vacia.");
		}
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
