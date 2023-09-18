package br.com.pitang.appcarusers.application.ports.out;

import java.util.List;
import java.util.Optional;

import br.com.pitang.appcarusers.application.domain.users.User;

public interface SearchUserPort {
	
	List<User> searchAll();
	Optional<User> searchById(Long id);
	boolean existsByEmail(String email);
	boolean existsByLogin(String login);

}
