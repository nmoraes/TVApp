package mainXlet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.havi.ui.HContainer;

public class ContenedorKeyboard  extends HContainer implements KeyListener{



	public static String message="";
	
	public static int invokeFather =0;
	
	// The image that we will show   
    private Image image; 
    private Image image2; 
    
    private boolean shiftFlag = true;
    
    //The pointer
    private int x = 60;
    private int y = 30;
    
    // Variable para manejar el texto en Gastos
    public static int navegadorTextGastos = 0;
    
   
    
    public ContenedorKeyboard(){

		// mi tamaño y posición x,y,x,y
		this.setBounds(0, 330, 800, 200);
		this.addKeyListener(this);
		loadForegroundBitmap();
    	
    }
	
	/**
	 * Procedimiento que oculta el teclado del MainXlet
	 * 
	 * @desc Segun desde que controldor se invoque el teclado este cuando se
	 *       cierre va a devolver el requestFocus a quien lo invoco.
	 * */
	private void closeKeyboard() {

		switch (invokeFather) {
		case Constant.WEATHER:
			// Si estoy dentro del contenedor weather:
			System.out.println("cerrar teclado en weather");
			MainXlet.contWeather.requestFocus();
			break;
		case Constant.ROJO:
			System.out.println("cerrar teclado en rojo");
			MainXlet.contRed.requestFocus();
			break;
		case Constant.AZUL:
			System.out.println("cerrar teclado en azul");
			MainXlet.cont.requestFocus();
			break;
		case Constant.AMARILLO:
			System.out.println("cerrar teclado en amarillo");
			MainXlet.contYellow.requestFocus();
			break;
		case Constant.GASTOS:
			System.out.println("cerrar teclado en gastos");
			MainXlet.gas.seVaElTeclado();
			MainXlet.gas.requestFocus();
			MainXlet.gas.setPrimeraVez(true);
			message = "";
			
			break;
		case Constant.CONTENEDOR_TWITTER:
			System.out.println("cerrar teclado en twitter");
			MainXlet.contYellow.conTwitter.escribir =false;
			ContenedorYellow.flagImage=true;
			//MainXlet.contYellow.conTwitter.hstTexto.setVisible(true);
			MainXlet.miniWeather.setVisible(true);
			MainXlet.contYellow.setVisible(true);
			MainXlet.contYellow.requestFocus();
			break;
		case Constant.CONTENEDOR_AGENDA:
			MainXlet.contRed.agenda.requestFocus();			
			break;
		}

		
		
//		// Si estoy dentro del contenedor amarillo:
//		if (invokeFather == Constant.CONTENEDOR_GASTOS) {
//			System.out.println("cerrar teclado en gastos");
//			MainXlet.contTasks.requestFocus();
//		}
				
		MainXlet.keyboard.setVisible(false);
		MainXlet.keyboard.repaint();
		invokeFather = 0;
//		ContenedorKeyboard.message = "";

	}
	
	
	
	private boolean isShiftFlag() {
		return shiftFlag;
	}

	private void setShiftFlag(boolean shiftFlag) {
		this.shiftFlag = shiftFlag;
	}

	/**
	 * @description botonShift, cambia caracteres de minuscula a mayuscula en el teclado.
	 * @param String
	 * @return String character modificado
	 * */
	private String botonShift(String character){
		String salida=character;
		//Shift no activado, entonces letras minusculas
		if (isShiftFlag() == false) {
			salida= character.toLowerCase();
		}
	return salida;	
	}
	
	
	/**
	 * @description adjustarEjeHorizontal permite mantener el mouse dentro del
	 *              teclado, sin que este, se vaya fuera del teclado, en el caso
	 *              de irse a la izquierda fuera de este, aparecera el
	 *              puntero en el lado derecho y viceversa.
	 * @param int x, int y correspondientes al eje de coordenadas
	 * */
	public void adjustarEjeHorizontal(int x, int y) {
		if (y == 30) {
			if (x >= 665)
				this.x = 60;
			if (x <= 25)
				this.x = 610;
		}

		if (y == 80) {
			if (x > 575)
				this.x = 80;
			if (x < 80)
				this.x = 575;

		}

		if (y == 130) {
			if (x >= 665)
				this.x = 60;
			if (x <= 25)
				this.x = 610;

		}

		if (y == 180) {
			if (x > 630)
				this.x = 80;
			if (x < 80)
				this.x = 630;

		}

	}
	
