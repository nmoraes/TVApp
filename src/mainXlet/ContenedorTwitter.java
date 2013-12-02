package mainXlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.havi.ui.HContainer;
import twitter.FachadaTwitter;
import twitter.Tweet;

@SuppressWarnings("serial")
public class ContenedorTwitter extends HContainer implements KeyListener {

    private Image image;
    private ArrayList <String>array= new ArrayList <String>();    
    public static boolean escribir = false;
    
    private String message;
    private String message2;
    private String message3;

	@SuppressWarnings("unchecked")
	public ContenedorTwitter() {

		readProperties();
		array = obtenerTweets();
		loadForegroundBitmap();
		this.setBounds(0, 0, 800, 600);
		this.addKeyListener(this);

	}
	
	

	public void keyPressed(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
		case 403:
			//Rojo, llama al teclado
			escribir = true;
			MainXlet.miniWeather.setVisible(false);
			MainXlet.keyboard.setVisible(true);
			MainXlet.keyboard.requestFocus();	
			ContenedorKeyboard.invokeFather=Constant.CONTENEDOR_TWITTER;
			array.set(0, "");
			array.set(1, "");
			array.set(2, "");
			array.set(3, "");
			array.set(4, "");
			array.set(5, "");
			array.set(6, "");
			array.set(7, "");
			array.set(8, "");
			array.set(9, "");
			message="";
			message2="";
			
			
			break;
		case 27:
			//exit
			ContenedorYellow.conTwitter.setVisible(false);
			MainXlet.miniWeather.setVisible(true);
			ContenedorYellow.flagImage=true;
			MainXlet.contYellow.requestFocus();
			array=obtenerTweets();
			readProperties();
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
		for (int i = 0; i < 10; i++) {
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

		MediaTracker tracker = new MediaTracker(this);
		image = Toolkit.getDefaultToolkit().getImage("textTwitter.png");
		tracker.addImage(image, 0);

		try {
			tracker.waitForAll();
		} catch (InterruptedException e) {
			image = null;

		}
	}
	
	 public void paint(Graphics graphics) {   
		
		try {
			
			graphics.setFont(new Font("Tiresias", Font.BOLD, 20));  
			graphics.setColor(Color.white);
			graphics.drawString(message, 90, 160);
			
		    graphics.setFont(new Font("Tiresias", Font.BOLD, 15));   
		    graphics.setColor(Color.black);
			
		    
		    graphics.drawString(array.get(0), 12, 200);
			graphics.drawString(array.get(1), 12, 220);
			graphics.drawString(array.get(2), 12, 240);
			graphics.drawString(array.get(3), 12, 260);
			graphics.drawString(array.get(4), 12, 280);
			graphics.drawString(array.get(5), 12, 300);
			graphics.drawString(array.get(6), 12, 320);
			graphics.drawString(array.get(7), 12, 340);
			graphics.drawString(array.get(8), 12, 360);
			graphics.drawString(array.get(9), 12, 380);
			
			graphics.setFont(new Font("Tiresias", Font.PLAIN, 15));  
			graphics.setColor(Color.black);
			graphics.drawString(message2, 455, 480);
			
			
			if (image != null && escribir == true) {
				graphics.setColor(Color.black);
				graphics.drawImage(image, 150, 230, null);   
				graphics.setFont(new Font("Tiresias", Font.PLAIN, 15));
				graphics.drawString(ContenedorKeyboard.message, 158, 245);
				graphics.setColor(Color.white);
				graphics.drawString(message3, 455, 190);
				message="";
				message2="";

			}
			
	
		} catch (Throwable t) {

			System.out.println("error al escribir");
		}
	}
	

		private void readProperties(){
		
			Properties properties = new Properties();
			try {
				properties.load(new FileInputStream(Constant.CONFIG_PROPERTIES));
				message = properties.getProperty("twittertimeline");
				message2 = properties.getProperty("mensajeIntruccionesTwitter");
				message3 = properties.getProperty("keyboardIntruccion");

			} catch (FileNotFoundException e) {

				System.out.println("I/O excepcion al leer config.properties, asegure tenerlo dentro de la carpeta BIN");
			} catch (IOException e) {
				
				System.out.println("I/O excepcion al leer config.properties, asegure tenerlo dentro de la carpeta BIN");
			}
			
		}
	 
	 
	 
	 
}
