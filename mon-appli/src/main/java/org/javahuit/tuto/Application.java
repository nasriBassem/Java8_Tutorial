package org.javahuit.tuto;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
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

	public void init() throws URISyntaxException, IOException {
		/**
		 * Parseuur des données
		 */
		Parser<Set<Product>, Supplier<Stream<String>>> parser = new CSVFileParser();
		/**
		 * Reader pour lire le fichier des données
		 */
		Reader<Stream<String>, Path> reader = new CSVFileReader();

		/**
		 * Lecture des données en input
		 */
		Path pathFileInput = Paths.get(ClassLoader.getSystemResource(CSV_FILE).toURI());
		Supplier<Stream<String>> streamSupplierData = () -> {
			try {
				return reader.read(pathFileInput);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		};

		/**
		 * Récupération des donnéesen format Produit
		 */
		Set<Product> products = parser.parse(streamSupplierData);
	}

	public void readInput() {

	}

}
