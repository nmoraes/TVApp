package mainXlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.havi.ui.HContainer;
import org.havi.ui.HState;
import org.havi.ui.HStaticText;

import tareas.ControladorTareas;

public class ContenedorAgenda extends HContainer implements KeyListener {
	
	HStaticText dia;
	HStaticText mes;
	HStaticText anio;
	HStaticText tarea;
	ControladorTareas tareas;
	int foco;//1-dia 2- mes 3-año
	public ContenedorAgenda() {
		this.addKeyListener(this);
		this.setBounds(0, 0, 800, 600);
		tareas=new ControladorTareas();
		dia=new HStaticText(tareas.darDia()+"");
		dia.setFont(new Font("Tiresias", 0, 14));
		dia.setBackground(Color.YELLOW);
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
		foco=1;
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
		switch (e.getKeyCode()) {
		case 39://derecha
			if(foco==1){
				mes.setBackground(Color.YELLOW);
				dia.setBackground(Color.WHITE);
				foco=2;
			}else if(foco==2){
				anio.setBackground(Color.YELLOW);
				mes.setBackground(Color.WHITE);
				foco=3;
			}else if(foco==3){
				dia.setBackground(Color.YELLOW);
				anio.setBackground(Color.WHITE);
				foco=1;
			}
			break;
		case 37:
			switch(foco){
			case 1:
				anio.setBackground(Color.YELLOW);
				dia.setBackground(Color.WHITE);
				foco=3;
				break;
			case 2:
				dia.setBackground(Color.YELLOW);
				mes.setBackground(Color.WHITE);
				foco=1;
				break;
			case 3:
				mes.setBackground(Color.YELLOW);
				anio.setBackground(Color.WHITE);
				foco=2;
				break;
			}
			break;
		case 38://arriba
			switch(foco){
			case 1:
				tareas.sumaDia();
				break;
			case 2:
				tareas.sumaMes();
				break;
			case 3:
				tareas.sumaAnio();
				break;
			}
			dia.setTextContent(tareas.darDia()+"", HState.ALL_STATES);
			mes.setTextContent(tareas.darMes(), HState.ALL_STATES);
			anio.setTextContent(tareas.darAnio()+"", HState.ALL_STATES);
			break;
		case 40://abajo
			switch(foco){
			case 1:
				tareas.restaDia();
				break;
			case 2:
				tareas.restaMes();
				break;
			case 3:
				tareas.restaAnio();
				break;
			}
			dia.setTextContent(tareas.darDia()+"", HState.ALL_STATES);
			mes.setTextContent(tareas.darMes(), HState.ALL_STATES);
			anio.setTextContent(tareas.darAnio()+"", HState.ALL_STATES);
			break;
		case 27:
			//exit
			MainXlet.label.setBackground(Color.white);
			MainXlet.label.repaint();
			MainXlet.scene.requestFocus();
			break;	
		}
		this.repaint();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
