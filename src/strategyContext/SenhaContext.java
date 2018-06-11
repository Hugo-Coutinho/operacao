package strategyContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import strategyInterface.ISenha;

public class SenhaContext {

	private ISenha s;

	public void setSenha(ISenha senha) {
		this.s = senha;
	}

	public void executar(HttpServletRequest request, HttpServletResponse response, String login, String mensagem) throws Exception {

		s.enviarEmail(request, response, login,mensagem);
	}

}
