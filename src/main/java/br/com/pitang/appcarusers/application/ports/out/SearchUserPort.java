package br.com.pitang.appcarusers.application.ports.out;

import java.util.List;

import br.com.pitang.appcarusers.application.domain.users.User;

public interface SearchUserPort {
	
	List<User> searchAll();
	User searchById(Long id);
	boolean existsByEmail(String email);
	boolean existsByLogin(String login);

}
