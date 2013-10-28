package deprecatedPackage;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;



import org.havi.ui.HComponent;
import org.havi.ui.HDefaultTextLayoutManager;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HScreen;
import org.havi.ui.HSound;
import org.havi.ui.HStaticText;

import wsPackage.JSONUtility;
import wsPackage.Weather;



/**
* A simple Xlet with a HStaticText label that changes background color
* when a key is pressed.
*/
public class SimpleXlet extends HComponent  implements Xlet, KeyListener{

    private XletContext context;
    private HScene scene;
    private HStaticText label;
    private Color[] colors = { Color.red, Color.green,  Color.yellow , Color.blue };
    private int intColor;
    

    
    /**Tipo de dato para guardar sonido */
    private HSound myHSound = new HSound();

	// The image that we will show
	private Image image;


	// this object is responsible for displaying the background I-frame
	private HaviBackgroundController backgroundManager;
	
	// The message that will get printed.  This is read from a file in initXlet()
	private String message;
    

    public SimpleXlet() {
    }

    public void initXlet(XletContext xletContext) throws XletStateChangeException {
        System.out.println("Ejecutando initXlet...");
        loadForegroundBitmap();
    	playSound();
        readProperties();
        context = xletContext;

    }

    public void startXlet() throws XletStateChangeException {
        System.out.println("Ejecutando startXlet...");
 
    	// This adds the background image to the display.  The background image is
		// displayed in the background plane.
		displayBackgroundImage();
		
        
        HSceneFactory hsceneFactory = HSceneFactory.getInstance();
        scene = hsceneFactory.getFullScreenScene(HScreen.getDefaultHScreen().getDefaultHGraphicsDevice());

        scene.setSize(720, 576);
        scene.setLayout(null);
        scene.addKeyListener(this);
      

        label = new HStaticText(message, 100, 100, 200, 200, new Font("Tiresias", Font.BOLD, 22), Color.black, colors[0], new HDefaultTextLayoutManager());
        scene.add(label);
        scene.add(this);
        
    
        scene.setVisible(true);
		scene.requestFocus();
    }

    public void pauseXlet() {
    }

    public void destroyXlet(boolean flag) throws XletStateChangeException {
        System.out.println("destroyXlet");
        if (scene != null) {
            scene.setVisible(false);
            scene.removeAll();
            scene = null;
        }
        context.notifyDestroyed();
    }
    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

	public void keyPressed(KeyEvent key) {
		// What key has been pressed?
		switch (key.getKeyCode()) {
		// if we have the 'up' key...
		case KeyEvent.VK_UP: {
			System.out.println("arriba ...");
			//loadForegroundBitmap();
			break;
		}
		case KeyEvent.VK_DOWN: {
			System.out.println("abajo ...");
			cambiarColor();
			break;
		}

		case KeyEvent.VK_LEFT: {
			System.out.println("evento estado del tiempo");
			Weather [] weatherCollection= JSONUtility.getWeather();
			
			for (int i = 0; i < weatherCollection.length; i++) {
				Weather h = weatherCollection[i];

				System.out.println("");
				System.out.println("");
				System.out.println(h.getTitle());
				System.out.println(h.getFcttext());
				System.out.println(h.getFcttext_metric());
				//System.out.println(h.getUrl());
		//		loadForegroundBitmap2(h.getUrl());
				
				
			}
			
			break;
		}

		case KeyEvent.VK_RIGHT: {
			System.out.println("derecha ...");
		
			 //Graphics g = getGraphics();
		    //paint(g);
			this.repaint();
			break;
		}

		case 403: {
			System.out.println("rojo ...");
			label.setBackground(colors[0]);
	        label.repaint();
	        myHSound.stop();

			break;
		}
		case 404: {
			System.out.println("verde ...");
			label.setBackground(colors[1]);
	        label.repaint();
	        myHSound.play();
			break;
		}
		case 405: {
			System.out.println("amarillo  ...");
			label.setBackground(colors[2]);
	        label.repaint();

			break;
		}
		case 406: {
			System.out.println("azul ...");
			label.setBackground(colors[3]);
	        label.repaint();

			break;
		}

		default: {
			// do nothing
			System.out.println("default case ...");
			System.out.println(key);
			break;
		}
		}
	}
    	
    	
	
