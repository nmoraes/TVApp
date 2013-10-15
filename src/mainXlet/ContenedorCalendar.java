package mainXlet;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import org.havi.ui.HContainer;
import org.havi.ui.HStaticText;

import calendar.Cal;

public class ContenedorCalendar extends HContainer implements KeyListener {

	
	Cal calendar=new Cal();

	public ContenedorCalendar() {
		calendar.setBounds(0, 0, 200, 50);
		this.add(calendar);
		// mi tama�o y posici�n x,y,x,y
		this.setBounds(0, 0, 800, 200);
		this.addKeyListener(this);
		
	}

	public void keyPressed(KeyEvent tecla) {

		switch (tecla.getKeyCode()) {
			
		case 27:
			//exit
			HelloTVXlet.label.setBackground(Color.white);
			HelloTVXlet.label.repaint();
			HelloTVXlet.scene.requestFocus();
			//this.repaint();
			break;	
		
		default: {
			// do nothing
			System.out.println("default case ...");
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