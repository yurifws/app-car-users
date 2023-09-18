package br.com.pitang.appcarusers.adapters.web.in.cars;

import static br.com.pitang.appcarusers.adapters.web.routes.Routes.BASE_PATH;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.CARS_BY_ID_ROUTE;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.CARS_ROUTE;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.pitang.appcarusers.application.domain.cars.Car;
import br.com.pitang.appcarusers.application.ports.in.SearchCarUseCase;
import br.com.pitang.appcarusers.testdata.CarTestData;

@WebMvcTest(SearchCarController.class)
class SearchCarControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SearchCarUseCase useCase;
	
	@Test
	void testSearch() throws Exception {
		List<Car> cars = new ArrayList<>();
		
		Car car = CarTestData.getCar();
		car.setId(null);
		cars.add(car);
		
		when(useCase.searchAll()).thenReturn(cars);
		
		mockMvc.perform(MockMvcRequestBuilders.get(BASE_PATH + CARS_ROUTE)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	void testSearchById() throws Exception {

		Long id = 1234l;
		Car car = CarTestData.getCar();
		
		when(useCase.searchById(id)).thenReturn(car);
		
		mockMvc.perform(MockMvcRequestBuilders.get(BASE_PATH + CARS_BY_ID_ROUTE, id)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
