package clases;
//TODO IMPLEMENTAR DAO
import java.util.ArrayList;

public class Restaurante {
	private float ingresosTotales;
	private ArrayList<Zona> zonas;
	private ArrayList<Producto> productoALaVenta;
	
	public Restaurante(float ingresosTotales, ArrayList<Zona> zonas, ArrayList<Producto> productoALaVenta) {
		super();
		this.ingresosTotales = ingresosTotales;
		this.zonas = zonas;
		this.productoALaVenta = productoALaVenta;
	}

	public float getIngresosTotales() {
		return ingresosTotales;
	}

	public void setIngresosTotales(float ingresosTotales) {
		this.ingresosTotales = ingresosTotales;
	}

	public ArrayList<Zona> getZonas() {
		return zonas;
	}

	public void setZonas(ArrayList<Zona> zonas) {
		this.zonas = zonas;
	}

	public ArrayList<Producto> getProductoALaVenta() {
		return productoALaVenta;
	}

	public void setProductoALaVenta(ArrayList<Producto> productoALaVenta) {
		this.productoALaVenta = productoALaVenta;
	}

	@Override
	public String toString() {
		return "Informacion del Restaurante: \n\tIngresos Totales: " + getIngresosTotales() + "\n\tZonas: " + getZonas() + "\n\tProducto A La Venta: "
				+ getProductoALaVenta();
	}
	
	
}
