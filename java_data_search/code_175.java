package comcoreym.routingpractice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pumpkins")
public class MainController {
	
	@GetMapping("")
	public String hello() {
		return "Hello World";
	}
	
		@GetMapping("/search")
	public String search(@RequestParam(value="name") String name) {
		return "You searched for " + name; 
	}
	
		@GetMapping("/{commonName}/{favAnimal}/{favMedia}/{favFood}")
	public String myFavorites(
			@PathVariable(value="commonName") String name,
			@PathVariable String favAnimal,
			@PathVariable String favMedia,
			@PathVariable String favFood
			) {
		return String.format("Hi! My name is %s. I love %s. My favorite thing to watch after settling down for the night is %s with a nice plate of %s", name, favAnimal, favMedia, favFood);
	}

}