package Gastos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import org.havi.ui.HContainer;
import org.havi.ui.HStaticText;

import mainXlet.*;

public class Gastos1 extends HContainer implements KeyListener {

	HStaticText titulo = new HStaticText ("Detalle                                  Cant  Unit.  Monto");
	HStaticText titulo2 = new HStaticText ("Resumen Mes");
	HStaticText titulo3 = new HStaticText ("Resumen Año");
	JTextField det1 = new JTextField(20); JTextField can1 = new JTextField(20);
	JTextField det2 = new JTextField(20); JTextField can2 = new JTextField(20);
	JTextField det3 = new JTextField(20); JTextField can3 = new JTextField(20);
	JTextField det4 = new JTextField(20); JTextField can4 = new JTextField(20);
	JTextField det5 = new JTextField(20); JTextField can5 = new JTextField(20);
	JTextField det6 = new JTextField(20); JTextField can6 = new JTextField(20);
	JTextField det7 = new JTextField(20); JTextField can7 = new JTextField(20);
	JTextField det8 = new JTextField(20); JTextField can8 = new JTextField(20);
	JTextField det9 = new JTextField(20); JTextField can9 = new JTextField(20);
	
	JTextField uni1 = new JTextField(20);
	JTextField uni2 = new JTextField(20);
	JTextField uni3 = new JTextField(20);
	JTextField uni4 = new JTextField(20);
	JTextField uni5 = new JTextField(20);
	JTextField uni6 = new JTextField(20);
	JTextField uni7 = new JTextField(20);
	JTextField uni8 = new JTextField(20);
	JTextField uni9 = new JTextField(20);
	JTextField mon1 = new JTextField(20);
	JTextField mon2 = new JTextField(20);
	JTextField mon3 = new JTextField(20);
	JTextField mon4 = new JTextField(20);
	JTextField mon5 = new JTextField(20);
	JTextField mon6 = new JTextField(20);
	JTextField mon7 = new JTextField(20);
	JTextField mon8 = new JTextField(20);
	JTextField mon9 = new JTextField(20);

	
	
	public Gastos1 (){
		
		// Tipo de letra
		titulo.setFont( new Font ("Tiresias", Font.BOLD, 20));
		titulo2.setFont( new Font ("Tiresias", Font.BOLD, 20));
		titulo3.setFont( new Font ("Tiresias", Font.BOLD, 20));
		
	
		// Posicion inicial en la pantalla y color
		titulo.setBounds(50, 10, 400, 30);
		titulo2.setBounds(50, 40, 100, 30);
		titulo3.setBounds(150, 40, 100, 30);
		
		titulo.setBackground(Color.darkGray);
		titulo2.setBackground(Color.darkGray);
		titulo3.setBackground(Color.darkGray);
		
		this.add(titulo);
		this.add(titulo2);
		this.add(titulo3);
		
		// prueba de textfield
		uni1.setBounds(10, 100, 100, 20);
		uni1.setBackground(Color.magenta);
		this.add(uni1);
		
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

