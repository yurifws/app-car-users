package br.com.pitang.appcarusers.common.exception;

public class BusinessException extends RuntimeException  {

	private static final long serialVersionUID = -1102429965366484723L;

	public BusinessException(String message){
		super(message);
	}
}
