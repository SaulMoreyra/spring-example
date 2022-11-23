package mx.org.coneval.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mx.org.coneval.constants.PDFsConstants;

@Controller
public class PDFSController {

	@RequestMapping(value = "/pdfs", method = RequestMethod.GET)
	public ModelAndView pdfs(@RequestParam(value = "search", required = false) String search) {
		ModelAndView model = new ModelAndView("pdfs");
		List<Map<String, Object>> pdfs = PDFsConstants.getPDFs();

		model.addObject("pdfs", pdfs);
		model.addObject("search", search);
		return model;
	}
}
