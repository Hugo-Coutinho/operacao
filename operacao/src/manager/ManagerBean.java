package manager;

import java.util.List;

import entity.Usuario;
import persistence.UsuarioDao;

public class ManagerBean {

	private List<Usuario> usuarios;

	public ManagerBean() {

	}

	public List<Usuario> getUsuarios() {

		try {

			usuarios = new UsuarioDao().findByPermision();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
