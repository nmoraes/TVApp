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

	HStaticText hstTexto = new HStaticText(" twitter ");

	public ContenedorTwitter() {
		hstTexto.setFont(new Font("Tiresias", Font.BOLD, 20));
		// texto tamaño y posición x,y,x,y
		hstTexto.setBounds(10, 10, 200, 300);
		hstTexto.setBackground(Color.blue);
		this.add(hstTexto);
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

	private void obtenerTweets() {
		FachadaTwitter ft = new FachadaTwitter();
		List lista = ft.getHomeTimeLine();
		StringBuilder tl = new StringBuilder();
		for (int i = 0; i < lista.size(); i++) {
			Tweet tweet = (Tweet) lista.get(i);
			tl.append(tweet.getUsuario() + " " + tweet.getMensaje()+"\n");
		}
		System.out.println(tl);
		// hstTexto.setTextContent(tl.toString(), 0);

	}
	
	public static void main(String[] args) {
		ContenedorTwitter ct=new ContenedorTwitter();
	}

}
