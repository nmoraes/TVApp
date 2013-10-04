package Gastos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import org.havi.ui.HContainer;
import org.havi.ui.HStaticText;
import mainXlet.*;

public class Gastos1 extends HContainer implements KeyListener {

	HStaticText titulo = new HStaticText ("Detalle                                  Cant  Unit.  Monto");
	HStaticText titulo2 = new HStaticText ("Resumen Mes");
	HStaticText titulo3 = new HStaticText ("Resumen Año");
	public Gastos1 (){
		
		// Tipo de letra
		titulo.setFont( new Font ("Tiresias", Font.BOLD, 20));
		titulo2.setFont( new Font ("Tiresias", Font.BOLD, 20));
		titulo3.setFont( new Font ("Tiresias", Font.BOLD, 20));
		
	
		// Posicion inicial en la pantalla y color
		titulo.setBounds(50, 400, 400, 30);
		titulo2.setBounds(50, 300, 100, 30);
		titulo3.setBounds(150, 300, 100, 30);
		
		titulo.setBackground(Color.darkGray);
		titulo2.setBackground(Color.darkGray);
		titulo3.setBackground(Color.darkGray);
		
		this.add(titulo);
		this.add(titulo2);
		this.add(titulo3);
		
		this.setBounds(0, 0, 800, 200);
		this.addKeyListener(this);
	
	}
	
	public void keyPressed(KeyEvent tecla){
		
		System.out.println("Prueba!!!");
		
		switch (tecla.getKeyCode()){

		case 39:
			//derecha
			titulo.setBackground(Color.blue);
			this.repaint();
			break;
		case 37:
			//izquierda
			titulo.setBackground(Color.red);
			this.repaint();
			break;
		
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

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}

