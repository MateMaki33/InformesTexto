package pacientes;

import java.util.Scanner;

public class Fistula extends AccesoVascular {
	Scanner sc=new Scanner (System.in);
	private static final String nom="FAV";

	public Fistula() {
	 this.nombre=nom;

	}
	
	

	@Override
	public String toString() {
		return "Fistula [" + super.toString() ;
	}



	
	public boolean normoFunciona() {
		boolean normofunciona=false;
		if (this.flujo >350 && this.pv < 280 && this.pa > -280 && this.pa <-100){
			normofunciona=true;
		}else normofunciona =false;
		return normofunciona;
	}

	

	

}
