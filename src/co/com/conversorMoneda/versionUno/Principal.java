package co.com.conversorMoneda.versionUno;
import javax.swing.JOptionPane;

import co.com.conversorMoneda.Excepciones.ExcepcionNoDigitarRespuestaCorrecta;
import co.com.conversorMoneda.ListasDeMenuEnum.OpcionesMenuInicial;
import co.com.conversorMoneda.ListasDeMenuEnum.OpcionesMenuMoneda;
import co.com.conversorMoneda.ListasDeMenuEnum.OpcionesMenuTemperatura;
import co.com.conversorMoneda.Logica.ConversorMoneda;
import co.com.conversorMoneda.Logica.ConversorTemperatura;

import java.awt.Image;
import java.util.Arrays;
import javax.swing.ImageIcon;


public class Principal{
	
	
	public static void main(String[] args) {
		
			escogerOpcionMenuPrincipal();		
			mensajeFinalReiniciar();
			
	}
	
	public static void escogerOpcionMenuPrincipal() {
		
		OpcionesMenuInicial[] opcionesMenuInicial = OpcionesMenuInicial.values();
				
		String imagenMenu = "C:\\Users\\carit\\Desktop\\programacion\\ORACLE-ALURA\\CHALLENGE\\challengeTwo\\image.jpeg";
				
		ImageIcon imagenMenuActualizada = obtenerImagenRedimensionada(imagenMenu, 300, 250);
	
		 String opcionSeleccionada = mostrarMenuDesplegable( Arrays.stream(opcionesMenuInicial).map(OpcionesMenuInicial::obtenerNombresSinGuiones).toArray(String[]::new),
			        imagenMenuActualizada
			    );
		
		double cantidad = solicitarCantidad();
		
		
		if(opcionSeleccionada.equals(OpcionesMenuInicial.values()[0].obtenerNombresSinGuiones())) {
			
			String opcionSeleccionadaMoneda = mostrarMenuMoneda(imagenMenuActualizada);
					
			ConversorMoneda objetoMoneda = new ConversorMoneda(cantidad);
			double cantidadFinal = objetoMoneda.operacionesConversor(cantidad, opcionSeleccionadaMoneda);
			objetoMoneda.mostrarResultado(cantidad, opcionSeleccionadaMoneda, cantidadFinal );
								
		}else {
			
			String opcionSeleccionadaTemperatura = mostrarMenuTemperatura(imagenMenuActualizada);
					
			ConversorTemperatura objetoTemperatura = new ConversorTemperatura(cantidad);
			double valorFinal = objetoTemperatura.operacionesConversor(cantidad, opcionSeleccionadaTemperatura);
			objetoTemperatura.mostrarResultado(cantidad, opcionSeleccionadaTemperatura,valorFinal);
		}	
		
	}
	
	
	private static ImageIcon obtenerImagenRedimensionada(String imagenMenu, int width, int height) {
		ImageIcon imageIcon = new ImageIcon(imagenMenu);
		Image image = imageIcon.getImage();
		Image tamañoRedimensionado = image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		return new ImageIcon(tamañoRedimensionado);		
	}
	
	private static String mostrarMenuDesplegable(String[] opcionesMenu, ImageIcon imagen) {
		return (String) JOptionPane.showInputDialog(null, "Selecciona una opción del menú:", "Conversion",
                JOptionPane.PLAIN_MESSAGE, imagen, opcionesMenu, opcionesMenu[0]);
	}
	
	
	private static double solicitarCantidad() {
		
		double cantidadIngresada=0;
		boolean valorValido = false;
		
		while (!valorValido) {
			try {
				String cantidadIngresadaStr = JOptionPane.showInputDialog(null, "Digite cantidad:");				
				cantidadIngresada = Double.parseDouble(cantidadIngresadaStr);		
				valorValido = true;
			} catch (NumberFormatException e){
				JOptionPane.showMessageDialog(null,"Por favor, ingrese un valor numérico." );
			}
			
		}					
		return cantidadIngresada;
	};
	
	private static String mostrarMenuMoneda(ImageIcon imagenMenuActualizada) {
	    OpcionesMenuMoneda[] opcionesMoneda = OpcionesMenuMoneda.values();
	    return mostrarMenuDesplegable(Arrays.stream(opcionesMoneda).map(OpcionesMenuMoneda::obtenerNombresSinGuiones).toArray(String[]::new),
	            imagenMenuActualizada);
	}

	private static String mostrarMenuTemperatura(ImageIcon imagenMenuActualizada) {
	    OpcionesMenuTemperatura[] opcionesTemperatura = OpcionesMenuTemperatura.values();
	    return mostrarMenuDesplegable(Arrays.stream(opcionesTemperatura).map(OpcionesMenuTemperatura::obtenerNombresSinGuiones).toArray(String[]::new),
	            imagenMenuActualizada);
	}
	
	private static void mensajeFinalReiniciar() {
			
		char respuesta = ' ';
		
		do {
			try {
				respuesta = obtenerRespuesta();			
			
				if(respuesta == 'S') {
					escogerOpcionMenuPrincipal();
				} else if(respuesta == 'N') {
					break;
				} else {
					throw new ExcepcionNoDigitarRespuestaCorrecta("Respuesta inválida. Debe ser 'S' o 'N'.");
				}
			
			}catch(ExcepcionNoDigitarRespuestaCorrecta e) {
				JOptionPane.showMessageDialog(null, "Error: "+ e.getMessage());
			}				
				
		}while(respuesta != 'N');
	}
	
	public static char obtenerRespuesta() throws ExcepcionNoDigitarRespuestaCorrecta{
		String textoIngresado= JOptionPane.showInputDialog(null, "¿Desea volver al menu inicial? (S/N)");
		
		if(textoIngresado != null && textoIngresado.length() ==1) {
			char respuesta = textoIngresado.charAt(0);
			respuesta = Character.toUpperCase(respuesta);
			return respuesta;
		}else {
			throw new ExcepcionNoDigitarRespuestaCorrecta("Respuesta inválida. Debe ser un solo carácter.");
		}
		
	}
	
}






