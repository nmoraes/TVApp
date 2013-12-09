package Gastos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

import org.havi.ui.HContainer;
import org.havi.ui.HSinglelineEntry;
import org.havi.ui.HState;
import org.havi.ui.HStaticText;
import org.havi.ui.HVisible;

import persistencia.Persistir;
import mainXlet.*;


public class ContenedorGastos extends HContainer implements KeyListener {

	private Image fondo;
	
	
	// Pantalla de ingreso de gastos
	HStaticText titpulse = new HStaticText ("Pulse + para moverse");
	HStaticText titDetalle = new HStaticText ("Detalle de la compra");
	HStaticText titCantidad = new HStaticText ("Cant.");
	HStaticText titUnitario = new HStaticText ("Unit.");
	HStaticText titMonto = new HStaticText ("Monto");
		
	// estos strings son usado para guardar en disco lo escrito en pantalla
	private String detText = new String("  ");
	private String canText = "  ";
	private String uniText = "  ";
	private String monText = "  ";
	
	// estas cajas de texto muestran lo que el usuario va escribiendo en pantalla
	private HSinglelineEntry cajaDetalle;
	private HSinglelineEntry cajaCantidad;
	private HSinglelineEntry cajaUnitario;
	private HSinglelineEntry cajaMonto;
	private Persistir persistir = new Persistir();
	
	// Coleccion de gastos en memoria
	public ColeccionGastos ListaGastos = new ColeccionGastos();
	
	// Variables para hacer que el monto aparesca a partir de la cantidad X precioUnitario
	private float cantidad;
	private String aux;
	private String aux2;
	private float precioUnitario;
	private float total = 0;
	// Se usa para saber en que mes estamos
	private Date mesActual = new Date();
	// Esta variable hace que apraescan y desaparescan los enenos
	private Boolean primeraVez = true;

