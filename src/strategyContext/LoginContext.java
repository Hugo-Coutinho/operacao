package strategyContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ctrlPattern.IUsuarioModel;
import strategyInterface.ILogar;

public class LoginContext {

	private ILogar permissao;

	public void setPermissao(ILogar permissao) {
		this.permissao = permissao;
	}

	public void criarUsuario(HttpSession sessao, IUsuarioModel u, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		permissao.gerarPermissao(sessao, u, req, res);
	}

}
