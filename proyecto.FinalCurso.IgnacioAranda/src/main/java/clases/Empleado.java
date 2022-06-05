package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import enums.Puesto;
import exception.ContrasenaIncorrectaException;
import exception.ContrasenaVaciaException;
import exception.EmpleadoNoExisteException;
import utils.UtilsDB;

public class Empleado extends EntidadConNombre {
	private String apellido;
	private float sueldo;
	private Puesto puesto;
	private String contrasena;

//TODO Implementar DAO
	public Empleado(String nombre, String apellido, float sueldo, Puesto puesto, String contrasena)
			throws SQLException, ContrasenaVaciaException {
		super(nombre);
		Statement query = UtilsDB.conectarBD();
		if (query.executeUpdate("INSERT INTO empleado VALUES('" + nombre + "','" + apellido + "','" + sueldo + "',"
				+ puesto + "','" + contrasena + ")") > 0) {
			this.apellido = apellido;
			this.sueldo = sueldo;
			this.puesto = puesto;
			setContrasena(contrasena);
		} else {
			throw new SQLException("No se ha podido insertar el empleado");
		}
		UtilsDB.desconectarBD();
	}

	public Empleado(String nombre, String contrasena)
			throws SQLException, ContrasenaIncorrectaException, EmpleadoNoExisteException {
		super(nombre);
		Statement smt = UtilsDB.conectarBD();

		ResultSet cursor = smt.executeQuery("SELECT * FROM usuario WHERE nombre='" +

				nombre + "'");

		if (cursor.next()) {

			this.contrasena = cursor.getString("contrasena");

			if (!this.contrasena.equals(contrasena)) {

				UtilsDB.desconectarBD();

				throw new ContrasenaIncorrectaException("La contrasena no es correcta");

			}
			super.setNombre(cursor.getString("nombre"));
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
			throw new ContrasenaVaciaException("La contraseña no puede estar vacia.");
		}
		Statement smt = UtilsDB.conectarBD();

		smt.executeUpdate(
				"UPDATE empleado SET contrasena='" + contrasena + "' WHERE contrasena='" + this.contrasena + "'");

		UtilsDB.desconectarBD();

		this.contrasena = contrasena;
	}

	private boolean contrasenaVacia(String pass) {
		return pass.isBlank();
	}
	public boolean eliminar() {
		Statement smt = UtilsDB.conectarBD();
		boolean ret;
		try {
			ret = smt.executeUpdate("DELETE FROM empleado WHERE nombre='" + super.getNombre() + "'") > 0;
			super.setNombre(null);
			this.contrasena = null;
		} catch (SQLException e) {
			UtilsDB.desconectarBD();
			return false;
		}
		UtilsDB.desconectarBD();
		return ret;
	}
	public static ArrayList<Empleado> getTodos() {
		Statement smt = UtilsDB.conectarBD();
		ArrayList<Empleado> res = new ArrayList<Empleado>();

		try {
			ResultSet devuelveUsuario = smt.executeQuery("select * from empleado");
			while (devuelveUsuario.next()) {
				Empleado actual = new Empleado();
				
				actual.setNombre(devuelveUsuario.getString("nombre"));
				actual.contrasena = devuelveUsuario.getString("contrasena");

				res.add(actual);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		UtilsDB.desconectarBD();
		return res;
	}

	@Override
	public String toString() {
		return "Empleado:\n\t" + super.toString() + "\n\tApellido: " + getApellido() + "\n\tSueldo: " + getSueldo()
				+ "\n\tPuesto: " + getPuesto() + "\n";
	}

}
