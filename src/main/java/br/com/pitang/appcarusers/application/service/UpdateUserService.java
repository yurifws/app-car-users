package br.com.pitang.appcarusers.application.service;

import org.springframework.stereotype.Component;

import br.com.pitang.appcarusers.application.domain.users.User;
import br.com.pitang.appcarusers.application.ports.in.UpdateUserUseCase;
import br.com.pitang.appcarusers.application.ports.in.ValidateUserUseCase;
import br.com.pitang.appcarusers.application.ports.out.UpdateUserPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class UpdateUserService implements UpdateUserUseCase {

	private final UpdateUserPort port;
	private final ValidateUserUseCase validateUserUseCase;
	
	@Override
	public User update(User user, Long id) {
		validateUserUseCase.existsByEmail(user.getEmail());
		validateUserUseCase.existsByLogin(user.getLogin());
		return port.update(user, id);
	}

}
