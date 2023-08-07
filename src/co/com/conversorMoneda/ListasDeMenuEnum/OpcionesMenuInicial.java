package co.com.conversorMoneda.ListasDeMenuEnum;

public enum OpcionesMenuInicial {
	Conversor_de_moneda, 
	Conversor_de_temperatura;
	
	public String obtenerNombresSinGuiones() {
		return this.name().replace("_", " ");
	}
	
}
