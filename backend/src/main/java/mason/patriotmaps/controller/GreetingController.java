package mason.patriotmaps.controller;

import mason.patriotmaps.entity.UserEntity;
import mason.patriotmaps.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class GreetingController {
//we will need to use response body in order to have functions return something in JSON format.
//user will need to create account before actually using the app
	@Autowired
	UserRepository repo;
	ModelAndView mav;
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
	@GetMapping("/login/registration")
	public String showRegistrationForm(WebRequest request, Model model) {
		model.addAttribute("user", new UserEntity());
		return "signup";
	}

	@GetMapping("/test")
	public String test(){ return "";
	}

	@PostMapping("/login/registration")
	public String processRegister(@ModelAttribute UserEntity user){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		repo.save(user);
		return "redirect:/login";
	}
}
