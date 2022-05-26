package clases;

import java.util.ArrayList;
//TODO IMPLEMENTAR  DAO
public class Zona extends EntidadConNombre{
	private ArrayList<Mesa> mesas;

	public Zona(String nombre, ArrayList<Mesa> mesas) {
		super(nombre);
		this.mesas = mesas;
	}

	public ArrayList<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(ArrayList<Mesa> mesas) {
		this.mesas = mesas;
	}

	@Override
	public String toString() {
		return "Zona:\n\t" + super.toString() + "\n\tMesas: " + getMesas(); 
	}
	
}
