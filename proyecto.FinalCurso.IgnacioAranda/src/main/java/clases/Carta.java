package clases;

import java.util.ArrayList;
//TODO IMPLEMENTAR DAO
public class Carta {
	private ArrayList<Producto> productos;

	public Carta(ArrayList<Producto> productos) {
		super();
		this.productos = productos;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Lista de productos de la carta: " + getProductos();
	}
	
	
}
