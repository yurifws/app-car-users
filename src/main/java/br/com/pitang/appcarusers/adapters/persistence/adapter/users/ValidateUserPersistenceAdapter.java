package br.com.pitang.appcarusers.adapters.persistence.adapter.users;

import org.springframework.stereotype.Component;

import br.com.pitang.appcarusers.adapters.persistence.service.users.IUserService;
import br.com.pitang.appcarusers.application.ports.out.ValidateUserPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ValidateUserPersistenceAdapter implements ValidateUserPort {

	private final IUserService service;
	
	@Override
	public boolean existsByEmail(String email) {
		return service.existsByEmail(email);
	}

	@Override
	public boolean existsByLogin(String login) {
		return service.existsByLogin(login);
	}

}