	/**
	 * @description adjustarEjeVertical permite mantener el mouse dentro del
	 *              teclado, sin que este, se vaya fuera del teclado, en el caso
	 *              de irse para arriba fuera de este, aparecera el
	 *              puntero por debajo, y viceversa.
	 * @param int y correspondientes al eje de coordenadas
	 * */
	public void adjustarEjeVertical(int y) {
		if (y<30){
			this.y=180;
			this.x =80;
		}
		if (y>180){
			this.y=30;
			this.x=60;
		}
	}
	
	
	public void keyPressed(KeyEvent tecla) {
		int numero=0;
		switch (tecla.getKeyCode()) {
		
		case 427:
			
			if (ContenedorKeyboard.invokeFather == Constant.GASTOS){
				
				switch(navegadorTextGastos){
					
				case 0:	navegadorTextGastos = 1;
						message = "";
					break;
					
				case 1: navegadorTextGastos = 2;
						message = "";
				
					break;
					
				case 2: navegadorTextGastos = 0;
						message = "";		
					break;
				}
				
		}
			
			
			if (ContenedorKeyboard.invokeFather == Constant.CONTENEDOR_TWITTER) {

				//PUBLICAR TWITTER
				
				if(message.length()>2)
					ContenedorTwitter.escribirTweet(message);
					
				closeKeyboard();
			}
			
			
		break;
		
		case 39:
			x = x + 55;
			adjustarEjeHorizontal(x,y);
			System.out.println("der cordenadas x = "+x +"y ="+y);
			this.repaint();
			break;
		case 37:
			x = x - 55;
			adjustarEjeHorizontal(x,y);
			System.out.println("izq cordenadas x = "+x +"y ="+y);
			this.repaint();
			break;
			
		case 38:
			y = y -50;
			if(y==30) x = 60;
			if(y==80) x = 80;
			if(y==130) x = 60;
			if(y==180) x = 80;
			System.out.println("arriba cordenadas x = "+x +"y ="+y);
			adjustarEjeVertical(y);
			this.repaint();
			break;
			
		case 40:
			y = y + 50;
			if(y==30) x = 60;
			if(y==80) x = 80;
			if(y==130) x = 60;
			if(y==180) x = 80;
			System.out.println("abajo cordenadas x = "+x +"y ="+y);
			adjustarEjeVertical(y);
			this.repaint();
			
			break;
			
		case 27:
			//exit
			closeKeyboard();
		
			break;	
			
		case 10:
			//OK
			write(x,y);
			break;
			
		case 49:
			numero=1;
			writeNumbers(numero);
			break;	
		
		case 50:
			numero=2;
			writeNumbers(numero);
			break;
			
		case 51:
			numero=3;
			writeNumbers(numero);
			break;	
		
		case 52:
			numero=4;
			writeNumbers(numero);
			break;	
			
		case 53:
			numero=5;
			writeNumbers(numero);
			break;	
			
		case 54:
			numero=6;
			writeNumbers(numero);
			break;
		
		case 55:
			numero=7;
			writeNumbers(numero);
			break;
		case 56:
			numero=8;
			writeNumbers(numero);
			break;	
		
		case 57:
			numero=9;
			writeNumbers(numero);
			break;
		
		case 48:
			numero=0;
			writeNumbers(numero);
			break;	
			
		case 151:
			//*
			message= message+"*";
			this.repaint();
			break;	
			
		case 520:
			//#
			message= message+"#";
			this.repaint();
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

	 public void loadForegroundBitmap() {   
	        // Create a MediaTracker to tell us when the image has loaded   
	        MediaTracker tracker = new MediaTracker(this);   
	        // Then load the image   
	        image = Toolkit.getDefaultToolkit().getImage("keyboardLetters.png");   
	        image2 = Toolkit.getDefaultToolkit().getImage("puntero.png");     	
	        
	        // add the image to the MediaTracker...   
	        tracker.addImage(image, 0); 
	        tracker.addImage(image2, 1); 
	     //   tracker.addImage(image2, 1);
	     
	        // ...and wait for it to finish loading   
	        try{   
	            tracker.waitForAll();   
	        }   
	        catch(InterruptedException e) {   
	            // Ignore the exception, since there's not a lot we can do.   
	            image = null;  
	            image2 = null;
	        }   
	    }   
	
	     
	 
	 /**  
	     * This is a standard AWT paint method for repainting the contents of the  
	     * component.  
	     */   
	    public void paint(Graphics graphics) {   
	   
	        // Get the size of this component so that we can clear it properly.   
	        Dimension size = getSize();   
	        graphics.setColor(new Color(0,0,0,0));
	        graphics.fillRect(0,0,size.width,size.height);   
	        

	        if (image != null) {   
	            // Draw the image from the buffer   
	            graphics.drawImage(image, 50, 0, null);     
	            
	        
	        
	        }
	        if (image2 != null) {   
	            // Draw the image from the buffer   
	            graphics.drawImage(image2, x, y, null);     
	            
	       
	        
	        }
	        
	        System.out.println(message);
	        
//	        graphics.setColor(Color.RED); 
//	        graphics.setFont(new Font("Tiresias", Font.PLAIN, 20));
////	          
////	    
////	        
//	        try{   
//	            graphics.drawString(message,10,125);  
//
//	        }catch(Throwable t) {   
//	            // Catch any errors that get thrown.   
//	            t.printStackTrace();   
//	        } 


	    }   
	    
	    
	public void writeNumbers(int numero){
		message= message+ numero;
		this.repaint();
	}    
	    
	public void write(int x, int y) {
		String character="";
		if (y == 30) {
			switch (x) {
			case 60:
				System.out.println("Q");
				character="Q";
				character=botonShift(character);
				message= message+character;
				this.repaint();

				break;
			case 115:
				System.out.println("W");
				character="W";
				character=botonShift(character);
				message= message+character;
				this.repaint();
				break;

			case 170:				
				System.out.println("E");
				character="E";
				character=botonShift(character);
				message= message+character;
				this.repaint();
				break;

			case 225:			
				System.out.println("R");
				character="R";
				character=botonShift(character);
				message= message+character;
				this.repaint();
				break;

			case 280:			
				System.out.println("T");
				character="T";
				character=botonShift(character);
				message= message+character;
				this.repaint();
				break;

			case 335:				
				System.out.println("Y");
				character="Y";
				character=botonShift(character);
				message= message+character;
				this.repaint();
				break;

			case 390:			
				System.out.println("U");
				character="U";
				character=botonShift(character);
				message= message+character;
				this.repaint();
				break;

			case 445:
			
				System.out.println("I");
				character="I";
				character=botonShift(character);
				message= message+character;
				this.repaint();
				break;

			case 500:			
				System.out.println("O");
				character="O";
				character=botonShift(character);
				message= message+character;
				this.repaint();
				break;
				
			case 555:		
				System.out.println("P");
				character="P";
				character=botonShift(character);
				message= message+character;
				this.repaint();
				break;
			case 610:
			
				System.out.println("borrar");
				int size=message.length();
				
				if(size>=1){
				message=(String) message.subSequence(0, size-1);
				}
				this.repaint();
				break;

			}
			
		}

			if (y == 80) {
				switch (x) {
				case 80:
				
					System.out.println("A");
					character="A";
					character=botonShift(character);
					message= message+character;
					this.repaint();
					break;
					
				case 135:
					System.out.println("S");
					character="S";
					character=botonShift(character);
					message= message+character;
					this.repaint();
					break;
					

				case 190:
					
					System.out.println("D");
					character="D";
					character=botonShift(character);
					message= message+character;
					this.repaint();
					break;
					
				case 245:
					
					System.out.println("F");
					character="F";
					character=botonShift(character);
					message= message+character;
					this.repaint();
					break;
					

				case 300:
					
					System.out.println("G");
					character="G";
					character=botonShift(character);
					message= message+character;
					this.repaint();
					break;
					

				case 355:
					
					System.out.println("H");
					character="H";
					character=botonShift(character);
					message= message+character;
					this.repaint();
					break;
					

				case 410:
					
					System.out.println("J");
					character="J";
					character=botonShift(character);
					message= message+character;
					this.repaint();
					break;
					

				case 465:
					
					System.out.println("K");
					character="K";
					character=botonShift(character);
					message= message+character;
					this.repaint();
					break;
					

				case 520:
					
					System.out.println("L");
					character="L";
					character=botonShift(character);
					message= message+character;
					this.repaint();
					break;
					
				case 575:
					//AUN NO HACE NADA
					System.out.println("enter");

					break;

				}
				

			}
			if (y == 130) {
				
				switch (x) {
				case 60:
					System.out.println("SHIFT");
					if (isShiftFlag()==false)
						setShiftFlag(true);
					else
						setShiftFlag(false);	
					break;
				
				case 115:
				
					System.out.println("Z");
					character="Z";
					character=botonShift(character);
					message= message+character;
					this.repaint();
					break;

				case 170:
					
					System.out.println("X");
					character="X";
					character=botonShift(character);
					message= message+character;
					this.repaint();
					break;

				case 225:
				
					System.out.println("C");
					character="C";
					character=botonShift(character);
					message= message+character;
					this.repaint();
					break;
					

				case 280:
					
					System.out.println("V");
					character="V";
					character=botonShift(character);
					message= message+character;
					this.repaint();
					break;

				case 335:
					
					System.out.println("B");
					character="B";
					character=botonShift(character);
					message= message+character;
					this.repaint();
					break;

				case 390:
				
					System.out.println("N");
					character="N";
					character=botonShift(character);
					message= message+character;
					this.repaint();
					break;

				case 445:
				
					System.out.println("M");
					character="M";
					character=botonShift(character);
					message= message+character;
					this.repaint();
					break;

				case 500:
					//AUN NO HACE NADA
					System.out.println(", !");

					break;
				case 555:
					//AUN NO HACE NADA
					System.out.println("? .");

					break;
				case 610:
					System.out.println("SHIFT");
					if (isShiftFlag()==false)
						setShiftFlag(true);
					else
						setShiftFlag(false);	

					break;

				}

			}
			
		if(y==180){
			
			switch (x) {
			case 80:
				System.out.println("123...");

				break;
			case 135:
			
				System.out.println("twitter");

				break;

			case 190:
				
				System.out.println("twitter");

				break;

			case 245:
			
				System.out.println("espacio");
				message= message+" ";
				this.repaint();

				break;

			case 300:
				
				System.out.println("espacio");
				message= message+" ";
				this.repaint();

				break;

			case 355:
				
				System.out.println("espacio");
				message= message+" ";
				this.repaint();
				break;

			case 410:
			
				System.out.println("espacio");
				message= message+" ";
				this.repaint();

				break;
			
			case 465:
				
				System.out.println("espacio");
				message= message+" ";
				this.repaint();

				break;	
				
			case 520:
				//abrimos el numerico
				System.out.println("123");

				break;

			case 575:
				//abrimos el numerico.
				System.out.println("123");

				break;

			case 630:
				
				closeKeyboard();
				
				break;


			}
			
			
		}	

		}

	}

