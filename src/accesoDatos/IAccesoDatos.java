package accesoDatos;

import javax.swing.JTextField;

import excepciones.*;
import pacientes.*;

public interface IAccesoDatos {

	boolean existe(String nombreRecurso) throws AccesoDatosEx;

	void crearFichero(String nombreFichero) throws AccesoDatosEx;

	void escribirPaciente(String nombreFichero, Paciente paciente, boolean anexar) throws EscrituraDatosEx;

	String mensajeNormofuncion(Paciente paciente);

	
	public void borrar(String nombreRecurso) throws AccesoDatosEx;
	
	Paciente crearPacienteFav(String nombre, int flujoint, int pvint, int paint);
	
	Paciente crearPacienteCvc(String nombre, int flujoint, int pvint, int paint);
	
	

}
