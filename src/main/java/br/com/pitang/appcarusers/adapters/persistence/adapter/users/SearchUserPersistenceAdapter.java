package br.com.pitang.appcarusers.adapters.persistence.adapter.users;

import static br.com.pitang.appcarusers.adapters.persistence.adapter.users.mapper.UserPersistenceMapper.INSTANCE;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.pitang.appcarusers.adapters.persistence.entity.UserEntity;
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
	public Optional<User> searchById(Long id) {
		Optional<UserEntity> optionalUserEntity = service.findById(id);
		if(optionalUserEntity.isPresent()) {
			return Optional.of(INSTANCE.toUser(optionalUserEntity.get()));
		}
		return Optional.empty();
	}
	
}
