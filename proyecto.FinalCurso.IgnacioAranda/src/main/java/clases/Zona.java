package clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import exception.NombreVacioException;
//TODO IMPLEMENTAR  DAO
public class Zona extends EntidadConNombre{
	private ArrayList<Mesa> mesas;

	public Zona(String nombre, ArrayList<Mesa> mesas) throws NombreVacioException {
		super(nombre);
		setMesas(mesas);
	}

	public ArrayList<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(ArrayList<Mesa> mesas) {
		this.mesas = mesas;
	}
	
	public void imprimirTodosCuenta(Mesa m) throws IOException {
		ArrayList<LineaDePedido> cuenta = m.getCuenta();
		byte numero = m.getNumero();
		short total = 0;
		File carpeta = new File("./documentosRestaurante");
		if(!carpeta.exists()) {
			carpeta.mkdir();
		}
		FileWriter txt = new FileWriter("./documentosRestaurante/Zona" + super.getNombre() + "Mesa" + numero + ".txt");
		txt.write("Zona " + super.getNombre() + " || Mesa: " + numero + "\n\n");
		for(short i = 0; i<cuenta.size(); i++) {
			txt.write(cuenta.get(i).toString() + " || Total: " + cuenta.get(i).getCantidad() * cuenta.get(i).getProducto().getPrecio() + " euros\n");
			total +=cuenta.get(i).getCantidad() * cuenta.get(i).getProducto().getPrecio();
		}
		txt.write("\nTotal Cuenta: " + total + " euros"); 
		txt.flush();
		txt.close();
		
		File lectura = new File("./documentosRestaurante/Zona" + super.getNombre() + "Mesa" + numero + ".txt");
		try (BufferedReader br = new BufferedReader(new FileReader(lectura)))
        {
            String linea;
            System.out.println("El siguiente contenido ha sido escrito: ");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
		

	@Override
	public String toString() {
		return super.getNombre(); 
	}
	
}
