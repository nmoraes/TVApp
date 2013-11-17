package Gastos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import org.havi.ui.HContainer;
import org.havi.ui.HSinglelineEntry;
import org.havi.ui.HState;
import org.havi.ui.HStaticText;
import org.havi.ui.HVisible;

import persistencia.Persistir;
import mainXlet.*;


public class ContenedorGastos extends HContainer implements KeyListener {

	// Teclado
	//ContenedorKeyboard keyboard = new ContenedorKeyboard();
	// Agregar los labels al repaint
	// Arreglar q solo se pueda escribir hasta el tope de los textbox
	// Darle un formato mas lindo
	// Agrandar los textos
	// Guardar en disco
	// El monto debe calcularse a partir del precio unitario y de la cantidad
	

	
	//TODO
	private Image fondo;
	private Image fondo2;
	
	// Pantalla de ingreso de gastos
	
	HStaticText resumenAño = new HStaticText ("Resumen Año");
	HStaticText resumenMes = new HStaticText ("Resumen Mes");
	HStaticText titDetalle = new HStaticText ("Detalle de la compra");
	HStaticText titCantidad = new HStaticText ("Cant.");
	HStaticText titUnitario = new HStaticText ("Unit.");
	HStaticText titMonto = new HStaticText ("Monto");

	// estos strings son usado para guardar en disco lo escrito en pantalla
	private String detText = new String(".  ");
	private String canText = ".  ";
	private String uniText = ".  ";
	private String monText = ".  ";
	
	// estas cajas de texto muestran lo que el usuario va escribiendo en pantalla
	private HSinglelineEntry cajaDetalle;
	private HSinglelineEntry cajaCantidad;
	private HSinglelineEntry cajaUnitario;
	private HSinglelineEntry cajaMonto;
	private Persistir persistir = new Persistir();
	// Coleccion de gastos en memoria
	private ColeccionGastos ListaGastos = new ColeccionGastos();
	
	// Variables para hacer que el monto aparesca a partir de la cantidad X precioUnitario
	private float cantidad;
	private String aux;
	private String aux2;
	private float precioUnitario;
	private float total = 0;
	

