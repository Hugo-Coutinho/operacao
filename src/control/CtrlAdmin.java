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

@WebServlet({ "/anotar.htm", "/editar.htm", "/deletar.htm" })
public class CtrlAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EnviarEmail enviaremail;
	UsuarioDao usuariodao;
	Arquivo word;
	PrintWriter out;
	HttpSession session;
	Usuario usuario;
	Endereco endereco;
	Calculo calculo;

	public CtrlAdmin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getServletPath().equals("/editar.htm")) {
			editar(request, response);
		} else if (request.getServletPath().equals("/anotar.htm")) {
			anotar(request, response);
		} else if (request.getServletPath().equals("/deletar.htm")) {
			deletar(request, response);
		}
	}

	protected void editar(HttpServletRequest request, HttpServletResponse response)
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
			request.getRequestDispatcher("adminListUsuario.jsp").forward(request, response);

		}
	}

	protected void anotar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
	}

	protected void deletar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
