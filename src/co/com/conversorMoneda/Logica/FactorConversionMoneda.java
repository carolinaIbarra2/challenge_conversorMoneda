package co.com.conversorMoneda.Logica;

public enum FactorConversionMoneda {
	
	PESOS_A_DOLAR(0.00025),
	PESOS_A_EURO(0.00022),
	PESOS_A_LIBRAS(0.00019),
	PESOS_A_YEN(0.033),
	PESOS_A_WON_COREANO(0.31),
	DOLAR_A_PESOS(4139.39),
	EURO_A_PESOS(4611.26),
	LIBRAS_A_PESOS(5378.60),
	YEN_A_PESOS(29.89),
	WON_COREANO_A_PESOS(3.24);
	
	
	private double tasaConversion;
	
	
	
	private FactorConversionMoneda(double tasaConversion) {
		this.tasaConversion = tasaConversion;
	}



	public double getTasaConversion() {
		return tasaConversion;
	}



	public void setTasaConversion(double tasaConversion) {
		this.tasaConversion = tasaConversion;
	}
	
	
	
	
	
}
