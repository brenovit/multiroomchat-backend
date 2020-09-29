package io.github.brenovit.swipe.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.github.brenovit.swipe.user.model.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {

        return userService
                .findByUsername(username)
                .map(UserDetailsImpl::new)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }
}
