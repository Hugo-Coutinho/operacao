package persistence;

import java.io.Serializable;
import java.util.List;

public interface IDao<E,ID extends Serializable> {
	
	void create(E obj)throws Exception;
	void update(E obj)throws Exception;
	void delete(E obj)throws Exception;
	List<E>findAll()throws Exception;
	E findByCode(ID cod)throws Exception;
	
}
