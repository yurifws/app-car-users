package br.com.pitang.appcarusers.common.exception;

public class UnauthorizedInvalidSessionException extends RuntimeException {

	private static final long serialVersionUID = 810998627579402324L;
	public UnauthorizedInvalidSessionException(String message){
		super(message);
	}
}
