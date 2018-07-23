package persistence;

import java.util.List;

import ctrlPattern.IUsuarioModel;
import ctrlPattern.UsuarioNull;
import entity.Anotacao;
import entity.Usuario;

public class AnotacaoDao extends GenericDao<Anotacao, Integer> {

	public AnotacaoDao() {
		super(new Anotacao());
		// TODO Auto-generated constructor stub
	}

	public List<Anotacao> buscarListaAnotacaoPorUsuarioLogado(Integer logado) {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("from Anotacao where id_usuario= :param1");
		query.setParameter("param1", logado);
		List<Anotacao> notas = (List<Anotacao>) query.list();
		return notas;
	}
	
	public boolean verificaNomeAnotacaoJaExiste(String nome) {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createSQLQuery("select * from anotacao where nome= :param1");
		query.setParameter("param1", nome);
		List<Anotacao> notas = (List<Anotacao>) query.list();
		if(notas.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
	
	

}
