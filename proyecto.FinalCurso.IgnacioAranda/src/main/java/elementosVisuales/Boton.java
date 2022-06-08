package elementosVisuales;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class Boton extends JButton {
	public Boton(String msg) {
		super(msg);
		estiloPorDefecto();
		this.setFont(new Font("Hack Nerd Font", Font.BOLD, 10));
		this.setBackground(new Color(102, 153, 204));
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(new Color(51, 102, 154));
				setForeground(new Color(102, 153, 204));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(new Color(102, 153, 204));
				setForeground(new Color(51, 102, 154));
			}
		});

	}

	private void estiloPorDefecto() {
		this.setFont(new Font("Hack Nerd Font", Font.BOLD, 10));
		this.setBackground(new Color(102, 153, 204));
		this.setForeground(new Color(51, 102, 154));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
}
