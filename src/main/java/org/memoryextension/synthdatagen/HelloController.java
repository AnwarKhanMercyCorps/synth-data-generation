package org.memoryextension.synthdatagen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {

	@GetMapping("/")
	public String index() {
		return "hello";
	}

	@GetMapping("/about/")
	public String about() {
		return "about";
	}
}
