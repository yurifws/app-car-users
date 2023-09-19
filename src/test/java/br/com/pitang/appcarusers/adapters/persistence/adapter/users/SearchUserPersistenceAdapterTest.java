package br.com.pitang.appcarusers.adapters.persistence.adapter.users;

import static org.junit.jupiter.api.Assertions.assertNotNull;
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

import br.com.pitang.appcarusers.adapters.persistence.entity.UserEntity;
import br.com.pitang.appcarusers.adapters.persistence.service.users.IUserService;
import br.com.pitang.appcarusers.application.domain.users.User;
import br.com.pitang.appcarusers.testdata.UserEntityTestData;

@ExtendWith(SpringExtension.class)
class SearchUserPersistenceAdapterTest {
	
	@InjectMocks
	private SearchUserPersistenceAdapter adapter;

	@Mock
	private IUserService service;

	@Test
	void testSearchAll() {
		List<UserEntity> entities = new ArrayList<>();
		entities.add(UserEntityTestData.getUserEntity());
		when(service.findAll()).thenReturn(entities);
		
		List<User> response = adapter.searchAll();
		
		verify(service).findAll();
		assertNotNull(response);
		
	}
	
	@Test
	void testSearchById() {
		Long id = 1234l;
		when(service.findById(id)).thenReturn(UserEntityTestData.getOptionalUserEntity());
		
		Optional<User> response = adapter.searchById(id);
		
		verify(service).findById(id);
		assertNotNull(response.get());
		
	}

}
