package Gastos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextField;

import org.havi.ui.HContainer;
import org.havi.ui.HSinglelineEntry;
import org.havi.ui.HState;
import org.havi.ui.HStaticText;
import org.havi.ui.HVisible;

import mainXlet.*;

public class ContenedorResumenMes extends HContainer implements KeyListener {
	
	// Pantalla Resumen Gastos del mes //
	
		HStaticText titulo = new HStaticText ("detalle                                  cant  unit.  monto");
		HStaticText titulo2 = new HStaticText ("Resumen Mes");
		HStaticText titulo3 = new HStaticText ("Resumen A�o");
		HSinglelineEntry detalle1; HSinglelineEntry cantidad1; HSinglelineEntry unitario1;
		HSinglelineEntry detalle2; HSinglelineEntry cantidad2; HSinglelineEntry unitario2;
		HSinglelineEntry detalle3; HSinglelineEntry cantidad3; HSinglelineEntry unitario3;
		HSinglelineEntry detalle4; HSinglelineEntry cantidad4; HSinglelineEntry unitario4;
		HSinglelineEntry detalle5; HSinglelineEntry cantidad5; HSinglelineEntry unitario5;
		HSinglelineEntry detalle6; HSinglelineEntry cantidad6; HSinglelineEntry unitario6;
		HSinglelineEntry detalle7; HSinglelineEntry cantidad7; HSinglelineEntry unitario7;
		HSinglelineEntry detalle8; HSinglelineEntry cantidad8; HSinglelineEntry unitario8;
		HSinglelineEntry detalle9; HSinglelineEntry cantidad9; HSinglelineEntry unitario9;
		
		HSinglelineEntry monto1;
		HSinglelineEntry monto2;
		HSinglelineEntry monto3;
		HSinglelineEntry monto4;
		HSinglelineEntry monto5;
		HSinglelineEntry monto6;
		HSinglelineEntry monto7;
		HSinglelineEntry monto8;
		HSinglelineEntry monto9;

