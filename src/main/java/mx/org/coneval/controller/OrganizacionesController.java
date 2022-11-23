package mx.org.coneval.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrganizacionesController {

	@RequestMapping(value = "/organizaciones", method = RequestMethod.GET)
	public ModelAndView organizaciones() {
		return new ModelAndView("organizaciones");
	}
}