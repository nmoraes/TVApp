package mainXlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.havi.ui.HContainer;
import org.havi.ui.HStaticText;

@SuppressWarnings("serial")

/**
 * ContenedorAzul es quien presenta los creditos de la aplicacion.
 * */
public class ContenedorAzul extends HContainer implements KeyListener {
	
	
	private Image fondoAplic, fondoAplic1;
	private static boolean flagImageBlue, flagImageBlue1;
	
	
	public ContenedorAzul() {
		setFlagImageBlue(false);
		this.setBounds(0, 0, 800, 600);
		this.addKeyListener(this);
		loadForegroundBitmap();

	}

	public void keyPressed(KeyEvent tecla) {

		switch (tecla.getKeyCode()) {
		case 403:
			System.out.println("Rojo");
			setFlagImageBlue1(true);
			MediaTracker tracker3 = new MediaTracker(this);
			// Then load the image
			fondoAplic = Toolkit.getDefaultToolkit().getImage("AyudaRojo.jpg");

			// add the image to the MediaTracker...
			tracker3.addImage(fondoAplic, 0);

			// ...and wait for it to finish loading
			try {
				tracker3.waitForAll();
			} catch (InterruptedException e) {
				// Ignore the exception, since there's not a lot we can do.
				fondoAplic = null;

			}
			this.repaint();
			break;
		case 404:
		
			System.out.println("verde");
			setFlagImageBlue1(true);
			MediaTracker tracker = new MediaTracker(this);
			// Then load the image
			fondoAplic = Toolkit.getDefaultToolkit().getImage("AyudaVerde.jpg");

			// add the image to the MediaTracker...
			tracker.addImage(fondoAplic, 0);

			// ...and wait for it to finish loading
			try {
				tracker.waitForAll();
			} catch (InterruptedException e) {
				fondoAplic = null;
			}
			this.repaint();
			break;
		case 405:
		
			System.out.println("verde");
			setFlagImageBlue1(true);
			MediaTracker tracker1 = new MediaTracker(this);
			fondoAplic = Toolkit.getDefaultToolkit().getImage("AyudaAmarillo.jpg");
			tracker1.addImage(fondoAplic, 0);
			try {
				tracker1.waitForAll();
			} catch (InterruptedException e) {
				fondoAplic = null;
			}
			this.repaint();
			break;
		case 406:

			System.out.println("Azul");
			setFlagImageBlue1(true);
			MediaTracker tracker2 = new MediaTracker(this);
			// Then load the image
			fondoAplic = Toolkit.getDefaultToolkit().getImage("AyudaAzul.jpg");

			// add the image to the MediaTracker...
			tracker2.addImage(fondoAplic, 0);

			// ...and wait for it to finish loading
			try {
				tracker2.waitForAll();
			} catch (InterruptedException e) {
				// Ignore the exception, since there's not a lot we can do.
				fondoAplic = null;

			}
			this.repaint();
			break;
		case 27:
			// exit

			MainXlet.mainPage=true;
			setFlagImageBlue(false);
			MainXlet.scene.requestFocus();
			fondoAplic = Toolkit.getDefaultToolkit().getImage("fondoAbout1.jpg");
			this.repaint();
			break;
		}

	}

	public void loadForegroundBitmap() {
		// Create a MediaTracker to tell us when the image has loaded
		MediaTracker tracker = new MediaTracker(this);
		// Then load the image
		fondoAplic = Toolkit.getDefaultToolkit().getImage("fondoAbout1.jpg");

		// add the image to the MediaTracker...
		tracker.addImage(fondoAplic, 0);

		// ...and wait for it to finish loading
		try {
			tracker.waitForAll();
		} catch (InterruptedException e) {
			// Ignore the exception, since there's not a lot we can do.
			fondoAplic = null;

		}
	}

	public void paint(Graphics graphics) {

		if (/*isFlagImageBlue1() == false && */isFlagImageBlue() == true && fondoAplic != null) {
			// Draw the image from the buffer
			graphics.drawImage(fondoAplic, 0, 0, null);
		}
		/*if (isFlagImageBlue1() == true ) {
			
			// Draw the image from the buffer
			graphics.drawImage(fondoAplic, 0, 0, null);
		}*/
		super.paint(graphics);

	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public boolean isFlagImageBlue() {
		return flagImageBlue;
	}

	public void setFlagImageBlue(boolean flag) {
		flagImageBlue = flag;
	}
/////
	
	public void loadForegroundBitmap1() {
		// Create a MediaTracker to tell us when the image has loaded
		MediaTracker tracker = new MediaTracker(this);
		// Then load the image
		fondoAplic1 = Toolkit.getDefaultToolkit().getImage("fondoAbout2.jpg");

		// add the image to the MediaTracker...
		tracker.addImage(fondoAplic1, 0);

		// ...and wait for it to finish loading
		try {
			tracker.waitForAll();
		} catch (InterruptedException e) {
			// Ignore the exception, since there's not a lot we can do.
			fondoAplic1 = null;

		}
	}

	public void paint1(Graphics graphics) {

		if (isFlagImageBlue1() == true && fondoAplic1 != null) {
			// Draw the image from the buffer
			graphics.drawImage(fondoAplic1, 0, 0, null);
		}

		super.paintAll(graphics);

	}

	public void keyReleased1(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void keyTyped1(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public boolean isFlagImageBlue1() {
		return flagImageBlue1;
	}

	public void setFlagImageBlue1(boolean flag) {
		flagImageBlue = flag;
	}
	
////
	
	
}