	// Primer pantalla de gastos!!!
	public ContenedorGastos(){
		
		ListaGastos = persistir.LeerGastos();
		
		 //cajas de texto
	    cajaDetalle = new HSinglelineEntry("", 30, 290, 250, 30, 12, new Font("Tiresias", Font.BOLD, 22), Color.blue);
	   	cajaDetalle.setType(org.havi.ui.HKeyboardInputPreferred.INPUT_ANY);
	   	cajaDetalle.setBackground(Color.white);
	  	cajaDetalle.setBackgroundMode(org.havi.ui.HVisible.BACKGROUND_FILL);
	  	cajaDetalle.setHorizontalAlignment(HVisible.HALIGN_CENTER);
	  	cajaDetalle.setEditMode(true);
	  	cajaDetalle.setCaretCharPosition(1);
	  	
	  	cajaCantidad = new HSinglelineEntry("", 280, 290, 45, 30, 3, new Font("Tiresias", Font.BOLD, 22), Color.blue);
	   	cajaCantidad.setType(org.havi.ui.HKeyboardInputPreferred.INPUT_ANY);
	   	cajaCantidad.setBackground(Color.white);
	  	cajaCantidad.setBackgroundMode(org.havi.ui.HVisible.BACKGROUND_FILL);
	  	cajaCantidad.setHorizontalAlignment(HVisible.HALIGN_CENTER);
	  	cajaCantidad.setEditMode(true);
	  	cajaCantidad.setCaretCharPosition(1);
	  	
	  	cajaUnitario = new HSinglelineEntry("", 325, 290, 65, 30, 5, new Font("Tiresias", Font.BOLD, 22), Color.blue);
	   	cajaUnitario.setType(org.havi.ui.HKeyboardInputPreferred.INPUT_ANY);
	   	cajaUnitario.setBackground(Color.white);
	  	cajaUnitario.setBackgroundMode(org.havi.ui.HVisible.BACKGROUND_FILL);
	  	cajaUnitario.setHorizontalAlignment(HVisible.HALIGN_CENTER);
	  	cajaUnitario.setEditMode(true);
	  	cajaUnitario.setCaretCharPosition(1);
	  	
	  	cajaMonto = new HSinglelineEntry("", 390, 290, 115, 30, 6, new Font("Tiresias", Font.BOLD, 22), Color.blue);
	   	cajaMonto.setType(org.havi.ui.HKeyboardInputPreferred.INPUT_ANY);
	   	cajaMonto.setBackground(Color.white);
	  	cajaMonto.setBackgroundMode(org.havi.ui.HVisible.BACKGROUND_FILL);
	  	cajaMonto.setHorizontalAlignment(HVisible.HALIGN_RIGHT);
	  	cajaMonto.setEditMode(true);
	  	cajaMonto.setCaretCharPosition(1);
	  			
		// tipo de letra
		
		titDetalle.setFont( new Font ("Tiresias", Font.BOLD, 22));
		titCantidad.setFont( new Font ("Tiresias", Font.BOLD, 22));
		titUnitario.setFont( new Font ("Tiresias", Font.BOLD, 22));
		titMonto.setFont( new Font ("Tiresias", Font.BOLD, 22));
		titpulse.setFont( new Font ("Tiresias", Font.BOLD, 22));
		titpulse.setForeground(Color.white);
		
		// Posicion inicial en la pantalla y color
	
		titDetalle.setBounds(30, 260, 250, 30);
		titCantidad.setBounds(280, 260, 50, 30);
		titUnitario.setBounds(330, 260, 75, 30);
		titMonto.setBounds(405, 260, 100, 30);
		titpulse.setBounds(400, 190, 250, 30);
		
		// Color de fondo

		titDetalle.setBackground(Color.blue);
		titCantidad.setBackground(Color.blue);
		titUnitario.setBackground(Color.blue);
		titMonto.setBackground(Color.blue);
		titpulse.setBackground(new Color(0, 0,0,0));
		
		// Agrego al contenedor
	
		this.add(titDetalle);
		this.add(titCantidad);
		this.add(titUnitario);
		this.add(titMonto);
		this.add(cajaDetalle);
		this.add(cajaCantidad);
		this.add(cajaUnitario);
		this.add(cajaMonto);
		this.add(titpulse);
		// Este titulo se vuelve visible solo cuando sale el teclado
		titpulse.setVisible(false);
		this.setBounds(0, 0, 800, 600);
		this.addKeyListener(this);
		// Funcion para cargar las imagenes
		loadForegroundBitmap();		
	}
		
	
	public void paint(Graphics graphics) {   
		
		if (fondo != null && primeraVez) {   
	        // Draw the image from the buffer   
			titpulse.setVisible(false);
			primeraVez = false;
			graphics.drawImage(fondo, 0, 0, null);
		}
				
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
	
	private void loadForegroundBitmap() {   
        // Create a MediaTracker to tell us when the image has loaded   
        MediaTracker tracker = new MediaTracker(this);   
        // Then load the image   
        fondo = Toolkit.getDefaultToolkit().getImage("Gastos1.jpg");   
             	
        
        // add the image to the MediaTracker...   
        tracker.addImage(fondo, 0); 
        
     //   tracker.addImage(image2, 1);
     
        // ...and wait for it to finish loading   
        try{   
            tracker.waitForAll();   
        }   
        catch(InterruptedException e) {   
            // Ignore the exception, since there's not a lot we can do.   
            fondo = null;
        } 
        
    }   		
	
	public void keyPressed(KeyEvent tecla){
		
		switch (tecla.getKeyCode()){
		
		case 404: 	// Boton Verde - Va para resumen Año
			
			MainXlet.gas.setVisible(false);
			MainXlet.anio.setVisible(true);
			MainXlet.anio.requestFocus();		
			LimpiarCajas();
			persistir.guardarGastos(ListaGastos);
			primeraVez = true;
			
			break;

		case 403: 	// Boton Rojo - llama al teclado
			
			titpulse.setVisible(true);
			super.paint(this.getGraphics());
			MainXlet.keyboard.setVisible(true);
			MainXlet.keyboard.requestFocus();	
			ContenedorKeyboard.invokeFather=Constant.GASTOS;
			
			break;
		
		case 405: 	// Boton Amarillo - Va para resumen gastos
			
			persistir.guardarGastos(ListaGastos);
			MainXlet.gas.setVisible(false);
			MainXlet.mes.cargarGastos(mesActual);
			MainXlet.mes.setVisible(true);
			MainXlet.mes.requestFocus();		
			LimpiarCajas();
			primeraVez = true;		
			this.repaint();
			
			break;
		
		case 406: // Boton Azul
			
			MainXlet.gas.setVisible(false);
			MainXlet.promedioAnio.setVisible(true);
			MainXlet.promedioAnio.requestFocus();		
			LimpiarCajas();
			persistir.guardarGastos(ListaGastos);
			primeraVez = true;
			
			break;
		
		case 27:	//exit
			
			LimpiarCajas();
			MainXlet.gas.setVisible(false);
			MainXlet.scene.requestFocus();
			MainXlet.miniWeather.setVisible(true);
			this.repaint();
			persistir.guardarGastos(ListaGastos);
			primeraVez = true;
			MainXlet.mainPage=true;
		
			break;	

						
		}
	}
	
	public void setPrimeraVez(Boolean f){
		primeraVez = f;
	}
	
	// Este metodo se invoca desde el contenedor teclado, cuando se va y guarda el gasto generado en la lista en memoria
	public void seVaElTeclado(){
				
		Gasto a = new Gasto(cajaDetalle.getTextContent(HState.ALL_STATES), cajaCantidad.getTextContent(HState.ALL_STATES), cajaUnitario.getTextContent(HState.ALL_STATES), String.valueOf(total));
		ListaGastos.agregarGasto(a);
		LimpiarCajas();
		
	}
	
	// Limpia las cajas de texto
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
			Float.parseFloat(s);
		} catch (Exception e) {
			return false;
		}
		return true;
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