package strategyContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ctrlPattern.IUsuarioModel;
import strategyInterface.IPermissao;

public class Context {

	private IPermissao permissao;

	public void setPermissao(IPermissao permissao) {
		this.permissao = permissao;
	}

	public void criarUsuario(Integer senha,HttpSession sessao, IUsuarioModel u, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		permissao.gerarPermissao(senha,sessao, u, req, res);
	}

}
