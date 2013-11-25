package mainXlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.havi.ui.HContainer;
import org.havi.ui.HStaticText;

import tareas.ControladorTareas;

public class ContenedorTarea extends HContainer implements KeyListener {
	
	HStaticText dia;
	HStaticText mes;
	HStaticText anio;
	HStaticText tarea;
	ControladorTareas tareas;
	public ContenedorTarea() {
		tareas=new ControladorTareas();
		dia=new HStaticText(tareas.darDia()+"");
		dia.setFont(new Font("Tiresias", 0, 14));
		dia.setBackground(Color.WHITE);
		mes=new HStaticText(tareas.darMes());
		mes.setBackground(Color.WHITE);
		mes.setFont(new Font("Tiresias", 0, 14));
		anio=new HStaticText(tareas.darAnio()+"");
		anio.setFont(new Font("Tiresias", 0, 14));
		anio.setBackground(Color.WHITE);
		this.add(dia);
		this.add(mes);
		this.add(anio);
		
		
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
