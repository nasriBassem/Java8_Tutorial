package org.javahuit.tuto.util;

import java.util.StringJoiner;

public class ValidationEtStringUtils {
	/******************************************************************************
	 * Les opérations de concaténation peuvent mener à la création de nombreuses
	 * chaînes intermédiaires, ce qui a un coût non négligeable en calculs et en
	 * ressources mémoire, surtout si ces chaînes sont longues. Une bonne habitude à
	 * prendre, est donc de n'utiliser ces opérations de concaténation que dans les
	 * cas où l'on se fiche de consommer trop de ressoures (rares), et dans les cas
	 * où l'on n'a que peu de concaténations à faire.
	 ******************************************************************************/
	/**
	 * La première classe (historiquement) utilisée pour concaténer efficacement des
	 * chaînes de caractères est StringBuffer. La classe StringBuilder est apparue
	 * dans l'API de Java 5,
	 * 
	 * @param cible
	 * @param destination
	 * @return
	 */
	public String conctenationStringBuilder(String cible, String destination) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(cible).append(destination);
		return stringBuilder.toString();
	}

	/**
	 * Si la variable concernée est en concurrence d'accès, alors on doit utiliser
	 * StringBuffer. C'est pour ca que Soanr n'est pas content
	 * 
	 * @param cible
	 * @param destination
	 * @return
	 */
	public String conctenationStringBuffer(String cible, String destination) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(cible).append(destination);
		return stringBuffer.toString();
	}

	/*****************************************************************************
	 * JAVA 8
	 *****************************************************************************/
	/**
	 * Si l'on n'a pas besoin des fonctionnalités complémentaires de l'API Stream,
	 * on peut encore utiliser deux autre méthodes. La première est la méthode
	 * join() de la classe String.
	 * 
	 * Dans l'exemple suivant, le return vaut one, two, three, du fait du caractère
	 * de séparation passé en premier paramètre.
	 * 
	 * @param cible
	 * @param destination
	 * @return
	 */
	public String conctenationStringJoin(String[] strings) {
		return String.join(", ", strings);
	}

	/**
	 * La classe StringJoiner permet de concaténer des chaînes de caractères avec un
	 * séparateur et avec éventuellement un caractère de début de chaîne et un
	 * caractère de fin de chaîne.
	 * 
	 * @param strings
	 * @return La valeur de concat est {one, two, three}.
	 */
	public String conctenationStringJoiner(String cible, String destination) {
		StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");
		return stringJoiner.add(destination).add(cible).toString();
	}

}
