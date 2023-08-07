
package co.com.conversorMoneda.Logica;
import javax.swing.JOptionPane;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class ConversorMoneda extends Conversor implements procesosNecesariosConversion{
	
	
	public ConversorMoneda(double cantidad) {
		super(cantidad);		
	}
	
	public double operacionesConversor(double cantidad, String opcionSeleccionadaMoneda) {
		
		double tasaDeCambio = factorDeCambio(opcionSeleccionadaMoneda);		
		double cantidadFinal = resultadoConversion(cantidad, tasaDeCambio);
		return cantidadFinal;
	}
	
	
	
	private double factorDeCambio(String opcionSeleccionadaMoneda) {
		
		FactorConversionMoneda tasaDeCambio  = FactorConversionMoneda.valueOf(opcionSeleccionadaMoneda.replace(" ", "_"));
		return tasaDeCambio.getTasaConversion();
	}
			
	
	private double resultadoConversion(double cantidadFinal, double tasaDeCambio) {
		double nuevaCantidad = cantidadFinal*tasaDeCambio;
		
		DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
		DecimalFormat df = new DecimalFormat("#.00", symbols);			
		return Double.parseDouble(df.format(nuevaCantidad));	
	}

	
	public void mostrarResultado(double cantidad, String opcionSeleccionadaMoneda, double nuevaCantidad) {
		
		JOptionPane.showMessageDialog(null,"Valor inicial ingresado: " + cantidad + "\nOpción seleccionada: " + opcionSeleccionadaMoneda + "\nCantidad nueva: " +nuevaCantidad );
	}
		
}
	
	

