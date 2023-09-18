package br.com.pitang.appcarusers.adapters.persistence.adapter.cars;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.pitang.appcarusers.adapters.persistence.service.cars.ICarService;

@ExtendWith(SpringExtension.class)
class ValidateCarPersistenceAdapterTest {
	
	@InjectMocks
	private ValidateCarPersistenceAdapter adapter;

	@Mock
	private ICarService service;

	@Test
	void testExistsByEmail() {
		String licensePlate = "PDV-2010";
		when(service.existsByLicensePlate(licensePlate)).thenReturn(true);
		
		boolean response = adapter.existsByLicensePlate(licensePlate);
		
		verify(service).existsByLicensePlate(licensePlate);
		assertTrue(response);
	}

}
