package co.com.conversorMoneda.versionDos;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class Ventana extends JFrame {
	
	private JPanel panel;
	private JButton boton1, boton2;
	private JLabel etiquetaFondo;
	
	public Ventana() {
		setSize(700,700);  //Establecer tamaño de la ventana
		setTitle("PROGRAMA DE CONVERSOR MONEDAS Y TEMPERATURA");
		setLocationRelativeTo(null);  //Centrar ventana
		this.getContentPane().setBackground(Color.lightGray);  //Color ventana
		iniciarComponentes();
		setDefaultCloseOperation(EXIT_ON_CLOSE);   //método para cuando cierre la ventana finalice la ejecución del programa.
	}
		
	private void iniciarComponentes() {
		colocarPaneles();		
		colocarBotones();		
		colocarEtiqueta();
		insertarImagenFondo();
		
	}		
	
	private void colocarPaneles() {
		panel = new JPanel();    //Creacion de un panel
		panel.setLayout(null);
		this.getContentPane().add(panel);  //Agregamos el panel a la ventana		
	}
	
	private void colocarBotones() {
	
		boton1 = new JButton("CONVERSOR DE MONEDAS");
		boton1.setBounds(220, 200, 260, 50);  
		boton1.setFont(new Font("Candara",Font.BOLD,17));
		boton1.setForeground(Color.black);
		boton1.setBackground(Color.gray);
		boton1.setBorder(BorderFactory.createLineBorder(Color.gray, 4, false));
		panel.add(boton1);
		
		boton2 = new JButton("CONVERSOR DE TEMPERATURA");
		boton2.setBounds(220, 300, 260, 50); 
		boton2.setFont(new Font("Candara",Font.BOLD,17));
		boton2.setForeground(Color.black);
		boton2.setBackground(Color.magenta);
		boton2.setBorder(BorderFactory.createLineBorder(Color.magenta, 4, false));
		panel.add(boton2);
				
	}
	
	private void colocarEtiqueta() {
		JLabel etiqueta = new JLabel("Challenge two: Bienvenidos, escoge una opción",SwingConstants.CENTER); 
        etiqueta.setBounds(75,120,550,40);
        etiqueta.setForeground(Color.black);  
		etiqueta.setFont(new Font("Candara",Font.BOLD,25));  //Establecemos la fuente del texto etiqueta
		panel.add(etiqueta);
	}
		
	private void insertarImagenFondo() {
		configurarImagen();
	}
	
	private void configurarImagen() {
		
		ImageIcon imagenFondo = new ImageIcon("imagenDeFondo.png");
		etiquetaFondo = new JLabel(imagenFondo);   //Crear etiqueta para la imagen de fondo
				
		panel.add(etiquetaFondo);
		
		panel.addComponentListener(new ComponentAdapter() {  //Agrega un componentAdapter para escuchar el evento cambio de pantalla
			
			@Override
			public void componentResized(ComponentEvent e) {
			
				int anchoVentana = panel.getWidth();   //Obtener nuevas dimensiones del panel
				int altoVentana = panel.getHeight();
			
				Image imagen = imagenFondo.getImage();   //Escalar imagen
				Image imagenEscalada = imagen.getScaledInstance(anchoVentana, altoVentana, Image.SCALE_SMOOTH);
				ImageIcon imagenFondoEscalada = new ImageIcon(imagenEscalada);
				
				etiquetaFondo.setIcon(imagenFondoEscalada);   //Actualizar icono de la etiqueta de fondo
				
				etiquetaFondo.setBounds(0, 0, anchoVentana, altoVentana);   //Ajustar el tamaño y posicion de la etiqueta para que ocupe todo el panel
			}				
		});				
	}
		
	protected void limpiarPanel() {
		panel.remove(boton1);
		panel.remove(boton2);
		this.repaint();
		this.revalidate();
		panel.setOpaque(true);
		configurarImagen();
	    panel.add(etiquetaFondo);
	         
	}

	public JButton getBoton1() {
		return boton1;
	}

	public JButton getBoton2() {
		return boton2;
	}

	public JPanel getPanel() {
		return panel;
	}
	
}

	
