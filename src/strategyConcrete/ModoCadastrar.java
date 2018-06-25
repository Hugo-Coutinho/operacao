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

		PrintWriter out = response.getWriter();

		new PerfilDao().create(p);
		new EnderecoDao().create(e);
		new UsuarioDao().create(usu);

		out.println("<script type=\"text/javascript\">");
		out.println("alert('cadastrado com sucesso !!!');");
		out.println("location='login.jsp';");
		out.println("</script>");

	}

}
