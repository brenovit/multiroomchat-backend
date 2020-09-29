package io.github.brenovit.swipe.exception;


public class UsernameAlreadyExistsException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4889360158665478594L;

	public UsernameAlreadyExistsException(String message) {
        super(message);
    }
}
