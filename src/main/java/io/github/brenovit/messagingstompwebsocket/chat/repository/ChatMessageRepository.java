package io.github.brenovit.messagingstompwebsocket.chat.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.brenovit.messagingstompwebsocket.chat.model.ChatMessage;
import io.github.brenovit.messagingstompwebsocket.chat.model.MessageStatus;

public interface ChatMessageRepository
        extends MongoRepository<ChatMessage, String> {

    long countBySenderIdAndRecipientIdAndStatus(
            String senderId, String recipientId, MessageStatus status);

    List<ChatMessage> findByChatId(String chatId);
}