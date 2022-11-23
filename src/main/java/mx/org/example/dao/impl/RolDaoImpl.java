package mx.org.example.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mx.org.example.dao.RolDao;
import mx.org.example.entity.Rol;

@Repository
public class RolDaoImpl implements RolDao{
		
	@Autowired
	public SessionFactory sessionFactory;
	
	private Session getSession() {
	  return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> paginate(Integer page, Integer limit, String search) {
		

		String sqlQueryTotal = "SELECT COUNT(t) FROM Rol t WHERE t.nombreRol LIKE CONCAT('%', :search, '%')";
		Query queryTotal = getSession()
				.createQuery(sqlQueryTotal)
	    		.setString("search", search);
		
		Long total = (long) queryTotal.uniqueResult();	
		Integer pages = (int) Math.ceil((double) total / limit);
		
		String sqlQueryItems = "SELECT t FROM Rol t WHERE t.nombreRol LIKE CONCAT('%', :search, '%')";
	    Query queryItems = getSession()
	    		.createQuery(sqlQueryItems)
	    		.setString("search", search)
	    		.setFirstResult((page - 1) * limit)
	    		.setMaxResults(limit);	  
	    List<Rol> items = queryItems.list();
	    
	    
	    Map<String, Object> paginateResult = new HashMap<>();
	    paginateResult.put("page", page);
	    paginateResult.put("total", total);
	    paginateResult.put("pages", pages);
	    paginateResult.put("items", items);
		return paginateResult;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rol> getAll() {
		String sqlQuery = "SELECT t FROM Rol t";
	    Query query = getSession().createQuery(sqlQuery);
		return query.list();
	}


	@Override
	public Rol findByName(String nombre) {
		String sqlQuery = "SELECT t FROM Rol t WHERE t.nombreRol t LIKE CONCAT('%', :search, '%')";
	    Query query = getSession().createQuery(sqlQuery);
	    query.setParameter("nombre", nombre);
		return (Rol) query.uniqueResult();
	}

	@Override
	public Rol findById(Long idRol) {
		String sqlQuery = "SELECT t FROM Rol t WHERE t.idRol = :idRol";
	    Query query = getSession().createQuery(sqlQuery).setParameter("idRol", idRol);
		return  (Rol) query.uniqueResult();
	}

	@Override
	public Rol create(Rol rol) {
		getSession().save(rol);
		return rol;
	}

	@Override
	public Rol update(Rol rol) {
		getSession().merge(rol);
		return rol;
	}
	
	@Override
	public Rol delete(Long idRol) {
		Rol rolFinded = this.findById(idRol);
		Rol rolDeleted = (Rol) getSession().load(Rol.class, idRol);
		if(null != rolDeleted){
			getSession().delete(rolDeleted);
		}
		return rolFinded;
	}
	
	@Override
	public boolean exists(Long idRol) {
		Rol rolFinded = this.findById(idRol);
		return rolFinded != null;
	}
}
