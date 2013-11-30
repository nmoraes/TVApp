package Gastos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mainXlet.MainXlet;
import org.havi.ui.HContainer;
import org.havi.ui.HSinglelineEntry;
import org.havi.ui.HState;
import org.havi.ui.HStaticText;
import org.havi.ui.HVisible;

public class ContenedorResumenMes extends HContainer implements KeyListener {
	
	// Pantalla Resumen Gastos del mes //
	
		HStaticText titulo = new HStaticText ("Detalle                    Cant Unit.  Monto");
		
		HStaticText titulo3 = new HStaticText ("Total: ");
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

		private HSinglelineEntry cajaTotal;
		private HSinglelineEntry mostrarMes;
		private int paginado = 0;
		
		// The image that we will show   
	    private Image image; 
	    private Image image2;
	    private Date mesActual = new Date();
	    private Image fondo;
	 // Esta variable hace que apraescan y desaparescan los enenos
	    private Boolean primeraVez = true;
	
public ContenedorResumenMes () {
		
	System.out.println("Arranca el contenedor gastos mes");
	cajaTotal = new HSinglelineEntry("", 410, 200, 160, 30, 12, new Font("Tiresias", Font.BOLD, 28), Color.blue);
   	cajaTotal.setType(org.havi.ui.HKeyboardInputPreferred.INPUT_ANY);
   	cajaTotal.setBackground(Color.white);
  	cajaTotal.setBackgroundMode(org.havi.ui.HVisible.BACKGROUND_FILL);
  	cajaTotal.setHorizontalAlignment(HVisible.HALIGN_CENTER);
  	cajaTotal.setEditMode(true);
  	cajaTotal.setCaretCharPosition(1);
  	this.add(cajaTotal);
  	
  	mostrarMes = new HSinglelineEntry("", 90, 200, 155, 30, 14, new Font("Tiresias", Font.BOLD, 22), Color.black);
   	mostrarMes.setType(org.havi.ui.HKeyboardInputPreferred.INPUT_ANY);
   	mostrarMes.setBackground(new Color(0, 0, 0, 0));
  	mostrarMes.setBackgroundMode(org.havi.ui.HVisible.BACKGROUND_FILL);
  	mostrarMes.setHorizontalAlignment(HVisible.HALIGN_CENTER);
  	mostrarMes.setEditMode(true);
  	mostrarMes.setCaretCharPosition(1);
  	mostrarMes.setTextContent(darMes(mesActual), HState.ALL_STATES);
  	this.add(mostrarMes);
		// Tipo de letra
		titulo.setFont( new Font ("Tiresias", Font.BOLD, 24));	
		titulo3.setFont( new Font ("Tiresias", Font.BOLD, 30));
		
	
		// Posicion inicial en la pantalla y color
		titulo.setBounds(120, 270, 410, 30);	
		titulo3.setBounds(300, 200, 120, 32);		
		titulo.setBackground(new Color(0,0,0,0));
		titulo.setForeground(Color.white);
		titulo3.setBackground(new Color(0,0,0,0));
		
		this.add(titulo);
		this.add(titulo3);
		
		// prueba de textfield
		detalle1 = new HSinglelineEntry("", 110, 310, 200, 20, 12, new Font("Tiresias", Font.BOLD, 20), Color.blue); detalle1.setBackground(Color.white); this.add(detalle1);
		detalle2 = new HSinglelineEntry("", 110, 330, 200, 20, 12, new Font("Tiresias", Font.BOLD, 20), Color.blue); detalle2.setBackground(Color.white); this.add(detalle2);
		detalle3 = new HSinglelineEntry("", 110, 350, 200, 20, 12, new Font("Tiresias", Font.BOLD, 20), Color.blue); detalle3.setBackground(Color.white); this.add(detalle3);
		detalle4 = new HSinglelineEntry("", 110, 370, 200, 20, 12, new Font("Tiresias", Font.BOLD, 20), Color.blue); detalle4.setBackground(Color.white); this.add(detalle4);
		detalle5 = new HSinglelineEntry("", 110, 390, 200, 20, 12, new Font("Tiresias", Font.BOLD, 20), Color.blue); detalle5.setBackground(Color.white); this.add(detalle5);
		detalle6 = new HSinglelineEntry("", 110, 410, 200, 20, 12, new Font("Tiresias", Font.BOLD, 20), Color.blue); detalle6.setBackground(Color.white); this.add(detalle6);
		detalle7 = new HSinglelineEntry("", 110, 430, 200, 20, 12, new Font("Tiresias", Font.BOLD, 20), Color.blue); detalle7.setBackground(Color.white); this.add(detalle7);
		detalle8 = new HSinglelineEntry("", 110, 450, 200, 20, 12, new Font("Tiresias", Font.BOLD, 20), Color.blue); detalle8.setBackground(Color.white); this.add(detalle8);
		detalle9 = new HSinglelineEntry("", 110, 470, 200, 20, 12, new Font("Tiresias", Font.BOLD, 20), Color.blue); detalle9.setBackground(Color.white); this.add(detalle9);
		
		cantidad1 = new HSinglelineEntry("", 330, 310, 50, 20, 4, new Font("Tiresias", Font.BOLD, 20), Color.blue); cantidad1.setBackground(Color.white); this.add(cantidad1);
		cantidad2 = new HSinglelineEntry("", 330, 330, 50, 20, 4, new Font("Tiresias", Font.BOLD, 20), Color.blue); cantidad2.setBackground(Color.white); this.add(cantidad2);
		cantidad3 = new HSinglelineEntry("", 330, 350, 50, 20, 4, new Font("Tiresias", Font.BOLD, 20), Color.blue); cantidad3.setBackground(Color.white); this.add(cantidad3);
		cantidad4 = new HSinglelineEntry("", 330, 370, 50, 20, 4, new Font("Tiresias", Font.BOLD, 20), Color.blue); cantidad4.setBackground(Color.white); this.add(cantidad4);
		cantidad5 = new HSinglelineEntry("", 330, 390, 50, 20, 4, new Font("Tiresias", Font.BOLD, 20), Color.blue); cantidad5.setBackground(Color.white); this.add(cantidad5);
		cantidad6 = new HSinglelineEntry("", 330, 410, 50, 20, 4, new Font("Tiresias", Font.BOLD, 20), Color.blue); cantidad6.setBackground(Color.white); this.add(cantidad6);
		cantidad7 = new HSinglelineEntry("", 330, 430, 50, 20, 4, new Font("Tiresias", Font.BOLD, 20), Color.blue); cantidad7.setBackground(Color.white); this.add(cantidad7);
		cantidad8 = new HSinglelineEntry("", 330, 450, 50, 20, 4, new Font("Tiresias", Font.BOLD, 20), Color.blue); cantidad8.setBackground(Color.white); this.add(cantidad8);
		cantidad9 = new HSinglelineEntry("", 330, 470, 50, 20, 4, new Font("Tiresias", Font.BOLD, 20), Color.blue); cantidad9.setBackground(Color.white); this.add(cantidad9);
		
		unitario1 = new HSinglelineEntry("", 380, 310, 55, 20, 5, new Font("Tiresias", Font.BOLD, 20), Color.blue); unitario1.setBackground(Color.white); this.add(unitario1);
		unitario2 = new HSinglelineEntry("", 380, 330, 55, 20, 5, new Font("Tiresias", Font.BOLD, 20), Color.blue); unitario2.setBackground(Color.white); this.add(unitario2);
		unitario3 = new HSinglelineEntry("", 380, 350, 55, 20, 5, new Font("Tiresias", Font.BOLD, 20), Color.blue); unitario3.setBackground(Color.white); this.add(unitario3);
		unitario4 = new HSinglelineEntry("", 380, 370, 55, 20, 5, new Font("Tiresias", Font.BOLD, 20), Color.blue); unitario4.setBackground(Color.white); this.add(unitario4);
		unitario5 = new HSinglelineEntry("", 380, 390, 55, 20, 5, new Font("Tiresias", Font.BOLD, 20), Color.blue); unitario5.setBackground(Color.white); this.add(unitario5);
		unitario6 = new HSinglelineEntry("", 380, 410, 55, 20, 5, new Font("Tiresias", Font.BOLD, 20), Color.blue); unitario6.setBackground(Color.white); this.add(unitario6);
		unitario7 = new HSinglelineEntry("", 380, 430, 55, 20, 5, new Font("Tiresias", Font.BOLD, 20), Color.blue); unitario7.setBackground(Color.white); this.add(unitario7);
		unitario8 = new HSinglelineEntry("", 380, 450, 55, 20, 5, new Font("Tiresias", Font.BOLD, 20), Color.blue); unitario8.setBackground(Color.white); this.add(unitario8);
		unitario9 = new HSinglelineEntry("", 380, 470, 55, 20, 5, new Font("Tiresias", Font.BOLD, 20), Color.blue); unitario9.setBackground(Color.white); this.add(unitario9);

		monto1 = new HSinglelineEntry("", 435, 310, 70, 20, 7, new Font("Tiresias", Font.BOLD, 20), Color.blue); monto1.setBackground(Color.white); this.add(monto1);
		monto2 = new HSinglelineEntry("", 435, 330, 70, 20, 7, new Font("Tiresias", Font.BOLD, 20), Color.blue); monto2.setBackground(Color.white); this.add(monto2);
		monto3 = new HSinglelineEntry("", 435, 350, 70, 20, 7, new Font("Tiresias", Font.BOLD, 20), Color.blue); monto3.setBackground(Color.white); this.add(monto3);
		monto4 = new HSinglelineEntry("", 435, 370, 70, 20, 7, new Font("Tiresias", Font.BOLD, 20), Color.blue); monto4.setBackground(Color.white); this.add(monto4);
		monto5 = new HSinglelineEntry("", 435, 390, 70, 20, 7, new Font("Tiresias", Font.BOLD, 20), Color.blue); monto5.setBackground(Color.white); this.add(monto5);
		monto6 = new HSinglelineEntry("", 435, 410, 70, 20, 7, new Font("Tiresias", Font.BOLD, 20), Color.blue); monto6.setBackground(Color.white); this.add(monto6);
		monto7 = new HSinglelineEntry("", 435, 430, 70, 20, 7, new Font("Tiresias", Font.BOLD, 20), Color.blue); monto7.setBackground(Color.white); this.add(monto7);
		monto8 = new HSinglelineEntry("", 435, 450, 70, 20, 7, new Font("Tiresias", Font.BOLD, 20), Color.blue); monto8.setBackground(Color.white); this.add(monto8);
		monto9 = new HSinglelineEntry("", 435, 470, 70, 20, 7, new Font("Tiresias", Font.BOLD, 20), Color.blue); monto9.setBackground(Color.white); this.add(monto9);
		
							 	
		this.setBounds(0, 0, 800, 800);
		this.addKeyListener(this);
		loadForegroundBitmap();
	
	}

public void paint(Graphics graphics) {

	if (fondo != null && primeraVez) {   
        // Draw the image from the buffer   
		primeraVez = false;
		graphics.drawImage(fondo, 0, 0, null);
	}	
	
	if (image != null) {   
        // Draw the image from the buffer   
		graphics.drawImage(image, 245, 205, null);
	}
	if (image2 != null) {   
	    // Draw the image from the buffer   
		graphics.drawImage(image2, 80, 205, null);          
	    
    }

	super.paint(graphics);

}
	
