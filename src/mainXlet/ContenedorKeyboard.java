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
import org.havi.ui.HDefaultTextLayoutManager;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HScreen;
import org.havi.ui.HStaticText;

public class ContenedorKeyboard  extends HContainer implements KeyListener{

	
	
	

	private String message="";
	
	// The image that we will show   
    private Image image; 
    private Image image2; 
    
    //The pointer
    private int x = 60;
    private int y = 30;
    
   
    
    public ContenedorKeyboard(){

		// mi tamaño y posición x,y,x,y
		this.setBounds(0, 330, 800, 200);
		this.addKeyListener(this);
		
		loadForegroundBitmap();
    	
    }
	
    
    private void closeKeyboard(){
    	
    	System.out.println("cerrar teclado");
		System.out.println("EXIT");
		
		MainXlet.label.setBackground(Color.white);
		
		MainXlet.label.repaint();
		MainXlet.keyboard.setVisible(false);
		MainXlet.keyboard.repaint();
		MainXlet.scene.requestFocus();
    	
    	
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
			closeKeyboard();
		
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
	        
	        graphics.setFont(new Font("Tiresias", Font.PLAIN, 20));
	        graphics.setColor(Color.RED);   
	    
	        
	        try{   
	            graphics.drawString(message,0,100);  

	        }catch(Throwable t) {   
	            // Catch any errors that get thrown.   
	            t.printStackTrace();   
	        } 


	    }   
	    
	    
	public void write(int x, int y) {

		if (y == 30) {

			switch (x) {
			case 60:
				System.out.println("Q");
				message= message+"Q";
				this.repaint();

				break;
			case 115:
				System.out.println("W");
				message= message+"W";
				this.repaint();

				break;

			case 170:
				
				System.out.println("E");
				message= message+"E";
				this.repaint();

				break;

			case 225:
			
				System.out.println("R");
				message= message+"R";
				this.repaint();
				break;

			case 280:
				
				System.out.println("T");
				message= message+"T";
				this.repaint();
				break;

			case 335:
				
				System.out.println("Y");
				message= message+"Y";
				this.repaint();

				break;

			case 390:
			
				System.out.println("U");
				message= message+"U";
				this.repaint();

				break;

			case 445:
			
				System.out.println("I");
				message= message+"I";
				this.repaint();

				break;

			case 500:
			
				System.out.println("O");
				message= message+"O";
				this.repaint();

				break;
			case 555:
				
				System.out.println("P");
				message= message+"P";
				this.repaint();

				break;
			case 610:
			
				System.out.println("borrar");
				int size=message.length();
				
				if(size>=1){
				message=(String) message.subSequence(0, size-1);
				}
				this.repaint();
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
					message= message+"A";
					this.repaint();

					break;
				case 135:
					System.out.println("S");
					message= message+"S";
					this.repaint();

					break;

				case 190:
					
					System.out.println("D");
					message= message+"D";
					this.repaint();
					break;

				case 245:
					
					System.out.println("F");
					message= message+"F";
					this.repaint();	
					break;

				case 300:
					
					System.out.println("G");
					message= message+"G";
					this.repaint();	
					break;

				case 355:
					
					System.out.println("H");
					message= message+"H";
					this.repaint();
					break;

				case 410:
					
					System.out.println("J");
					message= message+"J";
					this.repaint();

					break;

				case 465:
					
					System.out.println("K");
					message= message+"K";
					this.repaint();

					break;

				case 520:
					
					System.out.println("L");
					message= message+"L";
					this.repaint();
					break;
				case 575:
					//AUN NO HACE NADA
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
					//AUN NO HACE NADA
					System.out.println("SHIFT");

					break;
				case 115:
				
					System.out.println("Z");
					message= message+"Z";
					this.repaint();

					break;

				case 170:
					
					System.out.println("X");
					message= message+"X";
					this.repaint();

					break;

				case 225:
				
					System.out.println("C");
					message= message+"C";
					this.repaint();

					break;

				case 280:
					
					System.out.println("V");
					message= message+"V";
					this.repaint();

					break;

				case 335:
					
					System.out.println("B");
					message= message+"B";
					this.repaint();

					break;

				case 390:
				
					System.out.println("N");
					message= message+"N";
					this.repaint();

					break;

				case 445:
				
					System.out.println("M");
					message= message+"M";
					this.repaint();

					break;

				case 500:
					//AUN NO HACE NADA
					System.out.println(", !");

					break;
				case 555:
					//AUN NO HACE NADA
					System.out.println("? .");

					break;
				case 610:
					//AUN NO HACE NADA
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
				message= message+" ";
				this.repaint();

				break;

			case 300:
				
				System.out.println("espacio");
				message= message+" ";
				this.repaint();

				break;

			case 355:
				
				System.out.println("espacio");
				message= message+" ";
				this.repaint();
				break;

			case 410:
			
				System.out.println("espacio");

				break;

			case 520:
				//abrimos el numerico
				System.out.println("123");

				break;

			case 575:
				//abrimos el numerico.
				System.out.println("123");

				break;

			case 630:
				
				closeKeyboard();
				
				break;


			default: {
				
				System.out.println("fuera del rango");

				break;
			}

			}
			
			
		}	

		}

	}

