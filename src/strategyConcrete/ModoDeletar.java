package strategyConcrete;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ctrlPattern.IUsuarioModel;
import entity.Usuario;
import persistence.UsuarioDao;
import strategyInterface.IDeletar;

public class ModoDeletar implements IDeletar {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response, IUsuarioModel usuario) throws ServletException, IOException{
		// TODO Auto-generated method stub
		try {
			new UsuarioDao().delete((Usuario) usuario);
			request.getRequestDispatcher("adminListUsuario.jsp").forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("adminListUsuario.jsp").forward(request, response);
		}
	}

}
