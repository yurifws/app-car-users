package br.com.pitang.appcarusers.common.exception;

public class LicensePlateAlreadyExistsException extends BusinessException {

	private static final long serialVersionUID = -3724503239739790655L;

	public LicensePlateAlreadyExistsException(String message){
		super(message);
	}
}
