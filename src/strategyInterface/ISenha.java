package strategyInterface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ISenha {

	public void enviarEmail(HttpServletRequest request, HttpServletResponse response, String login, String mensagem) throws Exception;

}
