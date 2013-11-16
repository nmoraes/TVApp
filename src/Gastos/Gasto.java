package Gastos;

import java.io.Serializable;
import java.util.Date;

public class Gasto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String Detalle;
	private String Cantidad;
	private String Unitario;
	private String Monto;
	private Date d;
	
	public Gasto(String detalle, String cantidad, String unitario, String monto) {
		super();
		Detalle = detalle;
		Cantidad = cantidad;
		Unitario = unitario;
		Monto = monto;
		d = new Date();
	}
	
	public Gasto() {
		// TODO Auto-generated constructor stub
	}

	public String getDetalle() {
		return Detalle;
	}

	public void setDetalle(String detalle) {
		Detalle = detalle;
	}

	public String getCantidad() {
		return Cantidad;
	}

	public void setCantidad(String cantidad) {
		Cantidad = cantidad;
	}

	public String getUnitario() {
		return Unitario;
	}

	public void setUnitario(String unitario) {
		Unitario = unitario;
	}

	public String getMonto() {
		return Monto;
	}

	public void setMonto(String monto) {
		Monto = monto;
	}
	
	public Date getFecha(){
		return d;		
	}
	
	public void setFecha(Date fecha){
		d = fecha;
	}

}
