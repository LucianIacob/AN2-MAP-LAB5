package App;

import java.io.IOException;

import object.ui.Console;

// TODO: Auto-generated Javadoc
/**
 * The Class StartApp.
 */
public class StartApp {
	
	/** The my console. */
	private static object.ui.Console myConsole = new Console();
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {
		myConsole.run();		
	}
}