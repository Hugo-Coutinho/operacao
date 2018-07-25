package util;

import org.apache.commons.mail.HtmlEmail;

import entity.Usuario;
import persistence.UsuarioDao;

public class EnviarEmail {

	private static final String HOSTNAME = "smtp.gmail.com";
	private static final String USERNAME = "cotiexemplo@gmail.com";
	private static final String PASSWORD = "@coticoti@";

	// public static Email conectaEmail()throws Exception{

	// }

	public boolean enviar(String para, String assunto, String msg) {

		try {

			HtmlEmail html = new HtmlEmail();
			html.setHostName(HOSTNAME);
			html.setSmtpPort(587);
			html.setAuthentication(USERNAME, PASSWORD);
			html.setTLS(true);
			html.setSSL(true);
			html.setFrom(USERNAME, USERNAME);
			html.setSubject(assunto);
			html.addTo(para);
			html.setHtmlMsg(msg);
			html.send();
			html.setCharset("utf-8");
			 return true;

		} catch (Exception e) {
			e.printStackTrace();
			 return false;
		}

	}

}
