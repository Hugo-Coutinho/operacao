package persistence;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ctrlPattern.UsuarioNull;
import entity.Usuario;

abstract public class GenericDao<E, ID extends Serializable> implements IDao<E, ID> {

	Session session;
	Transaction transaction;
	Query query;
	Criteria criteria;

	E classe;

	public GenericDao(E classe) {
		this.classe = classe;
	}

	@Override
	public void create(E obj) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(obj);
		transaction.commit();
		session.close();
	}

	@Override
	public void update(E obj) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(obj);
		transaction.commit();
		session.close();

	}

	@Override
	public void delete(E obj) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(obj);
		transaction.commit();
		session.close();

	}

	@Override
	public List<E> findAll() throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		criteria = session.createCriteria(classe.getClass());
		List<E> lista = (List<E>) criteria.list();
		session.close();
		return lista;
	}

	@Override
	public E findByCode(ID cod) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		E obj = (E) session.get(classe.getClass(), cod);
		session.close();
		if(obj == null && classe instanceof Usuario) {
			obj = (E) new UsuarioNull();
			return obj;
		}
		return obj;
	}
}
