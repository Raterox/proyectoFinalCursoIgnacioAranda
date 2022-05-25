package clases;

import enums.Puesto;

public class Empleado extends EntidadConNombre{
	private String apellido;
	private float sueldo;
	private Puesto puesto;

	public Empleado(String nombre, String apellido, float sueldo, Puesto puesto) {
		super(nombre);
		this.apellido = apellido;
		this.sueldo = sueldo;
		this.puesto = puesto;
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
		return "Empleado:\n\t" + super.toString() + "\n\tApellido: " + getApellido() + "\n\tSueldo: " + getSueldo() + "\n\tPuesto: " + getPuesto() + "\n";
	}
	
	
}
