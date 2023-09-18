package br.com.pitang.appcarusers.adapters.persistence.adapter.users;

import org.springframework.stereotype.Component;

import br.com.pitang.appcarusers.adapters.persistence.service.users.UserService;
import br.com.pitang.appcarusers.application.ports.out.RemoveUserPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class RemoveUserPersistenceAdapter implements RemoveUserPort {

	private final UserService service;
	
	@Override
	public void removeById(Long id) {
		service.removeById(id);
	}

}
