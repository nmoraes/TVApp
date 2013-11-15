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
    public static boolean escribir = false;

	public ContenedorTwitter() {

		tweet="";
		timeline=obtenerTweets();
		hstTexto = new HStaticText(timeline);
		hstTexto.setFont(new Font("Tiresias", 0, 14));
		// texto tamaño y posición x,y,x,y
		hstTexto.setBounds(100, 350, 400, 200);
		hstTexto.setBackground(Color.white);
		this.add(hstTexto);
		nuevoTweet = new HStaticText("Rojo para escribir nuevo tweet");
		nuevoTweet.setFont(new Font("Tiresias", 0, 14));
		// texto tamaño y posición x,y,x,y
		nuevoTweet.setBounds(10, 110, 350, 100);
		nuevoTweet.setBackground(Color.white);
		this.add(nuevoTweet);
		// mi tamaño y posición x,y,x,y
		loadForegroundBitmap();
		
		this.setBounds(0, 0, 300, 700);
		this.addKeyListener(this);
	}
	
	

	public void keyPressed(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
		case 403:
			System.out.println("boton rojo siempre llama al teclado ...");
			escribir = true;
			MainXlet.keyboard.setVisible(true);
			MainXlet.keyboard.requestFocus();	
			ContenedorKeyboard.invokeFather=Constant.CONTENEDOR_TWITTER;
			
			break;
		case 27:
			//exit
			MainXlet.label.setBackground(Color.white);
			ContenedorYellow.conTwitter.setVisible(false);
			MainXlet.label.repaint();
			MainXlet.scene.requestFocus();
			hstTexto.setTextContent("otro texto", HState.ALL_STATES);
			this.repaint();
			break;
			
		case 10:
			//OK
		//	escribirTweet();
			break;
		}
	}

	public void keyReleased(KeyEvent arg0) {

	}

	public void keyTyped(KeyEvent arg0) {

	}

	private String obtenerTweets() {
//		FachadaTwitter ft = new FachadaTwitter();
//		List lista = ft.getHomeTimeLine();
//		StringBuilder tl = new StringBuilder();
//		for (int i = 0; i < 5; i++) {
//			Tweet tweet = (Tweet) lista.get(i);
//			tl.append(tweet.getUsuario() + ": " + tweet.getMensaje()+"\n");
//		}
		StringBuilder tl=new StringBuilder("Applesfera: La Estrella de la Muerte no se construirß sola: Star Wars Tiny Death \n Star ya disponible para iOS http://t.co/whohFXg8tf \n Chanchos del Uruguay: RT @becapablo: @chanchosUY RADAR en propios antes de la ca\nncha de la luz. Te esperan mas adelante para darte el regalito.\nCiencia y TecnologÝa: #Tecnologia 18 meses de cßrcel para el due±o de la web de\nenlaces http://t.co/HCOpmFVFOH http://t.co/2KoQlxsIQV \nCiencia y TecnologÝa: #Ciencia El 'gran hermano' de los osos polares http://t.co/jmu4WhNAED \nChanchos del Uruguay: RT @gcsuburu: @chanchosUY Multiple choque en Rambla portua\nria frente a Torre de Antel. Camineravy patrulkero. Semßforo siguiente un caos");		
		System.out.println(tl);
		return tl.toString();

	}
	public void escribirTweet(){
		System.out.println("tecla");
		//hstTexto.setVisible(false);
		MainXlet.keyboard.setVisible(true);
		MainXlet.keyboard.requestFocus();
		MainXlet.keyboard.invokeFather=Constant.CONTENEDOR_TWITTER;
		tweet=MainXlet.keyboard.message;
		System.out.println("letra "+tweet);
		nuevoTweet.setTextContent(tweet, HState.ALL_STATES);
		
		System.out.println("TWITTER --> "+tweet);
		escribirTweet(tweet);
		this.repaint();
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
		   
	        // Get the size of this component so that we can clear it properly.   
	        //Dimension size = getSize();   
	   
	       // graphics.setColor(Color.white);
	        
	        //graphics.fillRect(0,0,size.width,size.height);   
	        	        
	        
		 
	        if (image != null && escribir==true) {  
	        	
	            // Draw the image from the buffer   
	            graphics.drawImage(image, 5, 190, null);      
	        	 } 
	    
	        
	        // Once we've drawn the image, we can draw the message on top of it.   
	   
	        // Set the font to be the default MHP font.   
	        graphics.setFont(new Font("Tiresias", Font.BOLD, 15));   
	        // Set the text colour   
	        graphics.setColor(Color.RED);
	        

		try {

			graphics.drawString(timeline, 20, 20);
			graphics.setColor(Color.black);

			if (image != null && escribir == true) {
				graphics.setFont(new Font("Tiresias", Font.PLAIN, 15));
				graphics.drawString(ContenedorKeyboard.message, 12, 207);

			}
		} catch (Throwable t) {

			System.out.println("error al escribir");
		}
	}
	
	
	

}
