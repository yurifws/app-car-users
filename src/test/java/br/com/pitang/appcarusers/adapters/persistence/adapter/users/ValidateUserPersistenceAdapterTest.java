package br.com.pitang.appcarusers.adapters.persistence.adapter.users;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.pitang.appcarusers.adapters.persistence.service.users.IUserService;

@ExtendWith(SpringExtension.class)
class ValidateUserPersistenceAdapterTest {
	
	@InjectMocks
	private ValidateUserPersistenceAdapter adapter;

	@Mock
	private IUserService service;

	@Test
	void testExistsByEmail() {
		String email = "vilma.souza@teste.com";
		when(service.existsByEmail(email)).thenReturn(true);
		
		boolean response = adapter.existsByEmail(email);
		
		verify(service).existsByEmail(email);
		assertTrue(response);
	}
	
	@Test
	void testExistsByLogin() {
		String login = "silsou";
		when(service.existsByLogin(login)).thenReturn(true);
		
		boolean response = adapter.existsByLogin(login);

		verify(service).existsByLogin(login);
		assertTrue(response);
	}

}
