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
import exception.ApellidoVacioException;
import exception.ContrasenaVaciaException;
import exception.EmpleadosDuplicadosException;
import exception.NombreVacioException;
import exception.PuestoVacioException;
import exception.SueldoVacioException;
import enums.Puesto;

public class GestionaEmpleado extends JPanel {
	private Ventana ventana;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldContrasena;
	private JTextField textFieldSueldo;

	public GestionaEmpleado(Ventana v) {
		this.ventana = v;

		setBackground(SystemColor.activeCaption);
		setLayout(null);

		DefaultListCellRenderer renderer = new DefaultListCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblGestion = new JLabel("Gestion De Empleados");
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

		textFieldApellido = new JTextField();
		textFieldApellido.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(27, 165, 165, 20);
		add(textFieldApellido);

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

		textFieldContrasena = new JTextField();
		textFieldContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldContrasena.setColumns(10);
		textFieldContrasena.setBounds(27, 339, 165, 20);
		add(textFieldContrasena);

		JLabel lblContrasena = new JLabel("Contrasena");
		lblContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasena.setFont(new Font("Hack Nerd Font", Font.ITALIC, 15));
		lblContrasena.setBounds(27, 314, 165, 14);
		add(lblContrasena);

		textFieldSueldo = new JTextField();
		textFieldSueldo.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSueldo.setColumns(10);
		textFieldSueldo.setBounds(27, 225, 165, 20);
		add(textFieldSueldo);

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
				Empleado empleadoSeleccionado;
				try {
					empleadoSeleccionado = (Empleado) listEmpleados.getSelectedValue();
					for (int i = 0; i < ventana.restaurante.getEmpleados().size(); i++) {
						if (ventana.restaurante.getEmpleados().get(i).getNombre() == empleadoSeleccionado.getNombre()
								&& ventana.restaurante.getEmpleados().get(i).getApellido() == empleadoSeleccionado
										.getApellido()) {
							ventana.restaurante.getEmpleados().remove(i);
						}
					}
					listEmpleados.repaint();
				} catch (java.lang.NullPointerException e1) {
					JOptionPane.showMessageDialog(ventana, "Tienes que seleccionar un Empleado", "Error al Eliminar",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		btnAnadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String nombre = textFieldNombre.getText();
					String apellido = textFieldApellido.getText();
					float sueldo = Integer.parseInt(textFieldSueldo.getText());
					Puesto tipo = (Puesto) comboBoxPuesto.getSelectedItem();
					String contrasena = textFieldContrasena.getText();
					Empleado empleadoNuevo;
					ArrayList<Empleado> empleadosNuevos = ventana.restaurante.getEmpleados();
					for (int i = 0; i < ventana.restaurante.getEmpleados().size(); i++) {
						if (ventana.restaurante.getEmpleados().get(i).getNombre() == nombre
								&& ventana.restaurante.getEmpleados().get(i).getApellido() == apellido) {
							throw new EmpleadosDuplicadosException("Ese empleado ya existe");
						}
					}
					empleadoNuevo = new Empleado(nombre, apellido, sueldo, tipo, contrasena);
					empleadosNuevos.add(empleadoNuevo);	
					ventana.restaurante.setEmpleados(empleadosNuevos);
					listEmpleados.repaint();
					JOptionPane.showMessageDialog(ventana,
							"Empleado Anadido, si no lo visualiza, entre y salga de la pantalla", "Empleado Anadido",
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
				} catch (ApellidoVacioException e1) {
					JOptionPane.showMessageDialog(ventana, "Campo Apellido Vacio", "Error al Anadir",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (ContrasenaVaciaException e1) {
					JOptionPane.showMessageDialog(ventana, "Campo Contrasena Vacio", "Error al Anadir",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (EmpleadosDuplicadosException e1) {
					JOptionPane.showMessageDialog(ventana, "Ese Empleado ya existe", "Error al Anadir",
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
					String apellido = textFieldApellido.getText();
					float sueldo = Integer.parseInt(textFieldSueldo.getText());
					Puesto puesto = (Puesto) comboBoxPuesto.getSelectedItem();
					String contrasena = textFieldContrasena.getText();
					Empleado empleadoSeleccionado = (Empleado) listEmpleados.getSelectedValue();
					
					for(int i = 0; i < ventana.restaurante.getEmpleados().size(); i++) {
						if(ventana.restaurante.getEmpleados().get(i).getNombre().equals(nombre) && ventana.restaurante.getEmpleados().get(i).getApellido().equals(apellido)) {
							throw new EmpleadosDuplicadosException("Empleado ya existe");
						}
					}					
					for (int i = 0; i < ventana.restaurante.getEmpleados().size(); i++) {

						if (ventana.restaurante.getEmpleados().get(i).getNombre().equals(empleadoSeleccionado.getNombre()) && ventana.restaurante.getEmpleados().get(i).getApellido().equals(empleadoSeleccionado.getApellido())) {
							ventana.restaurante.getEmpleados().get(i).setNombre(nombre);
							ventana.restaurante.getEmpleados().get(i).setApellido(apellido);
							ventana.restaurante.getEmpleados().get(i).setSueldo(sueldo);
							ventana.restaurante.getEmpleados().get(i).setPuesto(puesto);
							ventana.restaurante.getEmpleados().get(i).setContrasena(contrasena);
							JOptionPane.showMessageDialog(ventana, "Empleado Actualizado", "Empleado Actualizada",
									JOptionPane.PLAIN_MESSAGE);
						}
					}
					listEmpleados.repaint();
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
				} catch (ApellidoVacioException e1) {
					JOptionPane.showMessageDialog(ventana, "Campo Apellido Vacio", "Error al Anadir",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (ContrasenaVaciaException e1) {
					JOptionPane.showMessageDialog(ventana, "Campo Contrasena Vacio", "Error al Anadir",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (EmpleadosDuplicadosException e1) {
					JOptionPane.showMessageDialog(ventana, "Ese Empleado ya existe", "Error al Anadir",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

			}
		});

	}
}
