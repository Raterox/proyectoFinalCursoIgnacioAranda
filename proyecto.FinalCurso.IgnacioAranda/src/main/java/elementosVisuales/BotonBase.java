package elementosVisuales;

import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;

public class BotonBase extends JButton{
	public BotonBase(String msg) {
		super(msg);
		this.setFont(new Font("Hack Nerd Font", Font.BOLD, 10));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
}
