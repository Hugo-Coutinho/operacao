package strategyInterface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ctrlPattern.IUsuarioModel;
import entity.Usuario;

public interface IPermissao {

	public void gerarPermissao(Integer senha, HttpSession sessao, IUsuarioModel u, HttpServletRequest req,
			HttpServletResponse res) throws Exception;
}
