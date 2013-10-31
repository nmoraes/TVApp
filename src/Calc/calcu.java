package Calc;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.havi.ui.HContainer;



public class calcu extends HContainer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Frame frame;// FRAME CREADOR DEL FORMULARIO
	Panel mp;// PANEL PARA LOS BOTONES
	Panel mp1;// PANEL PARA CAJA DE TEXTO
	TextField Mostrar;// CAJA DE TEXTO

	// AQUI SE CREAN LOS BOTONES QUE VAN DENTRO DEL FRAME
	Button B_1;
	Button B_2;
	Button B_3;
	Button B_4;
	Button B_5;
	Button B_6;
	Button B_7;
	Button B_8;
	Button B_9;
	Button B_0;
	Button B_S;
	Button B_r;
	Button B_I;
	Button B_M;
	Button B_D;
	Button B_c;

	public String acum = "";// VARIABLE QUE ACUMULA EL VALOR DIJITADO
	public double a; // VARIABLE QUE ALMACENA EL PRIMER VALOR DIJITADO

	public double op;// VARIABLE QUE ALMACENA EL VALOR DIGITADO Y REALIZA LA
						// OPERACION SEGUN EL SIGNO.
	public String c = "";// AQUI GUARDAMOS EL SIGNO DE LA OPERACION PARA LUEGO
							// SER LLAMADO EN LA CONDICION

	public static void main(String arg[]) { // METODO PRINCIPAL
		calcu n = new calcu();

	}

	// CONSTRUCTOR
	public calcu() {

		// 1. CREAO EL FRAME
		frame = new Frame("Calculadora");// ESTE ES EL NOBRE DE FRAME EL QUE SE
											// UBICA EN LA PARTE DE ARRIBA DEL
											// FORMULARIO

		setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		mp = new Panel(new GridLayout(4, 5));// GRILLAS COLUMNAS Y FILAS DEL
												// FORMULARIO
		mp1 = new Panel(new GridLayout(1, 1));// SE CREA UN SEGUNDO PANEL PARA
												// LA CAJA DE TEXTO

		// CUADROS DE TEXTO CON TAMAÑO
		Mostrar = new TextField();// NO TIENE DIMENCION

		// INICIALIZAMOS BOTONES

		B_1 = new Button("1");// ESTOS SON LOS NOMBRES DE LOS BOTONES
		B_2 = new Button("2");
		B_3 = new Button("3");
		B_4 = new Button("4");
		B_5 = new Button("5");
		B_6 = new Button("6");
		B_7 = new Button("7");
		B_8 = new Button("8");
		B_9 = new Button("9");
		B_0 = new Button("0");
		B_S = new Button("+");
		B_r = new Button("-");
		B_M = new Button("x");
		B_c = new Button("c");
		B_I = new Button("=");
		B_D = new Button("/");

		// AGREGO LOS BOTONES EL PANEL

		mp1.add(Mostrar);// AGREGO EL PANEL QUE TIENE LA CAJA DE TEXTO MP1
		mp.add(B_1);// BOTONES AL PANEL MP EN ORDEN DE LA CALCULADORA
		mp.add(B_2);
		mp.add(B_3);
		mp.add(B_S);
		mp.add(B_4);
		mp.add(B_5);
		mp.add(B_6);
		mp.add(B_r);
		mp.add(B_7);
		mp.add(B_8);
		mp.add(B_9);
		mp.add(B_M);
		mp.add(B_c);
		mp.add(B_0);
		mp.add(B_I);
		mp.add(B_D);

		// LLAMAR AL PANEL
		getContentPane().add(mp1, BorderLayout.CENTER);// AGREGO EL
																// SEGUNDO PANEL
																// EN EL FRAME
		getContentPane().add(mp, BorderLayout.SOUTH);// AGREGO EL PRIMER
															// PANEL EN EL FRAME

		// ACCIONES PARA LOS BOTONES NUMERICOS
		B_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				acum = Mostrar.getText() + "1";

				Mostrar.setText(acum);
			}
		});

		B_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acum = Mostrar.getText() + "2";
				Mostrar.setText(acum);
			}
		});
		B_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acum = Mostrar.getText() + "3";
				Mostrar.setText(acum);
			}
		});
		B_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acum = Mostrar.getText() + "4";
				Mostrar.setText(acum);
			}
		});
		B_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acum = Mostrar.getText() + "5";
				Mostrar.setText(acum);
			}
		});
		B_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acum = Mostrar.getText() + "6";
				Mostrar.setText(acum);
			}
		});
		B_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acum = Mostrar.getText() + "7";
				Mostrar.setText(acum);
			}
		});
		B_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acum = Mostrar.getText() + "8";
				Mostrar.setText(acum);
			}
		});
		B_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acum = Mostrar.getText() + "9";
				Mostrar.setText(acum);
			}
		});
		B_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acum = Mostrar.getText() + "0";
				Mostrar.setText(acum);
			}
		});

		B_S.addActionListener(new ActionListener() {// BOTON SUMAR
			public void actionPerformed(ActionEvent e) {
				acum = Mostrar.getText();
				a = (Double.parseDouble(acum));
				c = "+";

				Mostrar.setText("");
			}
		});

		B_M.addActionListener(new ActionListener() {// BOTON MULTIPLICAR
			public void actionPerformed(ActionEvent e) {
				acum = Mostrar.getText();
				a = (Double.parseDouble(acum));
				c = "*";
				Mostrar.setText("");
			}
		});

		B_r.addActionListener(new ActionListener() {// BOTON RESTA
			public void actionPerformed(ActionEvent e) {
				acum = Mostrar.getText();
				a = (Double.parseDouble(acum));
				c = "-";
				Mostrar.setText("");
			}
		});

		B_D.addActionListener(new ActionListener() {// BOTON DIVIDIR
			public void actionPerformed(ActionEvent e) {
				acum = Mostrar.getText();
				a = (Double.parseDouble(acum));
				c = "/";
				Mostrar.setText("");
			}
		});
		B_c.addActionListener(new ActionListener() {// BOTON BORRAR LOS NUMEROS
													// QUE APARECEN EN LA CAJA
													// DE TEXTO
			public void actionPerformed(ActionEvent e) {
				acum = "";

				Mostrar.setText(acum);
			}
		});

		B_I.addActionListener(new ActionListener() {// BOTON DE IGUAL
			public void actionPerformed(ActionEvent e) {

				acum = Mostrar.getText();
				double b = (Double.parseDouble(acum));

				base obj = new base();

				if (c == "+") {// CONDICION PARA C
								// "VARIABLE QUE ALMACENA LOS SIGNOS"

					Mostrar.setText(String.valueOf(obj.suma(a, b)));
				} else {
					if (c == "-") {
						Mostrar.setText(String.valueOf(obj.resta(a, b)));

					} else {
						if (c == "*") {
							Mostrar.setText(String.valueOf(obj.mul(a, b)));
						} else {
							if (c == "/") {

								Mostrar.setText(String.valueOf(obj.div(a, b)));

							}
						}
					}

				}

			}

		});

		// DIMENCIONES DEL JFRAME
		frame.setSize(170, 158);// TAMAÑO DEL FRAME
		frame.setResizable(false);// FRAME ESTATICO
		frame.setLocationRelativeTo(frame.getParent());
		frame.setVisible(true);// PERMITE QUE EL FRAME SEA VISIBLE

	}

	private void setDefaultCloseOperation(int hideOnClose) {
		// TODO Auto-generated method stub
		
	}

	private Container getContentPane() {
		// TODO Auto-generated method stub
		return null;
	}



}
