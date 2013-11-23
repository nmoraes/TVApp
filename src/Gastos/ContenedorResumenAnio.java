package Gastos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextField;

import org.havi.ui.HContainer;
import org.havi.ui.HState;
import org.havi.ui.HStaticText;

import mainXlet.*;

public class ContenedorResumenAnio extends HContainer implements KeyListener {

	// Pantalla Resumen Gastos del A�o //

	HStaticText titulo = new HStaticText("Resumen");
	HStaticText titulo2 = new HStaticText("2013");
	//HStaticText titulo3 = new HStaticText("Ver ordenado de Mayor a Menor");
	HStaticText titEnero = new HStaticText("Enero");
	HStaticText enero = new HStaticText("5000");
	HStaticText titFebrero = new HStaticText("Febrero");
	HStaticText febrero = new HStaticText("5500");
	HStaticText titMarzo = new HStaticText("Marzo");
	HStaticText marzo = new HStaticText("6000");
	HStaticText titAbril = new HStaticText("Abril");
	HStaticText abril = new HStaticText("6500");
	HStaticText titMayo = new HStaticText("Mayo");
	HStaticText mayo = new HStaticText("7000");
	HStaticText titJunio = new HStaticText("Junio");
	HStaticText junio = new HStaticText("7500");
	HStaticText titJulio = new HStaticText("Julio");
	HStaticText julio = new HStaticText("8000");
	HStaticText titAgosto = new HStaticText("Agosto");
	HStaticText agosto = new HStaticText("8500");
	HStaticText titSeptiembre = new HStaticText("Septiembre");
	HStaticText septiembre = new HStaticText("9000");
	HStaticText titOctubre = new HStaticText("Octubre");
	HStaticText octubre = new HStaticText("9500");
	HStaticText titNoviembre = new HStaticText("Noviembre");
	HStaticText noviembre = new HStaticText("10000");
	HStaticText titDiciembre = new HStaticText("Diciembre");
	HStaticText diciembre = new HStaticText("11000");
	HStaticText titTotal = new HStaticText("Total");
	HStaticText total = new HStaticText("93500");
	HStaticText titPromedio = new HStaticText("Promedio Mes");
	HStaticText titGrafica = new HStaticText("Grafica A�o");
	HStaticText titResumen = new HStaticText("ResumenMes");
	

