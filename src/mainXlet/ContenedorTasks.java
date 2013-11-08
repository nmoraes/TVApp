package mainXlet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JTextField;
import javax.swing.text.html.HTML;



import org.havi.ui.HContainer;
import org.havi.ui.HStaticText;


public class ContenedorTasks extends HContainer implements KeyListener {
	
	
	public static JTextField detalleCompra = new JTextField(20);
	public static JTextField cantidadCompra = new JTextField(20);
	public static JTextField precioCompra = new JTextField(20);
	public static JTextField monCompra = new JTextField(20);
	
	private String detalleText = "  ";
	private String cantidadText = "  ";
	private String precioText = "  ";
	//private String monText = "  ";
	
	HStaticText hstTexto = new HStaticText("descripcion: ______________ ");
	HStaticText hstTexto2 = new HStaticText("cantidad: _________________");
	HStaticText hstTexto3 = new HStaticText("precio: ___________________");
	HStaticText hstTexto4 = new HStaticText("otro: _____________________");	
	
	
	public ContenedorTasks() {
//	
//		hstTexto.setFont(new Font("Tiresias", Font.ITALIC, 15));
//		hstTexto.setBounds(20, 150, 200, 40);
//		hstTexto.setBackground(Color.white);
//		
//		hstTexto2.setFont(new Font("Tiresias", Font.ITALIC, 15));
//		hstTexto2.setBounds(20, 180, 200, 40);
//		hstTexto2.setBackground(Color.white);
//		
//		hstTexto3.setFont(new Font("Tiresias", Font.ITALIC, 15));
//		hstTexto3.setBounds(20, 210, 200, 40);
//		hstTexto3.setBackground(Color.white);
		
		// Textfields
		detalleCompra.setBounds(110, 35, 100, 20); 
		detalleCompra.setBackground(Color.LIGHT_GRAY); 
		this.add(detalleCompra);
		
		cantidadCompra.setBounds(110, 65, 100, 20); 
		cantidadCompra.setBackground(Color.LIGHT_GRAY); 
		this.add(cantidadCompra);
		
		precioCompra.setBounds(110, 95, 100, 20); 
		precioCompra.setBackground(Color.LIGHT_GRAY); 
		this.add(precioCompra);
		
		
		
		//hstTexto.setFont(new Font("Tiresias", Font.BOLD, 20));
		// texto tamaño y posición x,y,x,y
		//hstTexto.setBounds(19, 400, 200, 50);
		//hstTexto.setBackground(Color.blue);
		this.add(hstTexto);
		this.add(hstTexto2);
		this.add(hstTexto3);
		
		// mi tamaño y posición x,y,x,y
		
		
		this.setBounds(8, 150, 250, 150);
		this.addKeyListener(this);
		
		//this.repaint();
	}

	public void keyPressed(KeyEvent tecla) {

		switch (tecla.getKeyCode()) {

		case 27:
			//exit
			MainXlet.label.setBackground(Color.white);
			MainXlet.label.repaint();
			MainXlet.contTasks.setVisible(false);
			MainXlet.scene.requestFocus();
			this.repaint();
			break;	
			
			
		case 403: 
			System.out.println("boton rojo siempre llama al teclado ...");
			MainXlet.keyboard.setVisible(true);
			MainXlet.keyboard.requestFocus();	
			ContenedorKeyboard.invokeFather=Constant.CONTENEDOR_GASTOS;

			break;
			
		case 427:	// + 
			
			Properties properties = new Properties();
			try {
				System.out.println("guardando....");
				properties.load(new FileInputStream("tareas.database"));
				properties.setProperty("campo1", getDetalleText());
				properties.setProperty("campo2", getCantidadText());
				properties.setProperty("campo3",  getPrecioText());
				
				//properties.setProperty("campo4", getMonText());
				
				
				properties.store(new FileOutputStream("tareas.database"), null);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			break;	
		
		

		}	
		
	}

	
	
	
	public void paint(Graphics graphics) {   

		

		 System.out.println("hola paint");
		
		detalleCompra.setText(detalleText);	
		cantidadCompra.setText(cantidadText);
		precioCompra.setText(precioText);
		
				switch(ContenedorKeyboard.navegadorTextGastos){
					
				case 0:	
					detalleCompra.setText(ContenedorKeyboard.message);
						
					break;
					
				case 1:
					 cantidadCompra.setText(ContenedorKeyboard.message);
					
					break;
					
				case 2: 
					precioCompra.setText(ContenedorKeyboard.message);
			
					break;
//				case 3: 
//				        monCompra.setText(ContenedorKeyboard.message);
//			
//				    break;
				
//				default:
//					System.out.println("Error!!!");
//					break;
				}
	      
				graphics.setColor(Color.white);
				graphics.fillRect(0,0,250,150);  
				
				graphics.setFont(new Font("Tiresias", Font.BOLD, 15));
				graphics.setColor(Color.black);
				   try{   
			            graphics.drawString("descripcion: ",10,50);
			            graphics.drawString("cantidad: ",10,80); 
			            graphics.drawString("precio: ",10,110); 
			            
			            graphics.setFont(new Font("Tiresias", Font.BOLD, 12));
			            graphics.drawString("(+) para guardar/ (EXIT) volver / (rojo) escribir ",20,140); 

			        }catch(Throwable t) {   
			            // Catch any errors that get thrown.   
			            t.printStackTrace();   
			        } 
		

	    }   
	
	
	
	public String getDetalleText() {
		return detalleText;
	}

	public void setDetalleText(String detalleText) {
		this.detalleText = detalleText;
	}

	public String getCantidadText() {
		return cantidadText;
	}

	public void setCantidadText(String cantidadText) {
		this.cantidadText = cantidadText;
	}

	public String getPrecioText() {
		return precioText;
	}

	public void setPrecioText(String precioText) {
		this.precioText = precioText;
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}