	// Primer pantalla de gastos!!!
	public ContenedorGastos(){
		
		ListaGastos = persistir.LeerGastos();
		
		 //cajas de texto
	    cajaDetalle = new HSinglelineEntry("", 40, 290, 194, 30, 12, new Font("Tiresias", Font.BOLD, 22), Color.blue);
	   	cajaDetalle.setType(org.havi.ui.HKeyboardInputPreferred.INPUT_ANY);
	   	cajaDetalle.setBackground(Color.white);
	  	cajaDetalle.setBackgroundMode(org.havi.ui.HVisible.BACKGROUND_FILL);
	  	cajaDetalle.setHorizontalAlignment(HVisible.HALIGN_CENTER);
	  	cajaDetalle.setEditMode(true);
	  	cajaDetalle.setCaretCharPosition(1);
	  	
	  	cajaCantidad = new HSinglelineEntry("", 270, 290, 45, 30, 3, new Font("Tiresias", Font.BOLD, 22), Color.blue);
	   	cajaCantidad.setType(org.havi.ui.HKeyboardInputPreferred.INPUT_ANY);
	   	cajaCantidad.setBackground(Color.white);
	  	cajaCantidad.setBackgroundMode(org.havi.ui.HVisible.BACKGROUND_FILL);
	  	cajaCantidad.setHorizontalAlignment(HVisible.HALIGN_CENTER);
	  	cajaCantidad.setEditMode(true);
	  	cajaCantidad.setCaretCharPosition(1);
	  	
	  	cajaUnitario = new HSinglelineEntry("", 325, 290, 55, 30, 5, new Font("Tiresias", Font.BOLD, 22), Color.blue);
	   	cajaUnitario.setType(org.havi.ui.HKeyboardInputPreferred.INPUT_ANY);
	   	cajaUnitario.setBackground(Color.white);
	  	cajaUnitario.setBackgroundMode(org.havi.ui.HVisible.BACKGROUND_FILL);
	  	cajaUnitario.setHorizontalAlignment(HVisible.HALIGN_CENTER);
	  	cajaUnitario.setEditMode(true);
	  	cajaUnitario.setCaretCharPosition(1);
	  	
	  	cajaMonto = new HSinglelineEntry("", 380, 290, 95, 30, 6, new Font("Tiresias", Font.BOLD, 22), Color.blue);
	   	cajaMonto.setType(org.havi.ui.HKeyboardInputPreferred.INPUT_ANY);
	   	cajaMonto.setBackground(Color.white);
	  	cajaMonto.setBackgroundMode(org.havi.ui.HVisible.BACKGROUND_FILL);
	  	cajaMonto.setHorizontalAlignment(HVisible.HALIGN_CENTER);
	  	cajaMonto.setEditMode(true);
	  	cajaMonto.setCaretCharPosition(1);
	  			
		// tipo de letra
		resumenAño.setFont( new Font ("Tiresias", Font.BOLD, 20));
		resumenMes.setFont( new Font ("Tiresias", Font.BOLD, 20));
		titDetalle.setFont( new Font ("Tiresias", Font.BOLD, 20));
		titCantidad.setFont( new Font ("Tiresias", Font.BOLD, 20));
		titUnitario.setFont( new Font ("Tiresias", Font.BOLD, 20));
		titMonto.setFont( new Font ("Tiresias", Font.BOLD, 20));
		
		// Posicion inicial en la pantalla y color
		resumenAño.setBounds(30, 140, 140, 30);
		resumenMes.setBounds(240, 140, 140, 30);
		titDetalle.setBounds(30, 260, 240, 30);
		titCantidad.setBounds(270, 260, 55, 30);
		titUnitario.setBounds(325, 260, 65, 30);
		titMonto.setBounds(380, 260, 95, 30);
		
		// Color de fondo
		resumenAño.setBackground(Color.red);
		resumenMes.setBackground(Color.green);
		titDetalle.setBackground(Color.blue);
		titCantidad.setBackground(Color.blue);
		titUnitario.setBackground(Color.blue);
		titMonto.setBackground(Color.blue);
		
		// Agrego al contenedor
		this.add(resumenAño);
		this.add(resumenMes);
		this.add(titDetalle);
		this.add(titCantidad);
		this.add(titUnitario);
		this.add(titMonto);
		this.add(cajaDetalle);
		this.add(cajaCantidad);
		this.add(cajaUnitario);
		this.add(cajaMonto);		
		
		this.setBounds(0, 0, 800, 800);
		this.addKeyListener(this);
				
	}
		
	
	public void paint(Graphics graphics) {   
				
		switch(ContenedorKeyboard.navegadorTextGastos){
		
		case 0:	cajaDetalle.setTextContent(ContenedorKeyboard.message, HState.ALL_STATES);				
			
			break;
			
		case 1: cajaCantidad.setTextContent(ContenedorKeyboard.message, HState.ALL_STATES);
			
			break;
			
		case 2: cajaUnitario.setTextContent(ContenedorKeyboard.message, HState.ALL_STATES);
				
				// Mostrar el total a partir del precio unitario y la cantidad
				if (("" != cajaUnitario.getTextContent(HState.ALL_STATES)) && (" " != cajaUnitario.getTextContent(HState.ALL_STATES))){      
					if (esNumero(cajaUnitario.getTextContent(HState.ALL_STATES))){
						aux = cajaCantidad.getTextContent(HState.ALL_STATES);
						cantidad = Float.parseFloat(aux);
						aux2 = cajaUnitario.getTextContent(HState.ALL_STATES);
						precioUnitario = Float.parseFloat(aux2);
						total = cantidad * precioUnitario;
					}
				}
			break;
		
		default:
			System.out.println("Error!!!");
			break;
		
		}
		
		
		cajaMonto.setTextContent(String.valueOf(total), HState.ALL_STATES);
		
		
		super.paint(graphics);
		
		
	 }   
		
	
	public void keyPressed(KeyEvent tecla){
		
		System.out.println("Prueba!!!");
		

		switch (tecla.getKeyCode()){
		
		case 404: 	// Boton Verde
			System.out.println("Va para Resumen Gastos");
			MainXlet.gas.setVisible(false);
			MainXlet.mes.setVisible(true);
			MainXlet.mes.requestFocus();		
			MainXlet.label.setBackground(Color.darkGray);
			MainXlet.label.repaint();
			
			this.repaint();
			
			break;

		case 403: 	// Boton Rojo
			System.out.println("Va para Resumen Año");
			MainXlet.gas.setVisible(false);
			MainXlet.anio.setVisible(true);
			MainXlet.anio.requestFocus();		
			MainXlet.label.setBackground(Color.red);
			MainXlet.label.repaint();
			break;
		
		case 405: 	// Boton Amarillo
			System.out.println("llamamos al teclado desde gastos");
			MainXlet.keyboard.setVisible(true);
			MainXlet.keyboard.requestFocus();	
			ContenedorKeyboard.invokeFather=Constant.GASTOS;
			this.repaint();
			break;
		
		case 406: // Boton Azul
			
			break;
		
		case 27:	//exit
			LimpiarCajas();
			MainXlet.label.setBackground(Color.white);
			MainXlet.gas.setVisible(false);
			MainXlet.label.repaint();
			MainXlet.scene.requestFocus();
			this.repaint();
			persistir.guardarGastos(ListaGastos);
			System.out.println("Boton de persistencia!!");
		
			break;	

		
		case 427:	// + 
				
			break;		
						
		default: {	// do nothing
			System.out.println("default case ...");
			System.out.println(tecla);
			break;
		}
						
		}
	}
	public void seVaElTeclado(){
		if (ListaGastos.getColeccion().isEmpty()){
			System.out.println(" Esta Vacia");
		}else{
			System.out.println("Esta llena");
		}
		
		Gasto a = new Gasto(cajaDetalle.getTextContent(HState.ALL_STATES), cajaCantidad.getTextContent(HState.ALL_STATES), cajaUnitario.getTextContent(HState.ALL_STATES), String.valueOf(total));
		ListaGastos.agregarGasto(a);
//		monText = String.valueOf(total);
//		InsertarGasto();
		System.out.println("El Tamaño de la lista: " + ListaGastos.getColeccion().size());
		
		LimpiarCajas();
	}
	
