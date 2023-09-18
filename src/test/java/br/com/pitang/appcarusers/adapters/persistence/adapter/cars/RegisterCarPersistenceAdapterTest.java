package br.com.pitang.appcarusers.adapters.persistence.adapter.cars;

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

import br.com.pitang.appcarusers.adapters.persistence.entity.CarEntity;
import br.com.pitang.appcarusers.adapters.persistence.service.cars.ICarService;
import br.com.pitang.appcarusers.application.domain.cars.Car;
import br.com.pitang.appcarusers.testdata.CarEntityTestData;
import br.com.pitang.appcarusers.testdata.CarTestData;

@ExtendWith(SpringExtension.class)
class RegisterCarPersistenceAdapterTest {

	@InjectMocks
	private RegisterCarPersistenceAdapter adapter;

	@Mock
	private ICarService service;
	
	@Captor
	private ArgumentCaptor<CarEntity> argumentCaptorCarEntity;

	@Test
	void testRegister() {

		when(service.save(argumentCaptorCarEntity.capture())).thenReturn(CarEntityTestData.getCarEntity());

		Car car = CarTestData.getCar();
		car.setId(null);
		
		Car response = adapter.register(car);
		
		verify(service).save(argumentCaptorCarEntity.getValue());
		
		assertNotNull(response);
		
	}

}
