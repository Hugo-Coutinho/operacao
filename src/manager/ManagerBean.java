package manager;

import java.util.List;

import ctrlPattern.IUsuarioModel;
import persistence.UsuarioDao;

public class ManagerBean {

	private List<IUsuarioModel> usuarios;

	public ManagerBean() {

	}

	public List<IUsuarioModel> getUsuarios() {

		try {

			usuarios = new UsuarioDao().findByPermision();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return usuarios;
	}

	public void setUsuarios(List<IUsuarioModel> usuarios) {
		this.usuarios = usuarios;
	}

	public static void main(String[] args) {

		try {
			System.out.println(new ManagerBean().getUsuarios());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
