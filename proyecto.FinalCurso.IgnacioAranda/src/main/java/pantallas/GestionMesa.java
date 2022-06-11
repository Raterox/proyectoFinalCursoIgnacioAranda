package pantallas;

import java.awt.SystemColor;

import javax.swing.JPanel;

import clases.LineaDePedido;
import clases.Mesa;
import clases.Producto;
import clases.Zona;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import elementosVisuales.Boton;
import elementosVisuales.BotonRojo;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GestionMesa extends JPanel {
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

		JLabel lblMesa = new JLabel("Zona " + this.zona + " || Mesa: " + this.mesa);
		lblMesa.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblMesa, BorderLayout.NORTH);
		lblMesa.setFont(new Font("Hack Nerd Font", Font.BOLD, 30));

		final Boton btnEliminar = new Boton("Eliminar");
		add(btnEliminar, BorderLayout.WEST);
		btnEliminar.setPreferredSize(new Dimension(100, 100));

		final Boton btnAnadir = new Boton("Anadir");
		add(btnAnadir, BorderLayout.EAST);
		btnAnadir.setPreferredSize(new Dimension(100, 100));

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

		final BotonRojo btnAtras = new BotonRojo("Atras");
		add(btnAtras, BorderLayout.SOUTH);

		// Acciones
		btnAtras.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("Inicio");
			}
		});

		btnEliminar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				LineaDePedido seleccionada = (LineaDePedido) listaProductos.getSelectedValue();
				cuenta.remove(seleccionada);
				JOptionPane.showMessageDialog(ventana, "Linea de Pedido eliminada", "Eliminado Con Exito", JOptionPane.INFORMATION_MESSAGE);
				listaProductos.repaint();
			}
		});

		btnAnadir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("AnadirProducto", zona, mesa);
				System.out.println("He estado aqui");
			}
		});
	}

}
