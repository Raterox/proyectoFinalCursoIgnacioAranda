package clases;

import java.sql.SQLException;
import java.util.ArrayList;

import exception.NombreVacioException;
//TODO IMPLEMENTAR  DAO
public class Zona extends EntidadConNombre{
	private ArrayList<Mesa> mesas;

	public Zona(String nombre, ArrayList<Mesa> mesas) throws SQLException, NombreVacioException {
		super((short)0, nombre);
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
