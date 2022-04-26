package negocio;


import accesoDatos.*;
import excepciones.*;
import pacientes.*;

public class AccesoInformesImp implements IAccesoInformes {

	private final IAccesoDatos datos;

	public AccesoInformesImp() {
		this.datos = new AccesoDatosImp();
	}

	@Override
	public void iniciarInforme() {
		try {
			if (this.datos.existe(NOMBRE_RECURSO)) {
				this.datos.borrar(NOMBRE_RECURSO);
				this.datos.crearFichero(NOMBRE_RECURSO);
			} else {
				this.datos.crearFichero(NOMBRE_RECURSO);
			}

		} catch (AccesoDatosEx e) {
			System.out.println("ERROR DE INICIO DE INFORME");
			e.printStackTrace(System.out);

		}
	}

	@Override
	public void agregarPaciente(String NOMBRE_RECURSO, Paciente paciente) {

		try {
			this.datos.escribirPaciente(NOMBRE_RECURSO, paciente, false);
			
		} catch (EscrituraDatosEx e) {
			e.printStackTrace();
		}

	}

	@Override
	public Paciente crearPacienteFav(String nombre) {
		return this.datos.crearPacienteFav(nombre);
		
	}

	@Override
	public Paciente crearPacienteCvc(String nombre) {
		return this.datos.crearPacienteCvc(nombre);		
	}

}
