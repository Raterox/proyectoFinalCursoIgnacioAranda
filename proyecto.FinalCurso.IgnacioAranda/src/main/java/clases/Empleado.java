package clases;

import java.util.ArrayList;

import enums.Puesto;
import exception.ApellidoVacioException;
import exception.ContrasenaVaciaException;
import exception.EmpleadoNoExisteException;
import exception.NombreVacioException;
import exception.PuestoVacioException;
import exception.SueldoVacioException;

public class Empleado extends EntidadConNombre {
	private String apellido;
	private float sueldo;
	private Puesto puesto;
	private String contrasena;

	public Empleado(String nombre, String apellido, float sueldo, Puesto puesto, String contrasena)
			throws NombreVacioException, ApellidoVacioException, PuestoVacioException, ContrasenaVaciaException,
			SueldoVacioException {
		super(nombre);
		setApellido(apellido);
		setSueldo(sueldo);
		setPuesto(puesto);
		setContrasena(contrasena);
	}

	public Empleado(String nombre, String contrasena) throws NombreVacioException, ContrasenaVaciaException {
		super(nombre);
		setContrasena(contrasena);
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) throws ApellidoVacioException {
		if (apellidoVacio(apellido)) {
			throw new ApellidoVacioException("El apellido esta vacio");
		}
		this.apellido = apellido;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) throws SueldoVacioException {
		if (sueldoVacio(sueldo)) {
			throw new SueldoVacioException("El sueldo esta vacio");
		}
		this.sueldo = sueldo;
	}

	public Puesto getPuesto() {
		return puesto;
	}

	public void setPuesto(Puesto puesto) throws PuestoVacioException {
		if (puestoVacio(puesto)) {
			throw new PuestoVacioException("Tienes que seleccionar un puesto");
		}
		this.puesto = puesto;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) throws ContrasenaVaciaException {
		if (contrasenaVacia(contrasena)) {
			throw new ContrasenaVaciaException("La contrasena no puede estar vacia.");
		}
		this.contrasena = contrasena;
	}

	private boolean apellidoVacio(String apell) {
		return apell.isBlank();
	}

	private boolean sueldoVacio(float sueldo) {
		return sueldo == 0;
	}

	private boolean puestoVacio(Puesto puesto) {
		return puesto.toString().isBlank();
	}

	private boolean contrasenaVacia(String cont) {
		return cont.isBlank();
	}

	public Empleado existeEmpleado(ArrayList<Empleado> empleados) throws EmpleadoNoExisteException {
		boolean existe = false;
		short posEmpleado = 0;
		for (short i = 0; i < empleados.size(); i++) {
			if ((empleados.get(i).getNombre().equals(this.getNombre()))
					&& (empleados.get(i).getContrasena().equals(this.getContrasena()))) {
				existe = true;
				posEmpleado = i;
			}
		}
		if (existe == false) {
			System.out.println("Estoy aqui");
			throw new EmpleadoNoExisteException("El empleado no existe");
		} else {
			return empleados.get(posEmpleado);
		}
	}

	@Override
	public String toString() {
		return "Empleado:\n\t" + super.toString() + "\n\tApellido: " + getApellido() + "\n\tSueldo: " + getSueldo()
				+ "\n\tPuesto: " + getPuesto() + "\n";
	}

}
