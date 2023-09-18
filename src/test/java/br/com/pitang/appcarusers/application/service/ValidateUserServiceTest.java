package br.com.pitang.appcarusers.application.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.pitang.appcarusers.application.ports.out.ValidateUserPort;
import br.com.pitang.appcarusers.common.exception.EmailAlreadyExistsException;
import br.com.pitang.appcarusers.common.exception.LoginAlreadyExistsException;

@ExtendWith(SpringExtension.class)
class ValidateUserServiceTest {
	
	@InjectMocks
	private ValidateUserService service;
	
	@Mock
	private ValidateUserPort port;

	@Test
	void testExistsByEmail() {
		
		String email = "vilma.souza@teste.com";
		when(port.existsByEmail(email)).thenReturn(false);
		
		service.existsByEmail(email);

		verify(port).existsByEmail(email);
		
	}
	
	@Test
	void testExistsByLogin() {
		
		String login = "vilsou";
		when(port.existsByLogin(login)).thenReturn(false);
		
		service.existsByLogin(login);

		verify(port).existsByLogin(login);
		
	}
	
	@Test
	void testExistsByEmail_EmailAlreadyExistsException() {
		
		String email = "vilma.souza@teste.com";
		when(port.existsByEmail(email)).thenReturn(true);
		
		;
		EmailAlreadyExistsException exception = assertThrows(EmailAlreadyExistsException.class, 
				() -> service.existsByEmail(email));

		verify(port).existsByEmail(email);
		assertNotNull(exception);

	}
	
	@Test
	void testExistsByLogin_LoginAlreadyExistsException() {
		
		String login = "vilsou";
		when(port.existsByLogin(login)).thenReturn(true);
		
		LoginAlreadyExistsException exception = assertThrows(LoginAlreadyExistsException.class, 
				() -> service.existsByLogin(login));

		verify(port).existsByLogin(login);
		assertNotNull(exception);

	}

}
