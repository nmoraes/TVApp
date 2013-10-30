package Gastos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import org.havi.ui.HContainer;
import org.havi.ui.HStaticText;

import mainXlet.*;


public class ContenedorGastos extends HContainer implements KeyListener {

	// Teclado
	//ContenedorKeyboard keyboard = new ContenedorKeyboard();

	
	//TODO
	private Image fondo;
	
	// Pantalla de ingreso de gastos
	
	HStaticText resumenA�o = new HStaticText ("Resumen A�o");
	HStaticText resumenMes = new HStaticText ("Resumen Mes");
	HStaticText titDetalle = new HStaticText ("Detalle de la compra");
	HStaticText titCantidad = new HStaticText ("Cant.");
	HStaticText titUnitario = new HStaticText ("Unit.");
	HStaticText titMonto = new HStaticText ("Monto");
	
	JTextField detCompra = new JTextField(20);
	JTextField canCompra = new JTextField(20);
	JTextField uniCompra = new JTextField(20);
	JTextField monCompra = new JTextField(20);

	// Primer pantalla de gastos!!!
	public ContenedorGastos(){
		// tipo de letra
		resumenA�o.setFont( new Font ("Tiresias", Font.BOLD, 20));
		resumenMes.setFont( new Font ("Tiresias", Font.BOLD, 20));
		titDetalle.setFont( new Font ("Tiresias", Font.BOLD, 20));
		titCantidad.setFont( new Font ("Tiresias", Font.BOLD, 20));
		titUnitario.setFont( new Font ("Tiresias", Font.BOLD, 20));
		titMonto.setFont( new Font ("Tiresias", Font.BOLD, 20));
		
		
		// Posicion inicial en la pantalla y color
		resumenA�o.setBounds(50, 200, 140, 30);
		resumenMes.setBounds(250, 200, 140, 30);
		titDetalle.setBounds(50, 300, 240, 30);
		titCantidad.setBounds(290, 300, 45, 30);
		titUnitario.setBounds(335, 300, 45, 30);
		titMonto.setBounds(380, 300, 65, 30);
		
		// Color de fondo
		resumenA�o.setBackground(Color.red);
		resumenMes.setBackground(Color.green);
		titDetalle.setBackground(Color.blue);
		titCantidad.setBackground(Color.blue);
		titUnitario.setBackground(Color.blue);
		titMonto.setBackground(Color.blue);
		
		
		// Agrego al contenedor
		this.add(resumenA�o);
		this.add(resumenMes);
		this.add(titDetalle);
		this.add(titCantidad);
		this.add(titUnitario);
		this.add(titMonto);
		
		// Textfields
		detCompra.setBounds(50, 350, 240, 20); detCompra.setBackground(Color.white); this.add(detCompra);
		
		
		canCompra.setBounds(290, 350, 45, 20); canCompra.setBackground(Color.white); this.add(canCompra);
		uniCompra.setBounds(335, 350, 45, 20); uniCompra.setBackground(Color.white); this.add(uniCompra);
		monCompra.setBounds(380, 350, 65, 20); monCompra.setBackground(Color.white); this.add(monCompra);
		
		loadForegroundBitmap(); 
	       
		this.setBounds(0, 0, 800, 800);
		this.addKeyListener(this);
		
		
	}
	
	public void loadForegroundBitmap() {   
        // creamos un media tracker q nos dice si la imagen fue cargada  
        MediaTracker tracker = new MediaTracker(this);   
        // Carga la imagen  
       fondo = Toolkit.getDefaultToolkit().getImage("logoUDE.png");   
      
       System.out.println("carga imagen");     	
       
       
        // add the image to the MediaTracker...   
        tracker.addImage(fondo, 0);
  

        try{   
            tracker.waitForAll();   
        }   
        catch(InterruptedException e) {   
            // Ignore the exception, since there's not a lot we can do.   
            fondo = null; 
        
        }   
    }   
	
	
	 public void paint(Graphics graphics) {   
		   if (fondo != null) {   
            // Draw the image from the buffer 
			   System.out.println("no es null la imagen"); 
            graphics.drawImage(fondo, 100, 7, null);      }
        canCompra.setText("  ");
        uniCompra.setText("  ");
		  		 
		 System.out.println("hola paint");
		 //detCompra.setText(ContenedorKeyboard.message);
	    
	      


	    }   
	
	
	
	public void keyPressed(KeyEvent tecla){
		
		System.out.println("Prueba!!!");
		

		detCompra.setText(ContenedorKeyboard.message);
		
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
			System.out.println("Va para Resumen A�o");
			MainXlet.gas.setVisible(false);
			MainXlet.anio.setVisible(true);
			MainXlet.anio.requestFocus();		
			MainXlet.label.setBackground(Color.red);
			MainXlet.label.repaint();
			break;
		
		case 405: 	// Boton Amarillo
			this.repaint();
			break;
		
		case 406: 	// Boton Azul
			this.repaint();
			break;
		
		case 27:	//exit
			fondo = null;
			MainXlet.label.setBackground(Color.white);
			MainXlet.gas.setVisible(false);
			MainXlet.label.repaint();
			MainXlet.scene.requestFocus();
			this.repaint();
			break;	

		default: {	// do nothing
			System.out.println("default case ...");
			System.out.println(tecla);
			break;
		}
						
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}

