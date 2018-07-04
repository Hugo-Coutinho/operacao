package strategyConcrete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import strategyInterface.ISenha;

public class ErroSenha implements ISenha {

	@Override
	public void enviarEmail(HttpServletRequest request, HttpServletResponse response, String login, String mensagem)
			throws Exception {
		// TODO Auto-generated method stub
		request.setAttribute("msg",
				"<div class=\"alert alert-danger\"><strong>RUIM!! </strong> não achamos seu email na base de dados, desculpas..</div>");
		request.getRequestDispatcher("senha.jsp").forward(request, response);
	}

}
