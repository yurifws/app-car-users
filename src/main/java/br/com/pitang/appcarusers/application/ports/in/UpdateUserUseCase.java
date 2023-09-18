package br.com.pitang.appcarusers.application.ports.in;

import br.com.pitang.appcarusers.application.domain.users.User;

public interface UpdateUserUseCase {
	
	User update(User user, Long id);
}
