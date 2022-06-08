package pantallas;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Alergeno;
import clases.Empleado;
import clases.LineaDePedido;
import clases.Mesa;
import clases.Producto;
import clases.Zona;
import enums.Alcoholica;
import enums.Puesto;
import enums.TipoProducto;
import exception.ApellidoVacioException;
import exception.ContrasenaVaciaException;
import exception.EmpleadoNoExisteException;
import exception.NombreVacioException;
import exception.PrecioCeroException;
import exception.PuestoVacioException;
import exception.SimboloVacioException;
import exception.SueldoVacioException;

public class Ventana extends JFrame {
	private HashMap<String, JPanel> pantallas;
	private JPanel pantallaActual;
	protected Empleado empleadoLogado;
	protected ArrayList<Empleado> empleados = new ArrayList<Empleado>();

	public Ventana() {
		
		
		pantallas = new HashMap<String, JPanel>();
		pantallas.put("Login", new Login(this));

		// Se que no funciona pero no entiendo porque
		this.setIconImage(new ImageIcon("./Imagenes/logo.png").getImage());

		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Restaurante los Carpinchos");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pantallaActual=new Login(this);
		this.setContentPane(pantallaActual);
		this.setVisible(true);

		// Creo los 4 elementos de cada tipo para mantenerlos en el programa

		try {
			Empleado juana = new Empleado("Juana", "Rodriguez", 1900f, Puesto.ADMINISTRADOR, "Juana");
			Empleado paco = new Empleado("Paco", "Sanchez", 800f, Puesto.BECARIO, "Paco");
			Empleado ariadna = new Empleado("Ariadna", "Alvarez", 1200f, Puesto.CAMARERO, "Ariadna");
			Empleado placido = new Empleado("Placido", "Paez", 1200f, Puesto.ENCARGADO, "Placido");
			
			empleados.add(juana);
			empleados.add(paco);
			empleados.add(ariadna);
			empleados.add(placido);

			Alergeno lecheYDerivados = new Alergeno("Leche y Derivados", 'l');
			Alergeno huevos = new Alergeno("Huevos", 'h');
			Alergeno frutosSecos = new Alergeno("Frutos Secos", 'f');
			Alergeno soja = new Alergeno("Soja", 's');
			
			ArrayList<Alergeno> lecheYHuevos = new ArrayList<Alergeno>();
			lecheYHuevos.add(lecheYDerivados);
			lecheYHuevos.add(huevos);
			ArrayList<Alergeno> lecheYFrutos = new ArrayList<Alergeno>();
			lecheYFrutos.add(lecheYDerivados);
			lecheYFrutos.add(frutosSecos);
			ArrayList<Alergeno> lecheYSoja = new ArrayList<Alergeno>();
			lecheYSoja.add(lecheYDerivados);
			lecheYSoja.add(soja);
			ArrayList<Alergeno> huevosYFrutos = new ArrayList<Alergeno>();
			huevosYFrutos.add(huevos);
			huevosYFrutos.add(frutosSecos);
			
			Producto fileteConPatatas = new Producto("Filete con Patatas", 15.4f, lecheYHuevos, TipoProducto.PRINCIPAL);
			Producto sexInTheBeach = new Producto("Sex in The Beach", 6.2f, TipoProducto.BEBIDA, Alcoholica.SI);
			Producto chorizoSegoviano = new Producto("Chorizo Segoviano", 15.4f, TipoProducto.ENTRANTE);
			Producto tartaDeQueso = new Producto("Tarta de Queso", 15.4f, lecheYHuevos, TipoProducto.POSTRE);
			
			LineaDePedido linea1 = new LineaDePedido(fileteConPatatas, (short) 4);
			LineaDePedido linea2 = new LineaDePedido(sexInTheBeach, (short) 2);
			LineaDePedido linea3 = new LineaDePedido(chorizoSegoviano, (short) 3);
			LineaDePedido linea4 = new LineaDePedido(tartaDeQueso, (short) 2);
			
			ArrayList<LineaDePedido> cuenta1 = new ArrayList<LineaDePedido>();
			cuenta1.add(linea1);
			cuenta1.add(linea2);
			cuenta1.add(linea3);
			cuenta1.add(linea4);
			
			Mesa mesa1 = new Mesa(cuenta1, (byte)1);
			
			ArrayList<Mesa> salonMesas = new ArrayList<Mesa>();
			salonMesas.add(mesa1);
			
			Zona salon = new Zona("Salon",salonMesas);
			
			ArrayList<Zona> zonas = new ArrayList<Zona>();
			zonas.add(salon);
			
			
			
		} catch (NombreVacioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApellidoVacioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PuestoVacioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ContrasenaVaciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SueldoVacioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SimboloVacioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PrecioCeroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		} 

	}
	

	public void cambiarAPantalla(String nombrePantalla) {
		this.pantallaActual.setVisible(false);
		this.pantallaActual=null;
		switch(nombrePantalla) {
			case "Login":
				this.pantallaActual=new Login(this);
			break;
			case "Inicio":
				this.pantallaActual=new Inicio(this);
			break;
		}
		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual);
	}
}
