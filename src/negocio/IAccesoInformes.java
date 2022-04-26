package negocio;


import pacientes.Paciente;

public interface IAccesoInformes {
	
String NOMBRE_RECURSO = "informe.txt";
	
	
	
	void iniciarInforme();
	
	void agregarPaciente(String NOMBRE_RECURSO, Paciente paciente);

    Paciente crearPacienteFav(String nombre);
	
	Paciente crearPacienteCvc(String nombre);
	
	
}
