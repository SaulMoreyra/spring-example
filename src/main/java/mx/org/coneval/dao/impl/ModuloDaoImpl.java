package mx.org.coneval.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mx.org.coneval.dao.ModuloDao;
import mx.org.coneval.entity.Modulo;

@Repository
public class ModuloDaoImpl implements ModuloDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	private Session getSession() {
	  return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> paginate(Integer page, Integer limit, String search) {
		

		String sqlQueryTotal = "SELECT COUNT(t) FROM Modulo t WHERE t.nombreModulo LIKE CONCAT('%', :search, '%')";
		Query queryTotal = getSession()
				.createQuery(sqlQueryTotal)
	    		.setString("search", search);
		
		Long total = (long) queryTotal.uniqueResult();	
		Integer pages = (int) Math.round((double) total / limit);
		
		String sqlQueryItems = "SELECT t FROM Modulo t WHERE t.nombreModulo LIKE CONCAT('%', :search, '%')";
	    Query queryItems = getSession()
	    		.createQuery(sqlQueryItems)
	    		.setString("search", search)
	    		.setFirstResult((page - 1) * limit)
	    		.setMaxResults(limit);	  
	    List<Modulo> items = queryItems.list();
	    
	    
	    Map<String, Object> paginateResult = new HashMap<>();
	    paginateResult.put("page", page);
	    paginateResult.put("total", total);
	    paginateResult.put("pages", pages);
	    paginateResult.put("items", items);
		return paginateResult;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Modulo> getAll() {
		String sqlQuery = "SELECT t FROM Modulo t";
	    Query query = getSession().createQuery(sqlQuery);
		return query.list();
	}


	@Override
	public Modulo findByName(String nombre) {
		String sqlQuery = "SELECT t FROM Modulo t WHERE t.nombreModulo t LIKE CONCAT('%', :search, '%')";
	    Query query = getSession().createQuery(sqlQuery);
	    query.setParameter("nombre", nombre);
		return (Modulo) query.uniqueResult();
	}

	@Override
	public Modulo findById(Long idModulo) {
		String sqlQuery = "SELECT t FROM Modulo t WHERE t.idModulo = :idModulo";
	    Query query = getSession().createQuery(sqlQuery).setParameter("idModulo", idModulo);
		return  (Modulo) query.uniqueResult();
	}

	@Override
	public Modulo create(Modulo modulo) {
		getSession().save(modulo);
		return modulo;
	}

	@Override
	public Modulo update(Modulo modulo) {
		getSession().merge(modulo);
		return modulo;
	}
	
	@Override
	public Modulo delete(Long idModulo) {
		Modulo moduloFinded = this.findById(idModulo);
		Modulo moduloDeleted = (Modulo) getSession().load(Modulo.class, idModulo);
		if(null != moduloDeleted){
			getSession().delete(moduloDeleted);
		}
		return moduloFinded;
	}
	
	@Override
	public boolean exists(Long idModulo) {
		Modulo moduloFinded = this.findById(idModulo);
		return moduloFinded != null;
	}
}
