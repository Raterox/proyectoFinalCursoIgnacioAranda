package pantallas;

import java.awt.SystemColor;

import javax.swing.JPanel;

import elementosVisuales.Boton;
import elementosVisuales.BotonRojo;

import java.awt.GridBagLayout;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InicioAdmin extends JPanel{
	private Ventana ventana;
	
	public InicioAdmin(Ventana v) {
		this.ventana = v;
		
		setBackground(SystemColor.activeCaption);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblElige = new JLabel("Que Quieres Gestionar");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		lblElige.setFont(new Font("Hack Nerd Font", Font.BOLD, 25));
		gbc_lblNewLabel.gridwidth = 11;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		add(lblElige, gbc_lblNewLabel);
		
		Boton btnZona = new Boton("Zona");
		btnZona.setPreferredSize(new Dimension(125, 35));
		btnZona.setFont(new Font("Hack Nerd Font", Font.BOLD, 15));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridheight = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 1;
		add(btnZona, gbc_btnNewButton);
		
		Boton btnMesa = new Boton("Mesa");
		btnMesa.setPreferredSize(new Dimension(125, 35));
		btnMesa.setFont(new Font("Hack Nerd Font", Font.BOLD, 15));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridheight = 2;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 11;
		gbc_btnNewButton_1.gridy = 1;
		add(btnMesa, gbc_btnNewButton_1);
		
		Boton btnProducto = new Boton("Producto");
		btnProducto.setPreferredSize(new Dimension(125, 35));
		btnProducto.setFont(new Font("Hack Nerd Font", Font.BOLD, 15));
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 6;
		gbc_btnNewButton_4.gridy = 4;
		add(btnProducto, gbc_btnNewButton_4);
		
		Boton btnAlergeno = new Boton("Alergeno");
		btnAlergeno.setPreferredSize(new Dimension(125, 35));
		btnAlergeno.setFont(new Font("Hack Nerd Font", Font.BOLD, 15));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.gridheight = 2;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 6;
		add(btnAlergeno, gbc_btnNewButton_2);
		
		Boton btnEmpleado = new Boton("Empleado");
		btnEmpleado.setPreferredSize(new Dimension(125, 35));
		btnEmpleado.setFont(new Font("Hack Nerd Font", Font.BOLD, 15));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.gridheight = 2;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 11;
		gbc_btnNewButton_3.gridy = 6;
		add(btnEmpleado, gbc_btnNewButton_3);
		
		BotonRojo btnSalir = new BotonRojo("Cerrar Sesion");
		GridBagConstraints gbc_btnNewButton1 = new GridBagConstraints();
		gbc_btnNewButton1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton1.gridx = 11;
		gbc_btnNewButton1.gridy = 9;
		add(btnSalir, gbc_btnNewButton1);
		
		//Acciones
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("Login");
			}
		});
		
		btnZona.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("GestionaZona");
			}
		});
		
		btnMesa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("GestionaMesa");
			}
		});
		
		btnProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("GestionaProducto");
			}
		});
		
		btnEmpleado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("GestionaEmpleado");
			}
		});
		
		btnAlergeno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("GestionaAlergeno");
			}
		});
	}
}
