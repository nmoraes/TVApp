package mainXlet;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.havi.ui.HContainer;

public class ContenedorEscribirTweet extends HContainer implements KeyListener {

	/**https://www.jinahya.com/mvn/site/com.googlecode.jinahya/mhp-1.1.2/1.1/apidocs/index.html?org/havi/ui/HMultilineEntry.html
	 * Ver esta API
	 */
	public ContenedorEscribirTweet() {
		MainXlet.keyboard.setVisible(true);
		MainXlet.keyboard.requestFocus();
		MainXlet.keyboard.invokeFather=Constant.ESCRIBIR_TWEET;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
