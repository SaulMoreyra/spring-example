package mx.org.coneval.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mx.org.coneval.constants.EjecutivoConstants;
import mx.org.coneval.constants.LegislativoConstants;
import mx.org.coneval.constants.PDFsConstants;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/ejecutivo", method = RequestMethod.GET)
	public String ejecutivo(Locale locale, Model model) {
		Map<String, String> secretarias = EjecutivoConstants.getSecretarias();
		Map<String, String> estados = EjecutivoConstants.getEstados();
		model.addAttribute("secretarias", secretarias);
		model.addAttribute("estados", estados);
		return "ejecutivo";
	}
	
	@RequestMapping(value = "/legislativo", method = RequestMethod.GET)
	public String legislativo(Locale locale, Model model) {
		Map<String, String> options = LegislativoConstants.getOptions();
		Map<String, String> partidos = LegislativoConstants.getPartidos();
		model.addAttribute("options", options);
		model.addAttribute("partidos", partidos);
		return "legislativo";
	}
	
	@RequestMapping(value = "/organizaciones", method = RequestMethod.GET)
	public ModelAndView organizaciones() {
		return new ModelAndView("organizaciones");
	}
	
	@RequestMapping(value = "/pdfs", method = RequestMethod.GET)
	public ModelAndView pdfs(@RequestParam(value = "search", required = false) String search) {
		ModelAndView model = new ModelAndView("pdfs");
		List<Map<String, Object>> pdfs = PDFsConstants.getPDFs();

		if (search != null) {
			pdfs = pdfs.stream().filter((Map<String, Object> pdf) ->
			pdf.get("name").toString().toLowerCase()
			.contains(search.toLowerCase())).collect(Collectors.toList());
		}

		model.addObject("pdfs", pdfs);
		model.addObject("search", search);
		return model;
	}
	
	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	public ModelAndView roles() {
		return new ModelAndView("roles");
	}
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public ModelAndView usuarios() { 
		return new ModelAndView("usuarios");
	}
	
	@RequestMapping(value = "/accesos", method = RequestMethod.GET)
	public ModelAndView accesos() {
		return new ModelAndView("accesos");
	}
	
	
}
