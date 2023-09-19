package br.com.pitang.appcarusers.application.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.pitang.appcarusers.application.domain.users.User;
import br.com.pitang.appcarusers.application.ports.in.SearchUserUseCase;
import br.com.pitang.appcarusers.application.ports.out.RemoveCarPort;
import br.com.pitang.appcarusers.application.ports.out.SearchCarPort;
import br.com.pitang.appcarusers.testdata.CarTestData;
import br.com.pitang.appcarusers.testdata.UserTestData;

@ExtendWith(SpringExtension.class)
class RemoveCarServiceTest {
	
	@InjectMocks
	private RemoveCarService service;

	@Mock
	private RemoveCarPort port;

	@Mock
	private SearchCarPort searchCarPort;

	@Mock
	private SearchUserUseCase searchUserUseCase;

	@Test
	void testRemoveById() {

		Long id = 1234l;
		User user = UserTestData.getUser();
		when(searchCarPort.searchByIdAndUserId(id, user.getId())).thenReturn(CarTestData.getOptionalCar());
		doNothing().when(port).removeById(id);
		when(searchUserUseCase.searchByLoggedUser()).thenReturn(user);
		
		service.removeById(id);
		
		verify(searchCarPort).searchByIdAndUserId(id, user.getId());
		verify(searchUserUseCase).searchByLoggedUser();
	}
	
	@Test
	void testRemoveById_butCarNotFound() {

		Long id = 1234l;
		User user = UserTestData.getUser();
		when(searchCarPort.searchByIdAndUserId(id, user.getId())).thenReturn(Optional.empty());
		doNothing().when(port).removeById(id);
		when(searchUserUseCase.searchByLoggedUser()).thenReturn(user);
		
		service.removeById(id);
		
		verify(searchCarPort).searchByIdAndUserId(id, user.getId());
		verifyNoInteractions(port);
	}

}