		private HSinglelineEntry cajaDetalle;
	
public ContenedorResumenMes () {
		
	System.out.println("Arranca el contenedor gastos mes");
	cajaDetalle = new HSinglelineEntry("", 40, 290, 194, 30, 12, new Font("Tiresias", Font.BOLD, 22), Color.blue);
//   	cajaDetalle.setType(org.havi.ui.HKeyboardInputPreferred.INPUT_ANY);
//   	cajaDetalle.setBackground(Color.white);
//  	cajaDetalle.setBackgroundMode(org.havi.ui.HVisible.BACKGROUND_FILL);
//  	cajaDetalle.setHorizontalAlignment(HVisible.HALIGN_CENTER);
//  	cajaDetalle.setEditMode(true);
//  	cajaDetalle.setCaretCharPosition(1);
//  	this.add(cajaDetalle);
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
		detalle1 = new HSinglelineEntry("", 50, 100, 240, 20, 12, new Font("Tiresias", Font.BOLD, 22), Color.blue); detalle1.setBackground(Color.white); this.add(detalle1);
		detalle2 = new HSinglelineEntry("", 50, 120, 240, 20, 12, new Font("Tiresias", Font.BOLD, 22), Color.blue); detalle2.setBackground(Color.white); this.add(detalle2);
		detalle3 = new HSinglelineEntry("", 50, 140, 240, 20, 12, new Font("Tiresias", Font.BOLD, 22), Color.blue); detalle3.setBackground(Color.white); this.add(detalle3);
		detalle4 = new HSinglelineEntry("", 50, 160, 240, 20, 12, new Font("Tiresias", Font.BOLD, 22), Color.blue); detalle4.setBackground(Color.white); this.add(detalle4);
		detalle5 = new HSinglelineEntry("", 50, 180, 240, 20, 12, new Font("Tiresias", Font.BOLD, 22), Color.blue); detalle5.setBackground(Color.white); this.add(detalle5);
		detalle6 = new HSinglelineEntry("", 50, 200, 240, 20, 12, new Font("Tiresias", Font.BOLD, 22), Color.blue); detalle6.setBackground(Color.white); this.add(detalle6);
		detalle7 = new HSinglelineEntry("", 50, 220, 240, 20, 12, new Font("Tiresias", Font.BOLD, 22), Color.blue); detalle7.setBackground(Color.white); this.add(detalle7);
		detalle8 = new HSinglelineEntry("", 50, 240, 240, 20, 12, new Font("Tiresias", Font.BOLD, 22), Color.blue); detalle8.setBackground(Color.white); this.add(detalle8);
		detalle9 = new HSinglelineEntry("", 50, 260, 240, 20, 12, new Font("Tiresias", Font.BOLD, 22), Color.blue); detalle9.setBackground(Color.white); this.add(detalle9);
		
		cantidad1 = new HSinglelineEntry("", 290, 100, 45, 20, 4, new Font("Tiresias", Font.BOLD, 22), Color.blue); cantidad1.setBackground(Color.white); this.add(cantidad1);
		cantidad2 = new HSinglelineEntry("", 290, 120, 45, 20, 4, new Font("Tiresias", Font.BOLD, 22), Color.blue); cantidad2.setBackground(Color.white); this.add(cantidad2);
		cantidad3 = new HSinglelineEntry("", 290, 140, 45, 20, 4, new Font("Tiresias", Font.BOLD, 22), Color.blue); cantidad3.setBackground(Color.white); this.add(cantidad3);
		cantidad4 = new HSinglelineEntry("", 290, 160, 45, 20, 4, new Font("Tiresias", Font.BOLD, 22), Color.blue); cantidad4.setBackground(Color.white); this.add(cantidad4);
		cantidad5 = new HSinglelineEntry("", 290, 180, 45, 20, 4, new Font("Tiresias", Font.BOLD, 22), Color.blue); cantidad5.setBackground(Color.white); this.add(cantidad5);
		cantidad6 = new HSinglelineEntry("", 290, 200, 45, 20, 4, new Font("Tiresias", Font.BOLD, 22), Color.blue); cantidad6.setBackground(Color.white); this.add(cantidad6);
		cantidad7 = new HSinglelineEntry("", 290, 220, 45, 20, 4, new Font("Tiresias", Font.BOLD, 22), Color.blue); cantidad7.setBackground(Color.white); this.add(cantidad7);
		cantidad8 = new HSinglelineEntry("", 290, 240, 45, 20, 4, new Font("Tiresias", Font.BOLD, 22), Color.blue); cantidad8.setBackground(Color.white); this.add(cantidad8);
		cantidad9 = new HSinglelineEntry("", 290, 260, 45, 20, 4, new Font("Tiresias", Font.BOLD, 22), Color.blue); cantidad9.setBackground(Color.white); this.add(cantidad9);
		
		unitario1 = new HSinglelineEntry("", 335, 100, 45, 20, 5, new Font("Tiresias", Font.BOLD, 22), Color.blue); unitario1.setBackground(Color.white); this.add(unitario1);
		unitario2 = new HSinglelineEntry("", 335, 120, 45, 20, 5, new Font("Tiresias", Font.BOLD, 22), Color.blue); unitario2.setBackground(Color.white); this.add(unitario2);
		unitario3 = new HSinglelineEntry("", 335, 140, 45, 20, 5, new Font("Tiresias", Font.BOLD, 22), Color.blue); unitario3.setBackground(Color.white); this.add(unitario3);
		unitario4 = new HSinglelineEntry("", 335, 160, 45, 20, 5, new Font("Tiresias", Font.BOLD, 22), Color.blue); unitario4.setBackground(Color.white); this.add(unitario4);
		unitario5 = new HSinglelineEntry("", 335, 180, 45, 20, 5, new Font("Tiresias", Font.BOLD, 22), Color.blue); unitario5.setBackground(Color.white); this.add(unitario5);
		unitario6 = new HSinglelineEntry("", 335, 200, 45, 20, 5, new Font("Tiresias", Font.BOLD, 22), Color.blue); unitario6.setBackground(Color.white); this.add(unitario6);
		unitario7 = new HSinglelineEntry("", 335, 220, 45, 20, 5, new Font("Tiresias", Font.BOLD, 22), Color.blue); unitario7.setBackground(Color.white); this.add(unitario7);
		unitario8 = new HSinglelineEntry("", 335, 240, 45, 20, 5, new Font("Tiresias", Font.BOLD, 22), Color.blue); unitario8.setBackground(Color.white); this.add(unitario8);
		unitario9 = new HSinglelineEntry("", 335, 260, 45, 20, 5, new Font("Tiresias", Font.BOLD, 22), Color.blue); unitario9.setBackground(Color.white); this.add(unitario9);
		
		monto1 = new HSinglelineEntry("", 380, 100, 65, 20, 7, new Font("Tiresias", Font.BOLD, 22), Color.blue); monto1.setBackground(Color.white); this.add(monto1);
		monto2 = new HSinglelineEntry("", 380, 120, 65, 20, 7, new Font("Tiresias", Font.BOLD, 22), Color.blue); monto2.setBackground(Color.white); this.add(monto2);
		monto3 = new HSinglelineEntry("", 380, 140, 65, 20, 7, new Font("Tiresias", Font.BOLD, 22), Color.blue); monto3.setBackground(Color.white); this.add(monto3);
		monto4 = new HSinglelineEntry("", 380, 160, 65, 20, 7, new Font("Tiresias", Font.BOLD, 22), Color.blue); monto4.setBackground(Color.white); this.add(monto4);
		monto5 = new HSinglelineEntry("", 380, 180, 65, 20, 7, new Font("Tiresias", Font.BOLD, 22), Color.blue); monto5.setBackground(Color.white); this.add(monto5);
		monto6 = new HSinglelineEntry("", 380, 200, 65, 20, 7, new Font("Tiresias", Font.BOLD, 22), Color.blue); monto6.setBackground(Color.white); this.add(monto6);
		monto7 = new HSinglelineEntry("", 380, 220, 65, 20, 7, new Font("Tiresias", Font.BOLD, 22), Color.blue); monto7.setBackground(Color.white); this.add(monto7);
		monto8 = new HSinglelineEntry("", 380, 240, 65, 20, 7, new Font("Tiresias", Font.BOLD, 22), Color.blue); monto8.setBackground(Color.white); this.add(monto8);
		monto9 = new HSinglelineEntry("", 380, 260, 65, 20, 7, new Font("Tiresias", Font.BOLD, 22), Color.blue); monto9.setBackground(Color.white); this.add(monto9);
		
		// Cargar la grilla
		
		int cont = 0;
		Date d = new Date();
		ArrayList<Gasto> listGastos = new ArrayList();
		System.out.println("antes de devolver mes");
		listGastos = MainXlet.gas.ListaGastos.devolverMes(d);
		
		if (listGastos.size() == 1){
			System.out.println("entro en 1");
			detalle1.setTextContent(listGastos.get(0).getDetalle(), HState.ALL_STATES);	
			cantidad1.setTextContent(listGastos.get(0).getCantidad(), HState.ALL_STATES);	
			unitario1.setTextContent(listGastos.get(0).getUnitario(), HState.ALL_STATES);
			monto1.setTextContent(listGastos.get(0).getMonto(), HState.ALL_STATES);	
		}else if (listGastos.size() == 2){
			System.out.println("entro en 2");
			detalle1.setTextContent(listGastos.get(0).getDetalle(), HState.ALL_STATES);	
			cantidad1.setTextContent(listGastos.get(0).getCantidad(), HState.ALL_STATES);	
			unitario1.setTextContent(listGastos.get(0).getUnitario(), HState.ALL_STATES);
			monto1.setTextContent(listGastos.get(0).getMonto(), HState.ALL_STATES);	
			
			detalle2.setTextContent(listGastos.get(1).getDetalle(), HState.ALL_STATES);	
			cantidad2.setTextContent(listGastos.get(1).getCantidad(), HState.ALL_STATES);	
			unitario2.setTextContent(listGastos.get(1).getUnitario(), HState.ALL_STATES);
			monto2.setTextContent(listGastos.get(1).getMonto(), HState.ALL_STATES);	
		}else if (listGastos.size() == 3){
			System.out.println("entro en 3");
			detalle1.setTextContent(listGastos.get(0).getDetalle(), HState.ALL_STATES);	
			cantidad1.setTextContent(listGastos.get(0).getCantidad(), HState.ALL_STATES);	
			unitario1.setTextContent(listGastos.get(0).getUnitario(), HState.ALL_STATES);
			monto1.setTextContent(listGastos.get(0).getMonto(), HState.ALL_STATES);	
		
			detalle2.setTextContent(listGastos.get(1).getDetalle(), HState.ALL_STATES);	
			cantidad2.setTextContent(listGastos.get(1).getCantidad(), HState.ALL_STATES);	
			unitario2.setTextContent(listGastos.get(1).getUnitario(), HState.ALL_STATES);
			monto2.setTextContent(listGastos.get(1).getMonto(), HState.ALL_STATES);	
			
			detalle3.setTextContent(listGastos.get(2).getDetalle(), HState.ALL_STATES);	
			cantidad3.setTextContent(listGastos.get(2).getCantidad(), HState.ALL_STATES);	
			unitario3.setTextContent(listGastos.get(2).getUnitario(), HState.ALL_STATES);
			monto3.setTextContent(listGastos.get(2).getMonto(), HState.ALL_STATES);	
		}
		
//		for( cont=0; cont < listGastos.size() ; cont++){
//			
//			detalle1.setTextContent(ContenedorKeyboard.message, HState.ALL_STATES);	
//			}
		
		
		this.setBounds(0, 0, 800, 800);
		this.addKeyListener(this);
	
	}
	
	public void keyPressed(KeyEvent tecla){
		
		System.out.println("Prueba!!!");
		
		switch (tecla.getKeyCode()){
		
		case 404: 	// Boton Verde
			// Grafica A�o
			break;

		case 403: 	// Boton Rojo
			// Promedio Mes
			break;
		
		case 405: 	// Boton Amarillo
			//Resumen A�o
			break;
	
		case 406: 	// Boton Azul
			System.out.println("Vuelve para Menu compras");
			MainXlet.mes.setVisible(false);
			MainXlet.gas.setVisible(true);
			MainXlet.gas.requestFocus();
			break;	
						
		case 27:	//exit
			MainXlet.mes.setVisible(false);
			MainXlet.label.setBackground(Color.white);
			MainXlet.label.repaint();
			MainXlet.scene.requestFocus();
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
