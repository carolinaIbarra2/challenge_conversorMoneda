package co.com.conversorMoneda.ListasDeMenuEnum;

public enum OpcionesMenuTemperatura {
		GRADOS_CENTIGRADOS_A_GRADOS_FARENHEIT,
	    GRADOS_FARENHEIT_A_GRADOS_CENTIGRADOS,
	    GRADOS_KELVIN_A_GRADOS_CENTIGRADOS,
	    GRADOS_CENTIGRADOS_A_GRADOS_KELVIN,
	    GRADOS_FARENHEIT_A_GRADOS_KELVIN,
	    GRADOS_KELVIN_A_GRADOS_FARENHEIT;

	public String obtenerNombresSinGuiones() {
		return this.name().replace("_", " ");
	}

	
}
