package pantallas;

import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame{
	private HashMap<String,JPanel> pantallas;
	
	public Ventana() {
		pantallas=new HashMap<String,JPanel>();
		pantallas.put("Inicio",new Inicio(this));
		
		//Se que no funciona pero no entiendo porque
		this.setIconImage(new ImageIcon("./Imagenes/logo.png").getImage());
		
		this.setSize(800,450);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setTitle("Restaurante los Carpinchos");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setContentPane(this.pantallas.get("Inicio"));
		
		this.setVisible(true);
		
	}
	
//	public void cambiarAPantalla(String nombrePantalla) {
//		Iterator it=this.pantallas.values().iterator();
//		while(it.hasNext()) {
//			JPanel actual=(JPanel)it.next();
//			actual.setVisible(false);
//		}
//		this.pantallas.get(nombrePantalla).setVisible(true);
//		this.setContentPane(this.pantallas.get(nombrePantalla));
//	}
}