	private void cambiarColor(){
		 intColor++;
	        if (intColor == colors.length) {
	            intColor = 0;
	        }
	        label.setBackground(colors[intColor]);
	        label.repaint();
	        
	}
    	

   
    
	/**
	 * This method is responsible for displaying the background image
	 * on the screen.  This image will be displayed in the background
	 * plane, not the graphics plane.  See the graphics tutorial for
	 * a discussion of the differences between the two planes and how
	 * they work together.
	 */
	public void displayBackgroundImage() {
		// We've defined a separate object for displaying and managing
		// the background image.
		
		backgroundManager = new HaviBackgroundController();

		// If we can initialise the background manager (which means we have got
		// the resources we need to display the image), we load and display an
		// image in the background plane.
		if (backgroundManager.init()) {

				backgroundManager.display("background.jpg");
			
			
		
		}
	}
    
	
	private void readProperties(){
	
	// Load the message that we will display
	try {
		// This is all standard java.io file reading, so we won't explain it.
		// If you really need to know, look at a decent Java book.
		BufferedReader in = new BufferedReader(
			new InputStreamReader(new FileInputStream("app.properties")));

		// Read the first line from the file.  Our message will only be one
		// line long, in this case.
		message = in.readLine();
	}catch(IOException e){
		// Something went wrong reading the message file.
		System.out.println("I/O exception reading message.txt");
	}
	
	}
	
	public void playSound() {
		myHSound = new HSound();
		try {
			URL url;
			url = new URL("file://"
					+ new File("main_sound.mpg").getAbsolutePath());
			myHSound.load(url);
			System.out.println(url);

		} catch (IOException io) {
			io.printStackTrace();
			System.out.println("error al leer sound.");
		}
		myHSound.play();

	}
	
//	   public void loadForegroundBitmap2(Image i) {   
//	        // Create a MediaTracker to tell us when the image has loaded   
//	        MediaTracker tracker = new MediaTracker(label);   
//	        // Then load the image   
//	        //image = Toolkit.getDefaultToolkit().getImage("nico1.jpeg");   
//	   
//	        image=i;
//	        
//	        // add the image to the MediaTracker...   
//	        tracker.addImage(image, 0);   
//	   
//	        // ...and wait for it to finish loading   
//	        try{   
//	            tracker.waitForAll();   
//	            
//	        }   
//	        
//	        catch(InterruptedException e) {   
//	            // Ignore the exception, since there's not a lot we can do.   
//	            image = null;   
//	            System.out.println("exception en loadFore..");
//	        }  
//	      
//	        
//	    }
	   

	
	   /**  
	     * This is a standard AWT paint method for repainting the contents of the  
	     * component.  
	     */ 

	    public void paint(Graphics graphics) {   
	   
	    	super.paint(graphics);
	    	Dimension size = getSize();   
	    	   
	        /* Clear the background of the component to the current  
	        transparency level.  Since standard AWT doesn't  support  
	        transparency, we have to use an org.dvb.ui.DVBColor  
	        object rather than a java.awt.Color object */   
	        
	       
	        graphics.fillRect(0,0,size.width,size.height);   
	    	
	    	 System.out.println("dentro de paint");
	        if (image != null) {   
	            // Draw the image from the buffer   
	            graphics.drawImage(image, 100, 100, null);    
	           
	        System.out.println("ejecutado paint");
	        }   
	   
 
	    }

	    

	    public void loadForegroundBitmap() {   
	        // Create a MediaTracker to tell us when the image has loaded   
	        MediaTracker tracker = new MediaTracker(this);   
	        // Then load the image   
	        image = Toolkit.getDefaultToolkit().getImage("bg2.png");   
	   
	        // add the image to the MediaTracker...   
	        tracker.addImage(image, 0);   
	   
	        // ...and wait for it to finish loading   
	        try{   
	            tracker.waitForAll();   
	        }   
	        catch(InterruptedException e) {   
	            // Ignore the exception, since there's not a lot we can do.   
	            image = null;   
	            System.out.println("error en carga de imahen");
	        }   
	    }


}