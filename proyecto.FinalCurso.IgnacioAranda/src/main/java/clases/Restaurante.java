package clases;
//TODO IMPLEMENTAR DAO
import java.util.ArrayList;

public class Restaurante {
	private float ingresosTotales;
	private ArrayList<Zona> zonas;
	private Carta carta;
	
	public Restaurante(float ingresosTotales, ArrayList<Zona> zonas, Carta carta) {
		setIngresosTotales(ingresosTotales);
		setZonas(zonas);
		setCarta(carta);
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

	public Carta getCarta() {
		return carta;
	}

	public void setCarta(Carta carta) {
		this.carta = carta;
	}

	@Override
	public String toString() {
		return "Informacion del Restaurante: \n\tIngresos Totales: " + getIngresosTotales() + "\n\tZonas: " + getZonas() + "\n\tCarta: "
				+ getCarta();
	}
	
	
}
