package clases;

import java.sql.SQLException;

import exception.NombreVacioException;
import exception.SimboloVacioException;

/**
 * 
 * @author ignac
 * Esta clase, definira los 
 *
 */
public class Alergeno extends EntidadConNombre{
	private char simbolo;
	/**
	 * 
	 * @param nombre
	 * @param simbolo
	 * @throws SQLException
	 * @throws NombreVacioException
	 * @throws SimboloVacioException
	 */
	public Alergeno(String nombre, char simbolo) throws SQLException, NombreVacioException, SimboloVacioException {
		super(nombre);
		if(SimboloVacio(simbolo)) {
			throw new SimboloVacioException("Tienes que introducir un Simbolo");
		}
		this.simbolo = simbolo;
	}
	/**
	 * 
	 * @return
	 */
	public char getSimbolo() {
		return simbolo;
	}
	/**
	 * 
	 * @return
	 */
	public void setSimbolo(char simbolo) {
		this.simbolo = simbolo;
	}
	/**
	 * 
	 * @return
	 */
	private boolean SimboloVacio(char simbolo) {
		return simbolo=='\0';
	}
	/**
	 * 
	 * @return
	 */
	@Override
	public String toString() {
		return super.toString() + "||" + simbolo;
	}
	
	
	
	
	
}