	public void keyPressed(KeyEvent tecla){
		
		switch (tecla.getKeyCode()){
		
		case 404: 	// Boton Verde - Si hay mas gastos en ese mes los muestra
			
			primeraVez = true;
			cargarGastos(mesActual);
			this.repaint();
			break;

		case 403: 	// Boton Rojo	// Promedio Año
			
			paginado = 0;
			primeraVez = true;
			mesActual = new Date();
			mostrarMes.setTextContent(darMes(mesActual), HState.ALL_STATES);
			this.repaint();
			MainXlet.mes.setVisible(false);
			MainXlet.promedioAnio.setVisible(true);
			MainXlet.promedioAnio.requestFocus();
			break;
		
		case 405: 	// Boton Amarillo	//Resumen Año
			
			paginado = 0;
			primeraVez = true;
			mesActual = new Date();
			mostrarMes.setTextContent(darMes(mesActual), HState.ALL_STATES);
			this.repaint();
			MainXlet.mes.setVisible(false);
			MainXlet.anio.setVisible(true);
			MainXlet.anio.requestFocus();
			break;
	
		case 406: 	// Boton Azul
			
			paginado = 0;
			primeraVez = true;
			mesActual = new Date();
			mostrarMes.setTextContent(darMes(mesActual), HState.ALL_STATES);
			this.repaint();
			MainXlet.mes.setVisible(false);
			MainXlet.gas.setVisible(true);
			MainXlet.gas.requestFocus();
			break;	
			
		case 39:// Adelanta un mes
			
			primeraVez = true;
			cambiarMes(true);
			cargarGastos(mesActual);
			mostrarMes.setTextContent(darMes(mesActual), HState.ALL_STATES);
			this.repaint();
			break;
			
		case 37:// Atrasa un mes
			
			primeraVez = true;
			cambiarMes(false);
			cargarGastos(mesActual);
			mostrarMes.setTextContent(darMes(mesActual), HState.ALL_STATES);
			this.repaint();
			break;
						
		case 27:	//exit
			
			paginado = 0;
			primeraVez = true;
			mesActual = new Date();
			mostrarMes.setTextContent(darMes(mesActual), HState.ALL_STATES);
			this.repaint();
			MainXlet.mes.setVisible(false);
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
	
	private String darMes(Date d){
		String resultado = "";
		
		switch(d.getMonth()){
		
		case 0:
			resultado = "Enero";
			break;
		
		case 1:
			resultado = "Febrero";
			break;
			
		case 2:
			resultado = "Marzo";
			break;
			
		case 3:
			resultado = "Abril";
			break;
			
		case 4:
			resultado = "Mayo";
			break;
			
		case 5:
			resultado = "Junio";
			break;
			
		case 6:
			resultado = "Julio";
			break;
			
		case 7:
			resultado = "Agosto";
			break;
			
		case 8:
			resultado = "Septiembre";
			break;
			
		case 9:
			resultado = "Octubre";
			break;
			
		case 10:
			resultado = "Noviembre";
			break;
			
		case 11:
			resultado = "Diciembre";
			break;
		
			default:
				break;
		}
		
		return resultado;
		
	}
	// Cambia el mes para mostrar
	private void cambiarMes(Boolean sumar){
		
		Date fecha = new Date();
		if (sumar){
			if (mesActual.getMonth() == 11){
				mesActual.setYear(mesActual.getYear()+1);
				mesActual.setMonth(0);
				
			}else{
				mesActual.setMonth(mesActual.getMonth()+1);
			}
			
		}else{
			if (mesActual.getMonth() == 0){
				mesActual.setYear(mesActual.getYear()-1);
				mesActual.setMonth(11);
				
			}else{
				mesActual.setMonth(mesActual.getMonth()-1);
			}
		}		
		
	}
	
	public void cargarGastos(Date d){
				
		//Date d = new Date();
		String aux = "";
		ArrayList<Gasto> listGastos = new ArrayList<Gasto>();
		System.out.println("antes de devolver mes");
		listGastos = MainXlet.gas.ListaGastos.devolverMes(d);
				
		List<Gasto> subListGastos = new ArrayList<Gasto>();
		int tamanioLista =listGastos.size();
		
		// Carga el total de gastos
		aux = String.valueOf(cargarTotal(tamanioLista, listGastos));
		cajaTotal.setTextContent(aux,HState.ALL_STATES);
		
		if (tamanioLista > 9){		
			// Controlo q sea mayor a nueve
			if (paginado == 0){
				System.out.println("Aca se rompe");
				subListGastos= listGastos.subList(0, 9);
				System.out.println("Aca no llega");
				paginado(subListGastos);
				paginado = 1;
				
			}else if ((paginado == 1)&&(tamanioLista > 9)){
				
				if (tamanioLista > 19){
				subListGastos= listGastos.subList(9, 19);
				}else{
					subListGastos= listGastos.subList(9, tamanioLista);
				}
				
				paginado(subListGastos);
				paginado = 2;
														
			}else if ((paginado == 2)&&(tamanioLista > 19)){
				
				if (tamanioLista > 29){
				subListGastos= listGastos.subList(19, 29);
				}else{
					subListGastos= listGastos.subList(19, tamanioLista);
				}
				
				paginado(subListGastos);
				paginado = 0;
				
			}else if ((paginado == 2)&&(tamanioLista <= 19)){
				
					System.out.println("Aca se rompe");
					subListGastos= listGastos.subList(0, 9);
					System.out.println("Aca no llega");
					paginado(subListGastos);
					paginado = 1;
			}
		}else{
			paginado(listGastos);
		}
				
	}
	
	private float cargarTotal(int tope, ArrayList<Gasto> listaGastos){
		System.out.println("el tope: " + tope);
		
		float total = 0;
		String aux = "";
		
		for (int i = 0; i<tope ; i++){
			aux = listaGastos.get(i).getMonto();
			System.out.println("Entro al FOR");
			System.out.println(aux);
			if (esNumero(aux)){
				System.out.println("ENtro al IF");
				total = total + Float.parseFloat(aux);
			}
		}
		System.out.println("El total: " + total);
		return total;
	}
	
	// Si el string es un numero valido devuelve true, de lo contrario devuelve false
		private boolean esNumero(String s){
			try{
				Float.parseFloat(s);
			} catch (Exception e) {
				return false;
			}
			return true;
		}
	
	private void loadForegroundBitmap() {   
        // Create a MediaTracker to tell us when the image has loaded   
        MediaTracker tracker = new MediaTracker(this);   
        // Then load the image   
        image = Toolkit.getDefaultToolkit().getImage("BotonDer.jpg");   
        image2 = Toolkit.getDefaultToolkit().getImage("BotonIzq.jpg");  
        fondo = Toolkit.getDefaultToolkit().getImage("ResumenMes.jpg"); 
        
        // add the image to the MediaTracker...   
        tracker.addImage(fondo, 0);
        tracker.addImage(image, 1); 
        tracker.addImage(image2, 2); 
    
     
        // ...and wait for it to finish loading   
        try{   
            tracker.waitForAll();   
        }   
        catch(InterruptedException e) {   
            // Ignore the exception, since there's not a lot we can do.   
            image = null;  
            image2 = null;
            fondo = null;
        }   
    }   
	// Imprime segun lo que alla en la lista los gastos en pantalla
	private void paginado(List<Gasto> listGastos){
		System.out.println("LLego al paginado");
		switch (listGastos.size()){
		
		case 1:
			// Agraga solo un gasto
			detalle1.setTextContent(listGastos.get(0).getDetalle(), HState.ALL_STATES);	
			cantidad1.setTextContent(listGastos.get(0).getCantidad(), HState.ALL_STATES);	
			unitario1.setTextContent(listGastos.get(0).getUnitario(), HState.ALL_STATES);
			monto1.setTextContent(listGastos.get(0).getMonto(), HState.ALL_STATES);	
			
			// Limpia todas las demas filas
			detalle2.setTextContent("", HState.ALL_STATES);	
			cantidad2.setTextContent("", HState.ALL_STATES);	
			unitario2.setTextContent("", HState.ALL_STATES);
			monto2.setTextContent("", HState.ALL_STATES);	
			
			detalle3.setTextContent("", HState.ALL_STATES);	
			cantidad3.setTextContent("", HState.ALL_STATES);	
			unitario3.setTextContent("", HState.ALL_STATES);
			monto3.setTextContent("", HState.ALL_STATES);	
			
			detalle4.setTextContent("", HState.ALL_STATES);	
			cantidad4.setTextContent("", HState.ALL_STATES);	
			unitario4.setTextContent("", HState.ALL_STATES);
			monto4.setTextContent("", HState.ALL_STATES);	
			
			detalle5.setTextContent("", HState.ALL_STATES);	
			cantidad5.setTextContent("", HState.ALL_STATES);	
			unitario5.setTextContent("", HState.ALL_STATES);
			monto5.setTextContent("", HState.ALL_STATES);	
			
			detalle6.setTextContent("", HState.ALL_STATES);	
			cantidad6.setTextContent("", HState.ALL_STATES);	
			unitario6.setTextContent("", HState.ALL_STATES);
			monto6.setTextContent("", HState.ALL_STATES);	
			
			detalle7.setTextContent("", HState.ALL_STATES);	
			cantidad7.setTextContent("", HState.ALL_STATES);	
			unitario7.setTextContent("", HState.ALL_STATES);
			monto7.setTextContent("", HState.ALL_STATES);	
			
			detalle8.setTextContent("", HState.ALL_STATES);	
			cantidad8.setTextContent("", HState.ALL_STATES);	
			unitario8.setTextContent("", HState.ALL_STATES);
			monto8.setTextContent("", HState.ALL_STATES);
			
			detalle9.setTextContent("", HState.ALL_STATES);	
			cantidad9.setTextContent("", HState.ALL_STATES);	
			unitario9.setTextContent("", HState.ALL_STATES);
			monto9.setTextContent("", HState.ALL_STATES);			
			
		break;
		
		case 2:
			detalle1.setTextContent(listGastos.get(0).getDetalle(), HState.ALL_STATES);	
			cantidad1.setTextContent(listGastos.get(0).getCantidad(), HState.ALL_STATES);	
			unitario1.setTextContent(listGastos.get(0).getUnitario(), HState.ALL_STATES);
			monto1.setTextContent(listGastos.get(0).getMonto(), HState.ALL_STATES);	
			
			detalle2.setTextContent(listGastos.get(1).getDetalle(), HState.ALL_STATES);	
			cantidad2.setTextContent(listGastos.get(1).getCantidad(), HState.ALL_STATES);	
			unitario2.setTextContent(listGastos.get(1).getUnitario(), HState.ALL_STATES);
			monto2.setTextContent(listGastos.get(1).getMonto(), HState.ALL_STATES);	
			
			// Limpia las demas filas
			detalle3.setTextContent("", HState.ALL_STATES);	
			cantidad3.setTextContent("", HState.ALL_STATES);	
			unitario3.setTextContent("", HState.ALL_STATES);
			monto3.setTextContent("", HState.ALL_STATES);	
			
			detalle4.setTextContent("", HState.ALL_STATES);	
			cantidad4.setTextContent("", HState.ALL_STATES);	
			unitario4.setTextContent("", HState.ALL_STATES);
			monto4.setTextContent("", HState.ALL_STATES);	
			
			detalle5.setTextContent("", HState.ALL_STATES);	
			cantidad5.setTextContent("", HState.ALL_STATES);	
			unitario5.setTextContent("", HState.ALL_STATES);
			monto5.setTextContent("", HState.ALL_STATES);	
			
			detalle6.setTextContent("", HState.ALL_STATES);	
			cantidad6.setTextContent("", HState.ALL_STATES);	
			unitario6.setTextContent("", HState.ALL_STATES);
			monto6.setTextContent("", HState.ALL_STATES);	
			
			detalle7.setTextContent("", HState.ALL_STATES);	
			cantidad7.setTextContent("", HState.ALL_STATES);	
			unitario7.setTextContent("", HState.ALL_STATES);
			monto7.setTextContent("", HState.ALL_STATES);	
			
			detalle8.setTextContent("", HState.ALL_STATES);	
			cantidad8.setTextContent("", HState.ALL_STATES);	
			unitario8.setTextContent("", HState.ALL_STATES);
			monto8.setTextContent("", HState.ALL_STATES);
			
			detalle9.setTextContent("", HState.ALL_STATES);	
			cantidad9.setTextContent("", HState.ALL_STATES);	
			unitario9.setTextContent("", HState.ALL_STATES);
			monto9.setTextContent("", HState.ALL_STATES);		
		
		break;
		
		case 3:
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
			
			// Limpia las demas filas
			
			detalle4.setTextContent("", HState.ALL_STATES);	
			cantidad4.setTextContent("", HState.ALL_STATES);	
			unitario4.setTextContent("", HState.ALL_STATES);
			monto4.setTextContent("", HState.ALL_STATES);	
			
			detalle5.setTextContent("", HState.ALL_STATES);	
			cantidad5.setTextContent("", HState.ALL_STATES);	
			unitario5.setTextContent("", HState.ALL_STATES);
			monto5.setTextContent("", HState.ALL_STATES);	
			
			detalle6.setTextContent("", HState.ALL_STATES);	
			cantidad6.setTextContent("", HState.ALL_STATES);	
			unitario6.setTextContent("", HState.ALL_STATES);
			monto6.setTextContent("", HState.ALL_STATES);	
			
			detalle7.setTextContent("", HState.ALL_STATES);	
			cantidad7.setTextContent("", HState.ALL_STATES);	
			unitario7.setTextContent("", HState.ALL_STATES);
			monto7.setTextContent("", HState.ALL_STATES);	
			
			detalle8.setTextContent("", HState.ALL_STATES);	
			cantidad8.setTextContent("", HState.ALL_STATES);	
			unitario8.setTextContent("", HState.ALL_STATES);
			monto8.setTextContent("", HState.ALL_STATES);
			
			detalle9.setTextContent("", HState.ALL_STATES);	
			cantidad9.setTextContent("", HState.ALL_STATES);	
			unitario9.setTextContent("", HState.ALL_STATES);
			monto9.setTextContent("", HState.ALL_STATES);
			
		break;
		
		case 4:
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
			
			detalle4.setTextContent(listGastos.get(3).getDetalle(), HState.ALL_STATES);	
			cantidad4.setTextContent(listGastos.get(3).getCantidad(), HState.ALL_STATES);	
			unitario4.setTextContent(listGastos.get(3).getUnitario(), HState.ALL_STATES);
			monto4.setTextContent(listGastos.get(3).getMonto(), HState.ALL_STATES);	
			
			// Limpia las demas filas
			
			detalle5.setTextContent("", HState.ALL_STATES);	
			cantidad5.setTextContent("", HState.ALL_STATES);	
			unitario5.setTextContent("", HState.ALL_STATES);
			monto5.setTextContent("", HState.ALL_STATES);	
			
			detalle6.setTextContent("", HState.ALL_STATES);	
			cantidad6.setTextContent("", HState.ALL_STATES);	
			unitario6.setTextContent("", HState.ALL_STATES);
			monto6.setTextContent("", HState.ALL_STATES);	
			
			detalle7.setTextContent("", HState.ALL_STATES);	
			cantidad7.setTextContent("", HState.ALL_STATES);	
			unitario7.setTextContent("", HState.ALL_STATES);
			monto7.setTextContent("", HState.ALL_STATES);	
			
			detalle8.setTextContent("", HState.ALL_STATES);	
			cantidad8.setTextContent("", HState.ALL_STATES);	
			unitario8.setTextContent("", HState.ALL_STATES);
			monto8.setTextContent("", HState.ALL_STATES);
			
			detalle9.setTextContent("", HState.ALL_STATES);	
			cantidad9.setTextContent("", HState.ALL_STATES);	
			unitario9.setTextContent("", HState.ALL_STATES);
			monto9.setTextContent("", HState.ALL_STATES);
			
			break;
			
		case 5:
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
			
			detalle4.setTextContent(listGastos.get(3).getDetalle(), HState.ALL_STATES);	
			cantidad4.setTextContent(listGastos.get(3).getCantidad(), HState.ALL_STATES);	
			unitario4.setTextContent(listGastos.get(3).getUnitario(), HState.ALL_STATES);
			monto4.setTextContent(listGastos.get(3).getMonto(), HState.ALL_STATES);	
			
			detalle5.setTextContent(listGastos.get(4).getDetalle(), HState.ALL_STATES);	
			cantidad5.setTextContent(listGastos.get(4).getCantidad(), HState.ALL_STATES);	
			unitario5.setTextContent(listGastos.get(4).getUnitario(), HState.ALL_STATES);
			monto5.setTextContent(listGastos.get(4).getMonto(), HState.ALL_STATES);

			// Limpia las demas filas
			
			detalle6.setTextContent("", HState.ALL_STATES);	
			cantidad6.setTextContent("", HState.ALL_STATES);	
			unitario6.setTextContent("", HState.ALL_STATES);
			monto6.setTextContent("", HState.ALL_STATES);	
			
			detalle7.setTextContent("", HState.ALL_STATES);	
			cantidad7.setTextContent("", HState.ALL_STATES);	
			unitario7.setTextContent("", HState.ALL_STATES);
			monto7.setTextContent("", HState.ALL_STATES);	
			
			detalle8.setTextContent("", HState.ALL_STATES);	
			cantidad8.setTextContent("", HState.ALL_STATES);	
			unitario8.setTextContent("", HState.ALL_STATES);
			monto8.setTextContent("", HState.ALL_STATES);
			
			detalle9.setTextContent("", HState.ALL_STATES);	
			cantidad9.setTextContent("", HState.ALL_STATES);	
			unitario9.setTextContent("", HState.ALL_STATES);
			monto9.setTextContent("", HState.ALL_STATES);
			
			break;
			
		case 6:
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
			
			detalle4.setTextContent(listGastos.get(3).getDetalle(), HState.ALL_STATES);	
			cantidad4.setTextContent(listGastos.get(3).getCantidad(), HState.ALL_STATES);	
			unitario4.setTextContent(listGastos.get(3).getUnitario(), HState.ALL_STATES);
			monto4.setTextContent(listGastos.get(3).getMonto(), HState.ALL_STATES);	
			
			detalle5.setTextContent(listGastos.get(4).getDetalle(), HState.ALL_STATES);	
			cantidad5.setTextContent(listGastos.get(4).getCantidad(), HState.ALL_STATES);	
			unitario5.setTextContent(listGastos.get(4).getUnitario(), HState.ALL_STATES);
			monto5.setTextContent(listGastos.get(4).getMonto(), HState.ALL_STATES);

			detalle6.setTextContent(listGastos.get(5).getDetalle(), HState.ALL_STATES);	
			cantidad6.setTextContent(listGastos.get(5).getCantidad(), HState.ALL_STATES);	
			unitario6.setTextContent(listGastos.get(5).getUnitario(), HState.ALL_STATES);
			monto6.setTextContent(listGastos.get(5).getMonto(), HState.ALL_STATES);	

			// Limpia las demas filas
			
			detalle7.setTextContent("", HState.ALL_STATES);	
			cantidad7.setTextContent("", HState.ALL_STATES);	
			unitario7.setTextContent("", HState.ALL_STATES);
			monto7.setTextContent("", HState.ALL_STATES);	
			
			detalle8.setTextContent("", HState.ALL_STATES);	
			cantidad8.setTextContent("", HState.ALL_STATES);	
			unitario8.setTextContent("", HState.ALL_STATES);
			monto8.setTextContent("", HState.ALL_STATES);
			
			detalle9.setTextContent("", HState.ALL_STATES);	
			cantidad9.setTextContent("", HState.ALL_STATES);	
			unitario9.setTextContent("", HState.ALL_STATES);
			monto9.setTextContent("", HState.ALL_STATES);			
			
			break;
			
		case 7:
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
			
			detalle4.setTextContent(listGastos.get(3).getDetalle(), HState.ALL_STATES);	
			cantidad4.setTextContent(listGastos.get(3).getCantidad(), HState.ALL_STATES);	
			unitario4.setTextContent(listGastos.get(3).getUnitario(), HState.ALL_STATES);
			monto4.setTextContent(listGastos.get(3).getMonto(), HState.ALL_STATES);	
			
			detalle5.setTextContent(listGastos.get(4).getDetalle(), HState.ALL_STATES);	
			cantidad5.setTextContent(listGastos.get(4).getCantidad(), HState.ALL_STATES);	
			unitario5.setTextContent(listGastos.get(4).getUnitario(), HState.ALL_STATES);
			monto5.setTextContent(listGastos.get(4).getMonto(), HState.ALL_STATES);

			detalle6.setTextContent(listGastos.get(5).getDetalle(), HState.ALL_STATES);	
			cantidad6.setTextContent(listGastos.get(5).getCantidad(), HState.ALL_STATES);	
			unitario6.setTextContent(listGastos.get(5).getUnitario(), HState.ALL_STATES);
			monto6.setTextContent(listGastos.get(5).getMonto(), HState.ALL_STATES);	

			detalle7.setTextContent(listGastos.get(6).getDetalle(), HState.ALL_STATES);	
			cantidad7.setTextContent(listGastos.get(6).getCantidad(), HState.ALL_STATES);	
			unitario7.setTextContent(listGastos.get(6).getUnitario(), HState.ALL_STATES);
			monto7.setTextContent(listGastos.get(6).getMonto(), HState.ALL_STATES);	

			// Limpia las demas filas
			
			detalle8.setTextContent("", HState.ALL_STATES);	
			cantidad8.setTextContent("", HState.ALL_STATES);	
			unitario8.setTextContent("", HState.ALL_STATES);
			monto8.setTextContent("", HState.ALL_STATES);
			
			detalle9.setTextContent("", HState.ALL_STATES);	
			cantidad9.setTextContent("", HState.ALL_STATES);	
			unitario9.setTextContent("", HState.ALL_STATES);
			monto9.setTextContent("", HState.ALL_STATES);
			
			break;
			
		case 8:
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
			
			detalle4.setTextContent(listGastos.get(3).getDetalle(), HState.ALL_STATES);	
			cantidad4.setTextContent(listGastos.get(3).getCantidad(), HState.ALL_STATES);	
			unitario4.setTextContent(listGastos.get(3).getUnitario(), HState.ALL_STATES);
			monto4.setTextContent(listGastos.get(3).getMonto(), HState.ALL_STATES);	
			
			detalle5.setTextContent(listGastos.get(4).getDetalle(), HState.ALL_STATES);	
			cantidad5.setTextContent(listGastos.get(4).getCantidad(), HState.ALL_STATES);	
			unitario5.setTextContent(listGastos.get(4).getUnitario(), HState.ALL_STATES);
			monto5.setTextContent(listGastos.get(4).getMonto(), HState.ALL_STATES);

			detalle6.setTextContent(listGastos.get(5).getDetalle(), HState.ALL_STATES);	
			cantidad6.setTextContent(listGastos.get(5).getCantidad(), HState.ALL_STATES);	
			unitario6.setTextContent(listGastos.get(5).getUnitario(), HState.ALL_STATES);
			monto6.setTextContent(listGastos.get(5).getMonto(), HState.ALL_STATES);	

			detalle7.setTextContent(listGastos.get(6).getDetalle(), HState.ALL_STATES);	
			cantidad7.setTextContent(listGastos.get(6).getCantidad(), HState.ALL_STATES);	
			unitario7.setTextContent(listGastos.get(6).getUnitario(), HState.ALL_STATES);
			monto7.setTextContent(listGastos.get(6).getMonto(), HState.ALL_STATES);	

			detalle8.setTextContent(listGastos.get(7).getDetalle(), HState.ALL_STATES);	
			cantidad8.setTextContent(listGastos.get(7).getCantidad(), HState.ALL_STATES);	
			unitario8.setTextContent(listGastos.get(7).getUnitario(), HState.ALL_STATES);
			monto8.setTextContent(listGastos.get(7).getMonto(), HState.ALL_STATES);	

			// Limpia las demas filas
			
			detalle9.setTextContent("", HState.ALL_STATES);	
			cantidad9.setTextContent("", HState.ALL_STATES);	
			unitario9.setTextContent("", HState.ALL_STATES);
			monto9.setTextContent("", HState.ALL_STATES);
						
			break;
			
		case 9:
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
			
			detalle4.setTextContent(listGastos.get(3).getDetalle(), HState.ALL_STATES);	
			cantidad4.setTextContent(listGastos.get(3).getCantidad(), HState.ALL_STATES);	
			unitario4.setTextContent(listGastos.get(3).getUnitario(), HState.ALL_STATES);
			monto4.setTextContent(listGastos.get(3).getMonto(), HState.ALL_STATES);	
			
			detalle5.setTextContent(listGastos.get(4).getDetalle(), HState.ALL_STATES);	
			cantidad5.setTextContent(listGastos.get(4).getCantidad(), HState.ALL_STATES);	
			unitario5.setTextContent(listGastos.get(4).getUnitario(), HState.ALL_STATES);
			monto5.setTextContent(listGastos.get(4).getMonto(), HState.ALL_STATES);

			detalle6.setTextContent(listGastos.get(5).getDetalle(), HState.ALL_STATES);	
			cantidad6.setTextContent(listGastos.get(5).getCantidad(), HState.ALL_STATES);	
			unitario6.setTextContent(listGastos.get(5).getUnitario(), HState.ALL_STATES);
			monto6.setTextContent(listGastos.get(5).getMonto(), HState.ALL_STATES);	

			detalle7.setTextContent(listGastos.get(6).getDetalle(), HState.ALL_STATES);	
			cantidad7.setTextContent(listGastos.get(6).getCantidad(), HState.ALL_STATES);	
			unitario7.setTextContent(listGastos.get(6).getUnitario(), HState.ALL_STATES);
			monto7.setTextContent(listGastos.get(6).getMonto(), HState.ALL_STATES);	

			detalle8.setTextContent(listGastos.get(7).getDetalle(), HState.ALL_STATES);	
			cantidad8.setTextContent(listGastos.get(7).getCantidad(), HState.ALL_STATES);	
			unitario8.setTextContent(listGastos.get(7).getUnitario(), HState.ALL_STATES);
			monto8.setTextContent(listGastos.get(7).getMonto(), HState.ALL_STATES);	

			detalle9.setTextContent(listGastos.get(8).getDetalle(), HState.ALL_STATES);	
			cantidad9.setTextContent(listGastos.get(8).getCantidad(), HState.ALL_STATES);	
			unitario9.setTextContent(listGastos.get(8).getUnitario(), HState.ALL_STATES);
			monto9.setTextContent(listGastos.get(8).getMonto(), HState.ALL_STATES);			
			
			break;			
		
		default:// Fuera del rango
			// Limpio todo
			detalle1.setTextContent("", HState.ALL_STATES);	
			cantidad1.setTextContent("", HState.ALL_STATES);	
			unitario1.setTextContent("", HState.ALL_STATES);
			monto1.setTextContent("", HState.ALL_STATES);	
			
			// Limpia todas las demas filas
			detalle2.setTextContent("", HState.ALL_STATES);	
			cantidad2.setTextContent("", HState.ALL_STATES);	
			unitario2.setTextContent("", HState.ALL_STATES);
			monto2.setTextContent("", HState.ALL_STATES);	
			
			detalle3.setTextContent("", HState.ALL_STATES);	
			cantidad3.setTextContent("", HState.ALL_STATES);	
			unitario3.setTextContent("", HState.ALL_STATES);
			monto3.setTextContent("", HState.ALL_STATES);	
			
			detalle4.setTextContent("", HState.ALL_STATES);	
			cantidad4.setTextContent("", HState.ALL_STATES);	
			unitario4.setTextContent("", HState.ALL_STATES);
			monto4.setTextContent("", HState.ALL_STATES);	
			
			detalle5.setTextContent("", HState.ALL_STATES);	
			cantidad5.setTextContent("", HState.ALL_STATES);	
			unitario5.setTextContent("", HState.ALL_STATES);
			monto5.setTextContent("", HState.ALL_STATES);	
			
			detalle6.setTextContent("", HState.ALL_STATES);	
			cantidad6.setTextContent("", HState.ALL_STATES);	
			unitario6.setTextContent("", HState.ALL_STATES);
			monto6.setTextContent("", HState.ALL_STATES);	
			
			detalle7.setTextContent("", HState.ALL_STATES);	
			cantidad7.setTextContent("", HState.ALL_STATES);	
			unitario7.setTextContent("", HState.ALL_STATES);
			monto7.setTextContent("", HState.ALL_STATES);	
			
			detalle8.setTextContent("", HState.ALL_STATES);	
			cantidad8.setTextContent("", HState.ALL_STATES);	
			unitario8.setTextContent("", HState.ALL_STATES);
			monto8.setTextContent("", HState.ALL_STATES);
			
			detalle9.setTextContent("", HState.ALL_STATES);	
			cantidad9.setTextContent("", HState.ALL_STATES);	
			unitario9.setTextContent("", HState.ALL_STATES);
			monto9.setTextContent("", HState.ALL_STATES);
			
			break;
		
		}
		
	}
}
