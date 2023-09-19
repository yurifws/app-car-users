package br.com.pitang.appcarusers.adapters.persistence.adapter.users;

import static br.com.pitang.appcarusers.adapters.persistence.adapter.users.mapper.UserPersistenceMapper.INSTANCE;

import org.springframework.stereotype.Component;

import br.com.pitang.appcarusers.adapters.persistence.service.users.IUserService;
import br.com.pitang.appcarusers.application.domain.users.User;
import br.com.pitang.appcarusers.application.ports.out.RegisterUserPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class RegisterUserPersistenceAdapter implements RegisterUserPort {
	
	private final IUserService service;

	@Override
	public User register(User user) {
		return INSTANCE.toUser(service.save(INSTANCE.toUserEntity(user)));
	}

}
