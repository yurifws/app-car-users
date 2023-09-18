package br.com.pitang.appcarusers.application.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.pitang.appcarusers.application.domain.users.User;
import br.com.pitang.appcarusers.application.ports.out.SearchUserPort;
import br.com.pitang.appcarusers.testdata.UserTestData;

@ExtendWith(SpringExtension.class)
class SearchUserServiceTest {
	
	@InjectMocks
	private SearchUserService service;
	
	@Mock
	private SearchUserPort port;

	@Test
	void testSearchAll() {
		List<User> users = new ArrayList<>();
		users.add(UserTestData.getUser());

		when(port.searchAll()).thenReturn(users);
		
		List<User> response = service.searchAll();

		verify(port).searchAll();
		assertNotNull(response);
	}
	
	@Test
	void testSearchById() {
		
		Long id = 1234l;
		when(port.searchById(id)).thenReturn(UserTestData.getOptionalUser());
		
		User response = service.searchById(id);
		
		verify(port).searchById(id);
		assertNotNull(response);
	}
	
	@Test
	void testSearchById_butUserNotFound() {
		
		Long id = 1234l;
		when(port.searchById(id)).thenReturn(Optional.empty());
		
		User response = service.searchById(id);
		
		verify(port).searchById(id);
		assertNull(response);
	}

}
