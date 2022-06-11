package pantallas;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import clases.Carta;
import clases.LineaDePedido;
import clases.Mesa;
import clases.Producto;
import clases.Zona;
import elementosVisuales.Boton;
import elementosVisuales.BotonRojo;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;

import enums.TipoProducto;
import javax.swing.AbstractListModel;
import javax.swing.JTextField;

public class AnadirProducto extends JPanel{
	private Ventana ventana;
	private Zona zona;
	private Mesa mesa;
	private Carta carta;
	private ArrayList<Producto> cartaDeTipo;
	private JTextField textFieldCantidad;
	
	public AnadirProducto(Ventana v,Zona z, Mesa m) {
		this.ventana = v;
		this.zona = z;
		this.mesa = m;
		this.carta = v.restaurante.getCarta();
		
		cartaDeTipo = new ArrayList<>(carta.getProductos());
		
		setBackground(SystemColor.activeCaption);
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		DefaultListCellRenderer renderer = new DefaultListCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblAnadirProducto = new JLabel("Anadir Producto");
		GridBagConstraints gbc_lblAnadirProducto = new GridBagConstraints();
		gbc_lblAnadirProducto.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnadirProducto.gridx = 6;
		gbc_lblAnadirProducto.gridy = 1;
		lblAnadirProducto.setFont(new Font("Hack Nerd Font", Font.BOLD, 30));
		add(lblAnadirProducto, gbc_lblAnadirProducto);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Hack Nerd Font", Font.ITALIC, 20));
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoria.gridx = 6;
		gbc_lblCategoria.gridy = 2;
		add(lblCategoria, gbc_lblCategoria);
		
		final JComboBox comboBoxTipo = new JComboBox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(TipoProducto.values()));
		comboBoxTipo.setRenderer(renderer);
		GridBagConstraints gbc_comboBoxTipo = new GridBagConstraints();
		gbc_comboBoxTipo.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxTipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxTipo.gridx = 6;
		gbc_comboBoxTipo.gridy = 3;
		add(comboBoxTipo, gbc_comboBoxTipo);
		
		Boton btnAceptar = new Boton("Aceptar");
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 8;
		gbc_btnAceptar.gridy = 3;
		add(btnAceptar, gbc_btnAceptar);
		
		JScrollPane scrollPane = new JScrollPane();
		
		final JList listaProductos = new JList();
		listaProductos.setModel(new AbstractListModel() {
			public int getSize() {
				return cartaDeTipo.size();
			}

			public Object getElementAt(int index) {
				return cartaDeTipo.get(index);
			}
		});
		scrollPane.setViewportView(listaProductos);
		listaProductos.setCellRenderer(renderer);
		
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.gridheight = 10;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 6;
		gbc_scrollPane.gridy = 5;
		add(scrollPane, gbc_scrollPane);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		GridBagConstraints gbc_lblCantidad = new GridBagConstraints();
		lblCantidad.setFont(new Font("Hack Nerd Font", Font.ITALIC, 15));
		gbc_lblCantidad.gridwidth = 2;
		gbc_lblCantidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCantidad.gridx = 10;
		gbc_lblCantidad.gridy = 6;
		add(lblCantidad, gbc_lblCantidad);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setFont(new Font("Hack Nerd Font", Font.BOLD, 10));
		GridBagConstraints gbc_textFieldCantidad = new GridBagConstraints();
		gbc_textFieldCantidad.gridwidth = 2;
		gbc_textFieldCantidad.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCantidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCantidad.gridx = 10;
		gbc_textFieldCantidad.gridy = 7;
		add(textFieldCantidad, gbc_textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		Boton btnAnadir = new Boton("Anadir");
		GridBagConstraints gbc_btnAnadir = new GridBagConstraints();
		gbc_btnAnadir.gridwidth = 2;
		gbc_btnAnadir.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnadir.gridx = 10;
		gbc_btnAnadir.gridy = 10;
		add(btnAnadir, gbc_btnAnadir);
		
		BotonRojo btnAtras = new BotonRojo("Atras");
		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.insets = new Insets(0, 0, 0, 5);
		gbc_btnAtras.gridx = 11;
		gbc_btnAtras.gridy = 15;
		add(btnAtras, gbc_btnAtras);
		
		
		//Acciones
		
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("GestionMesa", zona, mesa);
			}
		});
		
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(comboBoxTipo.getSelectedItem());
				boolean primeraVez=false;
				for(int i = 0; i<carta.getProductos().size(); i++) {
					if(carta.getProductos().get(i).getTipoProducto().equals(comboBoxTipo.getSelectedItem())) {
						if(primeraVez==false) {
							cartaDeTipo.clear();
							primeraVez=true;
						}
						cartaDeTipo.add(carta.getProductos().get(i));
					}
				}
				listaProductos.repaint();
			}
		});
		
		btnAnadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ArrayList<LineaDePedido> nuevaCuenta = new ArrayList<>(mesa.getCuenta());
					short cantidad = (short)Integer.parseInt(textFieldCantidad.getText());
					nuevaCuenta.add(new LineaDePedido((Producto) listaProductos.getSelectedValue(), cantidad));
					mesa.setCuenta(nuevaCuenta);
					JOptionPane.showMessageDialog(ventana, "Insertado Correctamente", "Todo Correcto", JOptionPane.INFORMATION_MESSAGE);
				}catch(java.lang.NumberFormatException e2) {
					JOptionPane.showMessageDialog(ventana, "La cantidad es 0 o demasiado grande", "ERROR en Cantidad", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
	}

}
