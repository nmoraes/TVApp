
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;

import org.havi.ui.HDefaultTextLayoutManager;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HScreen;
import org.havi.ui.HStaticText;

/**
* A simple Xlet with a HStaticText label that changes background color
* when a key is pressed.
*/
public class SimpleXlet implements Xlet, KeyListener {

    private XletContext context;
    private HScene scene;
    private HStaticText label;
    private Color[] colors = { Color.black, Color.red, Color.blue };
    private int intColor;

    public SimpleXlet() {
    }

    public void initXlet(XletContext xletContext) throws XletStateChangeException {
        System.out.println("begin initXlet");
        context = xletContext;
    }

    public void startXlet() throws XletStateChangeException {
        System.out.println("begin startXlet");
        HSceneFactory hsceneFactory = HSceneFactory.getInstance();
        scene = hsceneFactory.getFullScreenScene(HScreen.getDefaultHScreen().getDefaultHGraphicsDevice());

        scene.setSize(720, 576);
        scene.setLayout(null);
        scene.addKeyListener(this);
        

        label = new HStaticText("HStaticText", 100, 100, 200, 200, new Font("Tiresias", Font.BOLD, 22), Color.yellow, colors[0], new HDefaultTextLayoutManager());
        scene.add(label);

        scene.setVisible(true);
		scene.requestFocus();
    }

    public void pauseXlet() {
    }

    public void destroyXlet(boolean flag) throws XletStateChangeException {
        System.out.println("destroyXlet");
        if (scene != null) {
            scene.setVisible(false);
            scene.removeAll();
            scene = null;
        }
        context.notifyDestroyed();
    }
    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
    	
    	System.out.println(e.getKeyChar());

    	
        intColor++;
        if (intColor == colors.length) {
            intColor = 0;
        }
        label.setBackground(colors[intColor]);
        label.repaint();
    }

}