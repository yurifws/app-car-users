package br.com.pitang.appcarusers.common.exception;

public class UserNotFoundException extends EntityNotFoundException {


	private static final String ERROR_MESSAGE = "Not found user with id %s";

	private static final long serialVersionUID = 1291979315749103436L;

	public UserNotFoundException(String message){
		super(message);
	}
	
	public UserNotFoundException(Long userId) {
		this(String.format(ERROR_MESSAGE, userId));
	}
}
