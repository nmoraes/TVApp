package mainXlet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
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
	
	
	private static int CONTADOR=0;
	
	public static JTextField detalleCompra = new JTextField(20);
	public static JTextField cantidadCompra = new JTextField(20);
	public static JTextField precioCompra = new JTextField(20);
	public static JTextField monCompra = new JTextField(20);
	
	private String detalleText = "  ";
	private String cantidadText = "  ";
	private String precioText = "  ";


	public ContenedorTasks() {

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
		
		this.setBounds(8, 150, 250, 150);
		this.addKeyListener(this);

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
			System.out.println("TVApp\\bin\\boton rojo siempre llama al teclado ...");
			MainXlet.keyboard.setVisible(true);
			MainXlet.keyboard.requestFocus();	
			ContenedorKeyboard.invokeFather=Constant.CONTENEDOR_GASTOS;

			break;
			
		case 427:	// + 
			
			Properties properties = new Properties();
			
			//File file = new File ("tareas_"+ContenedorTasks.CONTADOR+".database");
//			try {
//				file.createNewFile();
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			
			try {
				properties.store(new FileOutputStream("tareas_"+ContenedorTasks.CONTADOR+".database"),null);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				System.out.println("guardando....");
				properties.load(new FileInputStream("tareas_"+ContenedorTasks.CONTADOR+".database"));
				properties.setProperty("campo1", getDetalleText());
				properties.setProperty("campo2", getCantidadText());
				properties.setProperty("campo3",  getPrecioText());

				properties.store(new FileOutputStream("tareas_"+ContenedorTasks.CONTADOR+".database"), null);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			detalleCompra.setText("");
			cantidadCompra.setText("");
			precioCompra.setText("");
			
			ContenedorTasks.CONTADOR++;
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