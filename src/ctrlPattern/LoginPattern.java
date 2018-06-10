package ctrlPattern;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.Calculo;
import entity.Endereco;
import entity.Usuario;
import io.Arquivo;
import persistence.UsuarioDao;
import util.EnviarEmail;

public class LoginPattern {

	EnviarEmail enviaremail;
	UsuarioDao usuariodao;
	Arquivo word;
	PrintWriter out;
	HttpSession session;
	Usuario usuario;
	Endereco endereco;
	Calculo calculo;

	HttpServletRequest request;
	HttpServletResponse response;

	public LoginPattern(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	public void executar() throws Exception {

	}


	public Usuario trazUsuario(String login, String senha) throws Exception {

		usuario = new Usuario();
		return usuario = new UsuarioDao().login(login, new Integer(senha));

	}

	public void verificarNull(Usuario u) throws ServletException, IOException {

		if (u == null) {
			request.setAttribute("msg",
					"<div class=\"alert alert-danger\"><strong>não possui cadastro em nosso sistema!! </strong></div>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			verificarModoAdmin(u);
		}

	}

	public void verificarModoAdmin(Usuario usu) throws ServletException, IOException {

		if (usu.getPermissao().equalsIgnoreCase("administrador")) {
			session = request.getSession(true);
			session.setAttribute("logado", usuario);
			request.getRequestDispatcher("/Admin/paginaInicial.jsp").forward(request, response);
		} else {
			setarModoUsu();
		}

	}

	public void setarModoUsu() throws ServletException, IOException {

		session = request.getSession(true);
		session.setAttribute("logado", usuario);
		request.getRequestDispatcher("/Usu/paginaInicialUser.jsp").forward(request, response);
	}

}
