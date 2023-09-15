package br.com.pitang.appcarusers.application.service;

import org.springframework.stereotype.Component;

import br.com.pitang.appcarusers.application.domain.users.User;
import br.com.pitang.appcarusers.application.ports.in.RegisterUserUseCase;
import br.com.pitang.appcarusers.application.ports.out.RegisterUserPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class RegisterUserService implements RegisterUserUseCase {

	private final RegisterUserPort port;
	
	@Override
	public User register(User user) {
		return port.register(user);
	}

}
