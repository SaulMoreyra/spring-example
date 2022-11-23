package mx.org.coneval.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mx.org.coneval.dao.PdfDao;
import mx.org.coneval.entity.Pdf;

@Repository
public class PdfDaoImpl implements PdfDao {
	  
	@Autowired
	public SessionFactory sessionFactory;
	
	private Session getSession() {
	  return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> paginate(Integer page, Integer limit, String search) {
		

		String sqlQueryTotal = "SELECT COUNT(t) FROM Pdf t WHERE t.nombrePdf LIKE CONCAT('%', :search, '%')";
		Query queryTotal = getSession()
				.createQuery(sqlQueryTotal)
	    		.setString("search", search);
		
		Long total = (long) queryTotal.uniqueResult();	
		Integer pages = (int) Math.ceil((double) total / limit);
		
		String sqlQueryItems = "SELECT t FROM Pdf t WHERE t.nombrePdf LIKE CONCAT('%', :search, '%')";
	    Query queryItems = getSession()
	    		.createQuery(sqlQueryItems)
	    		.setString("search", search)
	    		.setFirstResult((page - 1) * limit)
	    		.setMaxResults(limit);	  
	    List<Pdf> items = queryItems.list();
	    
	    
	    Map<String, Object> paginateResult = new HashMap<>();
	    paginateResult.put("page", page);
	    paginateResult.put("total", total);
	    paginateResult.put("pages", pages);
	    paginateResult.put("items", items);
		return paginateResult;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pdf> getAll() {
		String sqlQuery = "SELECT t FROM Pdf t";
	    Query query = getSession().createQuery(sqlQuery);
		return query.list();
	}


	@Override
	public Pdf findByName(String nombre) {
		String sqlQuery = "SELECT t FROM TC_PDFS WHERE NOMBRE_PDF t LIKE %:nombre%";
	    Query query = getSession().createQuery(sqlQuery);
	    query.setParameter("nombre", nombre);
		return (Pdf) query.uniqueResult();
	}

	@Override
	public Pdf findById(Long idPdf) {
		String sqlQuery = "SELECT t FROM Pdf t WHERE t.idPdf = :idPdf";
	    Query query = getSession().createQuery(sqlQuery).setParameter("idPdf", idPdf);
		return (Pdf) query.uniqueResult();
	}

	@Override
	public Pdf create(Pdf pdf) {
		getSession().save(pdf);
		return pdf;
	}

	@Override
	public Pdf update(Pdf pdf) {
		getSession().merge(pdf);
		return pdf;
	}
	
	@Override
	public Pdf delete(Long idPdf) {
		Pdf pdfFinded = this.findById(idPdf);
		Pdf pdfDeleted = (Pdf) getSession().load(Pdf.class, idPdf);
		if(null != pdfDeleted){
			getSession().delete(pdfDeleted);
		}
		return pdfFinded;
	}
	
	@Override
	public boolean exists(Long idPdf) {
		Pdf pdfFinded = this.findById(idPdf);
		return pdfFinded != null;
	}
	
}
