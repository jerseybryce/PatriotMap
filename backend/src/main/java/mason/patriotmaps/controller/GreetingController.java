package mason.patriotmaps.controller;

import java.util.concurrent.atomic.AtomicLong;

import mason.patriotmaps.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	/**
	 * once the website maps to this url
	 * the user will be prompted with a login page
	 * @return random message
	 */
	@GetMapping("/login")
	public String login(){
		return "login";
	}
}
