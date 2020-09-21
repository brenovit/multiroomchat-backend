package io.github.brenovit.messagingstompwebsocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication
public class MultiroomchatStompWebsocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiroomchatStompWebsocketApplication.class, args);
	}
}
