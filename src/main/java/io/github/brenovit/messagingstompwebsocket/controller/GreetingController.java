package io.github.brenovit.messagingstompwebsocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import io.github.brenovit.messagingstompwebsocket.payload.Greeting;
import io.github.brenovit.messagingstompwebsocket.payload.HelloMessage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class GreetingController {
	
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws InterruptedException {
		log.info("Received message: "+message.toString());
		Thread.sleep(500);
		return new Greeting("Hello "+HtmlUtils.htmlEscape(message.getName())+"!");
	}
	
}
