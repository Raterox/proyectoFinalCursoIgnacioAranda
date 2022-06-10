package pantallas;

import java.awt.SystemColor;

import javax.swing.JPanel;

import clases.LineaDePedido;
import clases.Mesa;
import clases.Zona;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import elementosVisuales.Boton;
import elementosVisuales.BotonSalir;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GestionMesa extends JPanel{
	private Ventana ventana;
	private Mesa mesa;
	private Zona zona;
	public GestionMesa(Ventana v, Zona z, Mesa m) {
		this.ventana = v;
		this.mesa = m;
		this.zona = z;
		
		setBackground(SystemColor.activeCaption);
		setLayout(new BorderLayout(0, 0));
		
		DefaultListCellRenderer renderer = new DefaultListCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblMesa = new JLabel("Zona " + this.zona + " || Mesa: " + this.mesa );
		lblMesa.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblMesa, BorderLayout.NORTH);
		lblMesa.setFont(new Font("Hack Nerd Font", Font.BOLD, 30));
		
		Boton btnEliminar = new Boton("Eliminar");
		add(btnEliminar, BorderLayout.WEST);
		btnEliminar.setPreferredSize(new Dimension(100,100));
		
		Boton btnAnadir = new Boton("Anadir");
		add(btnAnadir, BorderLayout.EAST);
		btnAnadir.setPreferredSize(new Dimension(100,100));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		final JList listaProductos = new JList();
		final ArrayList<LineaDePedido> cuenta = mesa.getCuenta();
		listaProductos.setModel(new AbstractListModel() {
			public int getSize() {
				return cuenta.size();
			}

			public Object getElementAt(int index) {
				return cuenta.get(index);
			}
		});
		scrollPane.setViewportView(listaProductos);
		listaProductos.setCellRenderer(renderer);
		
		BotonSalir btnNewButton = new BotonSalir("Atras");
		
		
		//Acciones
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventana.cambiarAPantalla("Inicio");
			}
		});
		add(btnNewButton, BorderLayout.SOUTH);
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	}

}