	public ContenedorResumenAnio() {

		// Tipo de letra
		titulo.setFont(new Font("Tiresias", Font.BOLD, 35));
		titulo2.setFont(new Font("Tiresias", Font.BOLD, 28));
		//titulo3.setFont(new Font("Tiresias", Font.BOLD, 22));
		titEnero.setFont(new Font("Tiresias", Font.BOLD, 22));
		titFebrero.setFont(new Font("Tiresias", Font.BOLD, 22));
		titMarzo.setFont(new Font("Tiresias", Font.BOLD, 22));
		titAbril.setFont(new Font("Tiresias", Font.BOLD, 22));
		titMayo.setFont(new Font("Tiresias", Font.BOLD, 22));
		titJunio.setFont(new Font("Tiresias", Font.BOLD, 22));
		titJulio.setFont(new Font("Tiresias", Font.BOLD, 22));
		titAgosto.setFont(new Font("Tiresias", Font.BOLD, 22));
		titSeptiembre.setFont(new Font("Tiresias", Font.BOLD, 22));
		titOctubre.setFont(new Font("Tiresias", Font.BOLD, 22));
		titNoviembre.setFont(new Font("Tiresias", Font.BOLD, 22));
		titDiciembre.setFont(new Font("Tiresias", Font.BOLD, 22));
		titTotal.setFont(new Font("Tiresias", Font.BOLD, 28));
		total.setFont(new Font("Tiresias", Font.BOLD, 24));
		
		enero.setFont(new Font("Tiresias", Font.BOLD, 20));
		febrero.setFont(new Font("Tiresias", Font.BOLD, 20));
		marzo.setFont(new Font("Tiresias", Font.BOLD, 20));
		abril.setFont(new Font("Tiresias", Font.BOLD, 20));
		mayo.setFont(new Font("Tiresias", Font.BOLD, 20));
		junio.setFont(new Font("Tiresias", Font.BOLD, 20));
		julio.setFont(new Font("Tiresias", Font.BOLD, 20));
		agosto.setFont(new Font("Tiresias", Font.BOLD, 20));
		septiembre.setFont(new Font("Tiresias", Font.BOLD, 20));
		octubre.setFont(new Font("Tiresias", Font.BOLD, 20));
		noviembre.setFont(new Font("Tiresias", Font.BOLD, 20));
		diciembre.setFont(new Font("Tiresias", Font.BOLD, 20));
		
		// Posicion inicial en la pantalla y color
		titulo.setBounds(100, 130, 200, 36);
		titulo2.setBounds(130, 170, 140, 30);
		//titulo3.setBounds(30, 110, 320, 20);
		titEnero.setBounds(50, 290, 100, 30);
		titFebrero.setBounds(50,330 , 100, 30);
		titMarzo.setBounds(50, 370, 100, 30);
		titAbril.setBounds(50, 410, 100, 30);
		titMayo.setBounds(50, 450, 100, 30);
		titJunio.setBounds(50, 490, 100, 30);
		titJulio.setBounds(250, 290, 100, 30);
		titAgosto.setBounds(250, 330, 100, 30);
		titSeptiembre.setBounds(250, 370, 120, 30);
		titOctubre.setBounds(250, 410, 100, 30);
		titNoviembre.setBounds(250, 450, 110, 30);
		titDiciembre.setBounds(250, 490, 110, 30);
		titTotal.setBounds(500, 410, 110, 30);
		total.setBounds(500, 450, 110, 30);

		enero.setBounds(150, 290, 80, 30);
		febrero.setBounds(150, 330, 80, 30);
		marzo.setBounds(150, 370, 80, 30);
		abril.setBounds(150, 410, 80, 30);
		mayo.setBounds(150, 450, 80, 30);
		junio.setBounds(150, 490, 80, 30);
		julio.setBounds(370, 290, 80, 30);
		agosto.setBounds(370, 330, 80, 30);
		septiembre.setBounds(370, 370, 80, 30);
		octubre.setBounds(370, 410, 80, 30);
		noviembre.setBounds(370, 450, 80, 30);
		diciembre.setBounds(370, 490, 80, 30);
		
		enero.setBackground(Color.white);
		febrero.setBackground(Color.white);
		marzo.setBackground(Color.white);
		abril.setBackground(Color.white);
		mayo.setBackground(Color.white);
		junio.setBackground(Color.white);
		julio.setBackground(Color.white);
		agosto.setBackground(Color.white);
		septiembre.setBackground(Color.white);
		octubre.setBackground(Color.white);
		noviembre.setBackground(Color.white);
		diciembre.setBackground(Color.white);
		titTotal.setBackground(new Color(0, 0, 0, 0));
		total.setBackground(Color.white);
		
		titulo.setBackground(new Color(0, 0, 0, 0));
		titulo.setForeground(Color.white);
		titulo2.setBackground(new Color(0, 0, 0, 0));
		titulo2.setForeground(Color.white);
	//	titulo3.setBackground(Color.darkGray);
		titEnero.setBackground(new Color(0, 0, 0, 0));
		titFebrero.setBackground(new Color(0, 0, 0, 0));
		titMarzo.setBackground(new Color(0, 0, 0, 0));
		titAbril.setBackground(new Color(0, 0, 0, 0));
		titMayo.setBackground(new Color(0, 0, 0, 0));
		titJunio.setBackground(new Color(0, 0, 0, 0));
		titJulio.setBackground(new Color(0, 0, 0, 0));
		titAgosto.setBackground(new Color(0, 0, 0, 0));
		titSeptiembre.setBackground(new Color(0, 0, 0, 0));
		titOctubre.setBackground(new Color(0, 0, 0, 0));
		titNoviembre.setBackground(new Color(0, 0, 0, 0));
		titDiciembre.setBackground(new Color(0, 0, 0, 0));
		
		cargarTotales();

		this.add(titulo);
		this.add(titulo2);
	//	this.add(titulo3);
		this.add(titEnero);
		this.add(titFebrero);
		this.add(titMarzo);
		this.add(titMayo);
		this.add(titAbril);
		this.add(titJunio);
		this.add(titJulio);
		this.add(titAgosto);
		this.add(titSeptiembre);
		this.add(titOctubre);
		this.add(titNoviembre);
		this.add(titDiciembre);
		this.add(enero);
		this.add(febrero);
		this.add(marzo);
		this.add(abril);
		this.add(mayo);
		this.add(junio);
		this.add(julio);
		this.add(agosto);
		this.add(septiembre);
		this.add(octubre);
		this.add(noviembre);
		this.add(diciembre);
		this.add(titTotal);
		this.add(total);
		
		this.setBounds(0, 0, 800, 800);
		this.addKeyListener(this);

	}
	
