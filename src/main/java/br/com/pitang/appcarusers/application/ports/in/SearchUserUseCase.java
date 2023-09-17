package br.com.pitang.appcarusers.application.ports.in;

import java.util.List;

import br.com.pitang.appcarusers.application.domain.users.User;

public interface SearchUserUseCase {

	List<User> searchAll();
	User searchById(Long id);

	boolean existsByEmail(String email);
	boolean existsByLogin(String login);
}
