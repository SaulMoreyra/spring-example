package mx.org.coneval.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import mx.org.coneval.entity.Pdf;
import mx.org.coneval.service.PdfService;


@Controller
public class PdfController {
	
	@Autowired
	private PdfService pdfService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/pdfs", method = RequestMethod.GET)
	public ModelAndView getAll(
			@RequestParam(value = "search", required = false, defaultValue="") String search,
			@RequestParam(value = "page", required = false, defaultValue="1") int page,
			@RequestParam(value = "limit", required = false, defaultValue="10") int limit
		) 
	{
		ModelAndView model = new ModelAndView("admin/pdfs/allpdfs");
		try {		
			// PREVENT NEGATIVE VALUES
			if(page < 1) page = 1;
			if(limit < 1) limit = 1;
			
			Map<String, Object> pdfs = pdfService.paginate(page, limit, search);
			Long total = (Long) pdfs.get("total");
			Integer pages = (int) pdfs.get("pages");
			List<Pdf> items = (List<Pdf>) pdfs.get("items");
			
			model.addObject("pdfs", items);
			model.addObject("pages", pages);
			model.addObject("total", total);
			model.addObject("page", page);
			model.addObject("search", search);
		} catch (Exception e) {
			model.addObject("error", true);
			model.addObject("message", "No se ha podido conectar a la base");
		}
		
		return model;
	}
}
