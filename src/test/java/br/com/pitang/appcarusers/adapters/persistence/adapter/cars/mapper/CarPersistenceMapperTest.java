package br.com.pitang.appcarusers.adapters.persistence.adapter.cars.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.pitang.appcarusers.adapters.persistence.entity.CarEntity;
import br.com.pitang.appcarusers.application.domain.cars.Car;
import br.com.pitang.appcarusers.testdata.CarEntityTestData;
import br.com.pitang.appcarusers.testdata.CarTestData;

class CarPersistenceMapperTest {

	CarPersistenceMapper mapper = CarPersistenceMapper.INSTANCE;
	
	@Test
	void testToCarEntity() {
		Car car = CarTestData.getCar();

		CarEntity carEntity = mapper.toCarEntity(car);

		assertNotNull(carEntity);
		assertEquals(car.getId(), carEntity.getId());
		assertEquals(car.getYear(), carEntity.getYear());
		assertEquals(car.getLicensePlate(), carEntity.getLicensePlate());
		assertEquals(car.getModel(), carEntity.getModel());
		assertEquals(car.getColor(), carEntity.getColor());
		
	}
	
	@Test
	void testToCar() {
		CarEntity carEntity = CarEntityTestData.getCarEntity();

		Car car = mapper.toCar(carEntity);

		assertNotNull(car);
		assertEquals(carEntity.getId(), car.getId());
		assertEquals(carEntity.getYear(), car.getYear());
		assertEquals(carEntity.getLicensePlate(), car.getLicensePlate());
		assertEquals(carEntity.getModel(), car.getModel());
		assertEquals(carEntity.getColor(), car.getColor());
		
	}
	
	@Test
	void testToCars() {
		List<CarEntity> carEntities = new ArrayList<>();
		carEntities.add(CarEntityTestData.getCarEntity());

		List<Car> cars = mapper.toCars(carEntities);
		CarEntity carEntity = carEntities.get(0);
		Car car = cars.get(0);
		assertEquals(carEntity.getId(), car.getId());
		assertEquals(carEntity.getYear(), car.getYear());
		assertEquals(carEntity.getLicensePlate(), car.getLicensePlate());
		assertEquals(carEntity.getModel(), car.getModel());
		assertEquals(carEntity.getColor(), car.getColor());
		
	}
	
	@Test
	void testUpdate() {
		CarEntity carEntity = CarEntityTestData.getCarEntity();
		Car car = CarTestData.getCarUpdate();
		
		mapper.update(carEntity, car);

		assertEquals(carEntity.getId(), car.getId());
		assertEquals(carEntity.getYear(), car.getYear());
		assertEquals(carEntity.getLicensePlate(), car.getLicensePlate());
		assertEquals(carEntity.getModel(), car.getModel());
		assertEquals(carEntity.getColor(), car.getColor());
		
	}
}
