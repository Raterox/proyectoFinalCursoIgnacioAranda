package elementosVisuales;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class BotonSalir extends JButton{
	public BotonSalir(String msg) {
		super(msg);
		estiloPorDefecto();
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(new Color(255, 158, 129));
				setForeground(new Color(255, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(new Color(255, 0, 0));
				setForeground(new Color(255, 158, 129));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

	}

	private void estiloPorDefecto() {
		this.setFont(new Font("Hack Nerd Font", Font.BOLD, 10));
		this.setBackground(new Color(255, 0, 0));
		this.setForeground(new Color(255, 158, 129));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
}
