package mainXlet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import org.havi.ui.HContainer;

public class Keyboard  extends HContainer implements KeyListener{

	
	// The image that we will show   
    private Image image; 
    private Image image2; 
    
    //The pointer
    private int x = 60;
    private int y = 30;
    
    
    public Keyboard(){

		// mi tamaño y posición x,y,x,y
		this.setBounds(0, 330, 800, 200);
		this.addKeyListener(this);
		
		loadForegroundBitmap();
    	
    }
	
	
	public void keyPressed(KeyEvent tecla) {

		switch (tecla.getKeyCode()) {
		case 39:
			x = x + 55;
			//System.out.println("der cordenadas x = "+x +"y ="+y);
			//hstTexto.setBounds(x, 0, 200, 50);
			this.repaint();
			//System.out.println("default case ...");
			break;
		case 37:
			x = x - 55;
			//System.out.println("izq cordenadas x = "+x +"y ="+y);
			this.repaint();

			break;
			
		case 38:
			y = y -50;
			if(y==30) x = 60;
			if(y==80) x = 80;
			if(y==130) x = 60;
			if(y==180) x = 80;
			//System.out.println("arriba cordenadas x = "+x +"y ="+y);
			this.repaint();
			break;
			
		case 40:
			y = y + 50;
			if(y==30) x = 60;
			if(y==80) x = 80;
			if(y==130) x = 60;
			if(y==180) x = 80;
			//System.out.println("abajo cordenadas x = "+x +"y ="+y);
			this.repaint();
			
			break;
			
		case 27:
			//exit
			System.out.println("EXIT");
			
			HelloTVXlet.label.setBackground(Color.white);
			
			HelloTVXlet.label.repaint();
			HelloTVXlet.keyboard.setVisible(false);
			HelloTVXlet.keyboard.repaint();
			HelloTVXlet.scene.requestFocus();

			
			break;	
			
		case 10:
			//OK
			write(x,y);
			break;	
		
		default: {
			// do nothing
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

	 public void loadForegroundBitmap() {   
	        // Create a MediaTracker to tell us when the image has loaded   
	        MediaTracker tracker = new MediaTracker(this);   
	        // Then load the image   
	        image = Toolkit.getDefaultToolkit().getImage("keyboardLetters.png");   
	        image2 = Toolkit.getDefaultToolkit().getImage("puntero.png");     	
	        
	        // add the image to the MediaTracker...   
	        tracker.addImage(image, 0); 
	        tracker.addImage(image2, 1); 
	     //   tracker.addImage(image2, 1);
	     
	        // ...and wait for it to finish loading   
	        try{   
	            tracker.waitForAll();   
	        }   
	        catch(InterruptedException e) {   
	            // Ignore the exception, since there's not a lot we can do.   
	            image = null;  
	            image2 = null;
	        }   
	    }   
	
	     
	 
	 /**  
	     * This is a standard AWT paint method for repainting the contents of the  
	     * component.  
	     */   
	    public void paint(Graphics graphics) {   
	   
	        // Get the size of this component so that we can clear it properly.   
	        Dimension size = getSize();   
	   
	        graphics.fillRect(0,0,size.width,size.height);   
	        

	        if (image != null) {   
	            // Draw the image from the buffer   
	            graphics.drawImage(image, 50, 0, null);     
	            
	        
	        
	        }
	        if (image2 != null) {   
	            // Draw the image from the buffer   
	            graphics.drawImage(image2, x, y, null);     
	            
	       
	        
	        }
	        


	    }   
	    
	    
	public void write(int x, int y) {

		if (y == 30) {

			switch (x) {
			case 60:
				System.out.println("Q");

				break;
			case 115:
			
				System.out.println("W");

				break;

			case 170:
				
				System.out.println("E");

				break;

			case 225:
			
				System.out.println("R");

				break;

			case 280:
				
				System.out.println("T");

				break;

			case 335:
				
				System.out.println("Y");

				break;

			case 390:
			
				System.out.println("U");

				break;

			case 445:
			
				System.out.println("I");

				break;

			case 500:
			
				System.out.println("O");

				break;
			case 555:
				
				System.out.println("P");

				break;
			case 610:
			
				System.out.println("borrar");

				break;

			default: {
				
				System.out.println("fuera del rango");

				break;
			}

			}
			
		}

			if (y == 80) {
				switch (x) {
				case 80:
				
					System.out.println("A");

					break;
				case 135:
					// exit
					System.out.println("S");

					break;

				case 190:
					// exit
					System.out.println("D");

					break;

				case 245:
					// exit
					System.out.println("F");

					break;

				case 300:
					// exit
					System.out.println("G");

					break;

				case 355:
					// exit
					System.out.println("H");

					break;

				case 410:
					// exit
					System.out.println("J");

					break;

				case 465:
					// exit
					System.out.println("K");

					break;

				case 520:
					// exit
					System.out.println("L");

					break;
				case 575:
					// exit
					System.out.println("enter");

					break;

				default: {
					// do nothing
					System.out.println("fuera del rango");

					break;
				}

				}
				

			}
			if (y == 130) {
				
				switch (x) {
				case 60:
					System.out.println("SHIFT");

					break;
				case 115:
				
					System.out.println("Z");

					break;

				case 170:
					
					System.out.println("X");

					break;

				case 225:
				
					System.out.println("C");

					break;

				case 280:
					
					System.out.println("V");

					break;

				case 335:
					
					System.out.println("B");

					break;

				case 390:
				
					System.out.println("N");

					break;

				case 445:
				
					System.out.println("M");

					break;

				case 500:
				
					System.out.println(", !");

					break;
				case 555:
					
					System.out.println("? .");

					break;
				case 610:
				
					System.out.println("SHIFT");

					break;

				default: {
					
					System.out.println("fuera del rango");

					break;
				}

				}

			}
			
		if(y==180){
			
			switch (x) {
			case 80:
				System.out.println("123...");

				break;
			case 135:
			
				System.out.println("twitter");

				break;

			case 190:
				
				System.out.println("twitter");

				break;

			case 245:
			
				System.out.println("espacio");

				break;

			case 300:
				
				System.out.println("espacio");

				break;

			case 355:
				
				System.out.println("espacio");

				break;

			case 410:
			
				System.out.println("espacio");

				break;

			case 520:
			
				System.out.println("123");

				break;

			case 575:
			
				System.out.println("123");

				break;

			case 630:
				
				System.out.println("cerrar teclado");

				break;


			default: {
				
				System.out.println("fuera del rango");

				break;
			}

			}
			
			
		}	

		}

	}

