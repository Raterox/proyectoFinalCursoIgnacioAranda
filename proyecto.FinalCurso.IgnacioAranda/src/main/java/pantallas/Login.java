package pantallas;

//.setFont(new Font("Hack Nerd Font", Font.BOLD, 10));
import javax.swing.JPanel;
import javax.swing.JPasswordField;

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
import java.util.ArrayList;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import clases.Empleado;
import elementosVisuales.Boton;
import elementosVisuales.BotonRojo;
import enums.Puesto;
import exception.ContrasenaVaciaException;
import exception.EmpleadoNoExisteException;
import exception.NombreVacioException;

import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;

public class Login extends JPanel {
	private Ventana ventana;
	private JTextField textFieldUsuario;
	private JPasswordField textPassContrasena;

	public Login(Ventana v) {
		this.ventana = v;
		setBackground(SystemColor.activeCaption);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
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

		Boton btnIniciarSesion = new Boton("Iniciar Sesion");

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

		textPassContrasena = new JPasswordField();
		textPassContrasena.setFont(new Font("Hack Nerd Font", Font.BOLD, 15));
		textPassContrasena.setColumns(10);
		GridBagConstraints gbc_textFieldContrasena = new GridBagConstraints();
		gbc_textFieldContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldContrasena.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldContrasena.gridx = 8;
		gbc_textFieldContrasena.gridy = 5;
		add(textPassContrasena, gbc_textFieldContrasena);
		
		BotonRojo botonSalir = new BotonRojo("Salir");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.SOUTH;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 15;
		gbc_button.gridy = 6;
		add(botonSalir, gbc_button);

		// Acciones:
		
		botonSalir.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

		btnIniciarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String usuario = textFieldUsuario.getText();
				String contrasena = new String(textPassContrasena.getPassword());
				try {
					Empleado empleadoComprobar = new Empleado(usuario, contrasena);

					ventana.empleadoLogado = empleadoComprobar.existeEmpleado(ventana.restaurante.getEmpleados());
					JOptionPane.showMessageDialog(ventana, "Bienvenid@, " + ventana.empleadoLogado.getNombre(),
							"Login Correcto", JOptionPane.PLAIN_MESSAGE);
					if (ventana.empleadoLogado.getPuesto().equals(Puesto.ADMINISTRADOR)) {
						ventana.cambiarAPantalla("InicioAdmin");
					} else {
						ventana.cambiarAPantalla("Inicio");
					}

				} catch (NombreVacioException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ContrasenaVaciaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (EmpleadoNoExisteException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(ventana, "El emplead@ no existe", "Login Incorrecto",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
	}

}
