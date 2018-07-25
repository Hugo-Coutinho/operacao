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

import ctrlPattern.IUsuarioModel;
import entity.Endereco;
import entity.Usuario;
import io.Arquivo;
import persistence.UsuarioDao;
import strategyConcrete.EnviarEmailConcrete;
import strategyConcrete.ErroSenha;
import strategyConcrete.ModoAdmin;
import strategyConcrete.ModoCadastrar;
import strategyConcrete.ModoCadastrarFalha;
import strategyConcrete.ModoNulo;
import strategyConcrete.ModoUsuario;
import strategyContext.CadastrarContext;
import strategyContext.LoginContext;
import strategyContext.SenhaContext;
import type.TypePermissao;
import type.TypeSexo;
import util.EnviarEmail;
import util.Valida;

@MultipartConfig
@WebServlet({ "/cadastrar.htm","/senha.htm", "/logar.htm" })
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

		switch (request.getServletPath()) {
		case "/cadastrar.htm":
			cadastrar(request, response);
			break;
		case "/senha.htm":
			senha(request, response);
			break;
		case "/logar.htm":
			logar(request, response);
			break;
		}
	}

	protected void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
		out = response.getWriter();

		Part part = request.getPart("file");
		
		part.write(request.getRealPath("/" + Operacoes.getNomeImagem(part.getSubmittedFileName())));
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String sexo = request.getParameter("sexo");
		String permissao = request.getParameter("permissao");

		String cep = request.getParameter("cep");
		String logradouro = request.getParameter("logradouro");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");


			String foto="\\operacao\\" + Operacoes.getNomeImagem(part.getSubmittedFileName());
			endereco = new Endereco(null, logradouro, bairro, cidade, estado, cep);
			usuario = new Usuario(null, nome, email, senha, sexo.equalsIgnoreCase("f")? TypeSexo.FEMININO: TypeSexo.MASCULINO, foto,
					permissao.equalsIgnoreCase("Administrador")? TypePermissao.ADMINISTRADOR: TypePermissao.USUARIO, endereco);

			CadastrarContext ctx = new CadastrarContext();
			ctx.setCadastrar(new UsuarioDao().usuarioExiste(usuario.getEmail()) ? new ModoCadastrarFalha()
					: new ModoCadastrar());
			ctx.executarCadastramento(request, response, usuario, endereco);

		} catch (Exception e) {
			request.getRequestDispatcher("cadastrar.jsp").forward(request, response);
		}
	}

	protected void senha(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String login = request.getParameter("senha");
			String senha = new UsuarioDao().findPasswordByEmail(login);
			String msg = "<h1>SENHA </h1>" + "Sua senha = " + senha;
			SenhaContext ctx = new SenhaContext();
			ctx.setSenha(senha.equalsIgnoreCase("-1") ? new ErroSenha() : new EnviarEmailConcrete());
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

			if (new Valida().validaLoginNomeOuEmail(login).equalsIgnoreCase("Nome")) {
				IUsuarioModel u = new UsuarioDao().loginByNome(login,senha);
				LoginContext ctx = new LoginContext();
				ctx.setPermissao(u.getPermissao().equals(TypePermissao.USUARIO) ? new ModoUsuario()
						: u.getPermissao().equals(TypePermissao.ADMINISTRADOR) ? new ModoAdmin() : new ModoNulo());
				ctx.criarUsuario(session, u, request, response);

			} else {
				IUsuarioModel u = new UsuarioDao().login(login, senha);
				LoginContext ctx = new LoginContext();
				ctx.setPermissao(u.getPermissao().equals(TypePermissao.USUARIO) ? new ModoUsuario()
						: u.getPermissao().equals(TypePermissao.ADMINISTRADOR) ? new ModoAdmin() : new ModoNulo());
				ctx.criarUsuario(session, u, request, response);
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
