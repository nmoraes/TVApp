package mainXlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import org.havi.ui.HContainer;
import org.havi.ui.HState;
import org.havi.ui.HStaticText;

import tareas.ControladorTareas;
import tareas.Tarea;

public class ContenedorAgenda extends HContainer implements KeyListener {
	
	HStaticText dia;
	HStaticText mes;
	HStaticText anio;
	HStaticText tarea;
	HStaticText instrucciones=new HStaticText("Utilice las flechas para seleccionar el dia\nOK para escribir una nueva tarea\n+ y - para navegar entre las tareas");
	HStaticText guardar=new HStaticText("presione + para guardar");
	List<HStaticText> listaTareas;
	private static ControladorTareas tareas=new ControladorTareas();
	int visibles=0;
	int foco;//1-dia 2- mes 3-año
	int pagina=0;
	public ContenedorAgenda() {
		
		tareas.cargarTareas();
		tareas.listar();
		this.addKeyListener(this);
		this.setBounds(0, 0, 800, 600);
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
		instrucciones.setFont(new Font("Tiresias",0,14));
		instrucciones.setBounds(50, 350, 250, 100);
		instrucciones.setBackground(Color.WHITE);
		instrucciones.setVisible(true);
		this.add(instrucciones);
		guardar.setFont(new Font("Tiresias",0,14));
		guardar.setBackground(Color.WHITE);
		guardar.setBounds(300, 250, 170, 30);
		this.add(guardar);
		mostrarTextos();
		cargarListaTareas();
		foco=1;
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
		switch (e.getKeyCode()) {
		case 39://derecha
			switch(foco){
			case 1:
				mes.setBackground(Color.YELLOW);
				dia.setBackground(Color.WHITE);
				foco=2;
				break;
			case 2:
				anio.setBackground(Color.YELLOW);
				mes.setBackground(Color.WHITE);
				foco=3;
				break;
			case 3:
				dia.setBackground(Color.YELLOW);
				anio.setBackground(Color.WHITE);
				foco=1;
				break;
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
		case 10://ok
			if(listaTareas!=null){
				for (HStaticText hst : listaTareas) {
					hst.setVisible(false);
				}
			}
			guardar.setVisible(true);
			instrucciones.setVisible(false);
			MainXlet.keyboard.setVisible(true);
			MainXlet.keyboard.requestFocus();	
			ContenedorKeyboard.invokeFather=Constant.CONTENEDOR_AGENDA;
			break;
		case 27:
			//exit
			MainXlet.mainPage=true;
			this.setVisible(false);
			MainXlet.scene.requestFocus();
			break;
		case 427:
			paginar();
			break;
		case 428:
			if(pagina>6){
				pagina=pagina-6;
				paginar();
				pagina=pagina-6;
			}else{
				pagina=0;
				paginar();
			}
			break;
		}
		this.repaint();

	}
	public static void escribirTarea(String tarea){
		tareas.crearTarea(tarea);
		tareas.guardarTareas();
		tareas.listar();
	}
	
	public void cargarListaTareas(){
		guardar.setVisible(false);
		instrucciones.setVisible(true);
		if(listaTareas!=null){
			for (HStaticText hst : listaTareas) {
				hst.setVisible(false);
				this.remove(hst);
			}
			visibles=0;
		}
		listaTareas=new ArrayList<>();
		for (Tarea t : tareas.getTareas()) {
			int mes=t.getMes()+1;//java maneja los meses de 0 a 11
			HStaticText hst=new HStaticText(t.getDia()+"-"+mes+"-"+t.getAnio()+": "+t.getTarea());
			hst.setFont(new Font("Tiresias",0,14));
			hst.setBackground(Color.white);

			listaTareas.add(hst);
			visibles++;
		}
		paginar();
		
	}
	
	public void paginar(){
		for (HStaticText hst : listaTareas) {
			hst.setVisible(false);
			this.remove(hst);
		}
		int altura=250;
		if(visibles<6){
			for (HStaticText hst : listaTareas) {
				hst.setBounds(450, altura, 200, 30);
				altura=altura+50;
				hst.setVisible(true);
				this.add(hst);
			}
		}else{
			List<HStaticText> paginaAMostrar=null;
			int tope=pagina+6;
			if(tope<listaTareas.size()){
				paginaAMostrar=listaTareas.subList(pagina, tope);
				pagina=tope;
			}else{
				paginaAMostrar=listaTareas.subList(pagina, listaTareas.size());
			}
			for (HStaticText hst : paginaAMostrar) {
				hst.setBounds(450, altura, 200, 30);
				altura=altura+50;
				hst.setVisible(true);
				this.add(hst);
			}
		}
	}
	public void paint(Graphics graphics){
		tarea.setTextContent(MainXlet.keyboard.message, HState.ALL_STATES);
		super.paint(graphics);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
