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

/**
 * Servlet implementation class Controle
 */
@WebServlet({ "/editar.htm", "/cadastrar.htm", "/senha.htm", "/logar.htm", "/anotar.htm", "/upload.htm",
		"/uploadUsu.htm", "/editarUsu.htm", "/palavraPalindromo.htm", "/frasePalindromo.htm", "/fatorial.htm",
		"/primo.htm", "/fibonacci.htm", "/perfeito.htm", "/deletar.htm" })
public class Controle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	EnviarEmail enviaremail;
	UsuarioDao usuariodao;
	Arquivo word;
	PrintWriter out;
	HttpSession session;
	Usuario usuario;
	Endereco endereco;
	Calculo calculo;

	public Controle() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		login(request, response);
		admin(request, response);
		usu(request, response);
		if (request.getServletPath().equals("/editar.htm")) {
			admin(request, response);
		} else if (request.getServletPath().equals("/cadastrar.htm")) {
			login(request, response);

		} else if (request.getServletPath().equals("/senha.htm")) {
			login(request, response);
		} else if (request.getServletPath().equals("/logar.htm")) {
			login(request, response);
		} else if (request.getServletPath().equals("/anotar.htm")) {
			admin(request, response);
		} else if (request.getServletPath().equals("/deletar.htm")) {
			admin(request, response);
		} else if (request.getServletPath().equals("/palavraPalindromo.htm")) {
			usu(request, response);
		} else if (request.getServletPath().equals("/frasePalindromo.htm")) {
			usu(request, response);
		} else if (request.getServletPath().equals("/fatorial.htm")) {
			usu(request, response);
		} else if (request.getServletPath().equals("/primo.htm")) {
			usu(request, response);
		} else if (request.getServletPath().equals("/fibonacci.htm")) {
			usu(request, response);
		} else if (request.getServletPath().equals("/uploadUsu.htm")) {
			usu(request, response);
		} else if (request.getServletPath().equals("/editarUsu.htm")) {
			usu(request, response);
		}

	}

	private void usu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getServletPath().equals("/editarUsu.htm")) {

			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			Integer senha = new Integer(request.getParameter("senha"));
			String sexo = request.getParameter("sexo");
			String foto = request.getParameter("foto");
			String permissao = request.getParameter("permissao");

			try {

				Usuario u2 = (Usuario) session.getAttribute("logado");
				usuario = new Usuario(u2.getIdUsuario(), nome, email, senha, sexo, foto, permissao);

				new UsuarioDao().update(usuario);

				request.setAttribute("msg", "editado com sucesso");

			} catch (Exception e) {

				e.printStackTrace();

			} finally {
				request.getRequestDispatcher("cadastro.jsp").forward(request, response);

			}

		} else if (request.getServletPath().equals("/uploadUsu.htm")) {
			try {

				request.setAttribute("msg", "ok!!");

			} catch (Exception e) {

			} finally {

				request.getRequestDispatcher("fotoUsu.jsp").forward(request, response);

			}

		} else if (request.getServletPath().equals("/palavraPalindromo.htm")) {

			try {

				String palavra = request.getParameter("palavraPalindromo");
				calculo = new Calculo();
				request.setAttribute("msg", ": " + calculo.palavraPalindromo.operacao(palavra));

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				request.getRequestDispatcher("operacao.jsp").forward(request, response);
			}

		} else if (request.getServletPath().equals("/frasePalindromo.htm")) {

			try {

				String palavra = request.getParameter("frasePalindromo");
				calculo = new Calculo();
				request.setAttribute("msg", ": " + calculo.frasePalindromo.operacao(palavra));

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				request.getRequestDispatcher("operacao.jsp").forward(request, response);
			}
		} else if (request.getServletPath().equals("/primo.htm")) {

			try {

				String palavra = request.getParameter("primo");
				calculo = new Calculo();
				request.setAttribute("msg", ": " + calculo.primo.operacao(new Integer(palavra)));

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				request.getRequestDispatcher("operacao.jsp").forward(request, response);
			}

		} else if (request.getServletPath().equals("/fibonacci.htm")) {

			try {

				String palavra = request.getParameter("fibonacci");
				calculo = new Calculo();
				request.setAttribute("msg", ": " + calculo.fibonacci.operacao(new Integer(palavra)));

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				request.getRequestDispatcher("operacao.jsp").forward(request, response);
			}

		} else if (request.getServletPath().equals("/perfeito.htm")) {

			try {

				String palavra = request.getParameter("perfeito");
				calculo = new Calculo();
				request.setAttribute("msg", ": " + calculo.perfeito.operacao(new Integer(palavra)));

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				request.getRequestDispatcher("operacao.jsp").forward(request, response);
			}

		}

	}

	private void admin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getServletPath().equals("/editar.htm")) {

			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			Integer senha = new Integer(request.getParameter("senha"));
			String sexo = request.getParameter("sexo");
			String foto = request.getParameter("foto");
			String permissao = request.getParameter("permissao");

			try {

				Usuario u2 = (Usuario) session.getAttribute("logado");
				usuario = new Usuario(u2.getIdUsuario(), nome, email, senha, sexo, foto, permissao);

				new UsuarioDao().update(usuario);

				request.setAttribute("msg", "editado com sucesso");

			} catch (Exception e) {

				e.printStackTrace();

			} finally {
				request.getRequestDispatcher("adminListUsuario.jsp").forward(request, response);

			}

		} else if (request.getServletPath().equals("/anotar.htm")) {

			word = new Arquivo();
			String texto = request.getParameter("texto");
			try {

				word.open();
				word.writeFile(texto);
				word.close();
				request.setAttribute("msg", "salvo em documentos");

			} catch (Exception e) {
				request.setAttribute("msg", "word deu ruim");

			} finally {

				request.getRequestDispatcher("doc.jsp").forward(request, response);

			}

		} else if (request.getServletPath().equals("/deletar.htm")) {
			try {

				Integer id = new Integer(request.getParameter("id"));
				usuariodao = new UsuarioDao();
				usuario = new Usuario();
				usuario = usuariodao.findByCode(id);

				if (usuario == null) {
					request.getRequestDispatcher("adminListUsuario.jsp").forward(request, response);
				} else {

					usuariodao.delete(usuario);
					request.getRequestDispatcher("adminListUsuario.jsp").forward(request, response);
				}

			} catch (Exception e) {
				e.printStackTrace();

			} finally {

				request.getRequestDispatcher("foto.jsp").forward(request, response);

			}

		} else if (request.getServletPath().equals("/fatorial.htm")) {

			try {

				String fat = request.getParameter("fatorial");
				calculo = new Calculo();
				request.setAttribute("msg", calculo.fatorial.operacao(new Integer(fat)));
			} catch (Exception e) {
				request.setAttribute("msg", "deu ruim no fatorial " + e.getMessage());

			} finally {

				request.getRequestDispatcher("operacao.jsp").forward(request, response);
			}
		}

	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getServletPath().equals("/cadastrar.htm")) {

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

		} else if (request.getServletPath().equals("/logar.htm")) {

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
		} else if (request.getServletPath().equals("/senha.htm")) {

			String login = request.getParameter("senha");
			Integer senha = new UsuarioDao().findPasswordByEmail(login);
			String msg = "<h1>SENHA </h1>" + "Sua senha = " + senha;
			if (senha != -1) {
				request.setAttribute("msg",
						"<div class=\"alert alert-success\"><strong>Parabéns!! </strong> email enviado com sua senha!!</div>");
				request.getRequestDispatcher("senha.jsp").forward(request, response);
				new EnviarEmail().enviar(login, "senha do sistema operação", msg);
				return;
			}

			if (senha == -1) {
				request.setAttribute("msg",
						"<div class=\"alert alert-danger\"><strong>RUIM!! </strong> não achamos teu email na base de dados, desculpas..</div>");
				request.getRequestDispatcher("senha.jsp").forward(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
