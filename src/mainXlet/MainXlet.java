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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;

import org.dvb.ui.DVBColor;
import org.havi.ui.HComponent;
import org.havi.ui.HDefaultTextLayoutManager;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HSceneTemplate;
import org.havi.ui.HScreen;
import org.havi.ui.HSound;
import org.havi.ui.HStaticText;

import Gastos.ContenedorResumenAño;
import Gastos.ContenedorResumenMes;
import Gastos.Gastos1;
   
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

	public static HStaticText label;
	private Color[] colors = { Color.red, Color.green, Color.yellow,Color.blue, Color.white, Color.pink };
	private int intColor;

	// private ContenedorTwitter twitter=new ContenedorTwitter();
	private ContenedorAzul cont = new ContenedorAzul();
	private ContenedorRed contRed = new ContenedorRed();
	private ContenedorYellow contYellow = new ContenedorYellow();
	public static ContenedorKeyboard keyboard = new ContenedorKeyboard();

	public static ContenedorWeather contWeather = new ContenedorWeather();

	/** Tipo de dato para guardar sonido */
	private HSound myHSound = new HSound();
	/* // Gastos */
	public static Gastos1 gas = new Gastos1();
	public static ContenedorResumenMes mes = new ContenedorResumenMes();
	public static ContenedorResumenAño ano = new ContenedorResumenAño();

	// private JTablet tabla = new JTablet();

	// Before we can draw on the screen, we need an HScene to draw into. This
	// variable will hold a reference to our HScene
	public static HScene scene;

	// The image that we will show
	private Image image;

	// The message that will get printed. This is read from a file in initXlet()
	private String message = new String("No puedo ser nulo");

	// this holds the alpha (transparency) level that we will be using
	private int alpha = 0;
	// this object is responsible for displaying the background I-frame
	private HaviBackgroundController backgroundManager;
    
    
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
        loadForegroundBitmap(); 
        
        readProperties();
        playSound();
      
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
        
    	// This adds the background image to the display.  The background image is
		// displayed in the background plane.
		//displayBackgroundImage();
		
        
        HSceneFactory hsceneFactory = HSceneFactory.getInstance();
        scene = hsceneFactory.getFullScreenScene(HScreen.getDefaultHScreen().getDefaultHGraphicsDevice());

        scene.setSize(800, 600);
        scene.setLayout(null);
        scene.addKeyListener(this);
      

        label = new HStaticText("menu?"/*message*/, 600, 270, 50, 50, new Font("Tiresias", Font.BOLD, 22), Color.black, colors[4], new HDefaultTextLayoutManager());
        scene.add(label);
        scene.add(this);
        
    
        scene.setVisible(true);
		scene.requestFocus();
   
        //contenedores
		// Gastos
		scene.add(gas);
		gas.setVisible(false);
		scene.add(mes);
		mes.setVisible(false);
		scene.add(ano);
		ano.setVisible(false);
						
		scene.add(cont);
