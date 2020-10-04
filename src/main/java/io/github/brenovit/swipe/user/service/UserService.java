package io.github.brenovit.swipe.user.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.github.brenovit.swipe.auth.service.JwtTokenProvider;
import io.github.brenovit.swipe.exception.EmailAlreadyExistsException;
import io.github.brenovit.swipe.exception.UsernameAlreadyExistsException;
import io.github.brenovit.swipe.user.model.Role;
import io.github.brenovit.swipe.user.model.User;
import io.github.brenovit.swipe.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserService {
	
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;
	
	private AuthenticationManager authenticationManager;
	
	private JwtTokenProvider tokenProvider;

	public String loginUser(String username, String password) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		return tokenProvider.generateToken(authentication);
	}

	@SuppressWarnings("serial")
	public User registerUser(User user, Role role) {
		log.info("registering user {}", user.getUsername());

		if (userRepository.existsByUsername(user.getUsername())) {
			log.warn("username {} already exists.", user.getUsername());

			throw new UsernameAlreadyExistsException(String.format("username %s already exists", user.getUsername()));
		}

		if (userRepository.existsByEmail(user.getEmail())) {
			log.warn("email {} already exists.", user.getEmail());

			throw new EmailAlreadyExistsException(String.format("email %s already exists", user.getEmail()));
		}
		user.setActive(true);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRoles(new HashSet<>() {
			{
				add(role);
			}
		});

		return userRepository.save(user);
	}

	public List<User> findAll() {
		log.info("retrieving all users");
		return userRepository.findAll();
	}

	public Optional<User> findByUsername(String username) {
		log.info("retrieving user {}", username);
		return userRepository.findByUsername(username);
	}

	public Optional<User> findById(String id) {
		log.info("retrieving user {}", id);
		return userRepository.findById(id);
	}
}
