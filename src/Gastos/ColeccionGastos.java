package Gastos;

import java.util.ArrayList;
import java.util.Date;

public class ColeccionGastos {

	
ArrayList<Gasto> coleccion = new ArrayList();



public ColeccionGastos(ArrayList<Gasto> coleccion) {
	super();
	this.coleccion = coleccion;
}	


public ColeccionGastos() {
	super();
}


public void agregarGasto(Gasto a){
	coleccion.add(a);
}

@SuppressWarnings("deprecation")
public ArrayList<Gasto>	devolverMes (Date mes){
	ArrayList<Gasto> resultado = new ArrayList();
	int cont;
	
	for( cont=0; cont < coleccion.size() ; cont++){
		if (coleccion.get(cont).getFecha().getMonth() == mes.getMonth() && coleccion.get(cont).getFecha().getYear() == mes.getYear()){
			resultado.add(coleccion.get(cont));
		}
	}
	
	return resultado;
}


public ArrayList<Gasto> getColeccion() {
	return coleccion;
}
	
}
