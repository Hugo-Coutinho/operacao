package strategyInterface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ctrlPattern.IUsuarioModel;

public interface IDeletar {

	public void executar(HttpServletRequest request, HttpServletResponse response, IUsuarioModel usuario) throws Exception;

}
