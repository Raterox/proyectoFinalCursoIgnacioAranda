package clases;

import java.sql.SQLException;
import java.util.ArrayList;

import exception.NombreVacioException;

public class Producto extends EntidadConNombre{
	private float precio;
	private ArrayList<Alergeno> alergenos;
	
	public Producto(String nombre, float precio, ArrayList<Alergeno> alergenos) throws SQLException, NombreVacioException {
		super((short)0,nombre);
		this.precio = precio;
		this.alergenos = alergenos;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public ArrayList<Alergeno> getAlergenos() {
		return alergenos;
	}

	public void setAlergenos(ArrayList<Alergeno> alergenos) {
		this.alergenos = alergenos;
	}

	@Override
	public String toString() {
		return "Producto:\n\t" + super.toString() + "\n\tPrecio: " + getPrecio() + "\n\tAlergenos: " + getAlergenos() + "\n";
	}
	
}
