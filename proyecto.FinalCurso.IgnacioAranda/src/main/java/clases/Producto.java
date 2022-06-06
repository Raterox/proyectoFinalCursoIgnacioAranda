package clases;

import java.util.ArrayList;

import exception.NombreVacioException;
import exception.PrecioCeroException;

public class Producto extends EntidadConNombre{
	private float precio;
	private ArrayList<Alergeno> alergenos;
	
	public Producto(String nombre, float precio, ArrayList<Alergeno> alergenos) throws NombreVacioException, PrecioCeroException {
		super(nombre);
		if(precioCero(precio)) {
			throw new PrecioCeroException("El precio no puede ser cero");
		}
		setPrecio(precio);
		setAlergenos(alergenos);
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
	
	private boolean precioCero(float precio) {
		return precio==0;
	}

	@Override
	public String toString() {
		return super.toString() + "\n\tPrecio: " + getPrecio() + " euros" + "\n\tAlergenos: " + getAlergenos() + "\n";
	}
	
}
