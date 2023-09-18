package br.com.pitang.appcarusers.adapters.persistence.adapter.users;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.pitang.appcarusers.adapters.persistence.service.users.IUserService;

@ExtendWith(SpringExtension.class)
class RemoveUserPersistenceAdapterTest {
	
	@InjectMocks
	private RemoveUserPersistenceAdapter adapter;

	@Mock
	private IUserService service;
	
	@Test
	void testRemoveById() {
		
		Long id = 1234l;
		doNothing().when(service).removeById(id);
		
		adapter.removeById(id);
		
		verify(service).removeById(id);
	}

}
