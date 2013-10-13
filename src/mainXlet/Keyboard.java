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
    
    
    public Keyboard(){

		// mi tamaño y posición x,y,x,y
		this.setBounds(0, 330, 800, 200);
		this.addKeyListener(this);
		
		loadForegroundBitmap();
    	
    }
	
	
	public void keyPressed(KeyEvent tecla) {

		switch (tecla.getKeyCode()) {
		case 39:
		//	x = x + 100;
			//hstTexto.setBounds(x, 0, 200, 50);
			//this.repaint();
			System.out.println("default case ...");
			break;
		case 37:
//			x = x - 100;
	//		hstTexto.setBounds(x, 0, 200, 50);
			//this.repaint();
			System.out.println("default case ...");
			break;
			
		case 27:
			//exit
			System.out.println("EXIT");
			
			HelloTVXlet.label.setBackground(Color.white);
			
			HelloTVXlet.label.repaint();
			HelloTVXlet.keyboard.setVisible(false);
			HelloTVXlet.keyboard.repaint();
			HelloTVXlet.scene.requestFocus();
			
			//repaint();
		//	HelloTVXlet.keyboard.repaint();
			
			
		//	
		
			
			break;	
		
		default: {
			// do nothing
			System.out.println("default case ...");
			//System.out.println(tecla);
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
	             	
	        
	        // add the image to the MediaTracker...   
	        tracker.addImage(image, 0);   
	     //   tracker.addImage(image2, 1);
	     
	        // ...and wait for it to finish loading   
	        try{   
	            tracker.waitForAll();   
	        }   
	        catch(InterruptedException e) {   
	            // Ignore the exception, since there's not a lot we can do.   
	            image = null;   
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
	            
	        System.out.println("imagen no nula");
	        
	        }
	        
	        
	    
//	        if (image2 != null) {  
//	        	
//	            // Draw the image from the buffer   
//	            graphics.drawImage(image2, 10, 10, null);      
//	        	 } 
//	        
	        

	      //  graphics.setFont(new Font("Tiresias", Font.PLAIN, 20));   
	        // Set the text colour   
	     //   graphics.setColor(Color.black);   
	   
	        // Drawing the string may cause an error to get thrown, so we   
	        // surround it with a 'try' block.   

	    }   
	
	
}
