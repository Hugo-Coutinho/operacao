package strategyContext;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import entity.Endereco;
import entity.Usuario;
import strategyInterface.ICadastrar;

public class CadastrarContext {

	private ICadastrar cadastrar;

	public void setCadastrar(ICadastrar cadastrar) {
		this.cadastrar = cadastrar;
	}

	public void executarCadastramento(HttpServletRequest request, HttpServletResponse response, Usuario usu,
			Endereco e) throws Exception{

		cadastrar.executar(request, response, usu, e);
	}

}
