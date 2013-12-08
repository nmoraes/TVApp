package tareas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import persistencia.Persistir;

public class ControladorTareas {

	private Calendar dia=new GregorianCalendar(new Locale("es", "UY"));
	private List<Tarea> tareas=new ArrayList<Tarea>();
	public int darDia(){
		return dia.get(Calendar.DATE);
	}
	public String darMes(){
		return new SimpleDateFormat("MMM").format(dia.getTime());
	}
	public int darAnio(){
		return dia.get(Calendar.YEAR);
	}
	public void sumaDia(){
		dia.add(Calendar.DATE, 1);
	}
	public void restaDia(){
		/*Controlo que el dia no sea menor al dia actual*/
		Calendar aux=Calendar.getInstance();
		if(dia.compareTo(aux)>0){
			dia.add(Calendar.DATE, -1);
		}
	}
	public void sumaMes(){
		dia.add(Calendar.MONTH, 1);
	}
	public void restaMes(){
		/*Controlo que el dia no sea menor al dia actual*/
		Calendar aux=Calendar.getInstance();
		if(dia.compareTo(aux)>0){
			dia.add(Calendar.MONTH, -1);
		}
	}
	
	public void sumaAnio(){
		dia.add(Calendar.YEAR, 1);
	}
	public void restaAnio(){
		/*Controlo que el dia no sea menor al dia actual*/
		Calendar aux=Calendar.getInstance();
		if(dia.compareTo(aux)>0){
			dia.add(Calendar.YEAR, -1);
		}
	}
	
	
	public void crearTarea(String tarea){
		tareas.add(new Tarea(dia.get(Calendar.DATE), dia.get(Calendar.MONTH), dia.get(Calendar.YEAR), tarea));
		//ordeno las tareas a medida que se van agregando
		Collections.sort(tareas, new Comparator<Tarea>(){
			public int compare(Tarea t1, Tarea t2) {
				return t1.compareTo(t2);
			}
		});
	}
	public void guardarTareas(){
		Persistir p= new Persistir();
		p.persistirTareas(tareas);
	}
	public void listar(){
		for (Tarea t : tareas) {
			System.out.println(t.getTarea());
		}
	}
	public void cargarTareas(){
		Persistir p=new Persistir();
		tareas=p.leerTareas();
	}
	public List<Tarea> getTareas() {
		return tareas;
	}
	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}
	public static void main(String[] args) {
		ControladorTareas ct=new ControladorTareas();
		System.out.println("dia "+ct.darDia());
		System.out.println("mes "+ct.darMes());
		System.out.println("año "+ct.darAnio());
		ct.sumaMes();
		ct.crearTarea("3");
		ct.restaMes();
		ct.crearTarea("1");
		ct.sumaMes();
		ct.restaDia();
		ct.crearTarea("2");
		ct.listar();
		ct.guardarTareas();
	}
}
