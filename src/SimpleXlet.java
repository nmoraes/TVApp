
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
    private Color[] colors = { Color.black, Color.red, Color.blue , Color.CYAN };
    private int intColor;
    
	// this object is responsible for displaying the background I-frame
	private HaviBackgroundController backgroundManager;
    

    public SimpleXlet() {
    }

    public void initXlet(XletContext xletContext) throws XletStateChangeException {
        System.out.println("Ejecutando initXlet...");
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
        

        label = new HStaticText("HStaticText", 100, 100, 200, 200, new Font("Tiresias", Font.BOLD, 22), Color.yellow, colors[0], new HDefaultTextLayoutManager());
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

			break;
		}
		case 404: {
			System.out.println("verde ...");

			break;
		}
		case 405: {
			System.out.println("amarillo  ...");

			break;
		}
		case 406: {
			System.out.println("azul ...");

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
    	
    	
    	
    	/*System.out.println(e.getKeyChar());
    	    	
        intColor++;
        if (intColor == colors.length) {
            intColor = 0;
        }
        label.setBackground(colors[intColor]);
        label.repaint();
        
        
        */
   
    
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
    

}