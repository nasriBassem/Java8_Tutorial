package org.javahuit.tuto;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import org.javahuit.tuto.domain.Product;
import org.javahuit.tuto.parser.CSVFileParser;
import org.javahuit.tuto.parser.Parser;
import org.javahuit.tuto.reader.CSVFileReader;
import org.javahuit.tuto.reader.Reader;

/**
 * Configuration de l'application
 * 
 * @author bassem
 *
 */
public class Application {
	/**
	 * Logger de la classe main
	 */
	private static final Logger LOGGER = Logger.getLogger(Application.class.getName());

	/**
	 * Input des données = file name
	 */
	private static final String CSV_FILE = "product-data.csv";

	public void init() {
		/**
		 * Initialize welcome message
		 */
		printInstructions();

		/**
		 * Reader pour lire le fichier des données
		 */
		Reader<Stream<String>, Path> reader = new CSVFileReader();
		/**
		 * Utilisation de try ressource introduced in Java 7
		 */
		/**
		 * Lecture des données en input
		 */
		try (Stream<String> data = reader.read(Paths.get(ClassLoader.getSystemResource(CSV_FILE).toURI()))) {

			/**
			 * Parseuur des données
			 */
			Parser<Set<Product>, Stream<String>> parser = new CSVFileParser();
			/**
			 * Récupération des donnéesen format Produit
			 */
			Set<Product> products = parser.parse(data);

		} catch (URISyntaxException | IOException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}

	}

	public void readInput() {

	}

	/**
	 * Initialize welcome message
	 */
	private void printInstructions() {
		LOGGER.info("Enter \"list\" to show a list of products in the inventory");
		LOGGER.info("Enter \"add <ProductId>\" to add to basket");
		LOGGER.info("Enter \"remove <ProductId>\" to remove from basket");
		LOGGER.info("Enter \"basket\" to show the list of products in your basket");
		LOGGER.info("Enter \"total\" to show the total price of the basket");
		LOGGER.info("Enter \"exit\" to quit");
	}

}
