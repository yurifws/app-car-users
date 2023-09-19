package br.com.pitang.appcarusers.adapters.persistence.adapter.cars;

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
	void testSearchAllByUserId() {
		List<CarEntity> entities = new ArrayList<>();
		entities.add(CarEntityTestData.getCarEntityByUser());
		Long userId = entities.get(0).getUser().getId();
		when(service.findAllByUserId(userId)).thenReturn(entities);
		
		List<Car> response = adapter.searchAllByUserId(userId);
		
		verify(service).findAllByUserId(userId);
		assertNotNull(response);
		
	}
	
	@Test
	void testSearchByIdAndUserId() {
		Optional<CarEntity> optionalCarEntityByUser = CarEntityTestData.getOptionalCarEntityByUser();
		Long id = optionalCarEntityByUser.get().getId();
		Long userId = optionalCarEntityByUser.get().getUser().getId();
		when(service.findByIdAndUserId(id, userId)).thenReturn(optionalCarEntityByUser);
		
		Optional<Car> response = adapter.searchByIdAndUserId(id, userId);
		
		verify(service).findByIdAndUserId(id, userId);
		assertNotNull(response.get());
		
	}

}
