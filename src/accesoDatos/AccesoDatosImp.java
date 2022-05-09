package accesoDatos;

import java.io.*;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JTextField;

import excepciones.*;
import gui.VentanaInformes;
import negocio.AccesoInformesImp;
import negocio.IAccesoInformes;
import pacientes.*;

public class AccesoDatosImp implements IAccesoDatos {
	
	 
	public AccesoDatosImp() {}
	
	@Override
	public void crearFichero(String nombreFichero) throws AccesoDatosEx {
		File fichero = new File(nombreFichero);
		try {
			PrintWriter salida = new PrintWriter(new FileWriter(fichero));
			salida.close();
			System.out.println("se ha creado el archivo");
		} catch (IOException e) {
			e.printStackTrace();
			throw new AccesoDatosEx("Excepcion al crear:" + e.getMessage());

		}

	}

	@Override
	public void escribirPaciente(String nombreFichero, Paciente paciente, boolean anexar) throws EscrituraDatosEx {
		File fichero = new File(nombreFichero);
		try {
			PrintWriter salida = new PrintWriter(new FileWriter(fichero, anexar));
			salida.println(paciente.toString());
			salida.println(mensajeNormofuncion(paciente));
			salida.close();
			System.out.println("Se ha escrito informacion al archivo");
		} catch (IOException e) {

			e.printStackTrace();
			throw new EscrituraDatosEx("Excepcion al escribir:" + e.getMessage());
		}

	}

	public String mensajeNormofuncion(Paciente paciente) {
		String mensaje=null;
		if(paciente.getAccesoVascular().normoFunciona()==true) {
			mensaje = "Acceso vascular normofuncionante"
					+ " " + "con flujo y presiones en rango";
		}else {
			mensaje ="Acceso vascular con signos de disfunción"
					+ " " + "en base relación flujo y presiones";
		}
		return mensaje;
	}

	@Override
	public boolean existe(String nombreRecurso) throws AccesoDatosEx {
		var recurso = new File(nombreRecurso);
		return recurso.exists();
	
	}

	@Override
	public void borrar(String nombreRecurso) throws AccesoDatosEx {
		var recurso= new File (nombreRecurso);
		if(recurso.exists());
		recurso.delete();
		System.out.println("archivo borrado");
		
	}

	@Override
	public Paciente crearPacienteFav(String nombre, int flujoint, int pvint, int paint) {
		AccesoVascular fistula=new Fistula();
		fistula.getNombre();
		fistula.setFlujo(flujoint);
		fistula.setPa(paint);
		fistula.setPv(pvint);
		
		Paciente paciente= new Paciente(nombre,fistula);
		
		return paciente;
	}

	@Override
	public Paciente crearPacienteCvc(String nombre, int flujoint, int pvint, int paint) {       
		AccesoVascular cvc=new Cateter();
		cvc.getNombre();
		cvc.setFlujo(flujoint);
		cvc.setPa(paint);
		cvc.setPv(pvint);
		
		Paciente paciente= new Paciente(nombre,cvc);
		
		return paciente;
	}

	
}
