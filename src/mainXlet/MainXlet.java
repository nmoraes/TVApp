package mainXlet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.dvb.ui.DVBColor;
import org.havi.ui.HComponent;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HSceneTemplate;
import org.havi.ui.HScreen;
import org.havi.ui.HSound;
import Gastos.ContenedorGastos;
import Gastos.ContenedorPromedioAnio;
import Gastos.ContenedorResumenAnio;
import Gastos.ContenedorResumenMes;
   
 /**  
 * This Xlet will be visible on-screen, so we extend org.havi.ui.HComponent  
 * (NOT java.awt.Component).  it also implements java.awt.KeyListener to  
 * receive keypresses from an RCU.  
 *  
 * Since this is quite a complex Xlet that will be running for a long time,  
 * we do most of the work in a separate thread.  For this reason, the Xlet  
 * implements the Runnable interface.  
 */   
public class MainXlet extends HComponent implements Xlet, Runnable, KeyListener {   
      
	// A private field to hold a reference to our Xlet context
	// A private variable to store our Xlet context. In this case, we do
	// actually
	// use this, showing why it's a good idea to keep a reference to the Xlet
	// context.
	private XletContext context;

	// A private variable that keeps a reference to the thread that
	// will do all of the work.
	private Thread myWorkerThread;
	
	/** Contenedor boton azul */
	public static  ContenedorAzul cont = new ContenedorAzul();
	
	/** Contenedor boton rojo */
	public static ContenedorRed contRed = new ContenedorRed();
	
	/** Contenedor boton amarillo */
	public static ContenedorYellow contYellow = new ContenedorYellow();
	
	/** Contenedor Keyboard */
	public static ContenedorKeyboard keyboard = new ContenedorKeyboard();

	/** Contenedor Web Services Weather */
	public static ContenedorWeather contWeather = new ContenedorWeather();
	
	/** Tipo de dato para guardar sonido */
	private HSound myHSound = new HSound();
	
	/** Contenedor MiniWeather el cual se desplega debajo de la pantalla */
	public static ContenedorMiniWeather miniWeather = new ContenedorMiniWeather();
	
	/**CNN Image */
	private Image image;
		
	/**Main Image */
	private Image mainImage;
	
	/**Button izq Image */
	private Image weatherButton;
	//private static boolean flagImageMain = true;
	
	public static boolean mainPage;
	
	public static HScene scene;
	
	
	/* // Gastos */
	public static ContenedorGastos gas = new ContenedorGastos();
	public static ContenedorResumenMes mes = new ContenedorResumenMes();
	public static ContenedorResumenAnio anio = new ContenedorResumenAnio();
	public static ContenedorPromedioAnio promedioAnio = new ContenedorPromedioAnio();


	// this holds the alpha (transparency) level that we will be using
	private int alpha = 0;
	// this object is responsible for displaying the background I-frame

	
    /**  
     * A default constructor, included for completeness.  
     */   
    public MainXlet()   
    {   
    }   
   
   
    /**  
     * Initialise the Xlet.  Unlike some of the other Xlet examples, this actually does  
     * some real initialisation.  
     */   
    public void initXlet(javax.tv.xlet.XletContext context) throws javax.tv.xlet.XletStateChangeException   
    {   
    
        // We keep a reference to our Xlet context because doing so is good practise   
        this.context = context;   

        // load the image to be displayed in the graphics plane.  This should maybe   
        // get done in startXlet() instead, depending on the size of the image and   
        // the time it takes to load.  if this is being loaded from a DSM-CC   
        // carousel, it should definitely be loaded after startXlet() is called.   
        
        this.setBounds(0, 0, 800, 600);
		this.addKeyListener(this);
        loadForegroundBitmap(); 
      
    }   
   
   
    /**  
     * Start the Xlet.  This is where we actually start doing useful work.  
     */   
    public void startXlet() throws javax.tv.xlet.XletStateChangeException   
    {   
        // startXlet() should not block for too long, and doing UI stuff is   
        // way too long.  To solve this, we start another thread to do the   
        // work.
    
    	myWorkerThread = new Thread(this);   
        myWorkerThread.start();   
        
        System.out.println("Ejecutando startXlet...");
        
        
        HSceneFactory hsceneFactory = HSceneFactory.getInstance();
        scene = hsceneFactory.getFullScreenScene(HScreen.getDefaultHScreen().getDefaultHGraphicsDevice());
  
        scene.setSize(800, 600);
        scene.setLayout(null);
        scene.addKeyListener(this);
        
        scene.add(this);
        
    
        scene.setVisible(true);
		scene.requestFocus();
   
		scene.add(gas);
		gas.setVisible(false);
		scene.add(mes);
		mes.setVisible(false);
		scene.add(anio);
		anio.setVisible(false);
		scene.add(promedioAnio);
		promedioAnio.setVisible(false);
						
		scene.add(cont);

		scene.add(contRed);
		scene.setVisible(true); 
		
		scene.add(contYellow);
		contYellow.setVisible(false);
		scene.setVisible(true);
        
		//Weather
		scene.add(contWeather);
		contWeather.setVisible(false);
		
		//Keyboard
		keyboard.setVisible(false);
		scene.add(keyboard);
		
//		//MiniWeather
//		miniWeather.setVisible(true);
//		scene.add(miniWeather);
		mainPage = true;
    }   
   
