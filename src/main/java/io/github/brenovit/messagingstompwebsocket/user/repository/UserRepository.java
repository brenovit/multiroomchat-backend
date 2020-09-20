package io.github.brenovit.messagingstompwebsocket.user.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.brenovit.messagingstompwebsocket.user.model.User;

public interface UserRepository extends MongoRepository<User, String>{
	
	Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
