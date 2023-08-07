package co.com.conversorMoneda.Logica;
import java.text.DecimalFormat;

import java.text.DecimalFormatSymbols;
import java.util.Locale;

import javax.swing.JOptionPane;

import co.com.conversorMoneda.ListasDeMenuEnum.OpcionesMenuTemperatura;

public class ConversorTemperatura extends Conversor implements procesosNecesariosConversion{
		
	public ConversorTemperatura(double cantidad) {
		super
		(cantidad);		
	}
	
	
	public double operacionesConversor(double cantidad, String opcionSeleccionadaTemperatura ) {
		
		OpcionesMenuTemperatura opcion = OpcionesMenuTemperatura.valueOf(opcionSeleccionadaTemperatura.replace(" ", "_"));
		
		double nuevaCantidad = formulasTemperatura(cantidad, opcion);
		double valorFinal = acomodarValor(nuevaCantidad);
		return valorFinal;
	}
	
		
	private double formulasTemperatura(double cantidad, OpcionesMenuTemperatura opcionSeleccionadaTemperatura) {
		
		double resultado=0;
		
				
		switch(opcionSeleccionadaTemperatura) {
		
		case GRADOS_CENTIGRADOS_A_GRADOS_FARENHEIT:
			resultado = (cantidad*(1.8))+32;
			break;
			
		case GRADOS_FARENHEIT_A_GRADOS_CENTIGRADOS:
			resultado = (cantidad-32)*(0.56);
			break;
			
		case GRADOS_KELVIN_A_GRADOS_CENTIGRADOS:
			resultado = cantidad-273.15;
			break;
			
		case GRADOS_CENTIGRADOS_A_GRADOS_KELVIN:
			resultado = cantidad+273.15;
			break;
			
		case GRADOS_FARENHEIT_A_GRADOS_KELVIN:
			resultado = ((cantidad - 32) * (5/9)) + 273.15;
			break;
		
		case GRADOS_KELVIN_A_GRADOS_FARENHEIT:
			resultado = ((cantidad - 273.15) * (9/5)) + 32;
			break;		
		}
		
		return resultado;
		
	}


	public void mostrarResultado(double cantidad, String opcionSeleccionadaTemperatura, double valorFinal) {
		
		JOptionPane.showMessageDialog(null, "Valor inicial ingresado: " + cantidad + "\nOpción seleccionada: " + opcionSeleccionadaTemperatura + "\nCantidad nueva: " +valorFinal);
	}
	
	private double acomodarValor(double nuevaCantidad){
		DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
		DecimalFormat df = new DecimalFormat("#.00", symbols);			
		return Double.parseDouble(df.format(nuevaCantidad));
	}

}
