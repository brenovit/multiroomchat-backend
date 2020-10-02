package io.github.brenovit.swipe.chat.config;

import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebSocketHandler extends AbstractWebSocketHandler{

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {		
		log.info("New Text Message received");
		super.handleTextMessage(session, message);
		session.sendMessage(message);
	}

	@Override
	protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
		log.info("New Binary Message received");
		super.handleBinaryMessage(session, message);
		session.sendMessage(message);
	}
	
}