	private void cargarTotales(){
		
		Date d = new Date();
		ArrayList<Gasto> listGastos = new ArrayList<Gasto>();
		float tot = 0;
		float resultado = 0;
		
		for (int i=0 ; i<12 ; i++){
			d.setMonth(i);
			listGastos = MainXlet.gas.ListaGastos.devolverMes(d);
			resultado = cargarTotal(listGastos.size(), listGastos);
			muestro(i, resultado);
			tot = resultado + tot;
		}
		
		total.setTextContent(String.valueOf(tot), HState.ALL_STATES);
	}
	
	private void muestro(int mes, float resultado){
		
		switch(mes){
		
		case 0:
				enero.setTextContent(String.valueOf(resultado), HState.ALL_STATES);
			break;
		
		case 1:
			febrero.setTextContent(String.valueOf(resultado), HState.ALL_STATES);
		break;
		
		case 2:
			marzo.setTextContent(String.valueOf(resultado), HState.ALL_STATES);
		break;
		
		case 3:
			abril.setTextContent(String.valueOf(resultado), HState.ALL_STATES);
		break;
		
		case 4:
			mayo.setTextContent(String.valueOf(resultado), HState.ALL_STATES);
		break;
		
		case 5:
			junio.setTextContent(String.valueOf(resultado), HState.ALL_STATES);
		break;
		
		case 6:
			julio.setTextContent(String.valueOf(resultado), HState.ALL_STATES);
		break;
		
		case 7:
			agosto.setTextContent(String.valueOf(resultado), HState.ALL_STATES);
		break;
		
		case 8:
			septiembre.setTextContent(String.valueOf(resultado), HState.ALL_STATES);
		break;
		
		case 9:
			octubre.setTextContent(String.valueOf(resultado), HState.ALL_STATES);
		break;
		
		case 10:
			noviembre.setTextContent(String.valueOf(resultado), HState.ALL_STATES);
		break;
		
		case 11:
			diciembre.setTextContent(String.valueOf(resultado), HState.ALL_STATES);
		break;
		
		default:
		break;
		
		}
	}
	
	private float cargarTotal(int tope, ArrayList<Gasto> listaGastos){
		System.out.println("el tope: " + tope);
		
		float total = 0;
		String aux = "";
		
		for (int i = 0; i<tope ; i++){
			aux = listaGastos.get(i).getMonto();
			
			if (esNumero(aux)){
			
				total = total + Float.parseFloat(aux);
			}
		}
		
		return total;
	}
	
	private boolean esNumero(String s){
		try{
			Float.parseFloat(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}


	public void keyPressed(KeyEvent tecla) {

		System.out.println("Prueba!!!");

		switch (tecla.getKeyCode()) {

		case 404: // Boton Verde

			break;

		case 403: // Boton Rojo

			break;

		case 405: // Boton Amarillo
			System.out.println("Va para Resumen Mes");
			MainXlet.anio.setVisible(false);
			MainXlet.mes.setVisible(true);
			MainXlet.mes.requestFocus();
			MainXlet.label.setBackground(Color.green);
			MainXlet.label.repaint();
			break;

		case 406: // Boton Azul
			System.out.println("Vuelve para Menu compras");
			MainXlet.anio.setVisible(false);
			MainXlet.gas.setVisible(true);
			MainXlet.gas.requestFocus();
			break;

		case 27: // exit
			MainXlet.mes.setVisible(false);
			MainXlet.label.setBackground(Color.white);
			MainXlet.label.repaint();
			MainXlet.scene.requestFocus();
			break;

		default: { // do nothing
			System.out.println("default case ...");
			System.out.println(tecla);
			break;
		}

		}
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
