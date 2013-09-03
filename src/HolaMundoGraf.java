import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;

import org.havi.ui.HComponent;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HSceneTemplate;
import org.havi.ui.HStaticText;




//La clase principal de cada xlet debe implementar esta interfaz
//sino el middele ware no ejecuta.

//MHP norma europea.
public class HolaMundoGraf extends HComponent implements Xlet{
	

	XletContext contexto;	
	HScene scene;
	HStaticText hstText;
	 
	
	
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
		this.contexto=arg0;
		HSceneFactory factory=HSceneFactory.getInstance();
		
		HSceneTemplate hst=new HSceneTemplate();
		
	}

	public void pauseXlet() {
		// TODO Auto-generated method stub
		//nico
		System.out.println("ejecuto pausa... liberando recursos ...");
		
	}	

	public void startXlet() throws XletStateChangeException {
		// TODO Auto-generated method stub


			
		
		
	}

}
