package io.github.brenovit.messagingstompwebsocket.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import io.github.brenovit.messagingstompwebsocket.chat.model.ChatMessage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ChatController {
	
	@Autowired
	private ChatService chatService;
		
	@MessageMapping("/chat")
	@SendTo("/topic/greetings")
	public ChatMessage greeting(@Payload HelloMessage message) throws InterruptedException {
		log.info("Received message: "+message.toString());
		Thread.sleep(500);
		return new ChatMessage("Hello "+HtmlUtils.htmlEscape(message.getName())+"!");
	}
	
}
