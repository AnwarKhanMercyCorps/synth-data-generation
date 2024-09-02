package org.memoryextension.synthdatagen;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ConfigService {
	
	@Bean(name = "llmCurrentConfig")
	public LLMConfig LLMConfigService(){
			return new LLMConfig();
	}
}
