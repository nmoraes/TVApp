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
import java.util.ArrayList;
import java.util.List;

import org.havi.ui.HContainer;
import org.havi.ui.HMultilineEntry;
import org.havi.ui.HSinglelineEntry;
import org.havi.ui.HState;
import org.havi.ui.HStaticText;
import org.havi.ui.HVisible;

import twitter.FachadaTwitter;
import twitter.Tweet;

public class ContenedorTwitter extends HContainer implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5292849366437972565L;

	HStaticText hstTexto;
	private String tweet;
	HStaticText nuevoTweet;
	//(int x, int y, int width, int height, int maxChars)
	HMultilineEntry multiEntrada;
	
    // The image that we will show   
    private Image image;
	
    private String timeline;

    private ArrayList <String>array= new ArrayList <String>();
    
    public static boolean escribir = false;

	@SuppressWarnings("unchecked")
	public ContenedorTwitter() {

		tweet="";
		//timeline=obtenerTweets();
		array=obtenerTweets();
		//hstTexto = new HStaticText(timeline);
		//hstTexto.setFont(new Font("Tiresias", 0, 14));
		// texto tamaño y posición x,y,x,y
		//hstTexto.setBounds(100, 350, 400, 200);
		//hstTexto.setBackground(Color.white);
		//this.add(hstTexto);
		nuevoTweet = new HStaticText("Rojo para escribir nuevo tweet");
		nuevoTweet.setFont(new Font("Tiresias", 0, 14));
		// texto tamaño y posición x,y,x,y
		nuevoTweet.setBounds(10, 110, 350, 100);
		nuevoTweet.setBackground(Color.white);
		this.add(nuevoTweet);
		// mi tamaño y posición x,y,x,y
		loadForegroundBitmap();
		
		this.setBounds(0, 0, 800, 600);
		this.addKeyListener(this);
	}
	
	

	public void keyPressed(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
		case 403:
			System.out.println("boton rojo siempre llama al teclado ...");
			escribir = true;
			MainXlet.miniWeather.setVisible(false);
			MainXlet.keyboard.setVisible(true);
			timeline="";
			MainXlet.keyboard.requestFocus();	
			ContenedorKeyboard.invokeFather=Constant.CONTENEDOR_TWITTER;
			array.set(0, "");
			array.set(1, "");
			array.set(2, "");
			array.set(3, "");
			array.set(4, "");
			
			break;
		case 27:
			//exit
			MainXlet.label.setBackground(Color.white);
			ContenedorYellow.conTwitter.setVisible(false);
			MainXlet.label.repaint();
			MainXlet.scene.requestFocus();
			array=obtenerTweets();
			this.repaint();
			break;
			

		}
	}

	public void keyReleased(KeyEvent arg0) {

	}

	public void keyTyped(KeyEvent arg0) {

	}

	private ArrayList obtenerTweets() {
		FachadaTwitter ft = new FachadaTwitter();
		List lista = ft.getHomeTimeLine();
		//StringBuilder tl = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			Tweet tweet = (Tweet) lista.get(i);			
			String tw=tweet.getUsuario() + ": " + tweet.getMensaje();
			array.add(i, tw);
		}
		return array;

	}

	
	public static void escribirTweet(String tweet){
		FachadaTwitter ft=new FachadaTwitter();
		ft.escribirTweet(tweet);
	}
	
	
	 public void loadForegroundBitmap() {   
	        // Create a MediaTracker to tell us when the image has loaded   
	        MediaTracker tracker = new MediaTracker(this);   
	        // Then load the image   
	       image = Toolkit.getDefaultToolkit().getImage("textTwitter.png");   
	             	
	        
	        // add the image to the MediaTracker...
	       // tracker.addImage(image, 0);
	        tracker.addImage(image, 0);
	        
	        
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
		
		try {

		     graphics.setFont(new Font("Tiresias", Font.PLAIN, 15));   
		        // Set the text colour   
		        graphics.setColor(Color.white);
			
			graphics.drawString(array.get(0), 12, 300);
			graphics.drawString(array.get(1), 12, 315);
			graphics.drawString(array.get(2), 12, 330);
			graphics.drawString(array.get(3), 12, 345);
			graphics.drawString(array.get(4), 12, 360);
			
			graphics.setColor(Color.black);

			if (image != null && escribir == true) {
				graphics.drawImage(image, 150, 230, null);   
				graphics.setFont(new Font("Tiresias", Font.PLAIN, 15));
				graphics.drawString(ContenedorKeyboard.message, 158, 245);

			}
		} catch (Throwable t) {

			System.out.println("error al escribir");
		}
	}
	

}
