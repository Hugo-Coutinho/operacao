package persistence;

import java.util.List;

import ctrlPattern.IUsuarioModel;
import ctrlPattern.UsuarioNull;
import entity.Usuario;
import type.TypePermissao;

public class UsuarioDao extends GenericDao<Usuario, Integer> {

	public UsuarioDao() {

		super(new Usuario());

	}

	public IUsuarioModel login(String login, String senha) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		String hql = "from Usuario where email= :param1 and senha= :param2";
		IUsuarioModel u = null;
		query = session.createQuery(hql);
		query.setParameter("param1", login);
		query.setParameter("param2", senha);
		List<IUsuarioModel> lst = (List<IUsuarioModel>) query.list();
		if (lst.size() == 0) {
			return u = new UsuarioNull();
		}
		u = lst.get(0);
		return u;
	}

	public IUsuarioModel loginByNome(String login, String senha) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		String hql = "from Usuario where nome= :param1 and senha= :param2";
		IUsuarioModel u = null;
		query = session.createQuery(hql);
		query.setParameter("param1", login);
		query.setParameter("param2", senha);
		List<IUsuarioModel> lst = (List<IUsuarioModel>) query.list();
		if (lst.size() == 0) {
			return u = new UsuarioNull();
		}
		u = lst.get(0);
		return u;
	}

	public List<IUsuarioModel> findByPermision() throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("from Usuario where permissao= :param1");
		query.setParameter("param1", TypePermissao.USUARIO);
		List<IUsuarioModel> lst = (List<IUsuarioModel>) query.list();
		if (lst.size() == 0) {
			IUsuarioModel nulo = new UsuarioNull();
			lst.add(nulo);
			return lst;
		}
		return lst;
	}

	public String findPasswordByEmail(String email) {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createSQLQuery("select senha from usuario where email= :param1");
		query.setParameter("param1", email);
		List<String> senha = (List<String>) query.list();
		if (senha.size() == 0) {
			return "-1";
		} else {
			return senha.get(0);
		}
	}

	public boolean usuarioExiste(String email) {
		String vl = findPasswordByEmail(email);
		if (vl.equalsIgnoreCase("-1"))
			return false;

		return true;

	}

}
