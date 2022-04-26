package accesoDatos;

import java.io.*;
import java.util.Scanner;

import excepciones.*;
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
			salida.println(mensajeEstable());
			salida.close();
			System.out.println("Se ha escrito informacion cabecera al archivo");
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
					+ " "+ "en base relación flujo y presiones";
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
	public Paciente crearPacienteFav(String nombre) {
		Scanner sc=new Scanner (System.in);
		
		AccesoVascular fistula=new Fistula();
		fistula.getNombre();
		System.out.println("¿Cual es el flujo medio?");
		fistula.setFlujo(sc.nextInt());
		System.out.println("Introduce la presion arterial del acceso");
		fistula.setPa(sc.nextInt());
		System.out.println("Introduce la presion venosa del acceso");
		fistula.setPv(sc.nextInt());
		
	
		
		Paciente paciente= new Paciente(nombre,fistula);
		
		
		return paciente;
	}

	@Override
	public Paciente crearPacienteCvc(String nombre) {
Scanner sc=new Scanner (System.in);
		
		AccesoVascular cvc=new Cateter();
		cvc.getNombre();
		System.out.println("¿Cual es el flujo medio?");
		cvc.setFlujo(sc.nextInt());
		System.out.println("Introduce la presion arterial del acceso");
		cvc.setPa(sc.nextInt());
		System.out.println("Introduce la presion venosa del acceso");
		cvc.setPv(sc.nextInt());
		
	
		
		Paciente paciente= new Paciente(nombre,cvc);
		
		
		return paciente;
	}

	@Override
	public String mensajeEstable() {
		Scanner sc = new Scanner (System.in);
		System.out.println("¿El paciente está estable?"
				+ "\nMarque el numero que corresponda"
				+ "\n1. Estable"
				+ "\n2. Inestable e Hipotension"
				+ "\n3. Estable con HTA");
			int opcion=sc.nextInt();
		
		String mensaje= null;
		int opc=1;
		int opc2=2;
		int opc3=3;
		
		while(opcion!= opc && opcion!= opc2 && opcion!= opc3) {
			System.out.println("Introduce valor valido");
			
		}
		if(opcion==opc) {
			mensaje= "Paciente hemodinamicamente estable, "
					+ "con buena tolerancia general a las sesiones ";
			
		}else if(opcion==opc2) {
			mensaje="Paciente hemodinamicamente inestable, "
					+ "con episodios de hipotensión" +" " + "y"
					+ "mala tolerancia a la UF ";
		}else if(opcion==opc3) {
			mensaje= "Paciente hemodinamicamente estable, "
					+ "con buena tolerancia general a las sesiones"
					+ "y tendencia a hipertension ";
		}
		sc.close();
		
		return mensaje;
	}

	
	
	

}
