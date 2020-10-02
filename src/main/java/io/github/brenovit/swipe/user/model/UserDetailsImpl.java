package io.github.brenovit.swipe.user.model;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDetailsImpl(final User user) {
        //super(user);
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {

        return null;
    }
}
