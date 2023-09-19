package br.com.pitang.appcarusers;

import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.pitang.appcarusers.adapters.auth.service.TokenService;
import br.com.pitang.appcarusers.adapters.persistence.service.users.IUserService;

public abstract class ContextBaseTests {
	
	@MockBean
	private TokenService tokenService;

	@MockBean
	private IUserService iUserService;

}