    /**  
     * Pause the Xlet.  This method cannot throw any exceptions, since an Xlet MUST  
     * pause itself when asked.  However, exactly what the Xlet should do to pause  
     * itself is not specified.  Doing nothing is allowed, but is not a good idea.  
     */   
    public void pauseXlet()   
    {   
        // do what we need to in order to pause the Xlet.   
        doPause();   
    }   
   
    /**  
     * Destroy the Xlet.  This should release all resources, finish all threads and then exit.  
     * If the argument is false, then this method can refuse to be destroyed by throwing an  
     * XletStateChangeException.  
     */   
    public void destroyXlet(boolean unconditional) throws javax.tv.xlet.XletStateChangeException   
    {   
        if (unconditional) {   
            // We have been ordered to terminate, so we obey the order politely and release any   
            // scarce resources that we are holding.   
            doDestroy();   
        }   
        else {   
            // We have had a polite request to die, so we can refuse this request if we want.   
            throw new XletStateChangeException("Please don't let me die!");   
        }   
    }   
   
   
    /**  
     * The main method for the worker thread.  This is where most of the work is done.  
     */   
    public void run()   
    {   
        // We need quite a few resources before we can start doing anything.   
        getResources();   
   
        // This component should listen for AWT key events so that it can respond to them.   
        addKeyListener(this);   
   
        // This adds the background image to the display.  The background image is   
        // displayed in the background plane.   
       // displayBackgroundImage();   
   
        // The bitmap image is shown in the graphics plane.   
        displayForegroundBitmap();   
        
    }   
   
   
    /**  
     * This function is responsible for getting the resources we need to execute and  
     * for setting up the main component for the Xlet.  
     */   
    public void getResources() {   
        // Before we can do anything, we need to create a new HScene so that we   
        // can display something on the screen.  First, we get a reference to   
        // the HSceneFactory...   
        HSceneFactory factory = HSceneFactory.getInstance();   
   
        // ...and then we can get an HScene.   
           
        //  First, we create an HSceneTemplate   
        HSceneTemplate hst = new HSceneTemplate();   
   
        // Set it to cover the entire screen   
        hst.setPreference(   
            HSceneTemplate.SCENE_SCREEN_DIMENSION,   
            new org.havi.ui.HScreenDimension(1,1),   
            HSceneTemplate.REQUIRED);   
        hst.setPreference(   
            HSceneTemplate.SCENE_SCREEN_LOCATION,   
            new org.havi.ui.HScreenPoint(0,0),   
            HSceneTemplate.REQUIRED);   
           
        // Now actually get the HScene   
        scene = factory.getBestScene(hst);   
   
   
        // Since we didn't specify a size for our HScene when we created it,   
        // we need to find its size   
        Rectangle rect = scene.getBounds();   
   
        // Set the size of our component to fill the HScene, make it   
        // visible and set its background colour to be black.   
        setBounds(rect);   
        setVisible(true);   
        setBackground(Color.black);   
   
        // Add ourselves to the HScene.  While we're adding components to the   
        // scene, we should hide it to avoid any nasty flickering, but HScenes    
        // are not visible when they are created.   
        scene.add(this);   
        scene.setVisible(true);   
   
        // Give focus to this component   
        this.requestFocus();   
    }   
   

    
    public void loadForegroundBitmap() {   
        // Create a MediaTracker to tell us when the image has loaded   
        
    	MediaTracker tracker = new MediaTracker(this);   
        // Then load the image   
            	
    	image= Toolkit.getDefaultToolkit().getImage("bg22.png"); 
    	
    	mainImage = Toolkit.getDefaultToolkit().getImage("inicio.jpg");
    	
    	weatherButton = Toolkit.getDefaultToolkit().getImage("BotonIzq2.jpg");

        // add the image to the MediaTracker...   
        tracker.addImage(image, 0);
        tracker.addImage(mainImage, 1);
        tracker.addImage(weatherButton, 1);
        try{   
            tracker.waitForAll();   
        }   
        catch(InterruptedException e) {   
            // Ignore the exception, since there's not a lot we can do.   
            image = null; 
        }
    }  
           
   
    /**  
     * Display the foreground image in the AWT component  
     */   
    public void displayForegroundBitmap()   
    {   
    }   
   
