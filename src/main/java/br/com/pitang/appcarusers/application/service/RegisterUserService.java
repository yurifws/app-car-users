package br.com.pitang.appcarusers.application.service;

import org.springframework.stereotype.Component;

import br.com.pitang.appcarusers.application.domain.users.User;
import br.com.pitang.appcarusers.application.ports.in.RegisterUserUseCase;
import br.com.pitang.appcarusers.application.ports.in.ValidateUserUseCase;
import br.com.pitang.appcarusers.application.ports.out.RegisterUserPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class RegisterUserService implements RegisterUserUseCase {

	private final RegisterUserPort port;
	private final ValidateUserUseCase validateUserUseCase;
	
	@Override
	public User register(User user) {
		validateUserUseCase.existsByEmail(user.getEmail());
		validateUserUseCase.existsByLogin(user.getLogin());
		return port.register(user);
	}

}
