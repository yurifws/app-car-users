package br.com.pitang.appcarusers.application.ports.out;

import br.com.pitang.appcarusers.application.domain.users.User;

public interface RegisterUserPort {
	
	User register(User user);

}
