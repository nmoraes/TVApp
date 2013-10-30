package mainXlet;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import org.havi.ui.HContainer;
import org.havi.ui.HStaticText;

public class ContenedorAzul extends HContainer implements KeyListener {
	private int x = 0;
	
	HStaticText hstTexto = new HStaticText(" Menu Azul ");

	public ContenedorAzul() {
		hstTexto.setFont(new Font("Tiresias", Font.BOLD, 20));
		// texto tamaño y posición x,y,x,y
		hstTexto.setBounds(x, 150, 200, 50);
		hstTexto.setBackground(Color.blue);
		this.add(hstTexto);
		// mi tamaño y posición x,y,x,y
		this.setBounds(0, 0, 800, 200);
		this.addKeyListener(this);
		
	}

	public void keyPressed(KeyEvent tecla) {

		switch (tecla.getKeyCode()) {
		case 39:
			x = x + 100;
			hstTexto.setBounds(x, 150, 200, 50);
			this.repaint();
			break;
		case 37:
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
			ContenedorKeyboard.invokeFather=Constant.AZUL;

			break;
		}	
		
		
		default: {
			// do nothing
			System.out.println("default case en contenedor azul ...");
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