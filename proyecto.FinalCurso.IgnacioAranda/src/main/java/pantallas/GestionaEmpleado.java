package pantallas;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import clases.Alergeno;
import clases.Empleado;
import clases.Producto;
import elementosVisuales.Boton;
import elementosVisuales.BotonRojo;
import enums.Alcoholica;
import enums.TipoProducto;
import exception.NombreVacioException;
import exception.PuestoVacioException;
import exception.SueldoVacioException;
import enums.Puesto;

public class GestionaEmpleado extends JPanel {
	private Ventana ventana;
	private JTextField textFieldNombre;
	private JTextField textFieldContrasena;
	private JTextField textField;
	private JTextField textField_1;

	public GestionaEmpleado(Ventana v) {
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

		JLabel lblSueldo = new JLabel("Sueldo");
		lblSueldo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSueldo.setFont(new Font("Hack Nerd Font", Font.ITALIC, 15));
		lblSueldo.setBounds(27, 198, 165, 14);
		add(lblSueldo);

		JLabel lblPuesto = new JLabel("Puesto");
		lblPuesto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuesto.setFont(new Font("Hack Nerd Font", Font.ITALIC, 15));
		lblPuesto.setBounds(27, 256, 165, 14);
		add(lblPuesto);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellido.setFont(new Font("Hack Nerd Font", Font.ITALIC, 15));
		lblApellido.setBounds(27, 140, 165, 14);
		add(lblApellido);

		Boton btnEliminar = new Boton("Despedir");
		btnEliminar.setBounds(443, 366, 220, 23);
		add(btnEliminar);

		BotonRojo btnAtras = new BotonRojo("Atras");
		btnAtras.setBounds(574, 401, 89, 23);
		add(btnAtras);

		Boton btnAnadir = new Boton("Contratar");
		btnAnadir.setBounds(224, 195, 134, 23);
		add(btnAnadir);

		Boton btnActualizar = new Boton("Actualizar");
		btnActualizar.setBounds(224, 253, 134, 23);
		add(btnActualizar);

		textFieldNombre = new JTextField();
		textFieldNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNombre.setBounds(27, 109, 165, 20);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textFieldContrasena = new JTextField();
		textFieldContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldContrasena.setColumns(10);
		textFieldContrasena.setBounds(27, 165, 165, 20);
		add(textFieldContrasena);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(443, 84, 220, 271);
		add(scrollPane);

		final JList listEmpleados = new JList();
		final ArrayList<Empleado> empleados = ventana.restaurante.getEmpleados();
		listEmpleados.setModel(new AbstractListModel() {
			public int getSize() {
				return empleados.size();
			}

			public Object getElementAt(int index) {
				return empleados.get(index);
			}
		});
		listEmpleados.setBounds(433, 70, 230, 285);
		scrollPane.setViewportView(listEmpleados);

		final JComboBox comboBoxPuesto = new JComboBox();
		comboBoxPuesto.setModel(new DefaultComboBoxModel(Puesto.values()));
		comboBoxPuesto.setBounds(27, 281, 165, 22);
		add(comboBoxPuesto);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(27, 339, 165, 20);
		add(textField);
		
		JLabel lblContrasena = new JLabel("Contrasena");
		lblContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasena.setFont(new Font("Hack Nerd Font", Font.ITALIC, 15));
		lblContrasena.setBounds(27, 314, 165, 14);
		add(lblContrasena);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(27, 225, 165, 20);
		add(textField_1);

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
					float precio = (float) Integer.parseInt(textFieldContrasena.getText());
					TipoProducto tipo = (TipoProducto) comboBoxPuesto.getSelectedItem();
					Alcoholica alcoholica = (Alcoholica) comboBoxAlcoholico.getSelectedItem();
					ArrayList<Alergeno> alergenos = new ArrayList<Alergeno>();
					alergenos.add((Alergeno) comboBoxAlergeno.getSelectedItem());
					Producto productoNuevo;
					ArrayList<Producto> productosNuevos = ventana.restaurante.getCarta().getProductos();
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
				} catch (SueldoVacioException e1) {
					JOptionPane.showMessageDialog(ventana, "Campo Sueldo Cero", "Error al Anadir",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (PuestoVacioException e1) {
					e1.printStackTrace();
				} catch (java.lang.NumberFormatException e1) {
					JOptionPane.showMessageDialog(ventana, "Campo Sueldo Vacio", "Error al Anadir",
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
					float precio = (float) Integer.parseInt(textFieldContrasena.getText());
					TipoProducto tipo = (TipoProducto) comboBoxPuesto.getSelectedItem();
					Alcoholica alcoholica = (Alcoholica) comboBoxAlcoholico.getSelectedItem();
					ArrayList<Alergeno> alergenos = new ArrayList<Alergeno>();
					alergenos.add((Alergeno) comboBoxAlergeno.getSelectedItem());
					Producto productoNuevo;
					ArrayList<Producto> productosNuevos = ventana.restaurante.getCarta().getProductos();

					Producto productoSeleccionada = (Producto) listProductos.getSelectedValue();
					for (int i = 0; i < ventana.restaurante.getCarta().getProductos().size(); i++) {
						if (ventana.restaurante.getCarta().getProductos().get(i).getNombre() == productoSeleccionada
								.getNombre()) {
							ventana.restaurante.getCarta().getProductos().get(i).setNombre(nombre);
							ventana.restaurante.getCarta().getProductos().get(i).setSueldo(precio);
							ventana.restaurante.getCarta().getProductos().get(i).setAlergenos(alergenos);
							ventana.restaurante.getCarta().getProductos().get(i).setTipoProducto(tipo);
							ventana.restaurante.getCarta().getProductos().get(i).setAlcoholica(alcoholica);
							ventana.restaurante.getCarta().setProductos(productosNuevos);
							JOptionPane.showMessageDialog(ventana, "Producto Anadido", "Producto Actualizada",
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
				} catch (SueldoCeroException e1) {
					JOptionPane.showMessageDialog(ventana, "Campo Sueldo Cero", "Error al Anadir",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (PuestoVacioException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (java.lang.NumberFormatException e1) {
					JOptionPane.showMessageDialog(ventana, "Campo Sueldo Vacio", "Error al Anadir",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

			}
		});

	}
}
