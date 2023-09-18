package br.com.pitang.appcarusers.common.exception;

public class LoginAlreadyExistsException extends BusinessException {

	private static final long serialVersionUID = -6535871581952842695L;

	public LoginAlreadyExistsException(String message){
		super(message);
	}
}
