package strategyConcrete;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Endereco;
import entity.Perfil;
import entity.Usuario;
import persistence.EnderecoDao;
import persistence.PerfilDao;
import persistence.UsuarioDao;
import strategyInterface.ICadastrar;

public class ModoCadastrar implements ICadastrar {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response, Usuario usu, Endereco e, Perfil p)
			throws Exception {

		new PerfilDao().create(p);
		new EnderecoDao().create(e);
		new UsuarioDao().create(usu);

		request.setAttribute("alert", true);
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}

}
