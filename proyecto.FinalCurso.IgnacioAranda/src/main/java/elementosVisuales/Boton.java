package elementosVisuales;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;

public class Boton extends BotonBase {
	public Boton(String msg) {
		super(msg);
		estiloPorDefecto();
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
		this.setBackground(new Color(102, 153, 204));
		this.setForeground(new Color(51, 102, 154));
	}

	public void playSound(String soundName) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}
}
