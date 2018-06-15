package strategyConcrete;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Endereco;
import entity.Usuario;
import persistence.EnderecoDao;
import persistence.UsuarioDao;
import strategyInterface.ICadastrar;

public class ModoCadastrar implements ICadastrar {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response, Usuario usu, Endereco e)
			throws Exception {

		PrintWriter out = response.getWriter();
		new EnderecoDao().create(e);
		new UsuarioDao().create(usu);

		out.println("<script type=\"text/javascript\">");
		out.println("alert('usuário com esse email já existe');");
		out.println("location='login.jsp';");
		out.println("</script>");

	}

}
