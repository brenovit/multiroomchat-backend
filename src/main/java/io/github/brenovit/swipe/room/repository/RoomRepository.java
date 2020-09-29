package io.github.brenovit.swipe.room.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.brenovit.swipe.room.model.Room;

public interface RoomRepository extends MongoRepository<Room, String>{
    Optional<Room> findBySenderIdAndRecipientId(String senderId, String recipientId);

}
