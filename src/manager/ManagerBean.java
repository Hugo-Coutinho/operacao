package manager;

import java.util.List;

import ctrlPattern.IUsuarioModel;
import ctrlPattern.UsuarioNull;
import entity.Perfil;
import persistence.PerfilDao;
import persistence.UsuarioDao;

public class ManagerBean {

	private List<IUsuarioModel> usuarios;
	private List<Perfil> perfis;

	public ManagerBean() {

	}

	public List<Perfil> getPerfis() {
		try {
			perfis= new PerfilDao().findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
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

	public static void main(String[] args) {

		try {
			System.out.println(new ManagerBean().getPerfis());
			System.out.println(new ManagerBean().getUsuarios());
			List<IUsuarioModel>lst = new ManagerBean().getUsuarios();
			for(IUsuarioModel x : lst) {
				System.out.println(x.getPerfil());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
