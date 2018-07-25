package manager;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import control.CtrlLogin;
import ctrlPattern.IUsuarioModel;
import ctrlPattern.UsuarioNull;
import entity.Anotacao;
import entity.Usuario;
import persistence.UsuarioDao;

public class ManagerBean {

	private List<IUsuarioModel> usuarios;
	private List<Anotacao> notas;

	Usuario logado;
	HttpSession session;

	public ManagerBean() {
		logado = new Usuario();
		session = CtrlLogin.session;
		logado = (Usuario) session.getAttribute("logado");
	}

	public List<IUsuarioModel> getUsuarios() {

		try {

			usuarios = new UsuarioDao().findByPermision();
			if (usuarios.get(0) instanceof UsuarioNull) {
				return null;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return usuarios;
	}

	public void setUsuarios(List<IUsuarioModel> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Anotacao> getNotas() {
		try {
			if (notas == null) {
				notas = new ArrayList<Anotacao>();
			}
			for (Anotacao nota : logado.getAnotacoes()) {
				notas.add(nota);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return notas;
	}

	public void setNotas(List<Anotacao> notas) {
		this.notas = notas;
	}

}
