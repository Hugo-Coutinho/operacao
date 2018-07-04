package strategyConcrete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import strategyInterface.ISenha;
import util.EnviarEmail;

public class EnviarEmailConcrete implements ISenha {

	@Override
	public void enviarEmail(HttpServletRequest request, HttpServletResponse response, String login, String mensagem)
			throws Exception {
		request.setAttribute("msg",
				"<div class=\"alert alert-success\"><strong>Parabéns!! </strong> email enviado com sua senha!!</div>");
		request.getRequestDispatcher("senha.jsp").forward(request, response);
		new EnviarEmail().enviar(login, "senha do sistema operação", mensagem);
	}

}
