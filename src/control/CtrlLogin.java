package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Endereco;
import entity.Usuario;
import io.Arquivo;
import persistence.EnderecoDao;
import persistence.UsuarioDao;
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
			String id = request.getParameter("getId");
			Integer novaSenha = (int) (10000 * Math.random());
			String msg = "<h1>NOVA SENHA</h1>" + "Sua senha = " + novaSenha;
			enviaremail = new EnviarEmail();
			usuariodao = new UsuarioDao();
			Usuario usuario = usuariodao.findByCode(new Integer(id));

			if (usuario == null) {

				request.setAttribute("msg",
						"<div class=\"alert alert-danger\"><strong>ERRADO!! </strong> esse login não está registrado no sistema</div>");
			} else {

				usuario.setSenha(novaSenha);
				usuariodao.update(usuario);
				enviaremail.enviar(login, "nova Senha", msg);
				request.setAttribute("msg",
						"<div class=\"alert alert-success\"><strong>Parabéns!! </strong> email com nova senha enviado!!</div>");

			}

		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("msg", "deu ruim no senha " + e.getMessage());

		} finally {

			request.getRequestDispatcher("senha.jsp").forward(request, response);
		}
	}

	protected void logar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		try {
			session = request.getSession(true);
			usuariodao = new UsuarioDao();
			usuario = new Usuario();
			Usuario usuario = usuariodao.login(login, new Integer(senha));

			if (usuario == null) {

				request.setAttribute("msg", "<div class=\"alert alert-danger\"><strong>ERRADO!! </strong></div>");
				request.getRequestDispatcher("login.jsp").forward(request, response);

			} else if (usuario.getPermissao().equals("Usuario")) {

				session.setAttribute("logado", usuario);
				request.getRequestDispatcher("paginaInicialUser.jsp").forward(request, response);

			} else {
				session.setAttribute("logado", usuario);
				request.getRequestDispatcher("paginaInicial.jsp").forward(request, response);
			}

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
