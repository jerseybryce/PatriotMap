package mason.patriotmaps.controller;

import mason.patriotmaps.entity.ClassEntity;
import mason.patriotmaps.entity.UserEntity;
import mason.patriotmaps.entity.NewsEntity;
import mason.patriotmaps.repository.UserRepository;
import mason.patriotmaps.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

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

	@RequestMapping("/login")
	public String login(){
		return "login";
	}

	@RequestMapping("/news")
	public String news(){
		return "news";
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

	@GetMapping("/manageSchedule")
	public String manageSchedule(){
		return "patriotSchedule";
	}

	@GetMapping("/addClass")
	public String addClass(){
		return "addClass";
	}

	@GetMapping("/editClass")
	public String editClass(){
		return "editClass";
	}

	@GetMapping("/deleteClass")
	public String deleteClass(){
		return "deleteClass";
	}

    @Autowired
    NewsRepository newsRepo;

    @GetMapping("/news/stories")
    @ResponseBody
    public List<NewsEntity> stories() {
        updateNews();
        List<NewsEntity> stories = newsRepo.findAll();
        return stories;
    }

	@GetMapping("/userAccount")
	public String userAccount(){ return "userAccount"; }

    public void updateNews() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date dbDate = sdf.parse(newsRepo.getLastUpdated());
            Date current = new Date();

            long diffInMillies = Math.abs(current.getTime() - dbDate.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

            if (diff >= 1) {
                try {
                    Document doc = Jsoup.connect("https://www.gmu.edu/news/latest-news").get();
                    List<NewsEntity> stories = doc.select(".news-item").stream()
                        .map(e -> {
                            String publ = e.selectFirst(".news-list-date").text(); 
                            String title = e.selectFirst(".news-list-title").text();
                            String summary = e.selectFirst(".news-list-summary").text();
                            String link = "https://www.gmu.edu" + e.selectFirst("a").attr("href");
                            return new NewsEntity(publ, title, summary, link);
                        })
                        .collect(Collectors.toList());
                    newsRepo.clear();
                    newsRepo.saveAll(stories);
                    // newsRepo.updateDay(sdf.format(current));
                } catch (IOException e) {
                    return;
                }
            }
        } catch(ParseException e) {}
    }
}
