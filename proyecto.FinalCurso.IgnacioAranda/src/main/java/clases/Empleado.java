package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import enums.Puesto;
import exception.ApellidoVacioException;
import exception.ContrasenaIncorrectaException;
import exception.ContrasenaVaciaException;
import exception.EmpleadoNoExisteException;
import exception.IdVaciaException;
import exception.NombreVacioException;
import exception.PuestoVacioException;
import exception.SueldoVacioException;
import utils.UtilsDB;

public class Empleado extends EntidadConNombre {
	private short id;
	private String apellido;
	private float sueldo;
	private Puesto puesto;
	private String contrasena;

	/**
	 * Funcion Registrar empleado, se inserta el nombre, apellido, sueldo, puesto y contrasena y se crea un
	 * empleado en la base de datos con esos valores.
	 * Las excepcion ContrasenaVaciaException, UsuarioVacioException, ApellidoVacioException, SueldoVacioException, PuestoVacioException, saltara cuando el valor referido introducido este vacio
	 * @param nombre
	 * @param apellido
	 * @param sueldo
	 * @param puesto
	 * @param contrasena
	 * @throws SQLException
	 * @throws ContrasenaVaciaException
	 * @throws PuestoVacioException, SueldoVacioException 
	 */
	public Empleado(short id,String nombre, String apellido, float sueldo, Puesto puesto, String contrasena)
			throws SQLException, IdVaciaException, NombreVacioException, ApellidoVacioException, PuestoVacioException, ContrasenaVaciaException {
		super(id,nombre);
		Statement query = UtilsDB.conectarBD();
		if (query.executeUpdate("INSERT INTO empleado VALUES('" + id + "','" + nombre + "','" + apellido + "','" + sueldo + "',"
				+ puesto + "','" + contrasena + ")") > 0) {
			this.id=id;
			setApellido(apellido);
			setSueldo(sueldo);
			setPuesto(puesto);
			setContrasena(contrasena);
		} else {
			throw new SQLException("No se ha podido insertar el empleado");
		}
		UtilsDB.desconectarBD();
	}

	public Empleado(short id,String nombre, String contrasena)
			throws SQLException, ContrasenaIncorrectaException, EmpleadoNoExisteException, NombreVacioException {
		super(id,nombre);
		Statement smt = UtilsDB.conectarBD();

		ResultSet cursor = smt.executeQuery("SELECT * FROM usuario WHERE id='" +

				id + "'");

		if (cursor.next()) {

			this.contrasena = cursor.getString("contrasena");

			if (!this.contrasena.equals(contrasena)) {

				UtilsDB.desconectarBD();

				throw new ContrasenaIncorrectaException("La contrasena no es correcta");

			}
			super.setNombre(id,cursor.getString("nombre"));
		} else {

			UtilsDB.desconectarBD();

			throw new EmpleadoNoExisteException("No existe ese email en la BD");

		}

		UtilsDB.desconectarBD();

	}
	public Empleado() {
		super();
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public Puesto getPuesto() {
		return puesto;
	}

	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) throws SQLException, ContrasenaVaciaException {
		if (contrasenaVacia(contrasena)) {
			throw new ContrasenaVaciaException("La contrasena no puede estar vacia.");
		}
		Statement smt = UtilsDB.conectarBD();

		smt.executeUpdate(
				"UPDATE empleado SET contrasena='" + contrasena + "' WHERE id='" + this.id + "'");

		UtilsDB.desconectarBD();

		this.contrasena = contrasena;
	}

	private boolean contrasenaVacia(String cont) {
		return cont.isBlank();
	}

	@Override
	public String toString() {
		return "Empleado:\n\t" + super.toString() + "\n\tApellido: " + getApellido() + "\n\tSueldo: " + getSueldo()
				+ "\n\tPuesto: " + getPuesto() + "\n";
	}

}
