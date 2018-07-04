package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Valida {

	private static final String REGEX = "^.+@.+\\.[a-z]+$";

	public String validaLoginNomeOuEmail(String vl) {
		Pattern pattern = Pattern.compile(REGEX);
		Matcher combinado = pattern.matcher(vl);
		if (combinado.matches()) {
			return "Email";
		} else {
			return "Nome";
		}
	}
}
