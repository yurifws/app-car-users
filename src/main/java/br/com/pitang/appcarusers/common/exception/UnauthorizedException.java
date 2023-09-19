package br.com.pitang.appcarusers.common.exception;

public class UnauthorizedException extends RuntimeException {

	private static final long serialVersionUID = -8702144775940973865L;

	public UnauthorizedException(String message){
		super(message);
	}
}
