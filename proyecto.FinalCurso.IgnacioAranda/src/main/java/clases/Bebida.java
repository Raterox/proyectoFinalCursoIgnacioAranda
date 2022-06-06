package clases;

import java.sql.SQLException;
import java.util.ArrayList;

import exception.NombreVacioException;
//TODO IMPLEMENTAR DAO
public class Bebida extends Producto{
	private boolean alcoholica;

	public Bebida(String nombre, float precio, ArrayList<Alergeno> alergenos, boolean alcoholica) throws SQLException, NombreVacioException {
		super(nombre, precio, alergenos);
		this.alcoholica = alcoholica;
	}

	public boolean isAlcoholica() {
		return alcoholica;
	}

	public void setAlcoholica(boolean alcoholica) {
		this.alcoholica = alcoholica;
	}

	@Override
	public String toString() {
		return "Bebida: \n\t" + super.toString() + "\tAlcoholica: " + isAlcoholica();
	}

	
	
	
	
	
}
