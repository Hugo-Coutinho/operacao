package persistence;

import java.util.List;

import entity.Usuario;

public class UsuarioDao extends GenericDao<Usuario, Integer> {

	public UsuarioDao() {

		super(new Usuario());

	}

	public Usuario login(String login, Integer senha) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		String hql = "from Usuario where email= :param1 and senha= :param2";
		Usuario u = null;
		query = session.createQuery(hql);
		query.setParameter("param1", login);
		query.setParameter("param2", senha);
		List<Usuario> lst = (List<Usuario>) query.list();
		if (lst.size() == 0) {
			return u = null;
		}
		u = (Usuario) lst.get(0);
		return u;
	}

	public List<Usuario> findByPermision() throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("from Usuario where permissao= :param1");
		query.setParameter("param1", "Usuario");
		List<Usuario> lst = (List<Usuario>) query.list();
		return lst;
	}


}
