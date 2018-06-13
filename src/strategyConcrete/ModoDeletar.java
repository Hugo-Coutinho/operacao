package strategyConcrete;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ctrlPattern.IUsuarioModel;
import entity.Usuario;
import persistence.EnderecoDao;
import persistence.UsuarioDao;
import strategyInterface.IDeletar;

public class ModoDeletar implements IDeletar {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response, IUsuarioModel usuario) throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		Usuario u = (Usuario) usuario;
		Usuario u2 = (Usuario) usuario;
		u2.setEndereco(u.getEndereco());

		new UsuarioDao().delete(u);
		new EnderecoDao().delete(u2.getEndereco());
		u2 = new Usuario();
		request.getRequestDispatcher("adminListUsuario.jsp").forward(request, response);
	}

}