//		scene.add(twitter);
//		scene.setVisible(true);
		
		scene.add(contRed);
		scene.setVisible(true); 
		
		scene.add(contYellow);
		scene.setVisible(true);
        
		//Weather
		scene.add(contWeather);
		contWeather.setVisible(false);
		
		//Keyboard
		keyboard.setVisible(false);
		scene.add(keyboard);
    
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
   
    /**************************************************************************  
     *  
     * The methods below this point are the ones which actually do all of the work  
     * related to putting something on the screen.  
     */   

   
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
   
    /**  
     * This method is responsible for displaying the background image  
     * on the screen.  This image will be displayed in the background  
     * plane, not the graphics plane.  See the graphics tutorial for  
     * a discussion of the differences between the two planes and how  
     * they work together.  
     */   
    public void displayBackgroundImage() {   
        // We've defined a separate object for displaying and managing   
        // the background image.   
        backgroundManager = new HaviBackgroundController();   
   
        // If we can initialise the background manager (which means we have got   
        // the resources we need to display the image), we load and display an   
        // image in the background plane.   
        if (backgroundManager.init()) {   
            backgroundManager.display("background.jpg");   
        }   
    }   
   
    /**  
     * This method loads the bitmap that we will display in the component.  
     * The image can be loaded from a local filesystem or from a DSM-CC  
     * object carousel using the same code, with only the latency being  
     * different.  
     *  
     * This is fairly standard Java image loading, and so we won't  
     * examine this as closely as the rest of the example.  A good Java  
     * book will tell you everything you need to know about this topic.  
     */   
    public void loadForegroundBitmap() {   
        // Create a MediaTracker to tell us when the image has loaded   
        MediaTracker tracker = new MediaTracker(this);   
        // Then load the image   
       image = Toolkit.getDefaultToolkit().getImage("bg22.png");   
             	
       
        // add the image to the MediaTracker...   
        tracker.addImage(image, 0);   

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
        // Dispose of the background image   
        backgroundManager.dispose();   
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
        // Hide ourself and remove any components from the HScene   
        scene.setVisible(false);   
        scene.remove(this);   
   
        // Destroy the image buffer   
  //      image.flush();   
        image = null;   
   
        // Dispose of the background image.   
      //  backgroundManager.dispose();   
   
        // Dispose of our HScene   
        HSceneFactory.getInstance().dispose(scene);   
        scene = null;   
        
        keyboard=null;
        myHSound.dispose();
        myHSound=null;
        
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
        
        //HelloTVXlet.keyboard.setVisible(false);
   
        // If the image has been loaded, add it to the component.  This   
        // is necessary in some MHP applications because the long latency   
        // of the DSM-CC object carousel means that images may not have   
        // loaded by the time a component is added to the scene.  Checking   
        // first allows you to avoid any graphics glitches caused by your   
        // application assuming it has data that hasn't finished loading   
        // yet.   
        if (image != null) {   
            // Draw the image from the buffer   
            graphics.drawImage(image, 404, 7, null);      }
        
   
        // Once we've drawn the image, we can draw the message on top of it.   
   
        // Set the font to be the default MHP font.   
        graphics.setFont(new Font("Tiresias", Font.PLAIN, 20));   
        // Set the text colour   
        graphics.setColor(Color.black);   
   
        // Drawing the string may cause an error to get thrown, so we   
        // surround it with a 'try' block.   
        try{   
            graphics.drawString(message,300,350);  

        }catch(Throwable t) {   
            // Catch any errors that get thrown.   
            t.printStackTrace();   
        }   
    }   
   
      
    /**KeyListener interface.  
     * keyPressed is the only key event that gets generated by the set-top box.  We  
     * use this to listen for the keys that we care about.  
     */   
    public void keyPressed(KeyEvent key) {
		// What key has been pressed?
		switch (key.getKeyCode()) {
		
		case KeyEvent.VK_UP: {
			System.out.println("arriba ...");
			 myHSound.stop();
			break;
		}
		case KeyEvent.VK_DOWN: {
			System.out.println("abajo ...");
			cambiarColor();
			break;
		}

		case KeyEvent.VK_LEFT: {
			System.out.println("***** evento estado del tiempo *****");
			label.setBackground(Color.MAGENTA);
	        label.repaint();
	        contWeather.setVisible(true);
	        contWeather.requestFocus();
		
			break;
		}

		case KeyEvent.VK_RIGHT: {
			System.out.println("derecha ...Llamando al keyboard listener..");			
			label.setBackground(colors[5]);
			label.repaint();
			keyboard.setVisible(true);
			keyboard.requestFocus();
			
			
			break;
		}

		case 403: {
			System.out.println("rojo ...");
			label.setBackground(colors[0]);
	        label.repaint();
	        contRed.requestFocus();
	       

			break;
		}
		case 404: { // Clase gastos
			System.out.println("verde ...");
			label.setBackground(colors[1]);
	        label.repaint();
	        myHSound.play();
	     	gas.setVisible(true);
	        gas.requestFocus();
	        
	       	break;
		}
		case 405: {
			System.out.println("amarillo  ...");
			label.setBackground(colors[2]);
	        label.repaint();
	        contYellow.requestFocus();
			break;
		}
		case 406: {
			System.out.println("azul ...");
			label.setBackground(colors[3]);
	        label.repaint();
	        cont.requestFocus();
	      //  twitter.requestFocus();
			break;
		}

		default: {
			// do nothing
			System.out.println("default case ...");
			System.out.println(key);
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
    
	private void cambiarColor(){
		 intColor++;
	        if (intColor == colors.length) {
	            intColor = 0;
	        }
	        label.setBackground(colors[intColor]);
	        label.repaint();
	        
	}
   	
	public void playSound() {
		myHSound = new HSound();
		try {
			URL url;
			url = new URL("file://"+ new File("main_sound.mpg").getAbsolutePath());
			myHSound.load(url);
			System.out.println(url);

		} catch (IOException io) {
			System.out.println("-------- > Error al leer el sonido.");
		}
		myHSound.play();

	}

	private void readProperties(){
		
	// Load the message that we will display
	try {
		// This is all standard java.io file reading, so we won't explain it.
		// If you really need to know, look at a decent Java book.
		BufferedReader in = new BufferedReader(
			new InputStreamReader(new FileInputStream("app.properties")));

		// Read the first line from the file.  Our message will only be one
		// line long, in this case.
		message = in.readLine();
	}catch(IOException e){
		// Something went wrong reading the message file.
		System.out.println("I/O excepcion al leer app.properties");
	}
	
	}
    

    
   
   
} 
