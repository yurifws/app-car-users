package br.com.pitang.appcarusers.common.exception;

public class EntityNotFoundException extends BusinessException {

	private static final long serialVersionUID = -5161429341113793655L;

	public EntityNotFoundException(String message){
		super(message);
	}
}
