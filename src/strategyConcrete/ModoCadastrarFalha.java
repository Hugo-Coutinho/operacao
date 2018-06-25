package strategyConcrete;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Endereco;
import entity.Perfil;
import entity.Usuario;
import strategyInterface.ICadastrar;

public class ModoCadastrarFalha implements ICadastrar{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response, Usuario usu, Endereco e, Perfil p) throws Exception{
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
		out.println("alert('usuário com esse email já existe');");
		out.println("location='cadastrar.jsp';");
		out.println("</script>");

	}

}
