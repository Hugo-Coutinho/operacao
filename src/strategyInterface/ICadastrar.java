package strategyInterface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Endereco;
import entity.Perfil;
import entity.Usuario;

public interface ICadastrar {

	public void executar(HttpServletRequest request, HttpServletResponse response, Usuario usu, Endereco e, Perfil p)throws Exception;
	
}
