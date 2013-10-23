package Gastos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import org.havi.ui.HContainer;
import org.havi.ui.HStaticText;

import mainXlet.*;

public class ContenedorResumenAno extends HContainer implements KeyListener {

	// Pantalla Resumen Gastos del A�o //

	HStaticText titulo = new HStaticText("Resumen A�o");
	HStaticText titulo2 = new HStaticText("2013");
	HStaticText titulo3 = new HStaticText("Ver ordenado de Mayor a Menor");
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

	public ContenedorResumenAno() {

		// Tipo de letra
		titulo.setFont(new Font("Tiresias", Font.BOLD, 20));
		titulo2.setFont(new Font("Tiresias", Font.BOLD, 20));
		titulo3.setFont(new Font("Tiresias", Font.BOLD, 20));
		titEnero.setFont(new Font("Tiresias", Font.BOLD, 20));
		titFebrero.setFont(new Font("Tiresias", Font.BOLD, 20));
		titMarzo.setFont(new Font("Tiresias", Font.BOLD, 20));
		titAbril.setFont(new Font("Tiresias", Font.BOLD, 20));
		titMayo.setFont(new Font("Tiresias", Font.BOLD, 20));
		titJunio.setFont(new Font("Tiresias", Font.BOLD, 20));
		titJulio.setFont(new Font("Tiresias", Font.BOLD, 20));
		titAgosto.setFont(new Font("Tiresias", Font.BOLD, 20));
		titSeptiembre.setFont(new Font("Tiresias", Font.BOLD, 20));
		titOctubre.setFont(new Font("Tiresias", Font.BOLD, 20));
		titNoviembre.setFont(new Font("Tiresias", Font.BOLD, 20));
		titDiciembre.setFont(new Font("Tiresias", Font.BOLD, 20));

		// Posicion inicial en la pantalla y color
		titulo.setBounds(30, 30, 160, 30);
		titulo2.setBounds(40, 70, 140, 30);
		titulo3.setBounds(30, 110, 320, 20);
		titEnero.setBounds(50, 160, 100, 20);
		titFebrero.setBounds(50, 180, 100, 20);
		titMarzo.setBounds(50, 200, 100, 20);
		titAbril.setBounds(50, 220, 100, 20);
		titMayo.setBounds(50, 240, 100, 20);
		titJunio.setBounds(50, 260, 100, 20);
		titJulio.setBounds(250, 160, 100, 20);
		titAgosto.setBounds(250, 180, 100, 20);
		titSeptiembre.setBounds(250, 200, 100, 20);
		titOctubre.setBounds(250, 220, 100, 20);
		titNoviembre.setBounds(250, 240, 200, 30);
		titDiciembre.setBounds(250, 260, 100, 20);

		enero.setBounds(40, 30, 200, 30);
		febrero.setBounds(30, 30, 200, 30);
		marzo.setBounds(30, 30, 200, 30);
		abril.setBounds(30, 30, 200, 30);
		mayo.setBounds(30, 30, 200, 30);
		junio.setBounds(30, 30, 200, 30);
		julio.setBounds(30, 30, 200, 30);
		agosto.setBounds(30, 30, 200, 30);
		septiembre.setBounds(30, 30, 200, 30);
		octubre.setBounds(30, 30, 200, 30);
		noviembre.setBounds(30, 30, 200, 30);
		diciembre.setBounds(30, 30, 200, 30);

		titulo.setBackground(Color.darkGray);
		titulo2.setBackground(Color.darkGray);
		titulo3.setBackground(Color.darkGray);
		titEnero.setBackground(Color.BLUE);
		titFebrero.setBackground(Color.BLUE);
		titMarzo.setBackground(Color.BLUE);
		titAbril.setBackground(Color.BLUE);
		titMayo.setBackground(Color.BLUE);
		titJunio.setBackground(Color.BLUE);
		titJulio.setBackground(Color.BLUE);
		titAgosto.setBackground(Color.BLUE);
		titSeptiembre.setBackground(Color.BLUE);
		titOctubre.setBackground(Color.BLUE);
		titNoviembre.setBackground(Color.BLUE);
		titDiciembre.setBackground(Color.BLUE);

		this.add(titulo);
		this.add(titulo2);
		this.add(titulo3);
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

		this.setBounds(0, 0, 800, 800);
		this.addKeyListener(this);

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
			MainXlet.ano.setVisible(false);
			MainXlet.mes.setVisible(true);
			MainXlet.mes.requestFocus();
			MainXlet.label.setBackground(Color.green);
			MainXlet.label.repaint();
			break;

		case 406: // Boton Azul
			System.out.println("Vuelve para Menu compras");
			MainXlet.ano.setVisible(false);
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
