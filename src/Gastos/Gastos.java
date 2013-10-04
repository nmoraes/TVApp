package Gastos;

import javax.swing.*;

import java.awt.*;



public class Gastos {

	private JFrame f;
	private JPanel p;
	private JButton b1;
	private JLabel lab;
	
	public Gastos(){
		
		gui();
	}
	
	public void gui(){
		
		f = new JFrame ("Gastos");
		f.setVisible(true);
		f.setSize(600, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p = new JPanel();
		p.setBackground(Color.blue);
		
		b1 = new JButton("Exit");
		b1.setAlignmentX(100);
		b1.setAlignmentY(100);
		lab = new JLabel("Salir");
		
		p.add(b1);
		p.add(lab);
		
		f.add(p);
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Gastos();
		

		
	}

}
