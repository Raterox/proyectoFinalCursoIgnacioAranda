package pantallas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JPanel{
	private Ventana ventana;
	
	public Menu(Ventana v) {
		this.ventana=v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lbBienvenido = new JLabel("Bienvenido");
		lbBienvenido.setFont(new Font("Hack Nerd Font", Font.BOLD, 15));
		GridBagConstraints gbc_lbBienvenido = new GridBagConstraints();
		gbc_lbBienvenido.insets = new Insets(0, 0, 5, 5);
		gbc_lbBienvenido.gridx = 6;
		gbc_lbBienvenido.gridy = 1;
		add(lbBienvenido, gbc_lbBienvenido);
		
		JLabel lblRestauranteLosCarpinchos = new JLabel("Restaurante Los Carpinchos");
		lblRestauranteLosCarpinchos.setFont(new Font("Hack Nerd Font", Font.BOLD, 15));
		GridBagConstraints gbc_lblRestauranteLosCarpinchos = new GridBagConstraints();
		gbc_lblRestauranteLosCarpinchos.insets = new Insets(0, 0, 5, 5);
		gbc_lblRestauranteLosCarpinchos.gridx = 6;
		gbc_lblRestauranteLosCarpinchos.gridy = 2;
		add(lblRestauranteLosCarpinchos, gbc_lblRestauranteLosCarpinchos);
		
		JLabel lbQueQuieresHacer = new JLabel("Que Quieres Hacer?");
		lbQueQuieresHacer.setFont(new Font("Hack Nerd Font", Font.BOLD, 13));
		GridBagConstraints gbc_lbQueQuieresHacer = new GridBagConstraints();
		gbc_lbQueQuieresHacer.insets = new Insets(0, 0, 5, 5);
		gbc_lbQueQuieresHacer.gridx = 6;
		gbc_lbQueQuieresHacer.gridy = 7;
		add(lbQueQuieresHacer, gbc_lbQueQuieresHacer);
		
		JButton btnLogin = new JButton("Iniciar Sesion");
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogin.gridx = 5;
		gbc_btnLogin.gridy = 8;
		add(btnLogin, gbc_btnLogin);
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnLogin.setFont(new Font("Hack Nerd Font", Font.BOLD, 10));
		
		JButton btnRegister = new JButton("Registrarse");
		GridBagConstraints gbc_btnRegister = new GridBagConstraints();
		gbc_btnRegister.insets = new Insets(0, 0, 5, 5);
		gbc_btnRegister.gridx = 7;
		gbc_btnRegister.gridy = 8;
		add(btnRegister, gbc_btnRegister);
		btnRegister.setFont(new Font("Hack Nerd Font", Font.BOLD, 10));

	}
}
