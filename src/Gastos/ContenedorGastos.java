package Gastos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JTextField;

import org.havi.ui.HContainer;
import org.havi.ui.HStaticText;

import mainXlet.*;


public class ContenedorGastos extends HContainer implements KeyListener {

	// Teclado
	//ContenedorKeyboard keyboard = new ContenedorKeyboard();
	// Agregar los labels al repaint
	// Arreglar q solo se pueda escribir hasta el tope de los textbox
	// Darle un formato mas lindo
	// Agrandar los textos
	// Guardar en disco
	

	
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
	
	public static JTextField detCompra = new JTextField(20);
	public static JTextField canCompra = new JTextField(20);
	public static JTextField uniCompra = new JTextField(20);
	public static JTextField monCompra = new JTextField(20);
	private String detText = "  ";
	private String canText = "  ";
	private String uniText = "  ";
	private String monText = "  ";
	
	

	// Primer pantalla de gastos!!!
	public ContenedorGastos(){
		
		// tipo de letra
		resumenAño.setFont( new Font ("Tiresias", Font.BOLD, 20));
		resumenMes.setFont( new Font ("Tiresias", Font.BOLD, 20));
		titDetalle.setFont( new Font ("Tiresias", Font.BOLD, 20));
		titCantidad.setFont( new Font ("Tiresias", Font.BOLD, 20));
		titUnitario.setFont( new Font ("Tiresias", Font.BOLD, 20));
		titMonto.setFont( new Font ("Tiresias", Font.BOLD, 20));
		
		
		// Posicion inicial en la pantalla y color
		resumenAño.setBounds(50, 200, 140, 30);
		resumenMes.setBounds(250, 200, 140, 30);
		titDetalle.setBounds(50, 300, 240, 30);
		titCantidad.setBounds(290, 300, 45, 30);
		titUnitario.setBounds(335, 300, 45, 30);
		titMonto.setBounds(380, 300, 65, 30);
		
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
		
		// Textfields
		detCompra.setBounds(50, 300, 240, 20); detCompra.setBackground(Color.white); this.add(detCompra);	
		canCompra.setBounds(290, 300, 45, 20); canCompra.setBackground(Color.white); this.add(canCompra);
		uniCompra.setBounds(335, 300, 45, 20); uniCompra.setBackground(Color.white); this.add(uniCompra);
		monCompra.setBounds(380, 300, 65, 20); monCompra.setBackground(Color.white); this.add(monCompra);
		
		//loadForegroundBitmap(); 
	       
		this.setBounds(0, 0, 800, 800);
		this.addKeyListener(this);
		
		
	}
	
  
	
	
	
	
	 public void paint(Graphics graphics) {   


      
		// Vuelvo a dibujar los componentes
		//canCompra.setText("  ");
        //uniCompra.setText("  ");
        //monCompra.setText("  ");
		//detCompra.setText("  ");
		
		resumenAño.setVisible(true);
		//HStaticText resumenMes = new HStaticText ("Resumen Mes");
		//HStaticText titDetalle = new HStaticText ("Detalle de la compra");
		//HStaticText titCantidad = new HStaticText ("Cant.");
		//HStaticText titUnitario = new HStaticText ("Unit.");
		//HStaticText titMonto = new HStaticText ("Monto");
		 System.out.println("hola paint");
		 detCompra.setText(detText);	
		 uniCompra.setText(uniText);
		 monCompra.setText(monText);
		 canCompra.setText(canText);
					
				switch(ContenedorKeyboard.navegadorTextGastos){
					
				case 0:	
						detCompra.setText(ContenedorKeyboard.message);
						
					break;
					
				case 1:
						canCompra.setText(ContenedorKeyboard.message);
					
					break;
					
				case 2: 
						uniCompra.setText(ContenedorKeyboard.message);
			
					break;
				case 3: 
				        monCompra.setText(ContenedorKeyboard.message);
			
				    break;
				
				default:
					System.out.println("Error!!!");
					break;
				}
	      


	    }   
	 
		
	
	public void keyPressed(KeyEvent tecla){
		
		System.out.println("Prueba!!!");
		

		detCompra.setText(ContenedorKeyboard.message);
		
		switch (tecla.getKeyCode()){
		
//		case 404: 	// Boton Verde
//			System.out.println("Va para Resumen Gastos");
//			MainXlet.gas.setVisible(false);
//			MainXlet.mes.setVisible(true);
//			MainXlet.mes.requestFocus();		
//			MainXlet.label.setBackground(Color.darkGray);
//			MainXlet.label.repaint();
//			
//			this.repaint();
//			
//			break;

//		case 403: 	// Boton Rojo
//			System.out.println("Va para Resumen Año");
//			MainXlet.gas.setVisible(false);
//			MainXlet.anio.setVisible(true);
//			MainXlet.anio.requestFocus();		
//			MainXlet.label.setBackground(Color.red);
//			MainXlet.label.repaint();
//			break;
		
//		case 405: 	// Boton Amarillo
//			System.out.println("llamamos al teclado desde gastos");
//			MainXlet.keyboard.setVisible(true);
//			MainXlet.keyboard.requestFocus();	
//			ContenedorKeyboard.invokeFather=Constant.GASTOS;
//			detCompra.setText(ContenedorKeyboard.message);
//			break;
		
		case 406: 
			
			// Boton Azul
			System.out.println("boton azul llama al teclado ...");
			MainXlet.keyboard.setVisible(true);
			MainXlet.keyboard.requestFocus();	
			ContenedorKeyboard.invokeFather=Constant.GASTOS;

			this.repaint();
			break;
		
		case 27:	//exit
			MainXlet.label.setBackground(Color.white);
			MainXlet.gas.setVisible(false);
			MainXlet.label.repaint();
			MainXlet.scene.requestFocus();
			this.repaint();
			break;	

		
		case 427:	// + 
			
			Properties properties = new Properties();
			try {
				System.out.println("guardando....");
				properties.load(new FileInputStream("tareas.database"));
				properties.setProperty("campo1", "PEPE");
				properties.setProperty("campo2", getCanText());
				properties.setProperty("campo3", getUniText());
				properties.setProperty("campo4", getMonText());
				
				
				properties.store(new FileOutputStream("tareas.database"), null);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
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