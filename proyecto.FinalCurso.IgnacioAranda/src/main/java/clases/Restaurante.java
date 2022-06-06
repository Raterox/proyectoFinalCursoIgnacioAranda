package clases;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//TODO IMPLEMENTAR DAO
import java.util.ArrayList;

public class Restaurante {
	private float ingresosTotales;
	private ArrayList<Zona> zonas;
	private Carta carta;
	private ArrayList<Empleado> empleados;
	
	public Restaurante(float ingresosTotales, ArrayList<Zona> zonas, Carta carta, ArrayList<Empleado> empleados) {
		setIngresosTotales(ingresosTotales);
		setZonas(zonas);
		setCarta(carta);
		setEmpleados(empleados);
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
	
	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	public void imprimirTodosLosEmpleados(ArrayList<Empleado> empleados) throws IOException {
		File carpeta = new File("./documentosRestaurante");
		if(!carpeta.exists()) {
			carpeta.mkdir();
		}
		FileWriter txt = new FileWriter("./documentosRestaurante/Registro_De_Empleados.txt");
		for(short i = 0; i<empleados.size(); i++) {
			txt.write(empleados.get(i).toString() + "\n");
		}
		txt.flush();
		txt.close();
	}

	@Override
	public String toString() {
		return "Informacion del Restaurante: \n\tIngresos Totales: " + getIngresosTotales() + "\n\tZonas: " + getZonas() + "\n\tCarta: "
				+ getCarta();
	}
	
	
}
