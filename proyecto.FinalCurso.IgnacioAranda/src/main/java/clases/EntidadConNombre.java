package clases;

import java.sql.SQLException;
import exception.NombreVacioException;

public class EntidadConNombre {
	private String nombre;
	
	public EntidadConNombre(String nombre) throws NombreVacioException {
		setNombre(nombre);
	}
	public void setNombre(String nombre) throws NombreVacioException {
		if (nombreVacio(nombre)) {
			throw new NombreVacioException("El nombre no puede estar vacia.");
		}
		this.nombre=nombre;
	}
	public String getNombre() {
		return this.nombre;
	}
	private boolean nombreVacio(String nom) {
		return nom.isBlank();
	}

	@Override
	public String toString() {
		return "Nombre: " + getNombre();
	}
	
	
}
