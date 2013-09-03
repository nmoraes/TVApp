import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
//importamos javaTV
import javax.tv.xlet.XletStateChangeException;




//La clase principal de cada xlet debe implementar esta interfaz
//sino el middele ware no ejecuta.

//MHP norma europea.
public class primerXlet implements Xlet{
	
	//cada xlet es un contexto
	XletContext contexto;	
	
	//saber si arranco
	boolean fueStarted;
	
	
	
	public void destroyXlet(boolean unconditional) throws XletStateChangeException {
		// TODO Auto-generated method stub
		
		if (unconditional) {
			System.out.println("se llamo destroyXlet con TRUE");
			} else {
			System.out.println("Se llamo destroyXlet con false, pide no terminar");
			throw new XletStateChangeException("pidio continuar");
			}

		
		
	}

	public void initXlet(XletContext arg0) throws XletStateChangeException {
		// TODO Auto-generated method stub
		contexto=arg0;	
		fueStarted=false;		
		System.out.println("llamado Initxlet, el contexto es: " +arg0 );
		
	}

	public void pauseXlet() {
		// TODO Auto-generated method stub
		
		System.out.println("ejecuto pausa... liberando recursos ...");
		
	}	

	public void startXlet() throws XletStateChangeException {
		// TODO Auto-generated method stub

		if(fueStarted) {
			System.out.println("Pausa");
		}else {
			System.out.println("se llamo xstartLet por primera vez ...");
			fueStarted=true;
		}
			
		
		
	}

}
