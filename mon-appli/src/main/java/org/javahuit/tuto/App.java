package org.javahuit.tuto;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * La classe main de l'application
 * 
 * @author bassem
 *
 */
public class App {
	public static void main(String[] args) throws URISyntaxException, IOException {
		Application application = new Application();
        application.init();
        //application.readInput();

	}
}
