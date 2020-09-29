package io.github.brenovit.swipe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6023781557661396533L;

	public ResourceNotFoundException(String resource) {
        super(String.format("Resource %s not found", resource));
    }
}