    /**  
     * This method is used by pauseXlet() to do the tasks that should be carried out  
     * when the Xlet is paused.  In this case, that means hiding the visible  
     * parts of the application and freeing up any resources we're using.  
     */   
    public void doPause()   
    {   
        scene.setVisible(false);   

    }   
   
   
    /**  
     * This method is used by destroyXlet() to do the tasks that should be carried out  
     * when the Xlet is killed.  In this case, that means disposing of AWT components  
     * and freeing the associated resources.  Remember that some AWT elements must be  
     * freed explicitly in order for them to be disposed of completely.  This avoids  
     * resource leaks.  
     */   
    public void doDestroy()   
    {   
    	
    	System.out.println("************ Killing me now ************");

    	// Dispose of our HScene   
        HSceneFactory.getInstance().dispose(scene);  
        //scene.setVisible(false); 
    	scene.removeAll();
        scene.remove(this);   
        image = null;   
        scene = null;   
        keyboard=null;
        
        Runtime garbage = Runtime.getRuntime();
        garbage.gc();
        
        }   
   
    /**  
     * This is a standard AWT paint method for repainting the contents of the  
     * component.  
     */   
    public void paint(Graphics graphics) {   
   
        // Get the size of this component so that we can clear it properly.   
        Dimension size = getSize();   
   
        /* Clear the background of the component to the current  
        transparency level.  Since standard AWT doesn't  support  
        transparency, we have to use an org.dvb.ui.DVBColor  
        object rather than a java.awt.Color object */   
        
        graphics.setColor(new DVBColor(0,0,0,alpha));   
        graphics.fillRect(0,0,size.width,size.height);   

        // If the image has been loaded, add it to the component.  This   
        // is necessary in some MHP applications because the long latency   
        // of the DSM-CC object carousel means that images may not have   
        // loaded by the time a component is added to the scene.  Checking   
        // first allows you to avoid any graphics glitches caused by your   
        // application assuming it has data that hasn't finished loading   
        // yet.   
           
            // Draw the image from the buffer   
        
        if(mainPage==true){
            graphics.drawImage(mainImage, 0, 0, null);
            graphics.drawImage(weatherButton, 404, 180, null);
            
        }
    
        
        graphics.drawImage(image, 404, 7, null);      
        

        // Once we've drawn the image, we can draw the message on top of it.   
   
        // Set the font to be the default MHP font.   
        graphics.setFont(new Font("Tiresias", Font.PLAIN, 20));   
        // Set the text colour   
        graphics.setColor(Color.black);   
   
    }   
   
      
    /**KeyListener interface.  
     * keyPressed is the only key event that gets generated by the set-top box.  We  
     * use this to listen for the keys that we care about.  
     */   
    public void keyPressed(KeyEvent key) {
		// What key has been pressed?
		switch (key.getKeyCode()) {

		case KeyEvent.VK_LEFT: {
			//Estado del Tiempo
			mainPage=false;
	        miniWeather.setVisible(false);
	        contWeather.setVisible(true);
	        contWeather.requestFocus();
			this.repaint();
			break;
		}

		case 403: {
			//Rojo
			mainPage=false;
			miniWeather.setVisible(false);
			contRed.requestFocus();
	        contRed.agenda.setVisible(true);
	        contRed.agenda.requestFocus();
	        this.repaint();
	        break;
		}
		case 404: { 
			//Verde
			mainPage=false;
			miniWeather.setVisible(false);
			this.repaint();
	        gas.setVisible(true);
	        gas.requestFocus();
	        this.repaint();
	       	break;
		}
		case 405: {
			//Amarillo
			mainPage=false;
			contYellow.setVisible(true);
			contYellow.requestFocus();
			contYellow.texto.setVisible(true);
			this.repaint();
			break;
		}
		case 406: {
			//Azul
			mainPage=false;
			cont.setFlagImageBlue(true);
	        cont.requestFocus();
	        this.repaint();
			break;
		}

		}
	}   
   
   

	public void keyTyped(KeyEvent key)   
    {   
        // Ignored   
    }   
   
    public void keyReleased(KeyEvent key)   
    {   
        // Ignored   
    }   
    

//	public void playSound() {
//		myHSound = new HSound();
//		try {
//			URL url;
//			url = new URL("file://"+ new File("main_sound.mpg").getAbsolutePath());
//			myHSound.load(url);
//			System.out.println(url);
//
//		} catch (IOException io) {
//			System.out.println("-------- > Error al leer el sonido.");
//		}
//		myHSound.play();
//
//	}   

} 