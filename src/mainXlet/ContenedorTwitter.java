package mainXlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.havi.ui.HContainer;
import org.havi.ui.HStaticText;

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
		// texto tamaño y posición x,y,x,y
		hstTexto.setBounds(150, 300, 400, 200);
		hstTexto.setBackground(Color.white);
		this.add(hstTexto);
		// mi tamaño y posición x,y,x,y
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
//			tl.append(tweet.getUsuario() + " " + tweet.getMensaje()+"\n");
//		}
		StringBuilder tl=new StringBuilder("Ciencia y TecnologÝa #Tecnologia Call of Duty: Ghosts supera \nlos 1.000 millones de dolares en su lanzamiento http://t.co/Z3bhhki7Bt \n Ciencia y TecnologÝa #Tecnologia Twitter fija en 26 d¾lares el precio de su accion para su salida hoy a Bolsa http://t.co/aNePN7x24S \n Chanchos del Uruguay RT @TAXISmvdUY: MVD/UY-Atenci¾n:HOY,a partir de las 9 hs.,PARO y CONCENTRACIËN de #TAXIS en los alrededores del MTSS,puede afectar el trßnsà\n Android.es una GuÝa 902 en Google Play: http://t.co/spIRelfzMY \n EL PA-S Deportes FOTOS: Goles por doquier en la Champions http://t.co/53J5VugPKH  Eto'o, Ramsey, HiguaÝn... Repase las mejores escenas http://t.co/Sj614YNE8e ");
		System.out.println(tl);
		return tl.toString();
	//	hstTexto.setTextContent(tl.toString(), 0);

	}
	

}
