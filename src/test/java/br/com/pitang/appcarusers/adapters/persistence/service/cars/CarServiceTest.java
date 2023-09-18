package br.com.pitang.appcarusers.adapters.persistence.service.cars;

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

import br.com.pitang.appcarusers.adapters.persistence.entity.CarEntity;
import br.com.pitang.appcarusers.adapters.persistence.repository.CarRepository;
import br.com.pitang.appcarusers.testdata.CarEntityTestData;

@ExtendWith(SpringExtension.class)
class CarServiceTest {
	
	@InjectMocks
	private CarService service;
	
	@Mock
	private CarRepository repository;

	@Test
	void testSave() {
		
		CarEntity carEntity = CarEntityTestData.getCarEntity();
		carEntity.setId(null);
		when(repository.save(carEntity)).thenReturn(CarEntityTestData.getCarEntity());
		
		CarEntity response = service.save(carEntity);
		
		verify(repository).save(carEntity);
		assertNotNull(response);
		
	}
	

	@Test
	void testFindAll() {
		
		List<CarEntity> entities = Arrays.asList(CarEntityTestData.getCarEntity());
		when(repository.findAll()).thenReturn(entities);
		
		List<CarEntity> response = service.findAll();
		
		verify(repository).findAll();
		assertNotNull(response);
	}
	

	@Test
	void testFindById() {
		
		Long id = 1234l;
		when(repository.findById(id)).thenReturn(CarEntityTestData.getOptionalCarEntity());
		
		Optional<CarEntity> response = service.findById(id);
		
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
	
		String licensePlate = "PDV-2010";
		when(repository.existsByLicensePlate(licensePlate)).thenReturn(true);
		
		boolean response = service.existsByLicensePlate(licensePlate);
		
		verify(repository).existsByLicensePlate(licensePlate);
		assertTrue(response);
	}

}
