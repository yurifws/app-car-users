package br.com.pitang.appcarusers.application.service;

import org.springframework.stereotype.Component;

import br.com.pitang.appcarusers.application.domain.users.User;
import br.com.pitang.appcarusers.application.ports.in.RegisterUserUseCase;
import br.com.pitang.appcarusers.application.ports.out.RegisterUserPort;
import br.com.pitang.appcarusers.common.exception.EmailAlreadyExistsException;
import br.com.pitang.appcarusers.common.exception.LoginAlreadyExistsException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class RegisterUserService implements RegisterUserUseCase {

	private final RegisterUserPort port;
	private final SearchUserService searchUserService;
	
	@Override
	public User register(User user) {
		if(searchUserService.existsByEmail(user.getEmail())) {
			throw new EmailAlreadyExistsException("Email already exists");
		}
		if(searchUserService.existsByLogin(user.getLogin())) {
			throw new LoginAlreadyExistsException("Login already exists");
		}
		
		return port.register(user);
	}

}
