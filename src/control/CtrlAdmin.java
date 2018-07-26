package control;

import java.io.IOException; 
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.google.gson.Gson;

import ctrlPattern.IUsuarioModel;
import entity.Anotacao;
import entity.Endereco;
import entity.Usuario;
import io.AnotacaoIO;
import io.Arquivo;
import persistence.AnotacaoDao;
import persistence.EnderecoDao;
import persistence.UsuarioDao;
import strategyConcrete.ModoDeletar;
import strategyConcrete.ModoDeletarNulo;
import strategyContext.DeletarContext;
import type.TypeSexo;
import util.EnviarEmail;
 
@MultipartConfig
@WebServlet({ "/Admin/anotar.htm", "/Admin/atualizarFoto.htm", "/Admin/editar.htm", "/Admin/deletar.htm","/Admin/addAnotacao.htm", 
	"/Admin/removerAnotacao.htm", "/Admin/verAnotacao.htm", "/Admin/editarAnotacao.htm","/Admin/salvarAnotacaoEditada.htm","/Admin/apagarAnotacoesChecked.htm" })
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
	AnotacaoIO anotacaoIO;
	List<Anotacao> notas;

	public CtrlAdmin() {
		super();
		session = CtrlLogin.session;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		switch (request.getServletPath()) {
		case "/Admin/editar.htm":
			editar(request, response);
			break;
		case "/Admin/anotar.htm":
			anotar(request, response);
			break;
		case "/Admin/atualizarFoto.htm":
			atualizaPerfil(request, response);
			break;
		case "/Admin/deletar.htm":
			deletar(request, response);
			break;
		case "/Admin/addAnotacao.htm":
			addAnotacao(request, response);
			break;
		case "/Admin/removerAnotacao.htm":
			removerAnotacao(request, response);
			break;
		case "/Admin/verAnotacao.htm":
			verAnotacao(request, response);
			break;
		case "/Admin/editarAnotacao.htm":
			editarAnotacao(request, response);
			break;
		case "/Admin/salvarAnotacaoEditada.htm":
			salvarAnotacaoEditada(request, response);
			break;
		case "/Admin/apagarAnotacoesChecked.htm":
			apagarAnotacoesChecked(request, response);
			break;
		}
	}

	private void apagarAnotacoesChecked(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			usuario = (Usuario) session.getAttribute("logado");
			String[] listaIds = request.getParameterValues("ids[]");

			if (listaIds != null) {
				for (String vl : listaIds) {
					new AnotacaoDao().delete(new AnotacaoDao().findByCode(new Integer(vl)));
				}
			}
			usuario.setAnotacoes(new AnotacaoDao().buscarListaAnotacaoPorUsuarioLogado(usuario.getIdUsuario()));
			session.setAttribute("logado", usuario);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void salvarAnotacaoEditada(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			usuario = (Usuario) session.getAttribute("logado");
			String id = request.getParameter("idAnotacaoEditar");
			String nomeAnotacao = request.getParameter("nomeAnotacao");
			String texto = request.getParameter("textoEditado");
			
			AnotacaoIO noteIO = new AnotacaoIO(nomeAnotacao);
			noteIO.open();
			noteIO.writeFile(texto);
			noteIO.close();
			
			Anotacao notaEditada = new Anotacao(new Integer(id),nomeAnotacao,new Date(),usuario);
			new AnotacaoDao().update(notaEditada);
			usuario.setAnotacoes(new AnotacaoDao().buscarListaAnotacaoPorUsuarioLogado(usuario.getIdUsuario()));
			session.setAttribute("logado", usuario);
			
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("errorAddAnotacao",e.getMessage() );
		}finally {
			request.getRequestDispatcher("doc.jsp").forward(request, response);
		}
		
	}

	private void editarAnotacao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String id = request.getParameter("id");
			Anotacao nota = new AnotacaoDao().findByCode(new Integer(id));
			String anotacao = new AnotacaoIO().lerArquivo(nota.getNome());

			Map<String, String> notaJson = new LinkedHashMap<>();
			notaJson.put("nome", nota.getNome());
			notaJson.put("texto", anotacao);

			String json = new Gson().toJson(notaJson);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void verAnotacao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String id = request.getParameter("id");
			Anotacao nota = new AnotacaoDao().findByCode(new Integer(id));
			String anotacao = new AnotacaoIO().lerArquivo(nota.getNome());

			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(anotacao);
		} catch (Exception e) {
			// TODO: handle exception
			response.getWriter().write(e.getMessage());
		}

	}

	private void removerAnotacao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			usuario = (Usuario) session.getAttribute("logado");
			String anotacaoId = request.getParameter("idAnotacaoDelete");
			new AnotacaoDao().delete(new AnotacaoDao().findByCode(new Integer(anotacaoId)));
			usuario.setAnotacoes(new AnotacaoDao().buscarListaAnotacaoPorUsuarioLogado(usuario.getIdUsuario()));
			session.setAttribute("logado", usuario);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			response.sendRedirect("doc.jsp");
		}
	}

	private void addAnotacao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		usuario = (Usuario) session.getAttribute("logado");
		String nome = request.getParameter("nome");
		String nota = request.getParameter("anotacao");
		try {
			
			if(!new AnotacaoDao().verificaNomeAnotacaoJaExiste(nome)) {
				new AnotacaoDao().create(new Anotacao(null, nome, new Date(), usuario));
				usuario.setAnotacoes(new AnotacaoDao().buscarListaAnotacaoPorUsuarioLogado(usuario.getIdUsuario()));
				anotacaoIO = new AnotacaoIO(nome);
				anotacaoIO.open();
				anotacaoIO.writeFile(nota);
				anotacaoIO.close();
				session.setAttribute("logado", usuario);
			}else {
				request.setAttribute("errorAddAnotacao", "Anotação não criada: anotação com esse nome já existe..");
			}
		} catch (Exception e) {
			request.setAttribute("errorAddAnotacao", e.getMessage());
		} finally {
			request.getRequestDispatcher("doc.jsp").forward(request, response);
		}
	}

	private void atualizaPerfil(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Part part = request.getPart("file");

			part.write(request.getRealPath("/" + Operacoes.getNomeImagem(part.getSubmittedFileName())));

			Usuario usu = (Usuario) session.getAttribute("logado");
			String novoPerfil= "\\operacao\\" + Operacoes.getNomeImagem(part.getSubmittedFileName());
			usu.setFoto(novoPerfil);
			new UsuarioDao().update(usu);
			session.setAttribute("logado", usu);
			request.setAttribute("msg", "atualizado com sucesso");
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
		} finally {
			request.getRequestDispatcher("perfilAdmin.jsp").forward(request, response);
		}

	}

	protected void editar(HttpServletRequest request, HttpServletResponse response)
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
			usuario = new Usuario(u2.getIdUsuario(), nome, email, senha, sexo.equalsIgnoreCase("f")? TypeSexo.FEMININO: sexo.isEmpty() ? TypeSexo.INDEFINIDO :TypeSexo.MASCULINO, u2.getFoto(), u2.getPermissao(), e);

			new EnderecoDao().update(e);
			new UsuarioDao().update(usuario);

			for(Anotacao nota: u2.getAnotacoes()) {
				if(nota!=null) {
					new AnotacaoDao().update(nota);
				}
			}
			
			List<Anotacao> notas = new ArrayList<>();
			notas= (u2.getAnotacoes());
			usuario.setAnotacoes(notas);
			
			session.setAttribute("logado", usuario);
			request.setAttribute("msg", "editado com sucesso");

		} catch (Exception e) {
			request.setAttribute("msg", "fudeu mane!!, " + e.getMessage());
			e.printStackTrace();

		} finally {
			request.getRequestDispatcher("adminListUsuario.jsp").forward(request, response);

		}
	}

	protected void anotar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String texto = request.getParameter("texto");
		String path = request.getParameter("path");

		word = new Arquivo(path);
		try {

			word.open();
			word.writeFile(texto);
			word.close();
			request.setAttribute("msg", "salvo com sucesso !!!");

		} catch (Exception e) {
			request.setAttribute("msg", "word deu ruim " + e.getMessage());

		} finally {

			request.getRequestDispatcher("doc.jsp").forward(request, response);

		}
	}

	protected void deletar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			Integer id = new Integer(request.getParameter("id"));
			usuariodao = new UsuarioDao();
			IUsuarioModel usuario = new Usuario();
			usuario = usuariodao.findByCode(id);
			DeletarContext ctx = new DeletarContext();
			ctx.setDel(usuario instanceof Usuario ? new ModoDeletar() : new ModoDeletarNulo());
			ctx.CondicaoDeletar(request, response, usuario);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
