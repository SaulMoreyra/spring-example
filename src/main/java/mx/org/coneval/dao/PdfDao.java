package mx.org.coneval.dao;

import java.util.List;
import java.util.Map;

import mx.org.coneval.entity.Pdf;

public interface PdfDao {
	public Map<String, Object> paginate(Integer page, Integer limit, String search);
	public List<Pdf> getAll();
	public Pdf findById(Long idPdf);
	public Pdf findByName(String nombre);
	public Pdf create(Pdf pdf);
	public Pdf update(Pdf pdf);
	public Pdf delete(Long idPdf);
	public boolean exists(Long idPdf);
}
