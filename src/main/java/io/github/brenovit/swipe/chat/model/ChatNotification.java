package io.github.brenovit.swipe.chat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatNotification {
	private String id;
	private String senderId;
	private String senderName;
}
