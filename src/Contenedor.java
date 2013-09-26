import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import org.havi.ui.HContainer;
import org.havi.ui.HStaticText;

public class Contenedor extends HContainer implements KeyListener {
	private int x = 0;
	
	HStaticText hstTexto = new HStaticText(" Soy new HContainer ");

	public Contenedor() {
		hstTexto.setFont(new Font("Tiresias", Font.BOLD, 20));
		// texto tamaño y posición x,y,x,y
		hstTexto.setBounds(x, 0, 200, 50);
		hstTexto.setBackground(Color.blue);
		this.add(hstTexto);
		// mi tamaño y posición x,y,x,y
		this.setBounds(0, 0, 400, 200);
		this.addKeyListener(this);
	}

	public void keyPressed(KeyEvent tecla) {
		// boton azul key code = 406
		// boton amarillo key code = 405
		// boton verde key code = 404
		// boton rojo key code = 403
		// boton arriba key code = 38
		// boton derecha key code = 39k
		// boton abajo key code = 40
		// boton izquierda key code = 37
		// boton ok key code = 10
		// boton exit key code = 27
		switch (tecla.getKeyCode()) {
		case 10:
			x = x + 100;
			hstTexto.setBounds(x, 0, 200, 50);
			this.repaint();
			break;
		case 27:
			x = x - 100;
			hstTexto.setBounds(x, 0, 200, 50);
			this.repaint();
			break;
		}
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}