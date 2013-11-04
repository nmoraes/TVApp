package mainXlet;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import org.havi.ui.HContainer;
import org.havi.ui.HStaticText;

public class ContenedorRed extends HContainer implements KeyListener {
	private int x = 20;
	
	HStaticText hstTexto = new HStaticText(" Menu Rojo");

	public ContenedorRed() {
		hstTexto.setFont(new Font("Tiresias", Font.BOLD, 20));
		// texto tamaño y posición x,y,x,y
		hstTexto.setBounds(x, 390, 200, 50);
		hstTexto.setBackground(Color.red);
		this.add(hstTexto);
		// mi tamaño y posición x,y,x,y
		this.setBounds(0, 0, 800, 200);
		this.addKeyListener(this);
		
	}

	public void keyPressed(KeyEvent tecla) {

		System.out.println("contenedor red");
		switch (tecla.getKeyCode()) {
		case 39:
			//derecha
			x = x + 100;
			hstTexto.setBounds(x, 150, 200, 50);
			this.repaint();
			break;
		case 37:
			//izquierda
			x = x - 100;
			hstTexto.setBounds(x, 150, 200, 50);
			this.repaint();
			break;
		
		case 27:
			//exit
			MainXlet.label.setBackground(Color.white);
			MainXlet.label.repaint();
			MainXlet.scene.requestFocus();
			//this.repaint();
			break;	
			
			
		case 403: {
			System.out.println("boton rojo siempre llama al teclado ...");
			MainXlet.keyboard.setVisible(true);
			MainXlet.keyboard.requestFocus();	
			ContenedorKeyboard.invokeFather=Constant.ROJO;
	       

			break;
		}	
		

		default: {
			// do nothing
			System.out.println("default case en contenedor rojo...");
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
}