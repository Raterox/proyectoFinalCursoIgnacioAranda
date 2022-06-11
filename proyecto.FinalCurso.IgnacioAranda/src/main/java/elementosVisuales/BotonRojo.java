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

public class BotonRojo extends JButton{
	public BotonRojo(String msg) {
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
			
		});

	}

	private void estiloPorDefecto() {
		this.setFont(new Font("Hack Nerd Font", Font.BOLD, 10));
		this.setBackground(new Color(255, 0, 0));
		this.setForeground(new Color(255, 158, 129));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	public void playSound(String soundName) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File (soundName).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}
}
