package br.com.pitang.appcarusers.application.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.pitang.appcarusers.application.ports.out.SearchCarPort;

@ExtendWith(SpringExtension.class)
class SearchCarServiceTest {
	
	@InjectMocks
	private SearchCarService service;
	
	@Mock
	private SearchCarPort port;

//	@Test
//	void testSearchAll() {
//		List<Car> cars = new ArrayList<>();
//		cars.add(CarTestData.getCar());
//
//		when(port.search).thenReturn(cars);
//		
//		List<Car> response = service.searchAllByUserId();
//
//		verify(port).searchAll();
//		assertNotNull(response);
//	}
//	
//	@Test
//	void testSearchById() {
//		
//		Long id = 1234l;
//		when(port.searchById(id)).thenReturn(CarTestData.getOptionalCar());
//		
//		Car response = service.searchById(id);
//		
//		verify(port).searchById(id);
//		assertNotNull(response);
//	}
//	
//	@Test
//	void testSearchById_butCarNotFound() {
//		
//		Long id = 1234l;
//		when(port.searchById(id)).thenReturn(Optional.empty());
//		
//		Car response = service.searchById(id);
//		
//		verify(port).searchById(id);
//		assertNull(response);
//	}

}
