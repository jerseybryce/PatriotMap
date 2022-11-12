package mason.patriotmaps.controller;

import mason.patriotmaps.entity.ClassEntity;
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
	@GetMapping("/")
	public String noRouting(){
		return "redirect:/homepage";
	}
	@GetMapping("/homepage")
	public String homePage(){
		return "index";
	}

	@GetMapping("/test")
	public String test(){
		return "test";
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

	//does not allow for repeated values
	@PostMapping("/login/registration")
	public String processRegister(@ModelAttribute UserEntity user){
		if(repo.findByUsername(user.getUsername()) != null) return "redirect:/login/registration";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		repo.save(user);
		return "redirect:/login";
	}

	@GetMapping("/homepage/ManageSchedule")
	public String manageSchedule(){
		return "hello";
	}

	@GetMapping("/addClass")
	public String addClass(){
		return "addClass";
	}
}
