package strategyConcrete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ctrlPattern.IUsuarioModel;
import strategyInterface.IPermissao;

public class ModoNulo implements IPermissao {

	@Override
	public void gerarPermissao(Integer senha,HttpSession sessao, IUsuarioModel u, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		req.setAttribute("msg",
				"<div class=\"alert alert-danger\"><strong>login ou senha incorretos, digite novamente.. </strong></div>");
		req.getRequestDispatcher("login.jsp").forward(req, res);
	}

}
