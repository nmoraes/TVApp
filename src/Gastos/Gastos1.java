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

	// Pantalla Resumen Gastos del mes //
	
	HStaticText titulo = new HStaticText ("detalle                                  cant  unit.  monto");
	HStaticText titulo2 = new HStaticText ("Resumen Mes");
	HStaticText titulo3 = new HStaticText ("Resumen Año");
	JTextField detalle1 = new JTextField(20); JTextField cantidad1 = new JTextField(20); JTextField unitario1 = new JTextField(20);
	JTextField detalle2 = new JTextField(20); JTextField cantidad2 = new JTextField(20); JTextField unitario2 = new JTextField(20);
	JTextField detalle3 = new JTextField(20); JTextField cantidad3 = new JTextField(20); JTextField unitario3 = new JTextField(20);
	JTextField detalle4 = new JTextField(20); JTextField cantidad4 = new JTextField(20); JTextField unitario4 = new JTextField(20);
	JTextField detalle5 = new JTextField(20); JTextField cantidad5 = new JTextField(20); JTextField unitario5 = new JTextField(20);
	JTextField detalle6 = new JTextField(20); JTextField cantidad6 = new JTextField(20); JTextField unitario6 = new JTextField(20);
	JTextField detalle7 = new JTextField(20); JTextField cantidad7 = new JTextField(20); JTextField unitario7 = new JTextField(20);
	JTextField detalle8 = new JTextField(20); JTextField cantidad8 = new JTextField(20); JTextField unitario8 = new JTextField(20);
	JTextField detalle9 = new JTextField(20); JTextField cantidad9 = new JTextField(20); JTextField unitario9 = new JTextField(20);
	
	JTextField monto1 = new JTextField(20);
	JTextField monto2 = new JTextField(20);
	JTextField monto3 = new JTextField(20);
	JTextField monto4 = new JTextField(20);
	JTextField monto5 = new JTextField(20);
	JTextField monto6 = new JTextField(20);
	JTextField monto7 = new JTextField(20);
	JTextField monto8 = new JTextField(20);
	JTextField monto9 = new JTextField(20);
	
	// Pantalla de ingreso de gastos
	
	HStaticText resumenAño = new HStaticText ("Resumen Año");
	HStaticText resumenMes = new HStaticText ("Resumen Mes");
	HStaticText titDetalle = new HStaticText ("Detalle de la compra");
	HStaticText titCantidad = new HStaticText ("Cant.");
	HStaticText titUnitario = new HStaticText ("Unit.");
	HStaticText titMonto = new HStaticText ("Monto");
	
	JTextField detCompra = new JTextField(20);
	JTextField canCompra = new JTextField(20);
	JTextField uniCompra = new JTextField(20);
	JTextField monCompra = new JTextField(20);

	// Primer pantalla de gastos!!!
	public Gastos1(){
		// tipo de letra
		resumenAño.setFont( new Font ("Tiresias", Font.BOLD, 20));
		resumenMes.setFont( new Font ("Tiresias", Font.BOLD, 20));
		titDetalle.setFont( new Font ("Tiresias", Font.BOLD, 20));
		titCantidad.setFont( new Font ("Tiresias", Font.BOLD, 20));
		titUnitario.setFont( new Font ("Tiresias", Font.BOLD, 20));
		titMonto.setFont( new Font ("Tiresias", Font.BOLD, 20));
		
		
		// Posicion inicial en la pantalla y color
		resumenAño.setBounds(50, 200, 140, 30);
		resumenMes.setBounds(250, 200, 140, 30);
		titDetalle.setBounds(50, 300, 240, 30);
		titCantidad.setBounds(290, 300, 45, 30);
		titUnitario.setBounds(335, 300, 45, 30);
		titMonto.setBounds(380, 300, 65, 30);
		
		// Color de fondo
		resumenAño.setBackground(Color.red);
		resumenMes.setBackground(Color.green);
		titDetalle.setBackground(Color.blue);
		titCantidad.setBackground(Color.blue);
		titUnitario.setBackground(Color.blue);
		titMonto.setBackground(Color.blue);
		
		
		// Agrego al contenedor
		this.add(resumenAño);
		this.add(resumenMes);
		this.add(titDetalle);
		this.add(titCantidad);
		this.add(titUnitario);
		this.add(titMonto);
		
		// Textfields
		detCompra.setBounds(50, 350, 240, 20); detCompra.setBackground(Color.white); this.add(detCompra);
		canCompra.setBounds(290, 350, 45, 20); canCompra.setBackground(Color.white); this.add(canCompra);
		uniCompra.setBounds(335, 350, 45, 20); uniCompra.setBackground(Color.white); this.add(uniCompra);
		monCompra.setBounds(380, 350, 65, 20); monCompra.setBackground(Color.white); this.add(monCompra);
		
		this.setBounds(0, 0, 800, 800);
		this.addKeyListener(this);
		
	}
	
	
	public void resumenGastos1 (){
		
		// Tipo de letra
		titulo.setFont( new Font ("Tiresias", Font.BOLD, 20));
		titulo2.setFont( new Font ("Tiresias", Font.BOLD, 20));
		titulo3.setFont( new Font ("Tiresias", Font.BOLD, 20));
		
	
		// Posicion inicial en la pantalla y color
		titulo.setBounds(50, 50, 400, 30);
		titulo2.setBounds(50, 300, 140, 30);
		titulo3.setBounds(50, 350, 140, 30);
		
		titulo.setBackground(Color.darkGray);
		titulo2.setBackground(Color.darkGray);
		titulo3.setBackground(Color.darkGray);
		
		this.add(titulo);
		this.add(titulo2);
		this.add(titulo3);
		
		// prueba de textfield
		detalle1.setBounds(50, 100, 240, 20); detalle1.setBackground(Color.white); this.add(detalle1);
		detalle2.setBounds(50, 120, 240, 20); detalle2.setBackground(Color.white); this.add(detalle2);
		detalle3.setBounds(50, 140, 240, 20); detalle3.setBackground(Color.white); this.add(detalle3);
		detalle4.setBounds(50, 160, 240, 20); detalle4.setBackground(Color.white); this.add(detalle4);
		detalle5.setBounds(50, 180, 240, 20); detalle5.setBackground(Color.white); this.add(detalle5);
		detalle6.setBounds(50, 200, 240, 20); detalle6.setBackground(Color.white); this.add(detalle6);
		detalle7.setBounds(50, 220, 240, 20); detalle7.setBackground(Color.white); this.add(detalle7);
		detalle8.setBounds(50, 240, 240, 20); detalle8.setBackground(Color.white); this.add(detalle8);
		detalle9.setBounds(50, 260, 240, 20); detalle9.setBackground(Color.white); this.add(detalle9);
		
		cantidad1.setBounds(290, 100, 45, 20); cantidad1.setBackground(Color.white); this.add(cantidad1);
		cantidad2.setBounds(290, 120, 45, 20); cantidad2.setBackground(Color.white); this.add(cantidad2);
		cantidad3.setBounds(290, 140, 45, 20); cantidad3.setBackground(Color.white); this.add(cantidad3);
		cantidad4.setBounds(290, 160, 45, 20); cantidad4.setBackground(Color.white); this.add(cantidad4);
		cantidad5.setBounds(290, 180, 45, 20); cantidad5.setBackground(Color.white); this.add(cantidad5);
		cantidad6.setBounds(290, 200, 45, 20); cantidad6.setBackground(Color.white); this.add(cantidad6);
		cantidad7.setBounds(290, 220, 45, 20); cantidad7.setBackground(Color.white); this.add(cantidad7);
		cantidad8.setBounds(290, 240, 45, 20); cantidad8.setBackground(Color.white); this.add(cantidad8);
		cantidad9.setBounds(290, 260, 45, 20); cantidad9.setBackground(Color.white); this.add(cantidad9);
		
		unitario1.setBounds(335, 100, 45, 20); unitario1.setBackground(Color.white); this.add(unitario1);
		unitario2.setBounds(335, 120, 45, 20); unitario2.setBackground(Color.white); this.add(unitario2);
		unitario3.setBounds(335, 140, 45, 20); unitario3.setBackground(Color.white); this.add(unitario3);
		unitario4.setBounds(335, 160, 45, 20); unitario4.setBackground(Color.white); this.add(unitario4);
		unitario5.setBounds(335, 180, 45, 20); unitario5.setBackground(Color.white); this.add(unitario5);
		unitario6.setBounds(335, 200, 45, 20); unitario6.setBackground(Color.white); this.add(unitario6);
		unitario7.setBounds(335, 220, 45, 20); unitario7.setBackground(Color.white); this.add(unitario7);
		unitario8.setBounds(335, 240, 45, 20); unitario8.setBackground(Color.white); this.add(unitario8);
		unitario9.setBounds(335, 260, 45, 20); unitario9.setBackground(Color.white); this.add(unitario9);
		
		monto1.setBounds(380, 100, 65, 20); monto1.setBackground(Color.white); this.add(monto1);
		monto2.setBounds(380, 120, 65, 20); monto2.setBackground(Color.white); this.add(monto2);
		monto3.setBounds(380, 140, 65, 20); monto3.setBackground(Color.white); this.add(monto3);
		monto4.setBounds(380, 160, 65, 20); monto4.setBackground(Color.white); this.add(monto4);
		monto5.setBounds(380, 180, 65, 20); monto5.setBackground(Color.white); this.add(monto5);
		monto6.setBounds(380, 200, 65, 20); monto6.setBackground(Color.white); this.add(monto6);
		monto7.setBounds(380, 220, 65, 20); monto7.setBackground(Color.white); this.add(monto7);
		monto8.setBounds(380, 240, 65, 20); monto8.setBackground(Color.white); this.add(monto8);
		monto9.setBounds(380, 260, 65, 20); monto9.setBackground(Color.white); this.add(monto9);
		
		
		this.setBounds(0, 0, 800, 800);
		this.addKeyListener(this);
	
	}
	
	public void keyPressed(KeyEvent tecla){
		
		System.out.println("Prueba!!!");
		
		switch (tecla.getKeyCode()){
		
		case 404: 
			System.out.println("Va para Resumen Gastos");
			this.removeAll();
			this.resumenGastos1();
			this.repaint();
			break;

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

