package br.com.pitang.appcarusers.application.ports.in;

import br.com.pitang.appcarusers.application.domain.users.User;

public interface RegisterUserUseCase {
	
	User register(User user);

}
