package accesoDatos;

import javax.swing.JTextField;

import excepciones.*;
import pacientes.*;

public interface IAccesoDatos {

	boolean existe(String nombreRecurso);

	void crearFichero(String nombreFichero) throws AccesoDatosEx;

	void escribirPaciente(String nombreFichero, Paciente paciente, boolean anexar) throws EscrituraDatosEx;

	String mensajeNormofuncion(Paciente paciente);

    String mensajeEstabilidad(boolean hipoTa);

    String mensajeCoagulacion(boolean coagulacion);

	String mensajeGlucemia(boolean hipoglucemia);
	String mensajePeso(boolean peso);

	
	void borrar(String nombreRecurso);
	
	Paciente crearPacienteFav(String nombre, int flujoint, int pvint, int paint);
	
	Paciente crearPacienteCvc(String nombre, int flujoint, int pvint, int paint);
	
	
	

}
