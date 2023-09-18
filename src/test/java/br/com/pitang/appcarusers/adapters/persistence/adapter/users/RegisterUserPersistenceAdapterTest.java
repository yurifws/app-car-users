package br.com.pitang.appcarusers.adapters.persistence.adapter.users;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.pitang.appcarusers.adapters.persistence.entity.UserEntity;
import br.com.pitang.appcarusers.adapters.persistence.service.users.IUserService;
import br.com.pitang.appcarusers.application.domain.users.User;
import br.com.pitang.appcarusers.testdata.UserEntityTestData;
import br.com.pitang.appcarusers.testdata.UserTestData;

@ExtendWith(SpringExtension.class)
class RegisterUserPersistenceAdapterTest {

	@InjectMocks
	RegisterUserPersistenceAdapter adapter;

	@Mock
	private IUserService service;
	
	@Captor
	private ArgumentCaptor<UserEntity> argumentCaptorUserEntity;

	@Test
	void testRegister() {

		when(service.save(argumentCaptorUserEntity.capture())).thenReturn(UserEntityTestData.getUserEntity());

		User user = UserTestData.getUser();
		user.setId(null);
		
		User response = adapter.register(user);
		
		verify(service).save(argumentCaptorUserEntity.getValue());
		
		assertNotNull(response);
		
	}

}
