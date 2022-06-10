package clases;

import java.util.ArrayList;

import exception.NombreVacioException;
//TODO IMPLEMENTAR  DAO
public class Zona extends EntidadConNombre{
	private ArrayList<Mesa> mesas;

	public Zona(String nombre, ArrayList<Mesa> mesas) throws NombreVacioException {
		super(nombre);
		setMesas(mesas);
	}

	public ArrayList<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(ArrayList<Mesa> mesas) {
		this.mesas = mesas;
	}

	@Override
	public String toString() {
		return super.getNombre(); 
	}
	
}
