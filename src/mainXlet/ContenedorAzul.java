package mainXlet;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.havi.ui.HContainer;

@SuppressWarnings("serial")

/**
 * ContenedorAzul es quien presenta los creditos de la aplicacion.
 * */
public class ContenedorAzul extends HContainer implements KeyListener {
	
	
	private Image fondoAplic;
	private static boolean flagImageBlue;

	public ContenedorAzul() {
		setFlagImageBlue(false);
		this.setBounds(0, 0, 800, 600);
		this.addKeyListener(this);
		loadForegroundBitmap();

	}

	public void keyPressed(KeyEvent tecla) {

		switch (tecla.getKeyCode()) {

		case 27:
			// exit
			setFlagImageBlue(false);
			MainXlet.scene.requestFocus();
			this.repaint();
			break;
		}

	}

	public void loadForegroundBitmap() {
		// Create a MediaTracker to tell us when the image has loaded
		MediaTracker tracker = new MediaTracker(this);
		// Then load the image
		fondoAplic = Toolkit.getDefaultToolkit().getImage("fondoAbout.jpg");

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

		if (isFlagImageBlue() == true && fondoAplic != null) {
			// Draw the image from the buffer
			graphics.drawImage(fondoAplic, 0, 0, null);
		}

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
}