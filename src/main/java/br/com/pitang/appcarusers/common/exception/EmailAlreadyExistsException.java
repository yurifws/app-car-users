package br.com.pitang.appcarusers.common.exception;

public class EmailAlreadyExistsException extends BusinessException {

	private static final long serialVersionUID = -5490870689818423785L;

	public EmailAlreadyExistsException(String message){
		super(message);
	}
}
