package strategyConcrete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.CtrlLogin;
import ctrlPattern.IUsuarioModel;
import strategyInterface.ILogar;

public class ModoAdmin implements ILogar {

	@Override
	public void gerarPermissao(HttpSession session, IUsuarioModel usuario, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		new CtrlLogin();
		CtrlLogin.session= request.getSession(true);
		CtrlLogin.session.setAttribute("logado", usuario);
		request.getRequestDispatcher("/Admin/paginaInicial.jsp").forward(request, response);

	}

}
