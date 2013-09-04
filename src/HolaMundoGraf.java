import java.awt.Color;
import java.awt.Font;

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
		HSceneFactory.getInstance().dispose(scene);
		
		
	}

	public void initXlet(XletContext arg0) throws XletStateChangeException {
		// TODO Auto-generated method stub
		this.contexto=arg0;
		HSceneFactory factory=HSceneFactory.getInstance();
		
		HSceneTemplate hst=new HSceneTemplate();
		hstText=new HStaticText("hola mundo");
		hstText.setFont(new Font("Tiresias",Font.BOLD,20));
		hstText.setBounds(250, 250, 140, 128);
		hstText.setHorizontalAlignment((int)HStaticText.CENTER_ALIGNMENT);
		hstText.setForeground(new Color(255, 255, 255, 255));
		hstText.setBackground(new Color(0, 0, 200));
		
		scene=factory.getBestScene(hst);
		scene.setBounds(0, 0, 720, 576);
		scene.add(this);
		scene.add(hstText);
		this.setSize(scene.getSize());
		
		
	}

	public void pauseXlet() {
		// TODO Auto-generated method stub
		
	}	

	public void startXlet() throws XletStateChangeException {
		// TODO Auto-generated method stub
		scene.setVisible(true);
		
		
	}

}
