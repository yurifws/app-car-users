package br.com.pitang.appcarusers.application.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.pitang.appcarusers.application.ports.in.SearchCarUseCase;
import br.com.pitang.appcarusers.application.ports.out.RemoveCarPort;
import br.com.pitang.appcarusers.testdata.CarTestData;

@ExtendWith(SpringExtension.class)
class RemoveCarServiceTest {
	
	@InjectMocks
	private RemoveCarService service;

	@Mock
	private RemoveCarPort port;
	
	@Mock
	private SearchCarUseCase searchCarUseCase;

	@Test
	void testRemoveById() {

		Long id = 1234l;
		when(searchCarUseCase.searchById(id)).thenReturn(CarTestData.getCar());
		doNothing().when(port).removeById(id);
		
		service.removeById(id);
		
		verify(searchCarUseCase).searchById(id);
	}
	
	@Test
	void testRemoveById_butCarNotFound() {

		Long id = 1234l;
		when(searchCarUseCase.searchById(id)).thenReturn(null);
		
		service.removeById(id);
		
		verify(searchCarUseCase).searchById(id);
		verifyNoInteractions(port);
	}

}
