package io.github.brenovit.messagingstompwebsocket.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import io.github.brenovit.messagingstompwebsocket.chat.model.ChatMessage;
import io.github.brenovit.messagingstompwebsocket.chat.model.ChatNotification;

@Service
public class ChatService {
		
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;	
	@Autowired
	private ChatRoomService chatRoomService;
	
	public void processMessage(ChatMessage chatMessage) {
		var chatId = chatRoomService.getChatId(chatMessage.getSenderId(), chatMessage.getRecipientId(), true);
		chatMessage.setChatId(chatId);
		ChatMessage saved = chatMessageService.save(chatMessage);
		simpMessagingTemplate.convertAndSendToUser(
				chatMessage.getRecipientId(), 
				"/queue/messages", 
				new ChatNotification(saved.getId(), saved.getSenderId(), saved.getSenderName()));
	}
}
