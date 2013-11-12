package calc;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;


import mainXlet.MainXlet;

import org.havi.ui.HContainer;




public class Calcu extends HContainer implements KeyListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* blic static void main(String arg[]) { // METODO PRINCIPAL
		Calcu n = new Calcu();
		n.setBounds(0, 0, 800, 200);
	    //n.setVisible(true);
	    //n.setResizable(true);
	   
	}*/

	JTextField detCompra = new JTextField(50);
	String v1="";
	String v2="";
	long resultado=0;
	boolean estoyUsandoV1=true;
	boolean limpiar=true;
	String operador="";
	// CONSTRUCTOR
	public Calcu() {
		//HStaticText hstTexto = new HStaticText(" Menu akdjkfhhf ");
		
		detCompra.setText("0");
		// Textfields
		detCompra.setBounds(120, 150, 200, 50); 
		detCompra.setBackground(Color.green); 
		this.add(detCompra);
				
			//hstTexto.setFont(new Font("Tiresias", Font.BOLD, 20));
			// texto tamaño y posición x,y,x,y
			//hstTexto.setBounds(120, 150, 200, 50);
			//hstTexto.setBackground(Color.green);
			//this.add(hstTexto);
		this.setBounds(200, 200, 800, 200);
		this.addKeyListener(this);
	
	}	

		public void keyPressed(KeyEvent tecla){
			
			
			System.out.println(tecla.getKeyCode());
			switch (tecla.getKeyCode()){
			
			case 	48: 	// 0
				if(limpiar) detCompra.setText("");
				detCompra.setText(detCompra.getText() + "0");
				if(estoyUsandoV1){
					
					v1+="0";
				}
				else{
					v2+="0";
				}
				limpiar=false;
				this.repaint();
				
				break;
			case 	49: 	// 1;
				if(limpiar) detCompra.setText("");
				detCompra.setText(detCompra.getText() + "1");
				if(estoyUsandoV1){
					
					v1+="1";
				}
				else{
					v2+="1";
				}
				this.repaint();
				limpiar=false;
				break;
			case 	50: 	// 2
				detCompra.setText(detCompra.getText() + "2");
				this.repaint();
				
				break;
			case 	51: 	// 3
				detCompra.setText(detCompra.getText() + "3");
				this.repaint();
				
				break;
			case 	52: 	// 4
				detCompra.setText(detCompra.getText() + "4");
				this.repaint();
				
				break;
			case 	53: 	// 5
				detCompra.setText(detCompra.getText() + "5");
				this.repaint();
				
				break;
			case 	54: 	// 6
				detCompra.setText(detCompra.getText() + "6");
				this.repaint();
				
				break;
			case 	55: 	// 7
				detCompra.setText(detCompra.getText() + "7");
				this.repaint();
				
				break;

			case 	56: 	// 8
				detCompra.setText(detCompra.getText() + "8");
				this.repaint();
				
				break;
			case 	57: 	// 9
				detCompra.setText(detCompra.getText() + "9");
				this.repaint();
				
				break;
			case 	403: 	// +
				limpiar=true;
				if(estoyUsandoV1){
					estoyUsandoV1=false;
					operador="+";
				}
				else{
					long v1l=Long.valueOf(v1);
					long v2l=Long.valueOf(v2);
					System.out.println(v1l);
					System.out.println(v2l);
					System.out.println(resultado);
					if(operador=="+") resultado=v1l+v2l;
					if(operador=="-") resultado=v1l-v2l;
					if(operador=="*") resultado=v1l*v2l;
					if(operador=="/") resultado=v1l/v2l;
					operador="+";
					v1=String.valueOf(resultado);
					estoyUsandoV1=false;
					v2="";
					detCompra.setText(String.valueOf(resultado));
				}
			
				this.repaint();
				
				break;
			case 	404: 	// -
				limpiar=true;
				if(estoyUsandoV1){
					estoyUsandoV1=false;
					operador="-";
				}
				else{
					long v1l=Long.valueOf(v1);
					long v2l=Long.valueOf(v2);
					System.out.println(v1l);
					System.out.println(v2l);
					System.out.println(resultado);
					if(operador=="+") resultado=v1l+v2l;
					if(operador=="-") resultado=v1l-v2l;
					if(operador=="*") resultado=v1l*v2l;
					if(operador=="/") resultado=v1l/v2l;
					operador="-";
					v1=String.valueOf(resultado);
					estoyUsandoV1=false;
					v2="";
					detCompra.setText(String.valueOf(resultado));
				}
			
				this.repaint();
				
				break;
			case 	405: 	// *
				limpiar=true;
				if(estoyUsandoV1){
					estoyUsandoV1=false;
					operador="*";
				}
				else{
					long v1l=Long.valueOf(v1);
					long v2l=Long.valueOf(v2);
					System.out.println(v1l);
					System.out.println(v2l);
					System.out.println(resultado);
					if(operador=="+") resultado=v1l+v2l;
					if(operador=="-") resultado=v1l-v2l;
					if(operador=="*") resultado=v1l*v2l;
					if(operador=="/") resultado=v1l/v2l;
					operador="*";
					v1=String.valueOf(resultado);
					estoyUsandoV1=false;
					v2="";
					detCompra.setText(String.valueOf(resultado));
				}
			
				this.repaint();
				
				break;
			case 	406: 	// /
				limpiar=true;
				if(estoyUsandoV1){
					estoyUsandoV1=false;
					operador="/";
				}
				else{
					long v1l=Long.valueOf(v1);
					long v2l=Long.valueOf(v2);
					System.out.println(v1l);
					System.out.println(v2l);
					System.out.println(resultado);
					if(operador=="+") resultado=v1l+v2l;
					if(operador=="-") resultado=v1l-v2l;
					if(operador=="*") resultado=v1l*v2l;
					if(operador=="/") resultado=v1l/v2l;
					operador="/";
					v1=String.valueOf(resultado);
					estoyUsandoV1=false;
					v2="";
					detCompra.setText(String.valueOf(resultado));
				}
			
				this.repaint();
				
				break;
			case 	10: 	// =
				limpiar=true;
				if(!estoyUsandoV1){
					long v1l=Long.valueOf(v1);
					long v2l=Long.valueOf(v2);
					System.out.println(v1l);
					System.out.println(v2l);
					System.out.println(resultado);
					if(operador=="+") resultado=v1l+v2l;
					if(operador=="-") resultado=v1l-v2l;
					if(operador=="*") resultado=v1l*v2l;
					if(operador=="/") resultado=v1l/v2l;
					operador="";
					v1=String.valueOf(resultado);
					estoyUsandoV1=true;
					v2="";
					detCompra.setText(String.valueOf(resultado));
				}
			
				this.repaint();
				
				break;
			
			case 27:	//exit
				
				MainXlet.label.setBackground(Color.white);
				MainXlet.calcu.setVisible(false);
				MainXlet.label.repaint();
				MainXlet.scene.requestFocus();
				this.repaint();
				break;	
				
			default: {	// do nothing
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



