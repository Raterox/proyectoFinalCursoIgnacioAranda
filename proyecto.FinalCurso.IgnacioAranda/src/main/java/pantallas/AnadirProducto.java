package pantallas;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import clases.Carta;
import clases.Mesa;
import clases.Zona;
import elementosVisuales.Boton;
import elementosVisuales.BotonRojo;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import enums.TipoProducto;

public class AnadirProducto extends JPanel{
	private Ventana ventana;
	private Zona zona;
	private Mesa mesa;
	private Carta carta;
	
	public AnadirProducto(Ventana v,Zona z, Mesa m) {
		this.ventana = v;
		this.zona = z;
		this.mesa = m;
		this.carta = v.restaurante.getCarta();
		
		setBackground(SystemColor.activeCaption);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblAnadirProducto = new JLabel("Anadir Producto");
		GridBagConstraints gbc_lblAnadirProducto = new GridBagConstraints();
		gbc_lblAnadirProducto.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnadirProducto.gridx = 6;
		gbc_lblAnadirProducto.gridy = 1;
		lblAnadirProducto.setFont(new Font("Hack Nerd Font", Font.BOLD, 30));
		add(lblAnadirProducto, gbc_lblAnadirProducto);
		
		JList listaProductos = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 11;
		gbc_list.gridwidth = 5;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 2;
		add(listaProductos, gbc_list);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Hack Nerd Font", Font.BOLD, 30));
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoria.gridx = 6;
		gbc_lblCategoria.gridy = 2;
		add(lblCategoria, gbc_lblCategoria);
		
		JComboBox comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setModel(new DefaultComboBoxModel(TipoProducto.values()));
		GridBagConstraints gbc_comboBoxCategoria = new GridBagConstraints();
		gbc_comboBoxCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxCategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxCategoria.gridx = 6;
		gbc_comboBoxCategoria.gridy = 3;
		add(comboBoxCategoria, gbc_comboBoxCategoria);
		
		Boton btnAnadir = new Boton("Anadir");
		GridBagConstraints gbc_btnAnadir = new GridBagConstraints();
		gbc_btnAnadir.gridheight = 8;
		gbc_btnAnadir.gridwidth = 3;
		gbc_btnAnadir.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnadir.gridx = 8;
		gbc_btnAnadir.gridy = 3;
		add(btnAnadir, gbc_btnAnadir);
		
		BotonRojo btnAtras = new BotonRojo("Atras");
		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.insets = new Insets(0, 0, 0, 5);
		gbc_btnAtras.gridx = 11;
		gbc_btnAtras.gridy = 14;
		add(btnAtras, gbc_btnAtras);
		
		
		//Acciones
		
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("GestionMesa", zona, mesa);
			}
		});
	}

}
