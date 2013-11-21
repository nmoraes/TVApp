package tareas;

import java.io.Serializable;
import java.util.Calendar;

public class Tarea implements Serializable{

	private static final long serialVersionUID = 1L;
	private int dia;
	private int mes;
	private int anio;
	private String tarea;
	
	public Tarea(int dia, int mes, int anio, String tarea) {
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
		this.tarea = tarea;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public String getTarea() {
		return tarea;
	}
	public void setTarea(String tarea) {
		this.tarea = tarea;
	}
	
	public int compareTo(Tarea t2){
		Calendar c=Calendar.getInstance();
		c.set(anio, mes, dia);
		Calendar c2=Calendar.getInstance();
		c2.set(t2.getAnio(), t2.getMes(), t2.getDia());
		return c.compareTo(c2);
	}
}
