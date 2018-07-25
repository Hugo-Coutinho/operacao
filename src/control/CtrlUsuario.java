package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import entity.Endereco;
import entity.Usuario;
import io.Arquivo;
import persistence.AnotacaoDao;
import persistence.EnderecoDao;
import persistence.UsuarioDao;
import type.TypeSexo;
import util.EnviarEmail;

@MultipartConfig
@WebServlet({ "/Usu/upload.htm", "/Usu/atualizarFotoModoUsu.htm", "/Usu/editarUsu.htm", "/Usu/palavraPalindromo.htm",
		"/Usu/frasePalindromo.htm", "/Usu/fatorial.htm", "/Usu/primo.htm", "/Usu/fibonacci.htm", "/Usu/perfeito.htm" })
public class CtrlUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EnviarEmail enviaremail;
	UsuarioDao usuariodao;
	EnderecoDao enderecodao;
	Arquivo word;
	PrintWriter out;
	HttpSession session;
	Usuario usuario;
	Endereco endereco;
	Calculo calculo;

	public CtrlUsuario() {
		super();

		new CtrlLogin();
		this.session = CtrlLogin.session;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		switch (request.getServletPath()) {
		case "/Usu/palavraPalindromo.htm":
			palavraPalindromo(request, response);
			break;
		case "/Usu/frasePalindromo.htm":
			frasePalindromo(request, response);
			break;
		case "/Usu/fatorial.htm":
			fatorial(request, response);
			break;
		case "/Usu/primo.htm":
			primo(request, response);
			break;
		case "/Usu/atualizarFotoModoUsu.htm":
			atualizaPerfil(request, response);
			break;
		case "/Usu/fibonacci.htm":
			fibonacci(request, response);
			break;
		case "/Usu/editarUsu.htm":
			editarUsu(request, response);
			break;
		case "/Usu/perfeito.htm":
			perfeito(request, response);
			break;

		}

	}

	private void atualizaPerfil(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			enderecodao = new EnderecoDao();
			usuariodao = new UsuarioDao();
			Part part = request.getPart("file");
				
				part.write(request.getRealPath("/" + Operacoes.getNomeImagem(part.getSubmittedFileName())));
				
				Usuario usu = (Usuario) session.getAttribute("logado");
				
				String novaFoto= "\\operacao\\" + Operacoes.getNomeImagem(part.getSubmittedFileName());
				Usuario atualizaUsu = new Usuario(usu.getIdUsuario(),usu.getNome(),usu.getEmail(),usu.getSenha(),usu.getSexo(),novaFoto,usu.getPermissao(),usu.getEndereco());
				enderecodao.update(usu.getEndereco());
				usuariodao.update(atualizaUsu);
				session.setAttribute("logado", atualizaUsu);
				request.setAttribute("msg", "atualizado com sucesso");
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
		} finally {
			request.getRequestDispatcher("perfilUsu.jsp").forward(request, response);
		}

	}

	protected void perfeito(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String palavra = request.getParameter("perfeito");
			calculo = new Calculo();
			request.setAttribute("msg", ": " + calculo.perfeito.operacao(new Integer(palavra)));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("/Usu/operacao.jsp").forward(request, response);
		}

	}

	protected void editarUsu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String sexo = request.getParameter("sexo");
		String cep = request.getParameter("cep");
		String logradouro = request.getParameter("logradouro");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");

		try {
			Usuario u2 = (Usuario) session.getAttribute("logado");
			Endereco e = new Endereco(u2.getEndereco().getIdEndereco(), logradouro, bairro, cidade, estado, cep);
			usuario = new Usuario(u2.getIdUsuario(), nome, email, senha, sexo.equalsIgnoreCase("f")? TypeSexo.FEMININO: TypeSexo.MASCULINO, u2.getFoto(), u2.getPermissao(), e);

			new EnderecoDao().update(e);
			new UsuarioDao().update(usuario);

			session.setAttribute("logado", usuario);
			request.setAttribute("msg", "editado com sucesso");

		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("msg", "fudeu mané!!, " + e.getMessage());

		} finally {
			request.getRequestDispatcher("cadastro.jsp").forward(request, response);

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
			request.getRequestDispatcher("/Usu/operacao.jsp").forward(request, response);
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
			request.getRequestDispatcher("/Usu/operacao.jsp").forward(request, response);
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

			request.getRequestDispatcher("/Usu/operacao.jsp").forward(request, response);
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
			request.getRequestDispatcher("/Usu/operacao.jsp").forward(request, response);
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
			request.getRequestDispatcher("/Usu/operacao.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
