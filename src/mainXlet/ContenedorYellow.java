package mainXlet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.havi.ui.HContainer;
import org.havi.ui.HStaticText;

import calc.Base;
import calc.Calcu;

public class ContenedorYellow extends HContainer implements KeyListener {
	private int x = 0;
	private Image fondoAplic;
	HStaticText hstTexto;;
	public static ContenedorTwitter conTwitter;
	public static Base base = new Base();
	public static Calcu calcu = new Calcu();
	HStaticText texto;
	
	public ContenedorYellow() {
		texto = new HStaticText("verde twitter amarillo calculadora");
		texto.setFont(new Font("Tiresias", 0, 14));
		// texto tamaño y posición x,y,x,y
		texto.setBounds(100, 350, 400, 200);
		texto.setBackground(Color.white);
		//this.add(texto);
		texto.setVisible(false);
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(Constant.CONFIG_PROPERTIES));
			hstTexto = new HStaticText(
					properties.getProperty("textoContenedorAmarillo"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hstTexto.setFont(new Font("Tiresias", Font.BOLD, 20));
		// texto tamaño y posición x,y,x,y
		hstTexto.setBounds(x, 530, 720, 50);
		hstTexto.setBackground(Color.yellow);
		//this.add(hstTexto);
		// mi tamaño y posición x,y,x,y
		this.setBounds(0, 0, 800, 600);
		loadForegroundBitmap();
		this.addKeyListener(this);
		
	}

	public void keyPressed(KeyEvent tecla) {

		switch (tecla.getKeyCode()) {
		case 39:
			x = x + 100;
			hstTexto.setBounds(x, 530, 200, 50);
			this.repaint();
			break;
		case 37:
			x = x - 100;
			hstTexto.setBounds(x, 530, 200, 50);
			this.repaint();
			break;
			
		case 27:
			//exit
			MainXlet.label.setBackground(Color.white);
			MainXlet.label.repaint();
			MainXlet.scene.requestFocus();
			texto.setVisible(false);
			//this.repaint();
			MainXlet.contYellow.setVisible(false);
			break;
			
			
		case 403: {
			System.out.println("boton rojo siempre llama al teclado ...");
			MainXlet.keyboard.setVisible(true);
			MainXlet.keyboard.requestFocus();	
			ContenedorKeyboard.invokeFather=Constant.AMARILLO;
			texto.setVisible(false);
			MainXlet.contYellow.setVisible(false);
			break;
		}
		case 404:
			System.out.println("verde");
			texto.setVisible(false);
			conTwitter=new ContenedorTwitter();
			this.add(conTwitter);
			conTwitter.requestFocus();
			MainXlet.contYellow.conTwitter.setVisible(true);
			fondoAplic.flush();
			this.repaint();
			break;
		case 405:
			System.out.println("amarillo");
			texto.setVisible(false);
			this.add(base);
			base.setVisible(true);
			this.add(calcu);
			calcu.setVisible(true);
			calcu.requestFocus();
			MainXlet.contYellow.setVisible(true);
			fondoAplic.flush();
			this.repaint();
			break;
		default: {
			// do nothing
			System.out.println("default case en contenedor amarillo ...");
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
		fondoAplic = Toolkit.getDefaultToolkit().getImage("FondoAplic.jpg");

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

		if (fondoAplic != null) {
			// Draw the image from the buffer
			graphics.drawImage(fondoAplic, 0, 0, null); //ubicacion de calculadora

		}

		graphics.setColor(Color.RED);
		graphics.setFont(new Font("Tiresias", Font.PLAIN, 20));

		super.paint(graphics);


	}
}