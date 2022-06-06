package clases;

import java.sql.SQLException;

import exception.NombreVacioException;
import exception.SimboloVacioException;

//TODO IMPLEMENTAR DAO
public class Alergeno extends EntidadConNombre{
	private char simbolo;

<<<<<<< HEAD
	public Alergeno(String nombre, char simbolo) throws SQLException, NombreVacioException, SimboloVacioException {
		super(nombre);
=======
	public Alergeno() {
		super();
	}

	public Alergeno(short id, String nombre, char simbolo) throws SQLException, NombreVacioException {
		super(id, nombre);
>>>>>>> parent of 99a52cb (Limpieza del Programa 1)
		this.simbolo = simbolo;
	}

	public char getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(char simbolo) {
		this.simbolo = simbolo;
	}

	@Override
	public String toString() {
		return "Alergeno [simbolo=" + simbolo + ", Nombre()=" + super.toString() + "]";
	}
	
	
	
	
	
}
