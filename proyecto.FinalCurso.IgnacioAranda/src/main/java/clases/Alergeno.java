package clases;

import java.sql.SQLException;

import exception.NombreVacioException;
import exception.SimboloVacioException;


public class Alergeno extends EntidadConNombre{
	private char simbolo;
	public Alergeno(String nombre, char simbolo) throws SQLException, NombreVacioException, SimboloVacioException {
		super(nombre);
		if(SimboloVacio(simbolo)) {
			throw new SimboloVacioException("Tienes que introducir un Simbolo");
		}
		this.simbolo = simbolo;
	}

	public char getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(char simbolo) {
		this.simbolo = simbolo;
	}

	private boolean SimboloVacio(char simbolo) {
		return simbolo=='\0';
	}

	@Override
	public String toString() {
		return super.getNombre() + " || " + simbolo;
	}
	
	
	
	
	
}
