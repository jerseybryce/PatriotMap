package mason.patriotmaps.controller;

import mason.patriotmaps.model.User;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GreetingController {
//we will need to use response body in order to have functions return something in JSON format.
//user will need to create account before actually using the app


	@GetMapping("/")
	public String noRouting(){
		return "redirect:/homepage";
	}
	@GetMapping("/homepage")
	public String homePage(){
		return "index";
	}

	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	@GetMapping("/registration")
	public String userRegistration(final User userData, final BindingResult bindingResult, final Model model){
		return "signup";
	}
}
