package pantallas;

import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JPanel;

import clases.Mesa;
import clases.Zona;
import elementosVisuales.Boton;
import elementosVisuales.BotonRojo;
import exception.NombreVacioException;

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

public class GestionaZona extends JPanel{
	private Ventana ventana;
	private JTextField textFieldNombre;
	
	public GestionaZona(Ventana v) {
		this.ventana = v;
		
		setBackground(SystemColor.activeCaption);
		setLayout(null);
		
		DefaultListCellRenderer renderer = new DefaultListCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		final JList listZonas = new JList();
		final ArrayList<Zona> zonas = ventana.restaurante.getZonas();
		listZonas.setModel(new AbstractListModel() {
			public int getSize() {
				return zonas.size();
			}
			public Object getElementAt(int index) {
				return zonas.get(index);
			}
		});
		listZonas.setBounds(433, 70, 144, 285);
		listZonas.setCellRenderer(renderer);
		add(listZonas);
		
		Boton btnEliminar = new Boton("Eliminar");
		btnEliminar.setBounds(443, 366, 134, 23);
		add(btnEliminar);
		
		BotonRojo btnAtras = new BotonRojo("Atras");
		btnAtras.setBounds(574, 401, 89, 23);
		add(btnAtras);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNombre.setBounds(55, 151, 114, 20);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		final JComboBox comboBoxMesa = new JComboBox();
		comboBoxMesa.setModel(new DefaultComboBoxModel(ventana.getTodasMesas().toArray()));
		comboBoxMesa.setBounds(55, 256, 114, 22);
		add(comboBoxMesa);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Hack Nerd Font", Font.ITALIC, 15));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(55, 126, 114, 14);
		add(lblNombre);
		
		JLabel lblMesa = new JLabel("Mesa");
		lblMesa.setFont(new Font("Hack Nerd Font", Font.ITALIC, 15));
		lblMesa.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesa.setBounds(55, 231, 114, 14);
		add(lblMesa);
		
		Boton btnAnadir = new Boton("Anadir");
		btnAnadir.setBounds(224, 203, 134, 23);
		add(btnAnadir);
		
		Boton btnActualizar = new Boton("Actualizar");
		btnActualizar.setBounds(224, 256, 134, 23);
		add(btnActualizar);
		
		Boton btnCambiarNombre = new Boton("Cambiar Nombre");
		btnCambiarNombre.setBounds(224, 150, 134, 23);
		add(btnCambiarNombre);
		
		JLabel lblGestion = new JLabel("Gestion De Zonas");
		lblGestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestion.setFont(new Font("Hack Nerd Font", Font.BOLD, 30));
		lblGestion.setBounds(55, 11, 611, 48);
		add(lblGestion);
		
		//Acciones
		
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("InicioAdmin");
			}
		});
		
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Zona zonaSeleccionada;
				try {
					zonaSeleccionada = (Zona) listZonas.getSelectedValue();
					for(int i = 0; i<ventana.restaurante.getZonas().size(); i++) {
						if(ventana.restaurante.getZonas().get(i).getNombre() == zonaSeleccionada.getNombre()) {
							ventana.restaurante.getZonas().remove(i);
						}
					}
					listZonas.repaint();
				}catch(java.lang.NullPointerException e1) {
					JOptionPane.showMessageDialog(ventana, "Tienes que seleccionar una zona", "Error al Eliminar", JOptionPane.ERROR_MESSAGE );
				}
				
			}
		});
		
		btnAnadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<Mesa> mesas = new ArrayList<Mesa>();
				mesas.add((Mesa) comboBoxMesa.getSelectedItem());
				String nombre = textFieldNombre.getText();
				Zona zonaNueva;
				ArrayList<Zona> zonasNuevas = ventana.restaurante.getZonas();
				try {
					zonaNueva = new Zona(nombre, mesas);
					zonasNuevas.add(zonaNueva);
					ventana.restaurante.setZonas(zonasNuevas);
					listZonas.repaint();
				} catch (NombreVacioException e1) {
					JOptionPane.showMessageDialog(ventana, "Campo Nombre Vacio", "Error al Actualizada", JOptionPane.ERROR_MESSAGE );
					e1.printStackTrace();
				}
			}
		});
		
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Zona zonaSeleccionada = (Zona) listZonas.getSelectedValue();
					Mesa mesaNueva = (Mesa) comboBoxMesa.getSelectedItem();
					for(int i = 0; i<ventana.restaurante.getZonas().size(); i++) {
						if(ventana.restaurante.getZonas().get(i).getNombre() == zonaSeleccionada.getNombre()) {
							ArrayList<Mesa> mesasNuevas = ventana.restaurante.getZonas().get(i).getMesas();
							mesasNuevas.add(mesaNueva);
							ventana.restaurante.getZonas().get(i).setMesas(mesasNuevas);
							JOptionPane.showMessageDialog(ventana, "Mesa Anadida", "Zona Actualizada", JOptionPane.PLAIN_MESSAGE );
						}
					}
					listZonas.repaint();
				}catch(java.lang.NullPointerException e1) {
					JOptionPane.showMessageDialog(ventana, "Tienes que seleccionar una zona", "Error al Actualizar", JOptionPane.ERROR_MESSAGE );
				}
				
			}
		});
		
		btnCambiarNombre.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Zona zonaSeleccionada = (Zona) listZonas.getSelectedValue();
					String nombreNuevo = textFieldNombre.getText();
					for(int i = 0; i<ventana.restaurante.getZonas().size(); i++) {
						if(ventana.restaurante.getZonas().get(i).getNombre() == zonaSeleccionada.getNombre()) {
							try {
								ventana.restaurante.getZonas().get(i).setNombre(nombreNuevo);
								JOptionPane.showMessageDialog(ventana, "Nombre Actualizado", "Zona Actualizada", JOptionPane.PLAIN_MESSAGE );
							}catch(NombreVacioException e1) {
								JOptionPane.showMessageDialog(ventana, "Campo Nombre Vacio", "Error al Actualizada", JOptionPane.ERROR_MESSAGE );
							}
						}
					}
					listZonas.repaint();
				}catch(java.lang.NullPointerException e1) {
					JOptionPane.showMessageDialog(ventana, "Tienes que seleccionar una zona", "Error al Actualizar", JOptionPane.ERROR_MESSAGE );
				}
				
			}
		});
		
	}
}
