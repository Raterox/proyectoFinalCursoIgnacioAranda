package clases;

import java.util.ArrayList;

public class Mesa {
	private ArrayList<LineaDePedido> lineasDePedidos;
	private byte numero;
	
	public Mesa(ArrayList<LineaDePedido> lineasDePedidos, byte numero) {
		super();
		this.lineasDePedidos = lineasDePedidos;
		this.numero = numero;
	}

	public ArrayList<LineaDePedido> getLineasDePedidos() {
		return lineasDePedidos;
	}

	public void setLineasDePedidos(ArrayList<LineaDePedido> lineasDePedidos) {
		this.lineasDePedidos = lineasDePedidos;
	}

	public byte getNumero() {
		return numero;
	}

	public void setNumero(byte numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Mesa Numero" + getNumero() + "\n" + getLineasDePedidos();
	}
	
	
}
