package mason.patriotmaps.controller;

import java.util.concurrent.atomic.AtomicLong;

import mason.patriotmaps.Greeting;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GreetingController {
//we will need to use response body in order to have functions return something in JSON format.
//we will also need to have the homepage lead to the login page if the user is not logged in

	/**
	 * once the website maps to this url
	 * the user will be prompted with a login page
	 * @return random message
	 */
	@GetMapping("/login")
	public String login(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication == null || authentication instanceof AnonymousAuthenticationToken) return "login";
		return "redirect:/";
	}
}
