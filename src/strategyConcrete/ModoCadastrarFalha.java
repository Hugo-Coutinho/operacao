package strategyConcrete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Endereco;
import entity.Usuario;
import strategyInterface.ICadastrar;

public class ModoCadastrarFalha implements ICadastrar{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response, Usuario usu, Endereco e) throws Exception{
		// TODO Auto-generated method stub

		request.setAttribute("alert", false);
		request.getRequestDispatcher("login.jsp").forward(request, response);
	
	}

}
