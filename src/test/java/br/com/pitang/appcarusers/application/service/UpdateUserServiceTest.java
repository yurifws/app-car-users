package br.com.pitang.appcarusers.application.service;

import static org.junit.Assert.assertNotNull;
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
import br.com.pitang.appcarusers.application.ports.out.UpdateUserPort;
import br.com.pitang.appcarusers.common.exception.EmailAlreadyExistsException;
import br.com.pitang.appcarusers.common.exception.LoginAlreadyExistsException;
import br.com.pitang.appcarusers.testdata.UserTestData;

@ExtendWith(SpringExtension.class)
class UpdateUserServiceTest {
	
	@InjectMocks
	private UpdateUserService service;

	@Mock
	private UpdateUserPort port;
	
	@Mock
	private ValidateUserUseCase validateUserUseCase;

	@Test
	void testUpdate() {
		
		User user = UserTestData.getUser();
		user.setId(null);
		Long id = 1234l;
		doNothing().when(validateUserUseCase).existsByEmail(user.getEmail());
		doNothing().when(validateUserUseCase).existsByLogin(user.getLogin());
		when(port.update(user, id)).thenReturn(UserTestData.getUser());
		
		User response = service.update(user, id);
		
		verify(validateUserUseCase).existsByEmail(user.getEmail());
		verify(validateUserUseCase).existsByLogin(user.getLogin());
		verify(port).update(user, id);
		assertNotNull(response);
	}
	
	@Test
	void testUpdate_EmailAlreadyExistsException() {
		
		User user = UserTestData.getUser();
		user.setId(null);
		Long id = 1234l;
		doThrow(new EmailAlreadyExistsException("")).when(validateUserUseCase).existsByEmail(user.getEmail());
		
		EmailAlreadyExistsException exception = assertThrows(EmailAlreadyExistsException.class, 
				() -> service.update(user, id));
		
		assertNotNull(exception);
		verify(validateUserUseCase, times(1)).existsByEmail(user.getEmail());
		verify(validateUserUseCase, times(0)).existsByLogin(user.getLogin());
		verifyNoInteractions(port);
	}
	
	@Test
	void testUpdate_LoginAlreadyExistsException() {
		
		User user = UserTestData.getUser();
		user.setId(null);
		Long id = 1234l;
		doNothing().when(validateUserUseCase).existsByEmail(user.getEmail());
		doThrow(new LoginAlreadyExistsException("")).when(validateUserUseCase).existsByLogin(user.getLogin());
		
		LoginAlreadyExistsException exception = assertThrows(LoginAlreadyExistsException.class, 
				() -> service.update(user, id));
		
		assertNotNull(exception);
		verify(validateUserUseCase, times(1)).existsByEmail(user.getEmail());
		verify(validateUserUseCase, times(1)).existsByLogin(user.getLogin());
		verifyNoInteractions(port);
	}

}
