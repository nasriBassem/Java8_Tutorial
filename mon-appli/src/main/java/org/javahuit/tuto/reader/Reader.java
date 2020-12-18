package org.javahuit.tuto.reader;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

/**
 * Generic reader interface used for reading data, throws {@link IOException} if
 * errors occur
 * 
 * @author bassem
 *
 * @param <T1>
 * @param <T2>
 */
public interface Reader<T1, T2> {

	static final Logger LOGGER = Logger.getLogger(Reader.class.getName());

	/**
	 * Reader
	 * 
	 * @param from de type T2
	 * @return T1
	 * @throws IOException
	 */
	T1 read(T2 from) throws IOException;

	/**
	 * Méthodes Par Défaut = nouveauté de Java 8
	 * 
	 * @param from
	 */
	default void affichePath(T2 from) {
		LOGGER.info("Le Path de fichier lu est = " + getFileName((Path) from));
	}

	/**
	 * Méthodes Static = nouveauté de Java 8
	 * 
	 * @param <T>
	 * @return
	 */
	static String getFileName(Path path) {
		return path.getFileName().toString();
	}

}
