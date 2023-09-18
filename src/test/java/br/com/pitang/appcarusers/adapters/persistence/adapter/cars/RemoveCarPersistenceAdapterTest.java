package br.com.pitang.appcarusers.adapters.persistence.adapter.cars;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.pitang.appcarusers.adapters.persistence.service.cars.ICarService;

@ExtendWith(SpringExtension.class)
class RemoveCarPersistenceAdapterTest {
	
	@InjectMocks
	private RemoveCarPersistenceAdapter adapter;

	@Mock
	private ICarService service;
	
	@Test
	void testRemoveById() {
		
		Long id = 123L;
		doNothing().when(service).removeById(id);
		
		adapter.removeById(id);
		
		verify(service).removeById(id);
	}

}
