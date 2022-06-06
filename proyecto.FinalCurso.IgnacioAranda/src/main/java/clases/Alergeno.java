package clases;

import java.sql.SQLException;

import exception.NombreVacioException;

//TODO IMPLEMENTAR DAO
public class Alergeno extends EntidadConNombre{
	private char simbolo;

	public Alergeno(String nombre, char simbolo) throws SQLException, NombreVacioException {
		super(nombre);
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
