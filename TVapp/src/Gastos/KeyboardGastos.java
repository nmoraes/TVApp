package Gastos;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import mainXlet.ContenedorKeyboard;
import mainXlet.MainXlet;

import org.havi.ui.HContainer;

public class KeyboardGastos extends ContenedorKeyboard implements KeyListener {

	
	public KeyboardGastos(){
		
	}
	
	public void closeKeyboard(){
	    	
		 this.setVisible(false);
			System.out.println("cerrar teclado");
			System.out.println("EXIT");
			
			MainXlet.label.setBackground(Color.green);
			
			MainXlet.label.repaint();
			MainXlet.gas.requestFocus();
			
	    	
	    }
	
	//The pointer
   // private int x = 60;
   // private int y = 30;
    
	
	
	
	/*public void keyPressed(KeyEvent tecla) {

		switch (tecla.getKeyCode()) {
		case 39:
			x = x + 55;
			//System.out.println("der cordenadas x = "+x +"y ="+y);
			//hstTexto.setBounds(x, 0, 200, 50);
			this.repaint();
			//System.out.println("default case ...");
			break;
		case 37:
			x = x - 55;
			//System.out.println("izq cordenadas x = "+x +"y ="+y);
			this.repaint();

			break;
			
		case 38:
			y = y -50;
			if(y==30) x = 60;
			if(y==80) x = 80;
			if(y==130) x = 60;
			if(y==180) x = 80;
			//System.out.println("arriba cordenadas x = "+x +"y ="+y);
			this.repaint();
			break;
			
		case 40:
			y = y + 50;
			if(y==30) x = 60;
			if(y==80) x = 80;
			if(y==130) x = 60;
			if(y==180) x = 80;
			//System.out.println("abajo cordenadas x = "+x +"y ="+y);
			this.repaint();
			
			break;
			
		case 27:
			//exit
			
			this.setVisible(false);
			System.out.println("cerrar teclado");
			System.out.println("EXIT");
			
			MainXlet.label.setBackground(Color.green);
			
			MainXlet.label.repaint();
			MainXlet.gas.requestFocus();
			
			break;	
			
		case 10:
			//OK
			write(x,y);
			break;	
		
		default: {
			// do nothing
			System.out.println("default case ...");
			System.out.println(tecla);
			break;
		}
		}	
		
	}*/
}
