package clases;

import java.util.ArrayList;
//TODO IMPLEMENTAR DAO
public class Carta {
	private ArrayList<Producto> productos;

	public Carta(ArrayList<Producto> productos) {
		setProductos(productos);
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Carta: \n" + getProductos();
	}
	
	
}
