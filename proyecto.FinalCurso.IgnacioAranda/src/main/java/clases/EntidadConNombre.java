package clases;

import java.sql.SQLException;
import java.sql.Statement;

import utils.UtilsDB;

public class EntidadConNombre {
	private String nombre;
	
	public EntidadConNombre(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws SQLException {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Nombre: " + getNombre();
	}
	
	
}
