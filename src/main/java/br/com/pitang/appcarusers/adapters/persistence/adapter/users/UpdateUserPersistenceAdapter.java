package br.com.pitang.appcarusers.adapters.persistence.adapter.users;

import static br.com.pitang.appcarusers.adapters.persistence.adapter.users.mapper.UserPersistenceMapper.INSTANCE;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.pitang.appcarusers.adapters.persistence.entity.UserEntity;
import br.com.pitang.appcarusers.adapters.persistence.service.users.UserService;
import br.com.pitang.appcarusers.application.domain.users.User;
import br.com.pitang.appcarusers.application.ports.out.UpdateUserPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class UpdateUserPersistenceAdapter implements UpdateUserPort {

	private final UserService service;
		
	@Override
	public User update(User user, Long id) {
		Optional<UserEntity> optionalUser = service.findById(id);
		if(optionalUser.isPresent()) {
			UserEntity userEntity = optionalUser.get();
			INSTANCE.update(userEntity, user);
			return INSTANCE.toUser(service.save(userEntity));
		}
		return null;
	}
	
}
