package io.github.brenovit.swipe.chat.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.brenovit.swipe.chat.model.ChatMessage;
import io.github.brenovit.swipe.chat.service.ChatService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ChatController {
	
	private ChatService chatMessageService;

	@MessageMapping("/message")
	public void processMessage(@Payload ChatMessage chatMessage) {
		chatMessageService.processMessage(chatMessage);
	}

	@GetMapping("/messages/{senderId}/{recipientId}/count")
	public ResponseEntity<Long> countNewMessages(
			@PathVariable String senderId, 
			@PathVariable String recipientId) {
		return ResponseEntity.ok(chatMessageService.countNewMessages(senderId, recipientId));
	}

	@GetMapping("/messages/{senderId}/{recipientId}")
	public ResponseEntity<?> findChatMessages(
			@PathVariable String senderId, 
			@PathVariable String recipientId) {
		return ResponseEntity.ok(chatMessageService.findChatMessages(senderId, recipientId));
	}

	@GetMapping("/messages/{id}")
	public ResponseEntity<?> findMessage(
			@PathVariable String id) {
		return ResponseEntity.ok(chatMessageService.findById(id));
	}

}
