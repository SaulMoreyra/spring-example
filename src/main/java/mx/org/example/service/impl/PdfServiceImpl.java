package mx.org.example.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import mx.org.example.dao.PdfDao;
import mx.org.example.entity.Pdf;
import mx.org.example.pojos.FileStorage;
import mx.org.example.service.PdfService;

@Service
@Transactional
public class PdfServiceImpl implements PdfService {
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	private PdfDao pdfDao;

	@Override
	@Transactional
	public Map<String, Object> paginate(Integer page, Integer limit, String search) {
		return pdfDao.paginate(page, limit, search);
	}

	@Override
	@Transactional
	public List<Pdf> getAll() {
		return pdfDao.getAll();
	}

	@Override
	@Transactional
	public Pdf findById(Long idPdf) {
		Pdf pdfFinded = pdfDao.findById(idPdf);
		pdfFinded.createUrl();
		return pdfFinded;
	}

	@Override
	@Transactional
	public Pdf findByName(String nombre) {
		return pdfDao.findByName(nombre);
	}

	@Override
	@Transactional
	public Pdf create(Pdf pdf) {
		String basePath = servletContext.getRealPath("/") ;
		MultipartFile multipartFile = pdf.getFile();

		// RUTA PARA SVN 
		// FileStorage.getFilePath(basePath)
		
		String identifier = FileStorage
				.construct(multipartFile,basePath)
				.makeDestiny()
				.storage()
				.getIdentify();
		
		pdf.setUrlPdf(identifier);
		pdf.setFile(null);
		
		return pdfDao.create(pdf);
	}

	@Override
	@Transactional
	public Pdf update(Pdf pdf) {
		MultipartFile multipartFile = pdf.getFile();
		if(multipartFile != null) {
			String basePath = servletContext.getRealPath("/") ;
			FileStorage.delete(pdf.getUrlPdf(), basePath);
			String identifier = FileStorage.construct(multipartFile,basePath)
					.makeDestiny()
					.storage()
					.getIdentify();
			pdf.setFile(null);
			pdf.setUrlPdf(identifier);
		}
		return pdfDao.update(pdf);
	}

	@Override
	@Transactional
	public Pdf delete(Long idPdf) {
		return pdfDao.delete(idPdf);
	}	
	
	@Override
	@Transactional
	public boolean exists(Long idPdf) {
		return pdfDao.exists(idPdf);
	}
}
