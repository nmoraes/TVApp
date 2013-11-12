package calc;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.havi.ui.HContainer;


public class Base extends HContainer implements KeyListener {

 /**
	 Agrego aca serialVersion que no se que es pero pide que lo haga el compilador
	 */
	private static final long serialVersionUID = 1L;
public double suma(double a,double b){
 double r=a+b; 
 return r;
 }
 public double resta(double a,double b){
 double r=a-b;
 return r;
 }
 public double mul(double a,double b){
 double r=a*b;
 return r;
 }
 public double div(double a,double b){
 double r=a/b;
 return r;
 }
public void keyPressed(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}
public void keyReleased(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}
public void keyTyped(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}
public void setVisible(boolean b) {
	// TODO Auto-generated method stub
	
}
 }

 
