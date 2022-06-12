package pantallas;

import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JPanel;

import clases.Alergeno;
import clases.Producto;
import elementosVisuales.Boton;
import elementosVisuales.BotonRojo;
import exception.AlergenoDuplicadoException;
import exception.NombreVacioException;
import exception.PrecioCeroException;
import exception.ProductoDuplicadoException;
import exception.PuestoVacioException;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import enums.TipoProducto;
import enums.Alcoholica;

public class GestionaProducto extends JPanel {
	private Ventana ventana;
	private JTextField textFieldNombre;
	private JTextField textFieldPrecio;

	public GestionaProducto(Ventana v) {
		this.ventana = v;

		setBackground(SystemColor.activeCaption);
		setLayout(null);

		DefaultListCellRenderer renderer = new DefaultListCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblGestion = new JLabel("Gestion De Productos");
		lblGestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestion.setFont(new Font("Hack Nerd Font", Font.BOLD, 30));
		lblGestion.setBounds(55, 11, 611, 48);
		add(lblGestion);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Hack Nerd Font", Font.ITALIC, 15));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(27, 84, 165, 14);
		add(lblNombre);

		JLabel lblAlergeno = new JLabel("Alergeno");
		lblAlergeno.setFont(new Font("Hack Nerd Font", Font.ITALIC, 15));
		lblAlergeno.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlergeno.setBounds(27, 140, 165, 14);
		add(lblAlergeno);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setFont(new Font("Hack Nerd Font", Font.ITALIC, 15));
		lblTipo.setBounds(27, 198, 165, 14);
		add(lblTipo);

		JLabel lblAlcoholico = new JLabel("Alcoholico");
		lblAlcoholico.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlcoholico.setFont(new Font("Hack Nerd Font", Font.ITALIC, 15));
		lblAlcoholico.setBounds(27, 256, 165, 14);
		add(lblAlcoholico);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setFont(new Font("Hack Nerd Font", Font.ITALIC, 15));
		lblPrecio.setBounds(27, 314, 165, 14);
		add(lblPrecio);

		Boton btnEliminar = new Boton("Eliminar");
		btnEliminar.setBounds(443, 366, 220, 23);
		add(btnEliminar);

		BotonRojo btnAtras = new BotonRojo("Atras");
		btnAtras.setBounds(574, 401, 89, 23);
		add(btnAtras);

		Boton btnAnadir = new Boton("Anadir");
		btnAnadir.setBounds(224, 223, 134, 23);
		add(btnAnadir);

		Boton btnActualizar = new Boton("Actualizar");
		btnActualizar.setBounds(224, 281, 134, 23);
		add(btnActualizar);

		Boton btnCambiarNombre = new Boton("Cambiar Nombre");
		btnCambiarNombre.setBounds(224, 165, 134, 23);
		add(btnCambiarNombre);

		textFieldNombre = new JTextField();
		textFieldNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNombre.setBounds(27, 109, 165, 20);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textFieldPrecio = new JTextField();
		textFieldPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPrecio.setColumns(10);
		textFieldPrecio.setBounds(27, 339, 165, 20);
		add(textFieldPrecio);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(443, 84, 220, 271);
		add(scrollPane);

		final JList listProductos = new JList();
		final ArrayList<Producto> productos = ventana.restaurante.getCarta().getProductos();
		listProductos.setModel(new AbstractListModel() {
			public int getSize() {
				return productos.size();
			}

			public Object getElementAt(int index) {
				return productos.get(index);
			}
		});
		listProductos.setBounds(433, 70, 230, 285);
		scrollPane.setViewportView(listProductos);

		final JComboBox comboBoxAlergeno = new JComboBox();
		comboBoxAlergeno.setModel(new DefaultComboBoxModel(ventana.getTodosAlergenos().toArray()));
		comboBoxAlergeno.setBounds(27, 165, 165, 22);
		add(comboBoxAlergeno);

		final JComboBox comboBoxTipo = new JComboBox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(TipoProducto.values()));
		comboBoxTipo.setBounds(27, 223, 165, 22);
		add(comboBoxTipo);

		final JComboBox comboBoxAlcoholico = new JComboBox();
		comboBoxAlcoholico.setModel(new DefaultComboBoxModel(Alcoholica.values()));
		comboBoxAlcoholico.setBounds(27, 281, 165, 22);
		add(comboBoxAlcoholico);

