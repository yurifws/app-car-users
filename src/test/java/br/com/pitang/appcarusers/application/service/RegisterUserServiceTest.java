package br.com.pitang.appcarusers.application.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.pitang.appcarusers.application.domain.users.User;
import br.com.pitang.appcarusers.application.ports.in.ValidateUserUseCase;
import br.com.pitang.appcarusers.application.ports.out.RegisterUserPort;
import br.com.pitang.appcarusers.common.exception.EmailAlreadyExistsException;
import br.com.pitang.appcarusers.common.exception.LoginAlreadyExistsException;
import br.com.pitang.appcarusers.testdata.UserTestData;

@ExtendWith(SpringExtension.class)
class RegisterUserServiceTest {
	
	@InjectMocks
	private RegisterUserService service;
	
	@Mock
	private RegisterUserPort port;

	@Mock
	private ValidateUserUseCase validateUserUseCase;

	@Test
	void testRegister() {
		
		User user = UserTestData.getUser();
		user.setId(null);
		doNothing().when(validateUserUseCase).existsByEmail(user.getEmail());
		doNothing().when(validateUserUseCase).existsByLogin(user.getLogin());
		when(port.register(user)).thenReturn(UserTestData.getUser());
		
		User response = service.register(user);
		
		verify(validateUserUseCase).existsByEmail(user.getEmail());
		verify(validateUserUseCase).existsByLogin(user.getLogin());
		verify(port).register(user);
		assertNotNull(response);
	}
	
	@Test
	void testRegister_EmailAlreadyExistsException() {
		
		User user = UserTestData.getUser();
		user.setId(null);
		doThrow(new EmailAlreadyExistsException("")).when(validateUserUseCase).existsByEmail(user.getEmail());
		
		EmailAlreadyExistsException exception = assertThrows(EmailAlreadyExistsException.class, 
				() -> service.register(user));
		
		assertNotNull(exception);
		verify(validateUserUseCase, times(1)).existsByEmail(user.getEmail());
		verify(validateUserUseCase, times(0)).existsByLogin(user.getLogin());
		verifyNoInteractions(port);
	}
	
	@Test
	void testRegister_LoginAlreadyExistsException() {
		
		User user = UserTestData.getUser();
		user.setId(null);
		doNothing().when(validateUserUseCase).existsByEmail(user.getEmail());
		doThrow(new LoginAlreadyExistsException("")).when(validateUserUseCase).existsByLogin(user.getLogin());
		
		LoginAlreadyExistsException exception = assertThrows(LoginAlreadyExistsException.class, 
				() -> service.register(user));
		
		assertNotNull(exception);
		verify(validateUserUseCase, times(1)).existsByEmail(user.getEmail());
		verify(validateUserUseCase, times(1)).existsByLogin(user.getLogin());
		verifyNoInteractions(port);
	}

}
