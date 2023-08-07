package co.com.conversorMoneda.versionDos;
import javax.swing.*;


import co.com.conversorMoneda.ListasDeMenuEnum.OpcionesMenuMoneda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class PrincipalVersion2 implements ActionListener{

	private Ventana ventana;
	private JPanel panel;
	
	
	public PrincipalVersion2() {
		ventana = new Ventana();
		panel = ventana.getPanel();
		ventana.add(panel);
		ventana.getBoton1().addActionListener(this);
		ventana.getBoton2().addActionListener(this);
		ventana.setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == ventana.getBoton1()) {
			ventana.limpiarPanel();
			colocarListasDesplegablesMonedas();
		} else if(e.getSource() == ventana.getBoton2()) {
			ventana.limpiarPanel();			
		}
	}
	
	private void colocarListasDesplegablesMonedas() {
		OpcionesMenuMoneda [] opcionesMonedas = OpcionesMenuMoneda.values();
		JComboBox<OpcionesMenuMoneda> menuDesplegableMonedas = new JComboBox<>(opcionesMonedas);
		menuDesplegableMonedas.setBounds(100, 500, 100, 30);
		
		panel.revalidate();  //Actualizar el panel
		
	}
		
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
	    new PrincipalVersion2(); 
		});	
		
	}  
	
}
