package br.com.pitang.appcarusers.application.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.pitang.appcarusers.application.domain.users.User;
import br.com.pitang.appcarusers.application.ports.in.SearchUserUseCase;
import br.com.pitang.appcarusers.application.ports.out.SearchUserPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class SearchUserService implements SearchUserUseCase {

	private final SearchUserPort port;
	
	@Override
	public List<User> searchAll() {
		return port.searchAll();
	}

	@Override
	public User searchById(Long id) {
		return port.searchById(id);
	}

}
