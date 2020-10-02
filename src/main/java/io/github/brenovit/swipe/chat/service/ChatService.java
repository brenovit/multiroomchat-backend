package io.github.brenovit.swipe.chat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import io.github.brenovit.swipe.chat.model.ChatMessage;
import io.github.brenovit.swipe.chat.model.ChatNotification;
import io.github.brenovit.swipe.chat.model.MessageStatus;
import io.github.brenovit.swipe.chat.repository.ChatMessageRepository;
import io.github.brenovit.swipe.exception.ResourceNotFoundException;
import io.github.brenovit.swipe.room.service.RoomService;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ChatService {

	@Autowired
	private ChatMessageRepository repository;
	@Autowired
	private RoomService chatRoomService;
	@Autowired
	private MongoOperations mongoOperations;

	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	public ChatMessage save(ChatMessage chatMessage) {
		chatMessage.setStatus(MessageStatus.RECEIVED);
		repository.save(chatMessage);
		return chatMessage;
	}

	public long countNewMessages(String senderId, String recipientId) {
		return repository.countBySenderIdAndRecipientIdAndStatus(senderId, recipientId, MessageStatus.RECEIVED);
	}

	public List<ChatMessage> findChatMessages(String senderId, String recipientId) {
		var chatId = chatRoomService.getChatId(senderId, recipientId, false);

		var messages = chatId.map(cId -> repository.findByChatId(cId)).orElse(new ArrayList<>());

		if (messages.size() > 0) {
			updateStatuses(senderId, recipientId, MessageStatus.DELIVERED);
		}

		return messages;
	}

	public ChatMessage findById(String id) {
		return repository.findById(id).map(chatMessage -> {
			chatMessage.setStatus(MessageStatus.DELIVERED);
			return repository.save(chatMessage);
		}).orElseThrow(() -> new ResourceNotFoundException("can't find message (" + id + ")"));
	}

	public void updateStatuses(String senderId, String recipientId, MessageStatus status) {
		Query query = new Query(Criteria.where("senderId").is(senderId).and("recipientId").is(recipientId));
		Update update = Update.update("status", status);
		mongoOperations.updateMulti(query, update, ChatMessage.class);
	}

	public void processMessage(ChatMessage chatMessage) {
		log.info("Received: "+chatMessage.toString());
		//var chatId = chatRoomService.getChatId(chatMessage.getSenderId(), chatMessage.getRecipientId(), true);
		//chatMessage.setChatId(chatId.get());

		ChatMessage saved = save(chatMessage);
//		messagingTemplate.convertAndSendToUser(chatMessage.getRecipientId(), "/queue/messages",
//				new ChatNotification(saved.getId(), saved.getSenderId(), saved.getSenderName()));
		chatMessage.setCount(chatMessage.getCount() +1);
		messagingTemplate.convertAndSend("/topic/chat", chatMessage);
		messagingTemplate.convertAndSend("/topic/notification", chatMessage.getCount());
		//this.template.convertAndSend(TOPIC_URI + chatName, message);

	}
}
