package Gastos;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.table.*;

import org.havi.ui.HContainer;


public class JTablet extends HContainer implements KeyListener{
	
	
	JPanel panel;
	JScrollPane scroll;
	JTable tabla;
	TableColumn columna;
	String NombresColumnas []= {"Descripcion", "Unitario", "Cantidad", "Total"};
	String Matriz [][] = {{"m","e","l",""}, {"i", "n","g","e"}, {"s", "h", "e"}, {"l", "i", "c", ""}};
	
	
	public JTablet(){
		
		
		panel = new JPanel();
		// CREANDO LA TABLA Y AGREGANDO LA MATRIZ Y LOS NOMBRES DE LAS COLUMNAS
		tabla = new JTable(Matriz,NombresColumnas);
		// AGREGANDO EL SCROLLPANE A LA TABLA
		scroll = new JScrollPane(tabla);
		// AGREGANDO AL PANEL
		panel.add(scroll);
		// Agregando el panel al contenedor
		this.add(panel);
		
		// Cambiando el ancho de la columnas 0
		//columna = tabla.getColumnModel().getColumn(0);
		//columna.setPreferredWidth(200);
		
		// cambiando la letra del JTable
		//tabla.setFont(new Font("TAHOMA",1,14));
		
		
		
		// Haciendo visible el frame
		setVisible(true);
		//setLocation(300,340);
		//setSize(200,200);
		this.setBounds(50, 10, 300, 300);
		
		
		
	}

	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	

}
