package pantallas;

import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.ListModel;

import elementosVisuales.Boton;
import elementosVisuales.BotonSalir;

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

import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;

import java.awt.Component;
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
		mesas = new ArrayList<Mesa>();
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
		final String[] valores2 = new String[cuenta.size()];
		for(int i = 0; i<valores2.length; i++) {
			valores2[i] = cuenta.get(i).toString();
		}
		listaProductos.setModel(new AbstractListModel() {
			String [] values = valores2;
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		listaProductos.setCellRenderer(renderer);
		listaProductos.setEnabled(false);
		JScrollPane listaProductosScroll = new JScrollPane(listaProductos);
		panelProductos.add(listaProductosScroll, BorderLayout.CENTER);

		BotonSalir btnBotonSalir = new BotonSalir("Salir");
		btnBotonSalir.setBounds(599, 410, 69, 23);
		add(btnBotonSalir);

		Boton btnGestionar = new Boton("Gestionar");
		btnGestionar.setBounds(10, 336, 89, 23);
		add(btnGestionar);

		Boton btnImprimirTicket = new Boton("Imprimir Ticket");
		btnImprimirTicket.setBounds(120, 336, 199, 23);
		add(btnImprimirTicket);

		Boton btnEliminar = new Boton("Eliminar");
		btnEliminar.setBounds(340, 336, 89, 23);
		add(btnEliminar);

		// Acciones

		listaZonas.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					zonaSeleccionada = (Zona) listaZonas.getSelectedValue();
					System.out.println("Fuera del bucle");
					short numMesas = (short) zonaSeleccionada.getMesas().size();
					mesas.clear();
					System.out.println(numMesas);
					for(int i = 0; i<zonaSeleccionada.getMesas().size(); i++) {
						System.out.println("Dentro del bucle");
						mesas.add(zonaSeleccionada.getMesas().get(i));
						System.out.println(zonaSeleccionada.getMesas().get(i));
					}
					listaMesas.repaint();
					listaMesasScroll.repaint();
				}
			}
		});
		
		listaMesas.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					mesaSeleccionada = (Mesa) listaMesas.getSelectedValue();
					cuenta.clear();
					for(short i = 0; i<mesaSeleccionada.getCuenta().size(); i++) {
						cuenta.add(mesaSeleccionada.getCuenta().get(i));
					}
					listaProductos.repaint();
				}
			}
		});
		
		btnImprimirTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					mesaSeleccionada.imprimirTodosCuenta();
					JOptionPane.showMessageDialog(ventana, "Ya se ha impreso la cuenta de la mesa " + mesaSeleccionada.getNumero(),
							"Impresion Finalizada", JOptionPane.PLAIN_MESSAGE);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
