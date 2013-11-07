package mainXlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import org.havi.ui.HContainer;
import org.havi.ui.HStaticText;

import twitter.FachadaTwitter;
import twitter.Tweet;

public class ContenedorTwitter extends HContainer implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5292849366437972565L;

	HStaticText hstTexto;

	public ContenedorTwitter() {
		String tweets=obtenerTweets();
		hstTexto = new HStaticText(tweets);
		hstTexto.setFont(new Font("Tiresias", 0, 14));
		// texto tama�o y posici�n x,y,x,y
		hstTexto.setBounds(100, 350, 400, 200);
		hstTexto.setBackground(Color.white);
		this.add(hstTexto);
		// mi tama�o y posici�n x,y,x,y
		this.setBounds(100, 0, 800, 600);
		this.addKeyListener(this);
	}

	public void keyPressed(KeyEvent arg0) {

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
		StringBuilder tl=new StringBuilder("Applesfera: La Estrella de la Muerte no se construir� sola: Star Wars Tiny Death \n Star ya disponible para iOS http://t.co/whohFXg8tf \n Chanchos del Uruguay: RT @becapablo: @chanchosUY RADAR en propios antes de la ca\nncha de la luz. Te esperan mas adelante para darte el regalito.\nCiencia y Tecnolog�a: #Tecnologia 18 meses de c�rcel para el due�o de la web de\nenlaces http://t.co/HCOpmFVFOH http://t.co/2KoQlxsIQV \nCiencia y Tecnolog�a: #Ciencia El 'gran hermano' de los osos polares http://t.co/jmu4WhNAED \nChanchos del Uruguay: RT @gcsuburu: @chanchosUY Multiple choque en Rambla portua\nria frente a Torre de Antel. Camineravy patrulkero. Sem�foro siguiente un caos");		
		System.out.println(tl);
		return tl.toString();

	}
	

}