	private void LimpiarCajas(){
		// Borro todas las cajas de texto.
		cajaDetalle.setTextContent(" ", HState.ALL_STATES);
		cajaCantidad.setTextContent(" ", HState.ALL_STATES);
		cajaUnitario.setTextContent(" ", HState.ALL_STATES);
		cajaMonto.setTextContent(" ", HState.ALL_STATES);
		// Vuelvo el navegador de cajas de texto a la posiscion inicial para que arranque en "Detalle"
		ContenedorKeyboard.navegadorTextGastos = 0;
		// Borrar total
		total = 0;
		
	}
	// Si el string es un numero valido devuelve true, de lo contrario devuelve false
	private boolean esNumero(String s){
		try{
			Long.parseLong(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	// Ingresa una neuva tarea al arreglo de tareas.
	private void InsertarGasto(){
		Gasto a = new Gasto(detText, canText, uniText, monText);
		ListaGastos.agregarGasto(a);		

	}
	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void setDetText(String s){
		detText = s;
	}
	
	public void setCanText(String s){
		canText = s;
	}
	
	public void setUniText(String s){
		uniText = s;
	}
	
	public void setMonText(String s){
		monText = s;
	}
	

	public String getDetText() {
		return detText;
	}

	public String getCanText() {
		return canText;
	}

	public String getUniText() {
		return uniText;
	}

	public String getMonText() {
		return monText;
	}

	
}