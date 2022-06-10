package pantallas;

import java.awt.SystemColor;

import javax.swing.JPanel;

import clases.Mesa;
import clases.Zona;

public class GestionMesa extends JPanel{
	private Ventana ventana;
	private Mesa mesa;
	private Zona zona;
	public GestionMesa(Ventana v, Mesa m, Zona z) {
		this.ventana = v;
		this.mesa = m;
		this.zona = z;
		
		setBackground(SystemColor.activeCaption);
	}

}
