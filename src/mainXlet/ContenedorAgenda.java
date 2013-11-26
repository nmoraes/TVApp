package mainXlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.havi.ui.HContainer;
import org.havi.ui.HStaticText;

import tareas.ControladorTareas;

public class ContenedorAgenda extends HContainer implements KeyListener {
	
	HStaticText dia;
	HStaticText mes;
	HStaticText anio;
	HStaticText tarea;
	ControladorTareas tareas;
	public ContenedorAgenda() {
		this.addKeyListener(this);
		this.setBounds(0, 0, 800, 600);
		tareas=new ControladorTareas();
		dia=new HStaticText(tareas.darDia()+"");
		dia.setFont(new Font("Tiresias", 0, 14));
		dia.setBackground(Color.WHITE);
		dia.setBounds(50, 200, 50, 30);		
		mes=new HStaticText(tareas.darMes());
		mes.setBackground(Color.WHITE);
		mes.setFont(new Font("Tiresias", 0, 14));
		mes.setBounds(110, 200, 50, 30);
		anio=new HStaticText(tareas.darAnio()+"");
		anio.setFont(new Font("Tiresias", 0, 14));
		anio.setBackground(Color.WHITE);
		anio.setBounds(170, 200, 50, 30);
		tarea=new HStaticText();
		tarea.setFont(new Font("Tiresias",0,14));
		tarea.setBackground(Color.WHITE);
		tarea.setBounds(50, 250, 170, 30);
		this.add(dia);
		this.add(mes);
		this.add(anio);
		this.add(tarea);
		mostrarTextos();
		System.out.println("contenedor Agenda");
	}
	private void mostrarTextos(){
		dia.setVisible(true);
		mes.setVisible(true);
		anio.setVisible(true);
		tarea.setVisible(true);
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
