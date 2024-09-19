package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication

public String callLlmApi(String input) {
    RestTemplate restTemplate = new RestTemplate();
    String response = restTemplate.postForObject(llmApiUrl + "/api/llm-endpoint", input, String.class);
    return response;
}

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
