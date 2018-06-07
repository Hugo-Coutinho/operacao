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
import persistence.UsuarioDao;
import util.EnviarEmail;

@WebServlet({ "/upload.htm", "/uploadUsu.htm", "/editarUsu.htm", "/palavraPalindromo.htm", "/frasePalindromo.htm",
		"/fatorial.htm", "/primo.htm", "/fibonacci.htm", "/perfeito.htm" })
public class CtrlUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EnviarEmail enviaremail;
	UsuarioDao usuariodao;
	Arquivo word;
	PrintWriter out;
	HttpSession session;
	Usuario usuario;
	Endereco endereco;
	Calculo calculo;

	public CtrlUsuario() {
		super();
		session = CtrlLogin.session;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		if (request.getServletPath().equals("/palavraPalindromo.htm")) {
			palavraPalindromo(request, response);
		} else if (request.getServletPath().equals("/frasePalindromo.htm")) {
			frasePalindromo(request, response);
		} else if (request.getServletPath().equals("/fatorial.htm")) {
			fatorial(request, response);
		} else if (request.getServletPath().equals("/primo.htm")) {
			primo(request, response);
		} else if (request.getServletPath().equals("/fibonacci.htm")) {
			fibonacci(request, response);
		} else if (request.getServletPath().equals("/uploadUsu.htm")) {
			uploadUsu(request, response);
		} else if (request.getServletPath().equals("/editarUsu.htm")) {
			editarUsu(request, response);
		}

	}

	protected void editarUsu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
	}

	protected void uploadUsu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			request.setAttribute("msg", "ok!!");

		} catch (Exception e) {

		} finally {

			request.getRequestDispatcher("fotoUsu.jsp").forward(request, response);

		}

	}

	protected void fibonacci(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String palavra = request.getParameter("fibonacci");
			calculo = new Calculo();
			request.setAttribute("msg", ": " + calculo.fibonacci.operacao(new Integer(palavra)));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("operacao.jsp").forward(request, response);
		}

	}

	protected void primo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String palavra = request.getParameter("primo");
			calculo = new Calculo();
			request.setAttribute("msg", ": " + calculo.primo.operacao(new Integer(palavra)));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("operacao.jsp").forward(request, response);
		}

	}

	protected void fatorial(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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

	protected void frasePalindromo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String palavra = request.getParameter("frasePalindromo");
			calculo = new Calculo();
			request.setAttribute("msg", ": " + calculo.frasePalindromo.operacao(palavra));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("operacao.jsp").forward(request, response);
		}

	}

	protected void palavraPalindromo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String palavra = request.getParameter("palavraPalindromo");
			calculo = new Calculo();
			request.setAttribute("msg", ": " + calculo.palavraPalindromo.operacao(palavra));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("operacao.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
