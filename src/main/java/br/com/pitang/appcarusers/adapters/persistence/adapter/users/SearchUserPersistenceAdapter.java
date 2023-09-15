package br.com.pitang.appcarusers.adapters.persistence.adapter.users;

import static br.com.pitang.appcarusers.adapters.persistence.adapter.users.mapper.UserPersistenceMapper.INSTANCE;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.pitang.appcarusers.adapters.persistence.service.users.UserService;
import br.com.pitang.appcarusers.application.domain.users.User;
import br.com.pitang.appcarusers.application.ports.out.SearchUserPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class SearchUserPersistenceAdapter implements SearchUserPort {

	private final UserService service;
	
	@Override
	public List<User> searchAll() {
		return INSTANCE.toUsers(service.findAll());
	}

	@Override
	public User searchById(Long id) {
		return INSTANCE.toUser(service.findById(id).orElse(null));
	}

}
