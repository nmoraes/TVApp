package Gastos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;
import mainXlet.MainXlet;
import org.havi.ui.HContainer;
import org.havi.ui.HState;
import org.havi.ui.HStaticText;

public class ContenedorPromedioAnio extends HContainer implements KeyListener {

	// Pantalla Promedio del año//	
	HStaticText titulo2 = new HStaticText("2013");
	HStaticText promedio = new HStaticText("");
	HStaticText simboloPesos = new HStaticText("$");
	HStaticText promedioAnio = new HStaticText("Promedio del Año");
		
	private Image fondo;
	private Boolean primeraVez = true;
	// Esta variable hace que apraescan y desaparescan los enenos
	private Date mesActual = new Date();
		

	public ContenedorPromedioAnio() {

		// Tipo de letra
		
		titulo2.setFont(new Font("Tiresias", Font.BOLD, 28));
		promedio.setFont(new Font("Tiresias", Font.BOLD, 30));
		simboloPesos.setFont(new Font("Tiresias", Font.BOLD, 30));
		promedioAnio.setFont(new Font("Tiresias", Font.BOLD, 35));
		
		// Posicion inicial en la pantalla y color
	
		titulo2.setBounds(120, 190, 140, 30);
		promedio.setBounds(210, 370, 160, 34);
		promedioAnio.setBounds(150,320 , 280, 36);
		simboloPesos.setBounds(180, 373, 30, 30);		
		
		simboloPesos.setBackground(Color.black);
		simboloPesos.setBackground(new Color(0, 0, 0, 0));
		titulo2.setBackground(Color.white);
		titulo2.setForeground(Color.black);
	    promedio.setBackground(Color.white);
	    promedio.setForeground(Color.black);
		promedioAnio.setBackground(new Color(0, 0, 0, 0));
		promedioAnio.setForeground(Color.white);
				
		cargarTotales();

		this.add(titulo2);
		this.add(promedio);
		this.add(promedioAnio);
		this.add(simboloPesos);
				
		this.setBounds(0, 0, 800, 800);
		this.addKeyListener(this);
		loadForegroundBitmap();	

	}
	
	private void cargarTotales(){
		
		Date d = new Date();
		ArrayList<Gasto> listGastos = new ArrayList<Gasto>();
		float tot = 0;
		float resultado = 0;
		
		for (int i=0 ; i<12 ; i++){
			d.setMonth(i);
			listGastos = MainXlet.gas.ListaGastos.devolverMes(d);
			resultado = cargarTotal(listGastos.size(), listGastos);
			tot = resultado + tot;
		}
		tot = tot / 12;
		promedio.setTextContent(String.valueOf(tot), HState.ALL_STATES);
	}	
	
	private float cargarTotal(int tope, ArrayList<Gasto> listaGastos){
		
		float total = 0;
		String aux = "";
		
		for (int i = 0; i<tope ; i++){
			aux = listaGastos.get(i).getMonto();
			
			if (esNumero(aux)){
			
				total = total + Float.parseFloat(aux);
			}
		}
		
		return total;
	}
	
	private boolean esNumero(String s){
		try{
			Float.parseFloat(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public void paint(Graphics graphics) {  
	
		if (fondo != null && primeraVez) {   
	        // Draw the image from the buffer   
			primeraVez = false;
			graphics.drawImage(fondo, 0, 0, null);
		}
		
		super.paint(graphics);

	}
	
	private void loadForegroundBitmap() {   
        // Create a MediaTracker to tell us when the image has loaded   
        MediaTracker tracker = new MediaTracker(this);   
        // Then load the image   
        fondo = Toolkit.getDefaultToolkit().getImage("promedioMes.jpg");   
             	
        
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
	
	public void keyPressed(KeyEvent tecla) {

		switch (tecla.getKeyCode()) {

		case 404: // Boton Verde Va para Resumen Año
			
			MainXlet.promedioAnio.setVisible(false);
			MainXlet.anio.setVisible(true);
			MainXlet.anio.requestFocus();
			primeraVez = true;
			break;

		case 403: // Boton Rojo Va para Resumen Mes
			
			MainXlet.promedioAnio.setVisible(false);
			MainXlet.mes.cargarGastos(mesActual);
			MainXlet.mes.setVisible(true);
			MainXlet.mes.requestFocus();
			primeraVez = true;
			break;

		case 405: // Boton Amarillo Va para Menu compras

			MainXlet.promedioAnio.setVisible(false);
			MainXlet.gas.setVisible(true);
			MainXlet.gas.requestFocus();
			primeraVez = true;
			break;

		case 406: // Boton Azul
			
			break;

		case 27: // exit
			MainXlet.promedioAnio.setVisible(false);
			MainXlet.scene.requestFocus();
			primeraVez = true;
			MainXlet.mainPage=true;
			break;

		default: { // do nothing
			System.out.println("default case ...");
			System.out.println(tecla);
			break;
			}

		}
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
