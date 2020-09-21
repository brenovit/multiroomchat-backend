package io.github.brenovit.messagingstompwebsocket.room.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.brenovit.messagingstompwebsocket.room.model.Room;

public interface RoomRepository extends MongoRepository<Room, String>{
    Optional<Room> findBySenderIdAndRecipientId(String senderId, String recipientId);

}
