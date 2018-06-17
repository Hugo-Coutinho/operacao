package strategyConcrete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ctrlPattern.IUsuarioModel;
import strategyInterface.IDeletar;

public class ModoDeletarNulo implements IDeletar {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response, IUsuarioModel usuario)
			throws Exception {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("adminListUsuario.jsp").forward(request, response);		
	}

}
