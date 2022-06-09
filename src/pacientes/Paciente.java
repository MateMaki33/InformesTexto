package pacientes;
import gui.VentanaInformes;

public class Paciente {
	
	private String nombre;
	private AccesoVascular accesoVascular;
	private VentanaInformes obj= new VentanaInformes();
	
    public Paciente() {}
	
	public Paciente (String nombre, AccesoVascular accesoVascular) {
		this.nombre=nombre;
		this.accesoVascular=accesoVascular;
	}
	public AccesoVascular getAccesoVascular() {
		return this.accesoVascular;
	}

	public void setAccesoVascular(AccesoVascular accesoVascular) {
		this.accesoVascular = accesoVascular;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = obj.getNombretxt();
	}
	
	@Override
	public String toString() {
		return "Paciente"+ "\n" +  nombre + "\n "  + "[" + accesoVascular.toString() +"]";
	}

}
