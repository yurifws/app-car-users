package br.com.pitang.appcarusers.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
		Optional<User> optionalUser = port.searchById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		return null;
	}
	
	@Override
	public User searchByLoggedUser() {
		return port.searchByLogin(((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
	}

}
