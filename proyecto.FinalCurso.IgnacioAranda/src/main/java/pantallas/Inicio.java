package pantallas;

import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.ListModel;

import elementosVisuales.Boton;
import elementosVisuales.BotonRojo;

import java.awt.GridBagLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import clases.LineaDePedido;
import clases.Mesa;
import clases.Zona;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;

import java.awt.Component;
import java.awt.Cursor;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.AbstractListModel;

public class Inicio extends JPanel {
	private Ventana ventana;
	private Zona zonaSeleccionada;
	private Mesa mesaSeleccionada;
	private ArrayList<Mesa> mesas;
	private ArrayList<Zona> zonas;
	private ArrayList<LineaDePedido> cuenta;

	public Inicio(Ventana v) {
		this.ventana = v;
		zonaSeleccionada = ventana.restaurante.getZonas().get(0);
		mesaSeleccionada = zonaSeleccionada.getMesas().get(0);
		mesas = zonaSeleccionada.getMesas();
		zonas = new ArrayList<Zona>();

		setBackground(SystemColor.activeCaption);
		setLayout(null);

		DefaultListCellRenderer renderer = new DefaultListCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);

		final JList listaZonas = new JList();
		zonas = ventana.restaurante.getZonas();
		listaZonas.setModel(new AbstractListModel() {
			public int getSize() {
				return zonas.size();
			}

			public Object getElementAt(int index) {
				return zonas.get(index);
			}
		});

		JScrollPane listaZonasScroll = new JScrollPane(listaZonas);
		listaZonas.setCellRenderer(renderer);
		listaZonasScroll.setBounds(352, 47, 139, 250);
		listaZonasScroll.setFont(new Font("Hack Nerd Font", Font.BOLD, 10));
		add(listaZonasScroll);

		JLabel lblZonas = new JLabel("Zonas");
		lblZonas.setFont(new Font("Hack Nerd Font", Font.BOLD, 15));
		lblZonas.setHorizontalAlignment(SwingConstants.CENTER);
		lblZonas.setBounds(397, 21, 46, 14);
		add(lblZonas);

		final JList listaMesas = new JList();
		mesas = zonaSeleccionada.getMesas();
		listaMesas.setModel(new AbstractListModel() {
			public int getSize() {
				return mesas.size();
			}

			public Object getElementAt(int index) {
				return mesas.get(index);
			}
		});

		final JScrollPane listaMesasScroll = new JScrollPane(listaMesas);
		listaMesas.setCellRenderer(renderer);
		listaMesasScroll.setBounds(501, 46, 131, 250);
		listaMesasScroll.setFont(new Font("Hack Nerd Font", Font.BOLD, 10));
		add(listaMesasScroll);

		JLabel lblMesas = new JLabel("Mesas");
		lblMesas.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesas.setFont(new Font("Hack Nerd Font", Font.BOLD, 15));
		lblMesas.setBounds(540, 21, 46, 14);
		add(lblMesas);

		JPanel panelProductos = new JPanel();
		panelProductos.setBounds(10, 47, 332, 250);
		add(panelProductos);
		panelProductos.setLayout(new BorderLayout(0, 0));

		JLabel lblProductos = new JLabel("Productos");
		lblProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductos.setFont(new Font("Hack Nerd Font", Font.BOLD, 15));
		lblProductos.setAlignmentY(0.0f);
		lblProductos.setAlignmentX(0.5f);
		panelProductos.add(lblProductos, BorderLayout.NORTH);

		final JList listaProductos = new JList();
		cuenta = mesaSeleccionada.getCuenta();
		listaProductos.setModel(new AbstractListModel() {
			public int getSize() {
				return cuenta.size();
			}

			public Object getElementAt(int index) {
				return cuenta.get(index);
			}
		});

		listaProductos.setEnabled(false);
		final JScrollPane listaProductosScroll = new JScrollPane(listaProductos);
		listaProductos.setCellRenderer(renderer);
		panelProductos.add(listaProductosScroll, BorderLayout.CENTER);

		final Boton btnGestionar = new Boton("Gestionar");
		btnGestionar.setBounds(69, 336, 199, 23);
		add(btnGestionar);

		final Boton btnImprimirTicket = new Boton("Imprimir Ticket");
		btnImprimirTicket.setBounds(350, 336, 199, 23);
		add(btnImprimirTicket);
		
		final BotonRojo btnAtras = new BotonRojo("Cerrar Sesion");
		btnAtras.setBounds(540, 410, 128, 23);
		btnAtras.setFont(new Font("Hack Nerd Font", Font.BOLD, 10));
		btnAtras.setBackground(new Color(255, 0, 0));
		btnAtras.setForeground(new Color(255, 158, 129));
		btnAtras.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnAtras);

		// Acciones
		btnAtras.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("Login");
			}
		});

		listaZonas.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {
					zonaSeleccionada = (Zona) listaZonas.getSelectedValue();
					mesas = zonaSeleccionada.getMesas();
					listaMesas.repaint();
				}catch(java.lang.NullPointerException e1) {
					JOptionPane.showMessageDialog(ventana,
							"No hay seleccionada ninguna Zona","Error Seleccion Zona", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		listaMesas.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {
					zonaSeleccionada = (Zona) listaZonas.getSelectedValue();
					mesas = zonaSeleccionada.getMesas();
					cuenta = ((Mesa) listaMesas.getSelectedValue()).getCuenta();
					listaProductos.repaint();
				}catch(java.lang.NullPointerException e1) {
					JOptionPane.showMessageDialog(ventana,
							"No hay seleccionada ninguna Mesaf","Error Seleccion Mesa", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		

		btnImprimirTicket.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				float dineroTotal = ventana.restaurante.getIngresosTotales();
				try {
					zonaSeleccionada.imprimirTodosCuenta(mesaSeleccionada);
					JOptionPane.showMessageDialog(ventana,
							"Impresion de la mesa " + mesaSeleccionada.getNumero() + " finalizada",
							"Impresion Finalizada", JOptionPane.PLAIN_MESSAGE);
					for(int i = 0; i<mesaSeleccionada.getCuenta().size(); i++) {
						dineroTotal +=mesaSeleccionada.getCuenta().get(i).getProducto().getPrecio() * mesaSeleccionada.getCuenta().get(i).getCantidad();
					}
					ventana.restaurante.setIngresosTotales(dineroTotal);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}	
		});
		
		btnGestionar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("GestionMesa", zonaSeleccionada, mesaSeleccionada);
			}
		});
	}
}
