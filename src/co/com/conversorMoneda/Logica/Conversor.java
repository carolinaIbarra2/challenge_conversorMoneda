package co.com.conversorMoneda.Logica;

import javax.swing.JOptionPane;

public class Conversor {
	
	private double cantidad;
	

	public Conversor(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
	
	public void mostrarMensajeFinalReinicio() {
		JOptionPane.showMessageDialog(null,"¿Desea consultar de nuevo?" );
			
	}
				
}
