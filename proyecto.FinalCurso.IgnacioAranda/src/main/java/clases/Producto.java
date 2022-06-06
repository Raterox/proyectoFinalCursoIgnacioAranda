package clases;

import java.util.ArrayList;

import enums.Alcoholica;
import enums.TipoProducto;
import exception.NombreVacioException;
import exception.PrecioCeroException;
import exception.PuestoVacioException;

public class Producto extends EntidadConNombre{
	private float precio;
	private ArrayList<Alergeno> alergenos;
	private TipoProducto tipoProducto;
	private Alcoholica alcoholica;
	
	public Producto(String nombre, float precio, ArrayList<Alergeno> alergenos, TipoProducto tipoProducto) throws NombreVacioException, PrecioCeroException, PuestoVacioException {
		super(nombre);
		if(precioCero(precio)) {
			throw new PrecioCeroException("El precio no puede ser cero");
		}
		setPrecio(precio);
		setAlergenos(alergenos);
		setTipoProducto(tipoProducto);
	}
	
	public Producto(String nombre, float precio, ArrayList<Alergeno> alergenos, TipoProducto tipoProducto, Alcoholica alcoholica) throws NombreVacioException, PrecioCeroException, PuestoVacioException {
		super(nombre);
		if(precioCero(precio)) {
			throw new PrecioCeroException("El precio no puede ser cero");
		}
		setPrecio(precio);
		setAlergenos(alergenos);
		setTipoProducto(tipoProducto);
		setAlcoholica(alcoholica);
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
	
	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) throws PuestoVacioException {
		if(tipoVacio(tipoProducto)) {
			throw new PuestoVacioException("Tienes que seleccionar un puesto");
		}
		this.tipoProducto = tipoProducto;
	}
	
	public Alcoholica getAlcoholica() {
		return alcoholica;
	}

	public void setAlcoholica(Alcoholica alcoholica) {
		this.alcoholica = alcoholica;
	}

	private boolean tipoVacio(TipoProducto tipoProducto) {
		return tipoProducto.toString().isBlank();
	}

	private boolean precioCero(float precio) {
		return precio==0;
	}

	@Override
	public String toString() {
		return super.toString() + "\n\tPrecio: " + getPrecio() + " euros" + "\n\tAlergenos: " + getAlergenos() + "\n";
	}
	
}
