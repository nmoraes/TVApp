package Gastos;

import java.util.ArrayList;

public class ColoccionTareas {

	
ArrayList<Tarea> coleccion = new ArrayList();



public ColoccionTareas(ArrayList<Tarea> coleccion) {
	super();
	this.coleccion = coleccion;
}	



public ColoccionTareas() {
	super();
}



public void agregarTarea(Tarea a){
	
	
	coleccion.add(a);
}



public ArrayList<Tarea> getColeccion() {
	return coleccion;
}








	
}
