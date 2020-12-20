package org.javahuit.tuto.parser;

/**
 * Parser Interface , pour le parse des données en input 
 * 
 * @author bassem
 *
 * @param <T>
 * @param <V>
 */
public interface Parser<T, V> {
	
    T parse(V from);

}
