package strategyConcrete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ctrlPattern.IUsuarioModel;
import strategyInterface.ILogar;

public class ModoUsuario implements ILogar {

	@Override
	public void gerarPermissao(HttpSession session, IUsuarioModel usuario, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		session = request.getSession(true);
		session.setAttribute("logado", usuario);
		request.getRequestDispatcher("/Usu/paginaInicialUser.jsp").forward(request, response);

	}

}
