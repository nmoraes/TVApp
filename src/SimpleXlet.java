
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;

import org.havi.ui.HDefaultTextLayoutManager;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HScreen;
import org.havi.ui.HStaticText;

/**
* A simple Xlet with a HStaticText label that changes background color
* when a key is pressed.
*/
public class SimpleXlet implements Xlet, KeyListener {

    private XletContext context;
    private HScene scene;
    private HStaticText label;
    private Color[] colors = { Color.red, Color.green,  Color.yellow , Color.blue };
    private int intColor;
    
	// this object is responsible for displaying the background I-frame
	private HaviBackgroundController backgroundManager;
	
	// The message that will get printed.  This is read from a file in initXlet()
	private String message;
    

    public SimpleXlet() {
    }

    public void initXlet(XletContext xletContext) throws XletStateChangeException {
        System.out.println("Ejecutando initXlet...");
        readProperties();
        context = xletContext;
    }

    public void startXlet() throws XletStateChangeException {
        System.out.println("Ejecutando startXlet...");
    	// This adds the background image to the display.  The background image is
		// displayed in the background plane.
		displayBackgroundImage();
		
		// The bitmap image is shown in the graphics plane.
		displayForegroundBitmap();
        
        HSceneFactory hsceneFactory = HSceneFactory.getInstance();
        scene = hsceneFactory.getFullScreenScene(HScreen.getDefaultHScreen().getDefaultHGraphicsDevice());

        scene.setSize(720, 576);
        scene.setLayout(null);
        scene.addKeyListener(this);
        

        label = new HStaticText(message, 100, 100, 200, 200, new Font("Tiresias", Font.BOLD, 22), Color.black, colors[0], new HDefaultTextLayoutManager());
        scene.add(label);

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
			break;
		}
		case KeyEvent.VK_DOWN: {
			System.out.println("abajo ...");
			cambiarColor();
			break;
		}

		case KeyEvent.VK_LEFT: {
			System.out.println("izquierda ...");

			break;
		}

		case KeyEvent.VK_RIGHT: {
			System.out.println("derecha ...");

			break;
		}

		case 403: {
			System.out.println("rojo ...");
			label.setBackground(colors[0]);
	        label.repaint();

			break;
		}
		case 404: {
			System.out.println("verde ...");
			label.setBackground(colors[1]);
	        label.repaint();

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
			backgroundManager.display("sky.jpg");
		}
	}
    
	/**
	 * Display the foreground image in the AWT component
	 */
	public void displayForegroundBitmap()
	{
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
	
	
    

}