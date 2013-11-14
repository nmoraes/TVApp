package deprecatedPackage;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

import org.havi.ui.HContainer;

public class ContenedorLoading  extends HContainer {

	
	/**LoadingBar Image */
	private Image image;
       
    
    public ContenedorLoading(){

		// mi tamaño y posición x,y,x,y
		this.setBounds(0, 330, 800, 200);
		loadForegroundBitmap();	
	
		
    }
	
    
    public void comenzar(){
    	
    	for (int i=0; i<500; i++){
			System.out.println("OHHH");
		this.repaint();
    	}
    }
    
	 public void loadForegroundBitmap() {   
	        // Create a MediaTracker to tell us when the image has loaded   
	        MediaTracker tracker = new MediaTracker(this);   
	        // Then load the image   
	        image = Toolkit.getDefaultToolkit().getImage("loadingBar.gif");  	
	        
	        // add the image to the MediaTracker...   
	        tracker.addImage(image, 0); 
	        
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
	            graphics.drawImage(image, 30, 40, null);             
	        
	        }

	        
//	        graphics.setFont(new Font("Tiresias", Font.PLAIN, 20));
//	        graphics.setColor(Color.RED);   
//	    

	    	}
	       
	    
	    
	

	}
