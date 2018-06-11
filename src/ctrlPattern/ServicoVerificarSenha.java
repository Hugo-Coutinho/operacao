package ctrlPattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServicoVerificarSenha {

	public boolean senhaCorreta(IUsuarioModel usuario, Integer senha) {
		if (usuario.getSenha().equals(senha)) {
			return true;
		}
		return false;
	}

	public void senhaIncorreta(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setAttribute("msg",
				"<div class=\"alert alert-danger\"><strong>senha incorreta, tente novamente </strong></div>");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
