package pacientes;

public abstract class AccesoVascular {
	
	protected String nombre;
	protected int flujo;
	protected int pv;
	protected int pa;
	protected boolean normofunciona;
	
	public AccesoVascular() {}
	
	public AccesoVascular(String nombre, int flujo, int pv, int pa) {
		this.nombre=nombre;
		this.flujo=flujo;
		this.pa=pa;
		this.pv=pv;
		
	}
	
	public abstract boolean normoFunciona();
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getFlujo() {
		return flujo;
	}

	public void setFlujo(int flujo) {
		this.flujo = flujo;
	}

	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}

	public int getPa() {
		return pa;
	}

	public void setPa(int pa) {
		this.pa = pa;
	}

	@Override
	public String toString() {
		return  "nombre :" + nombre +", flujo=" + flujo + ", pv=" + pv + ", pa=" + pa + "]";
	}

	
	


	
}
