package mx.org.example.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mx.org.example.dao.UsuarioDao;
import mx.org.example.entity.Usuario;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {
	@Autowired
	public SessionFactory sessionFactory;
	
	private Session getSession() {
	  return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> paginate(Integer page, Integer limit, String search) {
		String sqlQueryTotal = "SELECT COUNT(t) FROM Usuario t WHERE "
				+ "t.nickName LIKE CONCAT('%', :search, '%') OR"
				+ "t.nombre LIKE CONCAT('%', :search, '%') OR " 
				+ "t.apellidoPaterno LIKE CONCAT('%', :search, '%') OR"
				+ "t.email LIKE CONCAT('%', :search, '%')";
		
		Query queryTotal = getSession()
				.createQuery(sqlQueryTotal)
	    		.setString("search", search);
		
		Long total = (long) queryTotal.uniqueResult();	
		Integer pages = (int) Math.ceil((double) total / limit);
		
		String sqlQueryItems =  "SELECT t FROM Usuario t WHERE "
				+ "t.nickName LIKE CONCAT('%', :search, '%') OR"
				+ "t.nombre LIKE CONCAT('%', :search, '%') OR " 
				+ "t.apellidoPaterno LIKE CONCAT('%', :search, '%') OR"
				+ "t.email LIKE CONCAT('%', :search, '%')";
		
		
	    Query queryItems = getSession()
	    		.createQuery(sqlQueryItems)
	    		.setString("search", search)
	    		.setFirstResult((page - 1) * limit)
	    		.setMaxResults(limit);	  
	    List<Usuario> items = queryItems.list();
	    
	    
	    Map<String, Object> paginateResult = new HashMap<>();
	    paginateResult.put("page", page);
	    paginateResult.put("total", total);
	    paginateResult.put("pages", pages);
	    paginateResult.put("items", items);
		return paginateResult;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Usuario> getAll() {
		String sqlQuery = "SELECT t FROM Usuario t";
	    Query query = getSession().createQuery(sqlQuery);
		return  query.list();
	}

	@Override
	public Usuario findById(Long idUsuario) {
		String sqlQuery = "SELECT t FROM Usuario t WHERE t.idUsuario = :idUsuario";
	    Query query = getSession().createQuery(sqlQuery).setParameter("idUsuario", idUsuario);
		return (Usuario) query.uniqueResult();
	}

	@Override
	public Usuario findByEmail(String correo) {
		String sqlQuery = "SELECT t FROM Usuario t WHERE t.correo = :correo";
	    Query query = getSession().createQuery(sqlQuery).setParameter("correo", correo);
		return (Usuario) query.uniqueResult();
	}

	@Override
	public Usuario create(Usuario usuario) {
		getSession().save(usuario);
		return usuario;
	}

	@Override
	public Usuario update(Usuario usuario) {
		getSession().merge(usuario);
		return usuario;
	}

	@Override
	public Usuario delete(Long idUsuario) {
		Usuario usuarioFinded = this.findById(idUsuario);
		Usuario usuarioDeleted = (Usuario) getSession().load(Usuario.class, idUsuario);
		if(null != usuarioDeleted){
			getSession().delete(usuarioDeleted);
		}
		return usuarioFinded;
	}

	@Override
	public boolean exists(Long idUsuario) {
		Usuario usuarioFinded = this.findById(idUsuario);
		return usuarioFinded != null;
	}

}
