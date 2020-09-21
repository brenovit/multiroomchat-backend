package io.github.brenovit.messagingstompwebsocket.exception;


public class EmailAlreadyExistsException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3101606168310394877L;

	public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
