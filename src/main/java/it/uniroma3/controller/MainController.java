package it.uniroma3.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {
	
		@GetMapping("/loginok")
		public String loginok(){
			return "loginOk";
		}
		
		@GetMapping("/logoutok")
		public String logoutok(){
			return "logoutOk";
		}


		// Login form with error
		@GetMapping("/error")
		public String loginError(Model model) {
			model.addAttribute("loginError", true);
			return "login";
		}
		
		
		// for 403 access denied page
		@RequestMapping(value = "/403", method = RequestMethod.GET)
		public ModelAndView accesssDenied(Principal user) {

			ModelAndView model = new ModelAndView();

			if (user != null) {
				model.addObject("msg", "Ciao " + user.getName()
				+ ", non hai il permesso per accedere a questa pagina!");
			} else {
				model.addObject("msg",
				"Non hai il permesso per accedere a questa pagina!");
			}

			model.setViewName("403");
			return model;

		}
}
