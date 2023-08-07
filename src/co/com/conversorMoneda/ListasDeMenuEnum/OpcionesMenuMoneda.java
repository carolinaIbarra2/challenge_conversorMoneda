package co.com.conversorMoneda.ListasDeMenuEnum;

public enum OpcionesMenuMoneda {
	PESOS_A_DOLAR,
	PESOS_A_EURO,
	PESOS_A_LIBRAS,
    PESOS_A_YEN,
    PESOS_A_WON_COREANO,
    DOLAR_A_PESOS,
    EURO_A_PESOS,
    LIBRAS_A_PESOS,
    YEN_A_PESOS,
    WON_COREANO_A_PESOS;
	
	public String obtenerNombresSinGuiones() {
		return this.name().replace("_", " ");
	}
}
