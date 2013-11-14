package mainXlet;

import java.awt.Color;
import java.awt.Font;
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
	String tweet;
	HStaticText nuevoTweet;
	//(int x, int y, int width, int height, int maxChars)
	HMultilineEntry multiEntrada;
	public ContenedorTwitter() {

		String tweets=obtenerTweets();
		hstTexto = new HStaticText(tweets);
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
//		multiEntrada=new HMultilineEntry(0, 0, 100, 200, 500);
//		multiEntrada.setType(org.havi.ui.HKeyboardInputPreferred.INPUT_ANY);
//		multiEntrada.setBackground(Color.white);
//		multiEntrada.setBackgroundMode(org.havi.ui.HVisible.BACKGROUND_FILL);
//		multiEntrada.setHorizontalAlignment(HVisible.HALIGN_LEFT);
//		multiEntrada.setEditMode(true);
//		multiEntrada.setCaretCharPosition(1);
//		
//		this.add(multiEntrada);
//		multiEntrada.setVisible(true);
		
		this.setBounds(0, 0, 800, 600);
		this.addKeyListener(this);
	}

	public void keyPressed(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
		case 403:
			escribirTweet();
			break;
		case 27:
			MainXlet.label.setBackground(Color.white);
			ContenedorYellow.conTwitter.setVisible(false);
			MainXlet.label.repaint();
			MainXlet.scene.requestFocus();
			hstTexto.setTextContent("otro texto", HState.ALL_STATES);
			this.repaint();
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
	private void escribirTweet(){
		System.out.println("tecla");
		hstTexto.setVisible(false);
		MainXlet.keyboard.setVisible(true);
		MainXlet.keyboard.requestFocus();
		MainXlet.keyboard.invokeFather=Constant.Contenedor_Twitter;
		tweet=MainXlet.keyboard.message;
		System.out.println("letra "+tweet);
		nuevoTweet.setTextContent(tweet, HState.ALL_STATES);
		this.repaint();
	}
	

}
