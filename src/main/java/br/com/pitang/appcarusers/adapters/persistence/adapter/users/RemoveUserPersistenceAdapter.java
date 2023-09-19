package br.com.pitang.appcarusers.adapters.persistence.adapter.users;

import org.springframework.stereotype.Component;

import br.com.pitang.appcarusers.adapters.persistence.service.users.IUserService;
import br.com.pitang.appcarusers.application.ports.out.RemoveUserPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class RemoveUserPersistenceAdapter implements RemoveUserPort {

	private final IUserService service;
	
	@Override
	public void removeById(Long id) {
		service.removeById(id);
	}

}
