package strategyConcrete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ctrlPattern.IUsuarioModel;
import ctrlPattern.ServicoVerificarSenha;
import strategyInterface.IPermissao;

public class ModoUsuario implements IPermissao {

	ServicoVerificarSenha service;

	@Override
	public void gerarPermissao(Integer senha, HttpSession session, IUsuarioModel usuario, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		service = new ServicoVerificarSenha();
		
		if (service.senhaCorreta(usuario, senha)) {
			logar(session, usuario, request, response);
		} else {
			service.senhaIncorreta(request, response);
		}

	}

	private void logar(HttpSession session, IUsuarioModel usuario, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		session = request.getSession(true);
		session.setAttribute("logado", usuario);
		request.getRequestDispatcher("/Usu/paginaInicialUser.jsp").forward(request, response);

	}

}
