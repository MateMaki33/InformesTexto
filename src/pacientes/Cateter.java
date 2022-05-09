package pacientes;

import java.util.Scanner;

public class Cateter extends AccesoVascular {
	
	Scanner sc=new Scanner (System.in);
	private static final String nom="CVC";

	public Cateter() {
		 this.nombre=nom;
		 
	}

	@Override
	public String toString() {
		return "Cateter [" + super.toString() ;
	}
	
	public boolean normoFunciona() {
		boolean normofunciona=false;
		if (this.flujo >300 && this.pv < 280 && this.pa > -280 && this.pa <-100){
			normofunciona=true;
		}else normofunciona =false;
		return normofunciona;
	}

}
