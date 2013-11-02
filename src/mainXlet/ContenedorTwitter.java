package mainXlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
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
	TextArea texto=new TextArea();

	public ContenedorTwitter() {
		String tweets=obtenerTweets();
		hstTexto = new HStaticText(tweets);
		hstTexto.setFont(new Font("Tiresias", 0, 14));
		// texto tamaño y posición x,y,x,y
		hstTexto.setBounds(10, 10, 400, 600);
		texto.setBounds(30, 30, 200, 400);
		hstTexto.setBackground(Color.WHITE);
		this.add(hstTexto);
		this.add(texto);
		// mi tamaño y posición x,y,x,y
		this.setBounds(100, 0, 800, 600);
		this.addKeyListener(this);
		obtenerTweets();
	}

	public void keyPressed(KeyEvent arg0) {

	}

	public void keyReleased(KeyEvent arg0) {

	}

	public void keyTyped(KeyEvent arg0) {

	}

	private String obtenerTweets() {
		FachadaTwitter ft = new FachadaTwitter();
		List lista = ft.getHomeTimeLine();
		StringBuilder tl = new StringBuilder();
		for (int i = 0; i < lista.size(); i++) {
			Tweet tweet = (Tweet) lista.get(i);
			tl.append(tweet.getUsuario() + " " + tweet.getMensaje()+"\n");
		}
		System.out.println(tl);
		return tl.toString();
	//	hstTexto.setTextContent(tl.toString(), 0);

	}
	

}
