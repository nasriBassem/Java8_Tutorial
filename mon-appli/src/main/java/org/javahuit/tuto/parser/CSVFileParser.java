package org.javahuit.tuto.parser;

import java.util.Set;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.javahuit.tuto.domain.Product;

/**
 * CSV file parsing, implementation of {@link Parser}. Parses the read stream
 * into a set of {@link Product}
 * 
 * @author bassem
 *
 */
public class CSVFileParser implements Parser<Set<Product>, Supplier<Stream<String>>> {

	private static final Logger LOGGER = Logger.getLogger(CSVFileParser.class.getName());
	private static final String CSV_SEPARATOR = ",";

	@Override
	public Set<Product> parse(Supplier<Stream<String>>  data) {
		if (data != null) {
			Set<Product> result = data.get().map(line -> {
				return productBuilder(line.split(CSV_SEPARATOR));
			}).collect(Collectors.toSet());
			result.removeIf(p -> p == null);
			return result;

		} else {
			LOGGER.log(Level.SEVERE, "Failed to parse a Null data");
			return null;
		}
	}

	/**
	 * Builder de Product , apartir d'un tableau des données en string
	 * 
	 * @param product
	 * @return
	 */
	private Product productBuilder(String[] product) {
		try {
			Integer id = Integer.valueOf(product[0].trim());
			String name = product[1].trim();
			Double price = Double.valueOf(product[2].trim().substring(1));
			return new Product(id, name, price);
		} catch (Exception e) {
			LOGGER.log(Level.WARNING, "Failed to parse product {}");
			return null;
		}
	}

}
