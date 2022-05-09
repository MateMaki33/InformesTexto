package test;

import gui.VentanaInformes;


public class TestInformes {

	public static void main(String[] args) {
		VentanaInformes obj = new VentanaInformes();
		mostrarVentana(obj);

	}

	private static void mostrarVentana(VentanaInformes obj) {
		obj = new VentanaInformes();
		obj.setVisible(true);
	}

}
