package test;

import java.util.*;

import gui.VentanaInformes;
import negocio.*;
import pacientes.*;

public class TestInformes {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		Paciente paciente = null;
		IAccesoInformes informe = new AccesoInformesImp();
		informe.iniciarInforme();
		mostrarVentana();
		
		System.out.println("Vamos a crear un paciente");
		System.out.println("¿Como se llama el paciente?");
		String nombre=sc.nextLine();
		
		
		
		System.out.println("Marca el número de la opción que corresponda,"
				+ "1. Fistula "
				+ "2. CVC");
		
		int opc= sc.nextInt();
		
		switch(opc) {
		
		case 1:
			paciente= informe.crearPacienteFav(nombre);
			break;
		case 2:
			paciente=informe.crearPacienteCvc(nombre);
			break;
		default: 
			System.out.println("opcion no valida");
			break;
		}
		
		
		informe.agregarPaciente(IAccesoInformes.NOMBRE_RECURSO, paciente);

	
		

	}
	
	private static void mostrarVentana() {
		VentanaInformes ventana= new VentanaInformes();
		ventana.setVisible(true);
	}

}
