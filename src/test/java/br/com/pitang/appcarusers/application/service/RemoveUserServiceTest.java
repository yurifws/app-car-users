package br.com.pitang.appcarusers.application.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.pitang.appcarusers.application.ports.in.SearchUserUseCase;
import br.com.pitang.appcarusers.application.ports.out.RemoveUserPort;
import br.com.pitang.appcarusers.testdata.UserTestData;

@ExtendWith(SpringExtension.class)
class RemoveUserServiceTest {
	
	@InjectMocks
	private RemoveUserService service;

	@Mock
	private RemoveUserPort port;
	
	@Mock
	private SearchUserUseCase searchUserUseCase;

	@Test
	void testRemoveById() {

		Long id = 1234l;
		when(searchUserUseCase.searchById(id)).thenReturn(UserTestData.getUser());
		doNothing().when(port).removeById(id);
		
		service.removeById(id);
		
		verify(searchUserUseCase).searchById(id);
	}
	
	@Test
	void testRemoveById_butUserNotFound() {

		Long id = 1234l;
		when(searchUserUseCase.searchById(id)).thenReturn(null);
		
		service.removeById(id);
		
		verify(searchUserUseCase).searchById(id);
		verifyNoInteractions(port);
	}

}
