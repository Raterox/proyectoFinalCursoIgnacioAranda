package pantallas;

import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import clases.Alergeno;
import clases.Empleado;
import clases.Mesa;
import clases.Zona;
import elementosVisuales.Boton;
import elementosVisuales.BotonRojo;
import enums.Puesto;
import exception.AlergenoDuplicadoException;
import exception.EmpleadosDuplicadosException;
import exception.NombreVacioException;
import exception.SimboloVacioException;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;

public class GestionaAlergeno extends JPanel {
	private Ventana ventana;
	private JTextField textFieldNombre;
	private JTextField textFieldSimbolo;

	public GestionaAlergeno(Ventana v) {
		this.ventana = v;

		setBackground(SystemColor.activeCaption);
		setLayout(null);

		DefaultListCellRenderer renderer = new DefaultListCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(443, 84, 220, 271);
		add(scrollPane);

		final JList listAlergenos = new JList();
		final ArrayList<Alergeno> alergenos = ventana.getTodosAlergenos();
		listAlergenos.setModel(new AbstractListModel() {
			public int getSize() {
				return alergenos.size();
			}

			public Object getElementAt(int index) {
				return alergenos.get(index);
			}
		});
		listAlergenos.setCellRenderer(renderer);
		listAlergenos.setBounds(433, 70, 230, 285);
		scrollPane.setViewportView(listAlergenos);
		
		
		
		Boton btnEliminar = new Boton("Eliminar");
		btnEliminar.setBounds(443, 366, 134, 23);
		add(btnEliminar);

		BotonRojo btnAtras = new BotonRojo("Atras");
		btnAtras.setBounds(574, 401, 89, 23);
		add(btnAtras);

		textFieldNombre = new JTextField();
		textFieldNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNombre.setBounds(55, 209, 114, 20);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Hack Nerd Font", Font.ITALIC, 15));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(55, 184, 114, 14);
		add(lblNombre);


		Boton btnAnadir = new Boton("Anadir");
		btnAnadir.setBounds(224, 308, 134, 23);
		add(btnAnadir);

		Boton btnActualizar = new Boton("Actualizar");
		btnActualizar.setBounds(224, 150, 134, 23);
		add(btnActualizar);

		JLabel lblGestion = new JLabel("Gestion De Alergenos");
		lblGestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestion.setFont(new Font("Hack Nerd Font", Font.BOLD, 30));
		lblGestion.setBounds(55, 11, 611, 48);
		add(lblGestion);
		
		JLabel lblSimbolo = new JLabel("Simbolo");
		lblSimbolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSimbolo.setFont(new Font("Hack Nerd Font", Font.ITALIC, 15));
		lblSimbolo.setBounds(55, 251, 114, 14);
		add(lblSimbolo);
		
		textFieldSimbolo = new JTextField();
		textFieldSimbolo.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSimbolo.setColumns(10);
		textFieldSimbolo.setBounds(55, 276, 114, 20);
		add(textFieldSimbolo);

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
				Alergeno alergenoSeleccionado;
				try {
					alergenoSeleccionado = (Alergeno) listAlergenos.getSelectedValue();
					for (int i = 0; i < ventana.getTodosAlergenos().size(); i++) {
						if (ventana.getTodosAlergenos().get(i).getNombre().equals(alergenoSeleccionado.getNombre())) {
							ventana.getTodosAlergenos().remove(i);
						}
					}
					listAlergenos.repaint();
				} catch (java.lang.NullPointerException e1) {
					JOptionPane.showMessageDialog(ventana, "Tienes que seleccionar un Alergeno", "Error al Eliminar",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		btnAnadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre = textFieldNombre.getText();
				char signo = textFieldSimbolo.getText().charAt(0);
				Alergeno alergenoNuevo;
				ArrayList<Alergeno> alergenosNuevos = ventana.getTodosAlergenos();
				try {
					for(int i = 0; i < ventana.getTodosAlergenos().size(); i++) {
						if(ventana.getTodosAlergenos().get(i).getNombre().equals(nombre)) {
							throw new AlergenoDuplicadoException("Alergeno ya existe");
						}
					}
					alergenoNuevo = new Alergeno(nombre,signo);
					alergenosNuevos.add(alergenoNuevo);
					ventana.setTodosAlergenos(alergenosNuevos);
					listAlergenos.repaint();
				} catch (java.lang.NumberFormatException e1) {
					JOptionPane.showMessageDialog(ventana, "El formato del nombre o signo no es correcto", "Error al Anadir",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NombreVacioException e1) {
					JOptionPane.showMessageDialog(ventana, "El Campo Nombre esta Vacio", "Error al Anadir",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (SimboloVacioException e1) {
					JOptionPane.showMessageDialog(ventana, "El Campo Simpbolo esta Vacio", "Error al Anadir",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (AlergenoDuplicadoException e1) {
					JOptionPane.showMessageDialog(ventana, "El Alergeno ya existe", "Error al Anadir",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				listAlergenos.repaint();
			}
		});

		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String nombre;
					char signo;
					if(textFieldNombre.getText().isBlank()) {
						throw new NombreVacioException("El nombre esta vacio");
					}else {
						nombre = textFieldNombre.getText();
					}
					if(textFieldSimbolo.getText().isBlank()) {
						throw new SimboloVacioException("El simbolo esta vacio");
					}else {
						signo = textFieldSimbolo.getText().charAt(0);
					}
					
					Alergeno alergenoSeleccionado = (Alergeno) listAlergenos.getSelectedValue();
					
					for(int i = 0; i < ventana.getTodosAlergenos().size(); i++) {
						if(ventana.getTodosAlergenos().get(i).getNombre().equals(nombre)) {
							throw new AlergenoDuplicadoException("Alergeno ya existe");
						}
					}
					System.out.println("aqui");
					for (int i = 0; i < ventana.getTodosAlergenos().size(); i++) {

						if (ventana.getTodosAlergenos().get(i).getNombre().equals(alergenoSeleccionado.getNombre()) && ventana.getTodosAlergenos().get(i).getSimbolo() == (alergenoSeleccionado.getSimbolo())) {
							ventana.getTodosAlergenos().get(i).setNombre(nombre);
							ventana.getTodosAlergenos().get(i).setSimbolo(signo);

							JOptionPane.showMessageDialog(ventana, "Alergeno Actualizado", "Alergeno Actualizado",
									JOptionPane.PLAIN_MESSAGE);
						}
					}
					listAlergenos.repaint();
				} catch (java.lang.NullPointerException e1) {
					JOptionPane.showMessageDialog(ventana, "Tienes que seleccionar un alergeno", "Error al Actualizar",
							JOptionPane.ERROR_MESSAGE);
				} catch (NombreVacioException e1) {
					JOptionPane.showMessageDialog(ventana, "El nombre no puede estar vacio", "Error al Actualizar",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (AlergenoDuplicadoException e1) {
					JOptionPane.showMessageDialog(ventana, "El alergeno esta duplicado", "Error al Actualizar",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (SimboloVacioException e1) {
					JOptionPane.showMessageDialog(ventana, "El simbolo no puede estar vacio", "Error al Actualizar",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

			}
		});

	}
}
