package br.com.pitang.appcarusers.adapters.persistence.service.users;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.pitang.appcarusers.adapters.persistence.entity.UserEntity;
import br.com.pitang.appcarusers.adapters.persistence.repository.UserRepository;
import br.com.pitang.appcarusers.testdata.UserEntityTestData;

@ExtendWith(SpringExtension.class)
class UserServiceTest {
	
	@InjectMocks
	private UserService service;
	
	@Mock
	private UserRepository repository;

	@Test
	void testSave() {
		
		UserEntity userEntity = UserEntityTestData.getUserEntity();
		userEntity.setId(null);
		when(repository.save(userEntity)).thenReturn(UserEntityTestData.getUserEntity());
		
		UserEntity response = service.save(userEntity);
		
		verify(repository).save(userEntity);
		assertNotNull(response);
		
	}
	

	@Test
	void testFindAll() {
		
		List<UserEntity> entities = Arrays.asList(UserEntityTestData.getUserEntity());
		when(repository.findAll()).thenReturn(entities);
		
		List<UserEntity> response = service.findAll();
		
		verify(repository).findAll();
		assertNotNull(response);
	}
	

	@Test
	void testFindById() {
		
		Long id = 1234l;
		when(repository.findById(id)).thenReturn(UserEntityTestData.getOptionalUserEntity());
		
		Optional<UserEntity> response = service.findById(id);
		
		verify(repository).findById(id);
		assertNotNull(response.get());
	}
	
	@Test
	void testRemoveById() {
		
		Long id = 1234l;
		doNothing().when(repository).deleteById(id);
		
		service.removeById(id);
		
		verify(repository).deleteById(id);
	}

	@Test
	void testExistsByEmail() {
	
		String email = "vilma.souza@teste.com";
		when(repository.existsByEmail(email)).thenReturn(true);
		
		boolean response = service.existsByEmail(email);
		
		verify(repository).existsByEmail(email);
		assertTrue(response);
	}

	@Test
	void testExistsByLogin() {
		
		String login = "vilsou";
		when(repository.existsByLogin(login)).thenReturn(true);
		
		boolean response = service.existsByLogin(login);
		
		verify(repository).existsByLogin(login);
		assertTrue(response);
	}

}
