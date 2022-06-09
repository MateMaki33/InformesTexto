package accesoDatos;

import java.io.*;
import excepciones.*;
import gui.VentanaInformes;
import pacientes.*;

public class AccesoDatosImp implements IAccesoDatos {

	public AccesoDatosImp() {
	}

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
			salida.append("\n");
			salida.println(paciente.toString());
			salida.println(mensajeNormofuncion(paciente));
			salida.println(mensajePeso(VentanaInformes.peso));
			salida.println(mensajeEstabilidad(VentanaInformes.pacienteEstable));
			salida.println(mensajeCoagulacion(VentanaInformes.hemostasiaACV));
			salida.println(mensajeGlucemia(VentanaInformes.hipoGlucemia));
			salida.close();
			System.out.println("Se ha escrito informacion al archivo");
		} catch (IOException e) {

			e.printStackTrace();
			throw new EscrituraDatosEx("Excepcion al escribir:" + e.getMessage());
		}

	}

	public String mensajeNormofuncion(Paciente paciente) {
		String mensaje;
		if (paciente.getAccesoVascular().normoFunciona()) {
			mensaje = "Acceso vascular normofuncionante" + " " + "con flujo y presiones en rango";
		} else {
			mensaje = "Acceso vascular con signos de disfunción" + " " + "en base relación flujo y presiones";
		}
		return mensaje;
	}

	@Override
	public boolean existe(String nombreRecurso) {
		var recurso = new File(nombreRecurso);
		return recurso.exists();

	}

	@Override
	public void borrar(String nombreRecurso) {
		var recurso = new File(nombreRecurso);
		if (recurso.exists()) {
			recurso.delete();
			System.out.println("archivo borrado");
		}

	}

	@Override
	public Paciente crearPacienteFav(String nombre, int flujoint, int pvint, int paint) {
		AccesoVascular fistula = new Fistula();
		fistula.getNombre();
		fistula.setFlujo(flujoint);
		fistula.setPa(paint);
		fistula.setPv(pvint);

		return new Paciente(nombre, fistula);
	}

	@Override
	public Paciente crearPacienteCvc(String nombre, int flujoint, int pvint, int paint) {
		AccesoVascular cvc = new Cateter();
		cvc.getNombre();
		cvc.setFlujo(flujoint);
		cvc.setPa(paint);
		cvc.setPv(pvint);

		return new Paciente(nombre, cvc);
	}


	@Override
	public String mensajeGlucemia(boolean hipoglucemia) {
		String mensaje;
		if (hipoglucemia) {
			 mensaje = "Bajadas en la cifra de glucemia por debajo del rango o muy ajustadas, "
					+ "\nteniendo que administrar glucosa en ocasiones para evitar sintomatología";
		}else{
			mensaje = "No hay incidencias respecto cifras de glucemia";
		}
		return mensaje;

	}

	@Override
	public String mensajePeso(boolean peso) {
		String mensaje;
		if (peso==false) {
			mensaje = "Paciente con mal control de peso, con ganancias interdialisis elevadas. "
					+ "\nSe va por encima de peso seco pautado frecuentemente ";
		} else {
			mensaje = "Paciente con buen control de peso, con ganancias interdialisis moderadas. "
					+ "\nSe va en peso seco pautado frecuentemente ";
		}
		return mensaje;
	}

	@Override
	public String mensajeEstabilidad(boolean estable) {
		String mensaje;
		if(estable==true){
			mensaje="Paciente generalmente estable durante los tratamientos \ncon " +
					"buena tolerancia a las sesiones y sin incidencias a reportar";
		}else {
			mensaje="Paciente inestable, con incidencias reportadas en cuanto a tolerancia \nde " +
					"las sesiones. Manifestado con sintomatología asociada a la hipotensión";
		}
		return mensaje;
	}

	@Override
	public String mensajeCoagulacion(boolean coagulacion) {
		String mensaje;
		if (coagulacion) {
			mensaje = "Presenta dificultades a la hora de cuagular FAV. \nprecisando mas de 20 min " +
					"y en ocasiones aplicar medidas locales para favorecer la hemostasia";
		}else {
			mensaje = "No presenta dificultades para la hemostasia";
		}
		return mensaje;
	}

}
