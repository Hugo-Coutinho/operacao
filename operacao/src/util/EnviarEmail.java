package util;

import org.apache.commons.mail.HtmlEmail;

public class EnviarEmail {

	private static String HOSTNAME = "smtp.gmail.com";
	private static String USERNAME = "cotiinformatica1@gmail.com";
	private static String PASSWORD = "aulaJava";

	public Boolean enviar(String para, String assunto, String msg) {

		try {

			HtmlEmail html = new HtmlEmail();
			html.setHostName(HOSTNAME);
			html.setSmtpPort(465);
			html.setSSL(true);
			html.setAuthentication(USERNAME, PASSWORD);
			html.addTo(para);
			html.setSubject(assunto);
			html.setFrom(USERNAME);
			html.setHtmlMsg(msg);
			html.setCharset("utf-8");
			html.send();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public static void main(String[] args) {

		EnviarEmail ee = new EnviarEmail();
		ee.enviar("hugocoutinho2011@gmail.com","testando sem nome", "foi , parabéns !!!");

	}

}
