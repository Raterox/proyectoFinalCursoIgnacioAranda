package pantallas;
//.setFont(new Font("Hack Nerd Font", Font.BOLD, 10));
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
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.GridLayout;

public class Inicio extends JPanel{
	private Ventana ventana;
	private JTextField textFieldUsuario;
	private JTextField textFieldContrasena;
	
	public Inicio(Ventana v) {
		setBackground(SystemColor.activeCaption);
		this.ventana=v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblRestaurante = new JLabel("Restaurante Los Carpinchos");
		lblRestaurante.setFont(new Font("Hack Nerd Font", Font.BOLD, 20));
		GridBagConstraints gbc_lblRestaurante = new GridBagConstraints();
		gbc_lblRestaurante.insets = new Insets(0, 0, 5, 5);
		gbc_lblRestaurante.gridx = 8;
		gbc_lblRestaurante.gridy = 1;
		add(lblRestaurante, gbc_lblRestaurante);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Hack Nerd Font", Font.BOLD, 15));
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 6;
		gbc_lblUsuario.gridy = 3;
		add(lblUsuario, gbc_lblUsuario);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setFont(new Font("Hack Nerd Font", Font.BOLD, 15));
		GridBagConstraints gbc_textFieldUsuario = new GridBagConstraints();
		gbc_textFieldUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUsuario.gridx = 8;
		gbc_textFieldUsuario.gridy = 3;
		add(textFieldUsuario, gbc_textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setFont(new Font("Hack Nerd Font", Font.BOLD, 10));
		GridBagConstraints gbc_btnIniciarSesion = new GridBagConstraints();
		gbc_btnIniciarSesion.gridwidth = 3;
		gbc_btnIniciarSesion.gridheight = 3;
		gbc_btnIniciarSesion.insets = new Insets(0, 0, 5, 5);
		gbc_btnIniciarSesion.gridx = 11;
		gbc_btnIniciarSesion.gridy = 3;
		add(btnIniciarSesion, gbc_btnIniciarSesion);
		
		JLabel lblContrasena = new JLabel("Contrasena");
		lblContrasena.setFont(new Font("Hack Nerd Font", Font.BOLD, 15));
		GridBagConstraints gbc_lblContrasena = new GridBagConstraints();
		gbc_lblContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasena.gridx = 6;
		gbc_lblContrasena.gridy = 5;
		add(lblContrasena, gbc_lblContrasena);
		
		textFieldContrasena = new JTextField();
		textFieldContrasena.setFont(new Font("Hack Nerd Font", Font.BOLD, 15));
		textFieldContrasena.setColumns(10);
		GridBagConstraints gbc_textFieldContrasena = new GridBagConstraints();
		gbc_textFieldContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldContrasena.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldContrasena.gridx = 8;
		gbc_textFieldContrasena.gridy = 5;
		add(textFieldContrasena, gbc_textFieldContrasena);
	}
}
