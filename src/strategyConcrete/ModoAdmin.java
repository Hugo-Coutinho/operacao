package strategyConcrete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ctrlPattern.IUsuarioModel;
import ctrlPattern.ServicoVerificarSenha;
import strategyInterface.IPermissao;

public class ModoAdmin implements IPermissao {

	ServicoVerificarSenha service;

	@Override
	public void gerarPermissao(Integer senha, HttpSession session, IUsuarioModel usuario, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		if (service.senhaCorreta(usuario, senha)) {
			logar(senha, session, usuario, request, response);
		} else {
			service.senhaIncorreta(request, response);
		}

	}

	private void logar(Integer senha, HttpSession session, IUsuarioModel usuario, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		session = request.getSession(true);
		session.setAttribute("logado", usuario);
		request.getRequestDispatcher("/Admin/paginaInicial.jsp").forward(request, response);
	}

}
