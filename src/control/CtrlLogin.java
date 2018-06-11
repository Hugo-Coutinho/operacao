package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ctrlPattern.IUsuarioModel;
import entity.Endereco;
import entity.Usuario;
import io.Arquivo;
import persistence.EnderecoDao;
import persistence.UsuarioDao;
import strategyConcrete.EnviarEmailConcrete;
import strategyConcrete.ErroSenha;
import strategyConcrete.ModoAdmin;
import strategyConcrete.ModoNulo;
import strategyConcrete.ModoUsuario;
import strategyContext.LoginContext;
import strategyContext.SenhaContext;
import util.EnviarEmail;

@WebServlet({ "/cadastrar.htm", "/senha.htm", "/logar.htm" })
public class CtrlLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EnviarEmail enviaremail;
	UsuarioDao usuariodao;
	Arquivo word;
	PrintWriter out;
	public static HttpSession session;
	Usuario usuario;
	Endereco endereco;
	Calculo calculo;

	public CtrlLogin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		if (request.getServletPath().equals("/cadastrar.htm")) {
			cadastrar(request, response);
		} else if (request.getServletPath().equals("/senha.htm")) {
			senha(request, response);
		} else if (request.getServletPath().equals("/logar.htm")) {
			logar(request, response);
		}

	}

	protected void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		out = response.getWriter();
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String sexo = request.getParameter("sexo");
		String foto = request.getParameter("foto");
		String permissao = request.getParameter("permissao");

		String cep = request.getParameter("cep");
		String logradouro = request.getParameter("logradouro");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");

		try {

			endereco = new Endereco(null, logradouro, bairro, cidade, estado, cep);
			usuario = new Usuario(null, nome, email, new Integer(senha), sexo, foto, permissao, endereco);

			new EnderecoDao().create(endereco);
			new UsuarioDao().create(usuario);

			out.println("<script type=\"text/javascript\">");
			out.println("alert('cadastrado com sucesso');");
			out.println("location='login.jsp';");
			out.println("</script>");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	protected void senha(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String login = request.getParameter("senha");
			Integer senha = new UsuarioDao().findPasswordByEmail(login);
			String msg = "<h1>SENHA </h1>" + "Sua senha = " + senha;
			SenhaContext ctx = new SenhaContext();
			ctx.setSenha(senha.equals(-1) ? new ErroSenha() : new EnviarEmailConcrete());
			ctx.executar(request, response, login, msg);

		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("msg", "deu ruim no senha " + e.getMessage());
		}

	}

	protected void logar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		try {
			IUsuarioModel u = new UsuarioDao().login(login, new Integer(senha));
			LoginContext ctx = new LoginContext();
			ctx.setPermissao(u.getPermissao().equalsIgnoreCase("usuario") ? new ModoUsuario()
					: u.getPermissao().equalsIgnoreCase("administrador") ? new ModoAdmin() : new ModoNulo());
			ctx.criarUsuario(session, u, request, response);

		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("msg", "deu ruim logar " + e.getMessage());
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
