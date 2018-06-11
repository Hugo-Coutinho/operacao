package strategyInterface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ctrlPattern.IUsuarioModel;

public interface ILogar {

	public void gerarPermissao(HttpSession sessao, IUsuarioModel u, HttpServletRequest req,
			HttpServletResponse res) throws Exception;
}
