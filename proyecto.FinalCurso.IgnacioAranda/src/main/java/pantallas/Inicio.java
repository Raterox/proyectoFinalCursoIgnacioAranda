package pantallas;

import java.awt.SystemColor;

import javax.swing.JPanel;

public class Inicio extends JPanel{
	private Ventana ventana;
	public Inicio(Ventana v) {
		this.ventana=v;
		setBackground(SystemColor.activeCaption);
	}
}
