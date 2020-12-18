package org.javahuit.tuto.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
/**
 * Reader
 * 
 * @author bassem
 *
 */
public class CSVFileReader implements Reader<Stream<String>, Path> {

	static final Logger LOGGER = Logger.getLogger(CSVFileReader.class.getName());

	/**
	 * Implémentation de Reader
	 */
	public Stream<String> read(Path from) throws IOException {

		if (from != null) {
			/**
			 * Afficher le nom de fichier en question
			 */
			affichePath(from);

			/**
			 * Lecture de continue de Fichier + Skip the first line as it's just the CSV
			 * headers
			 */
			return Files.lines(from).skip(1);
		} else {
			LOGGER.log(Level.SEVERE, "Error occurred when reading file: {}", from);
			return null;
		}
	}

}
