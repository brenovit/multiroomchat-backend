package io.github.brenovit.messagingstompwebsocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.web.client.RestTemplate;

@EnableMongoAuditing
@SpringBootApplication
public class MultiroomchatStompWebsocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiroomchatStompWebsocketApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
