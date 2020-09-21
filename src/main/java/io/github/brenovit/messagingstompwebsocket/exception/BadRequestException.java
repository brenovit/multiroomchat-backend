package io.github.brenovit.messagingstompwebsocket.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -969155623187726840L;

	public BadRequestException(String message) {
        super(message);
    }
}
