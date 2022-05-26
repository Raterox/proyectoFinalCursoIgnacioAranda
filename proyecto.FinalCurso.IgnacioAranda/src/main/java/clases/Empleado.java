package clases;

import java.sql.SQLException;
import java.sql.Statement;

import enums.Puesto;
import utils.UtilsDB;

public class Empleado extends EntidadConNombre {
	private String apellido;
	private float sueldo;
	private Puesto puesto;

//TODO Implementar DAO
	public Empleado(String nombre, String apellido, float sueldo, Puesto puesto) throws SQLException {
		super(nombre);
		Statement query = UtilsDB.conectarBD();
		if (query.executeUpdate("insert into empleado values('" + nombre + "','" + apellido + "','" + sueldo + "',"
				+ puesto + ")") > 0) {
			this.apellido = apellido;
			this.sueldo = sueldo;
			this.puesto = puesto;
		} else {
			throw new SQLException("No se ha podido insertar el empleado");
		}
		UtilsDB.desconectarBD();
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

	@Override
	public String toString() {
		return "Empleado:\n\t" + super.toString() + "\n\tApellido: " + getApellido() + "\n\tSueldo: " + getSueldo()
				+ "\n\tPuesto: " + getPuesto() + "\n";
	}

}
