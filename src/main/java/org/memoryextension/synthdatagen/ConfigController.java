package org.memoryextension.synthdatagen;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/llmconfig")
public class ConfigController {
	
	@Autowired
	private LLMConfig config;
	
	@GetMapping("/")
	public LLMConfig getConfig() {
		return config;
	}
	
	@PostMapping("/")
	public void setConfig(LLMConfig cfg) {
		config.SetConfig(cfg);
		
	}
}
