package calc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import mainXlet.MainXlet;

import org.havi.ui.HContainer;
import org.havi.ui.HSinglelineEntry;
import org.havi.ui.HState;
import org.havi.ui.HVisible;

public class Calcu extends HContainer implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * blic static void main(String arg[]) { // METODO PRINCIPAL Calcu n = new
	 * Calcu(); n.setBounds(0, 0, 800, 200); //n.setVisible(true);
	 * //n.setResizable(true);
	 * 
	 * }
	 */
	private Image image;
	HSinglelineEntry pantalla;// = new JTextField(50);
	String v1 = "";
	String v2 = "";
	long resultado = 0;
	boolean estoyUsandoV1 = true;
	boolean limpiar = false;
	String operador = "";
	String message = "";

	// CONSTRUCTOR
	public Calcu() {
		// HStaticText hstTexto = new HStaticText(" Menu akdjkfhhf ");
		pantalla = new HSinglelineEntry("", 14, 250, 200, 50, 20, new Font(
				"Tiresias", Font.PLAIN, 22), Color.black);
		pantalla.setType(org.havi.ui.HKeyboardInputPreferred.INPUT_ANY);
		pantalla.setBackground(Color.green);
		pantalla.setHorizontalAlignment(HVisible.HALIGN_LEFT);
		pantalla.setEditMode(true);
		pantalla.setCaretCharPosition(1);
		/**
		 * cajaDetalle = new HSinglelineEntry("", 30, 290, 240, 30, 12, new
		 * Font("Tiresias", Font.BOLD, 22), Color.blue);
		 * cajaDetalle.setType(org.havi.ui.HKeyboardInputPreferred.INPUT_ANY);
		 * cajaDetalle.setBackground(Color.white);
		 * cajaDetalle.setBackgroundMode(org.havi.ui.HVisible.BACKGROUND_FILL);
		 * cajaDetalle.setHorizontalAlignment(HVisible.HALIGN_LEFT);
		 * cajaDetalle.setEditMode(true); cajaDetalle.setCaretCharPosition(1);
		 */
		// pantalla.setText("0");
		// // Textfields
		// pantalla.setBounds(120, 150, 200, 50);
		// pantalla.setBackground(Color.green);

		// hstTexto.setFont(new Font("Tiresias", Font.BOLD, 20));
		// texto tama�o y posici�n x,y,x,y
		// hstTexto.setBounds(120, 150, 200, 50);
		// hstTexto.setBackground(Color.green);
		// this.add(hstTexto);
		this.setBounds(0, 0, 400, 600);
		this.addKeyListener(this);
		loadForegroundBitmap();
		this.add(pantalla);
	}

	public void keyPressed(KeyEvent tecla) {

		System.out.println(tecla.getKeyCode());
		switch (tecla.getKeyCode()) {

		case 48: // 0
			if (limpiar)
				pantalla.setTextContent("", HState.ALL_STATES);
			pantalla.setTextContent(
					(pantalla.getTextContent(HState.ALL_STATES) + "0"),
					HState.ALL_STATES);
			if (estoyUsandoV1) {

				v1 += "0";
			} else {
				v2 += "0";
			}
			limpiar = false;

			break;
		case 49: // 1;
			if (limpiar)
				pantalla.setTextContent("", HState.ALL_STATES);
			pantalla.setTextContent(
					(pantalla.getTextContent(HState.ALL_STATES) + "1"),
					HState.ALL_STATES);
			if (estoyUsandoV1) {

				v1 += "1";
			} else {
				v2 += "1";
			}

			limpiar = false;
			break;
		case 50: // 2
			if (limpiar)
				pantalla.setTextContent("", HState.ALL_STATES);
			pantalla.setTextContent(
					(pantalla.getTextContent(HState.ALL_STATES) + "2"),
					HState.ALL_STATES);
			// this.repaint();

			break;
		case 51: // 3
			if (limpiar)
				pantalla.setTextContent("", HState.ALL_STATES);
			pantalla.setTextContent(
					(pantalla.getTextContent(HState.ALL_STATES) + "3"),
					HState.ALL_STATES);
			// this.repaint();

			break;
		case 52: // 4
			if (limpiar)
				pantalla.setTextContent("", HState.ALL_STATES);
			pantalla.setTextContent(
					(pantalla.getTextContent(HState.ALL_STATES) + "4"),
					HState.ALL_STATES);
			// this.repaint();

			break;
		case 53: // 5
			if (limpiar)
				pantalla.setTextContent("", HState.ALL_STATES);
			pantalla.setTextContent(
					(pantalla.getTextContent(HState.ALL_STATES) + "5"),
					HState.ALL_STATES);
			// this.repaint();

			break;
		case 54: // 6
			if (limpiar)
				pantalla.setTextContent("", HState.ALL_STATES);
			pantalla.setTextContent(
					(pantalla.getTextContent(HState.ALL_STATES) + "6"),
					HState.ALL_STATES);
			// this.repaint();

			break;
		case 55: // 7
			if (limpiar)
				pantalla.setTextContent("", HState.ALL_STATES);
			pantalla.setTextContent(
					(pantalla.getTextContent(HState.ALL_STATES) + "7"),
					HState.ALL_STATES);
			// this.repaint();

			break;

		case 56: // 8
			if (limpiar)
				pantalla.setTextContent("", HState.ALL_STATES);
			pantalla.setTextContent(
					(pantalla.getTextContent(HState.ALL_STATES) + "8"),
					HState.ALL_STATES);
			// this.repaint();

			break;
		case 57: // 9
			if (limpiar)
				pantalla.setTextContent("", HState.ALL_STATES);
			pantalla.setTextContent(
					(pantalla.getTextContent(HState.ALL_STATES) + "9"),
					HState.ALL_STATES);
			// this.repaint();

			break;
		case 403: // +
			limpiar = true;
			if (estoyUsandoV1) {
				estoyUsandoV1 = false;
				operador = "+";
			} else {
				long v1l = Long.valueOf(v1);
				long v2l = Long.valueOf(v2);
				System.out.println(v1l);
				System.out.println(v2l);
				System.out.println(resultado);
				if (operador == "+")
					resultado = v1l + v2l;
				if (operador == "-")
					resultado = v1l - v2l;
				if (operador == "*")
					resultado = v1l * v2l;
				if (operador == "/")
					resultado = v1l / v2l;
				operador = "+";
				v1 = String.valueOf(resultado);
				estoyUsandoV1 = false;
				v2 = "";
				pantalla.setTextContent(String.valueOf(resultado),
						HState.ALL_STATES);
			}

			this.repaint();

			break;
		case 404: // -
			limpiar = true;
			if (estoyUsandoV1) {
				estoyUsandoV1 = false;
				operador = "-";
			} else {
				long v1l = Long.valueOf(v1);
				long v2l = Long.valueOf(v2);
				System.out.println(v1l);
				System.out.println(v2l);
				System.out.println(resultado);
				if (operador == "+")
					resultado = v1l + v2l;
				if (operador == "-")
					resultado = v1l - v2l;
				if (operador == "*")
					resultado = v1l * v2l;
				if (operador == "/")
					resultado = v1l / v2l;
				operador = "-";
				v1 = String.valueOf(resultado);
				estoyUsandoV1 = false;
				v2 = "";
				pantalla.setTextContent(String.valueOf(resultado),
						HState.ALL_STATES);
			}

			this.repaint();

			break;
		case 405: // *
			limpiar = true;
			if (estoyUsandoV1) {
				estoyUsandoV1 = false;
				operador = "*";
			} else {
				long v1l = Long.valueOf(v1);
				long v2l = Long.valueOf(v2);
				System.out.println(v1l);
				System.out.println(v2l);
				System.out.println(resultado);
				if (operador == "+")
					resultado = v1l + v2l;
				if (operador == "-")
					resultado = v1l - v2l;
				if (operador == "*")
					resultado = v1l * v2l;
				if (operador == "/")
					resultado = v1l / v2l;
				operador = "*";
				v1 = String.valueOf(resultado);
				estoyUsandoV1 = false;
				v2 = "";
				pantalla.setTextContent(String.valueOf(resultado),
						HState.ALL_STATES);
			}

			this.repaint();

			break;
		case 406: // /
			limpiar = true;
			if (estoyUsandoV1) {
				estoyUsandoV1 = false;
				operador = "/";
			} else {
				long v1l = Long.valueOf(v1);
				long v2l = Long.valueOf(v2);
				System.out.println(v1l);
				System.out.println(v2l);
				System.out.println(resultado);
				if (operador == "+")
					resultado = v1l + v2l;
				if (operador == "-")
					resultado = v1l - v2l;
				if (operador == "*")
					resultado = v1l * v2l;
				if (operador == "/")
					resultado = v1l / v2l;
				operador = "/";
				v1 = String.valueOf(resultado);
				estoyUsandoV1 = false;
				v2 = "";
				pantalla.setTextContent(String.valueOf(resultado),
						HState.ALL_STATES);
			}

			this.repaint();

			break;
		case 10: // =
			limpiar = true;
			if (!estoyUsandoV1) {
				long v1l = Long.valueOf(v1);
				long v2l = Long.valueOf(v2);
				System.out.println(v1l);
				System.out.println(v2l);
				System.out.println(resultado);
				if (operador == "+")
					resultado = v1l + v2l;
				if (operador == "-")
					resultado = v1l - v2l;
				if (operador == "*")
					resultado = v1l * v2l;
				if (operador == "/")
					resultado = v1l / v2l;
				operador = "";
				v1 = String.valueOf(resultado);
				estoyUsandoV1 = true;
				v2 = "";
				pantalla.setTextContent(String.valueOf(resultado),
						HState.ALL_STATES);
			}

			this.repaint();

			break;

		case 27: // exit

			MainXlet.label.setBackground(Color.white);
			MainXlet.calcu.setVisible(false);
			MainXlet.label.repaint();
			MainXlet.scene.requestFocus();
			this.repaint();
			break;
		case 151:
			pantalla.setTextContent("", HState.ALL_STATES);

		default: { // do nothing
			System.out.println("default case ...");
			System.out.println(tecla);
			break;
		}

		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void loadForegroundBitmap() {
		// Create a MediaTracker to tell us when the image has loaded
		MediaTracker tracker = new MediaTracker(this);
		// Then load the image
		image = Toolkit.getDefaultToolkit().getImage("Calculadora.png");

		// add the image to the MediaTracker...
		tracker.addImage(image, 0);

		// ...and wait for it to finish loading
		try {
			tracker.waitForAll();
		} catch (InterruptedException e) {
			// Ignore the exception, since there's not a lot we can do.
			image = null;

		}
	}

	/**
	 * This is a standard AWT paint method for repainting the contents of the
	 * component.
	 */
	public void paint(Graphics graphics) {

		if (image != null) {
			// Draw the image from the buffer
			graphics.drawImage(image, 7, 250, null);

		}

		graphics.setColor(Color.RED);
		graphics.setFont(new Font("Tiresias", Font.PLAIN, 20));

		super.paint(graphics);

		// try{
		// graphics.drawString(message,0,100);
		//
		// }catch(Throwable t) {
		// // Catch any errors that get thrown.
		// t.printStackTrace();
		// }

	}

}