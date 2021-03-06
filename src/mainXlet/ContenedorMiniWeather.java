package mainXlet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;

import org.havi.ui.HContainer;

import wsPackage.JSONUtility;
import wsPackage.Weather;

@SuppressWarnings("serial")
public class ContenedorMiniWeather extends HContainer {
	
	    private String messageWeather1= new String();
	    private String messageWeather2= new String();
	    private String messageWeather3= new String();
	    
	    // The image that we will show   
	    private Image image2;
	    // The image that we will show   
	    private Image image3;
	    // The image that we will show   
	    private Image image4;

	public ContenedorMiniWeather() {

		// mi tama�o y posici�n x,y,x,y
		this.setBounds(404, 180, 306, 80);

		executeMiniTimeWeather();

		loadForegroundBitmap();
		this.repaint();

	}


		 public void loadForegroundBitmap() {   
		        // Create a MediaTracker to tell us when the image has loaded   
		        MediaTracker tracker = new MediaTracker(this);   

		        tracker.addImage(image2, 0);
		        tracker.addImage(image3, 1);
		        tracker.addImage(image4, 2);
		        // ...and wait for it to finish loading   
		        try{   
		            tracker.waitForAll();   
		        }   
		        catch(InterruptedException e) {   
		            // Ignore the exception, since there's not a lot we can do.   
		            image2 = null;
		            image3 = null;
		            image4 = null;
		        }   
		    }   
		   
		
		     
		 
		 public void paint(Graphics graphics) {   
			   
		        // Get the size of this component so that we can clear it properly.   
		        Dimension size = getSize();   
		   
		        graphics.setColor(Color.white);
		        
		        graphics.fillRect(0,0,size.width,size.height);   
		        	        
		        
		        if (image2 != null) {  
		        	
		            // Draw the image from the buffer   
		            graphics.drawImage(image2, 20, 10, null);      
		        	 } 
		        
		        
		        if (image3 != null) {   
		            // Draw the image from the buffer   
		            graphics.drawImage(image3, 120, 10, null);  
		            }  
		        if (image4 != null) {   
		            // Draw the image from the buffer   
		            graphics.drawImage(image4, 250, 10, null);      }  
		   
		        // Once we've drawn the image, we can draw the message on top of it.   
		   
		        // Set the font to be the default MHP font.   
		        graphics.setFont(new Font("Tiresias", Font.BOLD, 15));   
		        // Set the text colour   
		        graphics.setColor(Color.BLACK);
		        
		        
		       
		        // Drawing the string may cause an error to get thrown, so we   
		        // surround it with a 'try' block.   
		        try{   
		        	
		        	graphics.drawString(messageWeather1,20,70);  
		            graphics.drawString(messageWeather2,120,70);  
		            graphics.drawString(messageWeather3,250,70);  
		          
		        }catch(Throwable t) {   
		           
		            System.out.println("Ocurrio un error al intentar conectarse a Weather."); 
		        }   
		    }   
		   
		    
		
		private void executeMiniTimeWeather(){
			
			System.out.println("---- > LLAMANDO AL MINI WEATHER, SI ESTA EN MODO DESARROLLO, COMENTE EL METODO executeMiniTimeWeather() DE LA CLASE ContenedorMiniWeather.java ***********");
			
			Weather [] weatherCollection= JSONUtility.getWeather();
			
			for (int i = 0; i < weatherCollection.length; i++) {
				Weather h = weatherCollection[i];

				if(i==0){
				messageWeather1 = h.getTitle();
				image2 = h.getUrl();
				}
				if(i==1){
				image3 =h.getUrl();
				messageWeather2 = h.getTitle();
			}
				if(i==2){
				image4 =h.getUrl();
				messageWeather3 = h.getTitle();
				loadForegroundBitmap();
			}
				
			}
			

			
			
		}
	
	
	

}
