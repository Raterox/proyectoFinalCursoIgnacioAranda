package clases;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//TODO IMPLEMENTAR DAO
import java.util.ArrayList;

public class Mesa {
	private ArrayList<LineaDePedido> cuenta;
	private byte numero;
	
	public Mesa(ArrayList<LineaDePedido> cuenta, byte numero) {
		setCuenta(cuenta);
		setNumero(numero);
	}

	public ArrayList<LineaDePedido> getCuenta() {
		return cuenta;
	}

	public void setCuenta(ArrayList<LineaDePedido> cuenta) {
		this.cuenta = cuenta;
	}

	public byte getNumero() {
		return numero;
	}

	public void setNumero(byte numero) {
		this.numero = numero;
	}
	
	public void imprimirTodosCuenta(ArrayList<LineaDePedido> cuenta, byte numero) throws IOException {
		File carpeta = new File("./documentosRestaurante");
		if(!carpeta.exists()) {
			carpeta.mkdir();
		}
		FileWriter txt = new FileWriter("./documentosRestaurante/CuentaMesa" + numero + ".txt");
		txt.write("Mesa: " + numero + "\n\n");
		for(short i = 0; i<cuenta.size(); i++) {
			txt.write(cuenta.get(i).toString() + "\n");
		}
		txt.flush();
		txt.close();
	}


	@Override
	public String toString() {
		return "Mesa Numero" + getNumero() + "\n\t" + getCuenta();
	}
	
	
}
