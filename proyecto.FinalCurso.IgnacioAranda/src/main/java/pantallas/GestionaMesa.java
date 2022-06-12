package pantallas;

import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JPanel;

import clases.Mesa;
import clases.Zona;
import elementosVisuales.Boton;
import elementosVisuales.BotonRojo;
import exception.MesaDuplicadoException;
import exception.NombreVacioException;
import exception.ProductoDuplicadoException;

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

public class GestionaMesa extends JPanel {
	private Ventana ventana;
	private JTextField textFieldNombre;

	public GestionaMesa(Ventana v) {
		this.ventana = v;

		setBackground(SystemColor.activeCaption);
		setLayout(null);

		DefaultListCellRenderer renderer = new DefaultListCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);

		final JList listMesas = new JList();
		final ArrayList<Mesa> mesas = ventana.getTodasMesas();
		listMesas.setModel(new AbstractListModel() {
			public int getSize() {
				return mesas.size();
			}

			public Object getElementAt(int index) {
				return mesas.get(index);
			}
		});
		listMesas.setBounds(433, 70, 144, 285);
		listMesas.setCellRenderer(renderer);
		add(listMesas);

		Boton btnEliminar = new Boton("Eliminar");
		btnEliminar.setBounds(443, 366, 134, 23);
		add(btnEliminar);

		BotonRojo btnAtras = new BotonRojo("Atras");
		btnAtras.setBounds(574, 401, 89, 23);
		add(btnAtras);

		textFieldNombre = new JTextField();
		textFieldNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNombre.setBounds(55, 256, 114, 20);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);

		JLabel lblNombre = new JLabel("Numero");
		lblNombre.setFont(new Font("Hack Nerd Font", Font.ITALIC, 15));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(55, 231, 114, 14);
		add(lblNombre);


		Boton btnAnadir = new Boton("Anadir");
		btnAnadir.setBounds(224, 308, 134, 23);
		add(btnAnadir);

		Boton btnCambiarNumero = new Boton("Cambiar Numero");
		btnCambiarNumero.setBounds(224, 150, 134, 23);
		add(btnCambiarNumero);

		JLabel lblGestion = new JLabel("Gestion De Mesas");
		lblGestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestion.setFont(new Font("Hack Nerd Font", Font.BOLD, 30));
		lblGestion.setBounds(55, 11, 611, 48);
		add(lblGestion);

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
				Mesa mesaSeleccionada;
				try {
					 mesaSeleccionada = (Mesa) listMesas.getSelectedValue();
					for (int i = 0; i < ventana.restaurante.getZonas().size(); i++) {
						if (ventana.getTodasMesas().get(i).getNumero() == mesaSeleccionada.getNumero()) {
							ventana.getTodasMesas().remove(i);
						}
					}
					listMesas.repaint();
				} catch (java.lang.NullPointerException e1) {
					JOptionPane.showMessageDialog(ventana, "Tienes que seleccionar una zona", "Error al Eliminar",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		btnAnadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				byte numero = (byte) Integer.parseInt(textFieldNombre.getText());
				Mesa mesaNueva;
				ArrayList<Mesa> mesasNuevas = ventana.getTodasMesas();
				try {
					for(int i = 0; i < ventana.getTodasMesas().size(); i++) {
						if(ventana.getTodasMesas().get(i).getNumero() == (numero)) {
							throw new MesaDuplicadoException("Mesa ya existe");
						}
					}
					mesaNueva = new Mesa(numero);
					mesasNuevas.add(mesaNueva);
					ventana.setTodasMesas(mesasNuevas);
					listMesas.repaint();
				} catch (java.lang.NumberFormatException e1) {
					JOptionPane.showMessageDialog(ventana, "El formato del Numero no es correcto", "Error al Anadir",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (MesaDuplicadoException e1) {
					JOptionPane.showMessageDialog(ventana, "La mesa ya existe", "Error al Anadir",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				listMesas.repaint();
			}
		});

		btnCambiarNumero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Mesa mesaSeleccionada = (Mesa) listMesas.getSelectedValue();
					try {
						byte numeroNuevo = (byte) Integer.parseInt(textFieldNombre.getText());
						
						for(int i = 0; i < ventana.getTodasMesas().size(); i++) {
							if(ventana.getTodasMesas().get(i).getNumero() == (numeroNuevo)) {
								throw new MesaDuplicadoException("Mesa ya existe");
							}
						}
						
						for (int i = 0; i < ventana.getTodasMesas().size(); i++) {
							if (ventana.getTodasMesas().get(i).getNumero() == mesaSeleccionada.getNumero()) {
								ventana.getTodasMesas().get(i).setNumero(numeroNuevo);
								JOptionPane.showMessageDialog(ventana, "Numero Actualizado", "Mesa Actualizada",
										JOptionPane.PLAIN_MESSAGE);
							}
						}
					}catch(java.lang.NumberFormatException e1) {
						JOptionPane.showMessageDialog(ventana, "El formato del Numero no es correcto", "Error al Actualizar",
								JOptionPane.ERROR_MESSAGE);
					} catch (MesaDuplicadoException e1) {
						JOptionPane.showMessageDialog(ventana, "La mesa ya existe", "Error al Actualizar",
								JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
					listMesas.repaint();
				} catch (java.lang.NullPointerException e1) {
					JOptionPane.showMessageDialog(ventana, "Tienes que seleccionar una mesa", "Error al Actualizar",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

	}
}
