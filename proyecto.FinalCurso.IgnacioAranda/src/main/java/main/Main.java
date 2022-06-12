package main;

import pantallas.Ventana;

public class Main {

	public static void main(String[] args) {
		String direccionLogo = "./Imagenes/logo.png";

		for (byte i = 0; i < args.length; i++) {
			if (args[i].equals("-logo")) {
				direccionLogo = args[i + 1];
			}

			if (args[i].equals("-h") || args[i].equals("-help")) {
				System.out.println("Ayuda:" + "\t-logo: Uselo seguido de la direccion donde se encuentra el logo");
				System.exit(0);
			}
		}
		Ventana v = new Ventana(direccionLogo);
	}

}
