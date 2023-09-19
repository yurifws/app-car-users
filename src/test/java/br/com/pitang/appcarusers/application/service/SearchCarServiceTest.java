package br.com.pitang.appcarusers.application.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
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

import br.com.pitang.appcarusers.application.domain.cars.Car;
import br.com.pitang.appcarusers.application.ports.out.SearchCarPort;
import br.com.pitang.appcarusers.testdata.CarTestData;

@ExtendWith(SpringExtension.class)
class SearchCarServiceTest {
	
	@InjectMocks
	private SearchCarService service;
	
	@Mock
	private SearchCarPort port;

	@Test
	void testSearchAll() {
		List<Car> cars = new ArrayList<>();
		cars.add(CarTestData.getCar());

		when(port.searchAll()).thenReturn(cars);
		
		List<Car> response = service.searchAll();

		verify(port).searchAll();
		assertNotNull(response);
	}
	
	@Test
	void testSearchById() {
		
		Long id = 1234l;
		when(port.searchById(id)).thenReturn(CarTestData.getOptionalCar());
		
		Car response = service.searchById(id);
		
		verify(port).searchById(id);
		assertNotNull(response);
	}
	
	@Test
	void testSearchById_butCarNotFound() {
		
		Long id = 1234l;
		when(port.searchById(id)).thenReturn(Optional.empty());
		
		Car response = service.searchById(id);
		
		verify(port).searchById(id);
		assertNull(response);
	}

}
