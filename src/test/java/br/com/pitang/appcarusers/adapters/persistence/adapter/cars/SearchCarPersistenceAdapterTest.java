package br.com.pitang.appcarusers.adapters.persistence.adapter.cars;

import static org.junit.Assert.assertNotNull;
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

import br.com.pitang.appcarusers.adapters.persistence.entity.CarEntity;
import br.com.pitang.appcarusers.adapters.persistence.service.cars.ICarService;
import br.com.pitang.appcarusers.application.domain.cars.Car;
import br.com.pitang.appcarusers.testdata.CarEntityTestData;

@ExtendWith(SpringExtension.class)
class SearchCarPersistenceAdapterTest {
	
	@InjectMocks
	private SearchCarPersistenceAdapter adapter;

	@Mock
	private ICarService service;

	@Test
	void testSearchAll() {
		List<CarEntity> entities = new ArrayList<>();
		entities.add(CarEntityTestData.getCarEntity());
		when(service.findAll()).thenReturn(entities);
		
		List<Car> response = adapter.searchAll();
		
		verify(service).findAll();
		assertNotNull(response);
		
	}
	
	@Test
	void testSearchById() {
		Long id = 1234l;
		when(service.findById(id)).thenReturn(CarEntityTestData.getOptionalCarEntity());
		
		Optional<Car> response = adapter.searchById(id);
		
		verify(service).findById(id);
		assertNotNull(response.get());
		
	}

}
