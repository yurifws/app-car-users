package br.com.pitang.appcarusers.application.service;

import org.springframework.stereotype.Component;

import br.com.pitang.appcarusers.application.ports.in.ValidateUserUseCase;
import br.com.pitang.appcarusers.application.ports.out.ValidateUserPort;
import br.com.pitang.appcarusers.common.exception.EmailAlreadyExistsException;
import br.com.pitang.appcarusers.common.exception.LoginAlreadyExistsException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ValidateUserService implements ValidateUserUseCase {

	private final ValidateUserPort port;
	
	@Override
	public void existsByEmail(String email) {
		if(port.existsByEmail(email)) {
			throw new EmailAlreadyExistsException("Email already exists");
		}
	}

	@Override
	public void existsByLogin(String login) {
		if(port.existsByLogin(login)) {
			throw new LoginAlreadyExistsException("Login already exists");
		}
	}

}
