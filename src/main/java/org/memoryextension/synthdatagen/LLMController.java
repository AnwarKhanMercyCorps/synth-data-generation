package org.memoryextension.synthdatagen;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import java.util.List;

@RestController
@RequestMapping("/llm")
public class LLMController {

	@Autowired
	private LLMConfig config;

	@GetMapping("/")
	public ModelAndView index() {
		return new ModelAndView("todo"); // TODO: return a spa to debug the API
	}
	
	@GetMapping("/tgdebug")
	public List<TextGenerated> textGenerationDebug() {
		return textGeneration( new TextGenerator("Debug",config.getSeed(),config.getNbTokens(),config.getNbSequences()) );
	}

	@PostMapping("/tg")
	public List<TextGenerated> textGenerationSimple(@RequestBody String text) {
		return textGeneration( new TextGenerator(text,config.getSeed(),config.getNbTokens(),config.getNbSequences()) );
	}

	@PostMapping("/tgfull")
	public List<TextGenerated> textGeneration(@RequestBody TextGenerator tg) {

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<TextGenerated>> response = restTemplate.exchange(
								"http://192.168.27.32/textgeninference", 
								HttpMethod.POST,
								new HttpEntity<>(tg), 
								new ParameterizedTypeReference<List<TextGenerated>>(){});

		List<TextGenerated> result = response.getBody();
		return result;
	}
	
}
