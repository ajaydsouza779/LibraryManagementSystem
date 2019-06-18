package com.pgdca.lms.error;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Error {

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String showError(ModelMap model) {
		model.addAttribute("message", "You encountered an unexpexted error.");
		return "error";
	}
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView welcome() {
    	ModelAndView model = new ModelAndView();
    	model.setViewName("Welcome");
    	return model;
    }
}
