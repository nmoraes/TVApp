package mainXlet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.dvb.ui.DVBColor;
import org.havi.ui.HContainer;
import org.havi.ui.HStaticText;

import wsPackage.JSONUtility;
import wsPackage.Weather;


public class ContenedorWeather extends HContainer implements KeyListener {

    private String messageWeather1= new String();
    private String messageWeather2= new String();
    private String messageWeather3= new String();
    
    // The image that we will show   
    private Image image; 
    
    // The image that we will show   
    private Image image2;
    // The image that we will show   
    private Image image3;
    // The image that we will show   
    private Image image4; 
   


	public ContenedorWeather() {

		this.setBounds(0, 0, 800, 200);
		this.addKeyListener(this);
		
	}

	public void keyPressed(KeyEvent tecla) {

		switch (tecla.getKeyCode()) {
		case 10:
			//OK Button

			Weather [] weatherCollection= JSONUtility.getWeather();
			
			for (int i = 0; i < weatherCollection.length; i++) {
				Weather h = weatherCollection[i];

				System.out.println("");
				System.out.println("");
				System.out.println(h.getTitle());
				System.out.println(h.getFcttext());
				System.out.println(h.getFcttext_metric());
				//System.out.println(h.getUrl());
				
				if(i==0){
				messageWeather1 = h.getTitle() + ": "+h.getFcttext_metric();
				image2 = h.getUrl();
				}
				if(i==1){
				image3 =h.getUrl();
				messageWeather2 = h.getTitle() + ": "+h.getFcttext_metric();
			}
				if(i==2){
				image4 =h.getUrl();
				messageWeather3 = h.getTitle() + ": "+h.getFcttext_metric();
				loadForegroundBitmap();
			}
				this.repaint();
			}

			break;
		
			
		case 27:
			//exit
			MainXlet.label.setBackground(Color.white);
			MainXlet.label.repaint();
			MainXlet.contWeather.setVisible(false);
			MainXlet.scene.requestFocus();
			//this.repaint();
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
	       // image = Toolkit.getDefaultToolkit().getImage("bg2.png");   
	             	
	        
	        // add the image to the MediaTracker...   
	        tracker.addImage(image2, 0);
	        tracker.addImage(image3, 1);
	        tracker.addImage(image4, 2);
	        // ...and wait for it to finish loading   
	        try{   
	            tracker.waitForAll();   
	        }   
	        catch(InterruptedException e) {   
	            // Ignore the exception, since there's not a lot we can do.   
	            image = null;   
	        }   
	    }   
	   
	
	     
	 
	 public void paint(Graphics graphics) {   
		   
	        // Get the size of this component so that we can clear it properly.   
	        Dimension size = getSize();   
	   
	   
	        graphics.fillRect(0,0,size.width,size.height);   
	        
	    
	        if (image2 != null) {  
	        	
	            // Draw the image from the buffer   
	            graphics.drawImage(image2, 10, 10, null);      
	        	 } 
	        
	        
	        if (image3 != null) {   
	            // Draw the image from the buffer   
	            graphics.drawImage(image3, 10, 60, null);  
	            graphics.setColor(Color.red);}  
	        if (image4 != null) {   
	            // Draw the image from the buffer   
	            graphics.drawImage(image4, 10, 110, null);      }  
	   
	        // Once we've drawn the image, we can draw the message on top of it.   
	   
	        // Set the font to be the default MHP font.   
	        graphics.setFont(new Font("Tiresias", Font.PLAIN, 15));   
	        // Set the text colour   
	        graphics.setColor(Color.white);   
	       
	        // Drawing the string may cause an error to get thrown, so we   
	        // surround it with a 'try' block.   
	        try{   
	        	
	        	graphics.drawString(messageWeather1,80,30);  
	            graphics.drawString(messageWeather2,80,90);  
	            graphics.drawString(messageWeather3,80,150);  
	          
	        }catch(Throwable t) {   
	           
	            System.out.println("Ocurrio un error al intentar conectarse a Weather."); 
	        }   
	    }   
	   
	    
	
	
	
}