		// Acciones

		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("InicioAdmin");
			}
		});

		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Producto productoSeleccionado;
				try {
					productoSeleccionado = (Producto) listProductos.getSelectedValue();
					for (int i = 0; i < ventana.restaurante.getCarta().getProductos().size(); i++) {
						if (ventana.restaurante.getCarta().getProductos().get(i).getNombre() == productoSeleccionado
								.getNombre()) {
							ventana.restaurante.getCarta().getProductos().remove(i);
						}
					}
					listProductos.repaint();
				} catch (java.lang.NullPointerException e1) {
					JOptionPane.showMessageDialog(ventana, "Tienes que seleccionar un Producto", "Error al Eliminar",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		btnAnadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String nombre = textFieldNombre.getText();
					float precio = (float) Integer.parseInt(textFieldPrecio.getText());
					TipoProducto tipo = (TipoProducto) comboBoxTipo.getSelectedItem();
					Alcoholica alcoholica = (Alcoholica) comboBoxAlcoholico.getSelectedItem();
					ArrayList<Alergeno> alergenos = new ArrayList<Alergeno>();
					alergenos.add((Alergeno) comboBoxAlergeno.getSelectedItem());
					Producto productoNuevo;
					ArrayList<Producto> productosNuevos = ventana.restaurante.getCarta().getProductos();
					for(int i = 0; i < ventana.restaurante.getCarta().getProductos().size(); i++) {
						if(ventana.restaurante.getCarta().getProductos().get(i).getNombre().equals(nombre)) {
							throw new ProductoDuplicadoException("Producto ya existe");
						}
					}
					productoNuevo = new Producto(nombre, precio, alergenos, tipo, alcoholica);
					productosNuevos.add(productoNuevo);					
					ventana.restaurante.getCarta().setProductos(productosNuevos);
					listProductos.repaint();
					JOptionPane.showMessageDialog(ventana,
							"Producto Anadido, si no lo visualiza, entre y salga de la pantalla", "Producto Anadido",
							JOptionPane.PLAIN_MESSAGE);
				} catch (NombreVacioException e1) {
					JOptionPane.showMessageDialog(ventana, "Campo Nombre Vacio", "Error al Anadir",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (PrecioCeroException e1) {
					JOptionPane.showMessageDialog(ventana, "Campo Precio Cero", "Error al Anadir",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (PuestoVacioException e1) {
					e1.printStackTrace();
				} catch (java.lang.NumberFormatException e1) {
					JOptionPane.showMessageDialog(ventana, "Campo Precio Vacio", "Error al Anadir",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (ProductoDuplicadoException e1) {
					JOptionPane.showMessageDialog(ventana, "El producto ya existe", "Error al Anadir",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});

		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String nombre = textFieldNombre.getText();
					float precio = (float) Integer.parseInt(textFieldPrecio.getText());
					TipoProducto tipo = (TipoProducto) comboBoxTipo.getSelectedItem();
					Alcoholica alcoholica = (Alcoholica) comboBoxAlcoholico.getSelectedItem();
					ArrayList<Alergeno> alergenos = new ArrayList<Alergeno>();
					alergenos.add((Alergeno) comboBoxAlergeno.getSelectedItem());

					Producto productoSeleccionada = (Producto) listProductos.getSelectedValue();
					
					for(int i = 0; i < ventana.restaurante.getCarta().getProductos().size(); i++) {
						if(ventana.restaurante.getCarta().getProductos().get(i).getNombre().equals(nombre)) {
							throw new ProductoDuplicadoException("Producto ya existe");
						}
					}
					for (int i = 0; i < ventana.restaurante.getCarta().getProductos().size(); i++) {

						if (ventana.restaurante.getCarta().getProductos().get(i).getNombre().equals(productoSeleccionada
								.getNombre())) {
							ventana.restaurante.getCarta().getProductos().get(i).setNombre(nombre);
							ventana.restaurante.getCarta().getProductos().get(i).setPrecio(precio);
							ventana.restaurante.getCarta().getProductos().get(i).setAlergenos(alergenos);
							ventana.restaurante.getCarta().getProductos().get(i).setTipoProducto(tipo);
							ventana.restaurante.getCarta().getProductos().get(i).setAlcoholica(alcoholica);
							JOptionPane.showMessageDialog(ventana, "Producto Actualizado", "Producto Actualizado",
									JOptionPane.PLAIN_MESSAGE);
						}
					}
					listProductos.repaint();
				} catch (java.lang.NullPointerException e1) {
					JOptionPane.showMessageDialog(ventana, "Tienes que seleccionar un producto", "Error al Anadir",
							JOptionPane.ERROR_MESSAGE);
				} catch (NombreVacioException e1) {
					JOptionPane.showMessageDialog(ventana, "Campo Nombre Vacio", "Error al Anadir",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (PrecioCeroException e1) {
					JOptionPane.showMessageDialog(ventana, "Campo Precio Cero", "Error al Anadir",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (PuestoVacioException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (java.lang.NumberFormatException e1) {
					JOptionPane.showMessageDialog(ventana, "Campo Precio Vacio", "Error al Anadir",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (ProductoDuplicadoException e1) {
					JOptionPane.showMessageDialog(ventana, "El producto ya existe", "Error al Anadir",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

			}
		});

		btnCambiarNombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String nombre = textFieldNombre.getText();
					Producto productoSeleccionada = (Producto) listProductos.getSelectedValue();
					
					for(int i = 0; i < ventana.restaurante.getCarta().getProductos().size(); i++) {
						if(ventana.restaurante.getCarta().getProductos().get(i).getNombre().equals(nombre)) {
							throw new ProductoDuplicadoException("Producto ya existe");
						}
					}
					
					for (int i = 0; i < ventana.restaurante.getCarta().getProductos().size(); i++) {
						if (ventana.restaurante.getCarta().getProductos().get(i).getNombre() == productoSeleccionada
								.getNombre()) {
							ventana.restaurante.getCarta().getProductos().get(i).setNombre(nombre);
							JOptionPane.showMessageDialog(ventana, "Nombre Cambiado", "Producto Actualizada",
									JOptionPane.PLAIN_MESSAGE);
						}
					}
					listProductos.repaint();
				} catch (java.lang.NullPointerException e1) {
					JOptionPane.showMessageDialog(ventana, "Tienes que seleccionar un producto", "Error al Anadir",
							JOptionPane.ERROR_MESSAGE);
				} catch (NombreVacioException e1) {
					JOptionPane.showMessageDialog(ventana, "Campo Nombre Vacio", "Error al Anadir",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (ProductoDuplicadoException e1) {
					JOptionPane.showMessageDialog(ventana, "El producto ya existe", "Error al Anadir",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});

	}
}
