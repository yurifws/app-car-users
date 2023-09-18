package br.com.pitang.appcarusers.adapters.web.in.cars.mapper;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.pitang.appcarusers.adapters.web.in.cars.dto.CarDto;
import br.com.pitang.appcarusers.application.domain.cars.Car;
import br.com.pitang.appcarusers.testdata.CarDtoTestData;
import br.com.pitang.appcarusers.testdata.CarTestData;

class CarControllerMapperTest {
	
	CarControllerMapper mapper = CarControllerMapper.INSTANCE;

	@Test
	void testToCar() {
		
		CarDto carDto = CarDtoTestData.getCarDto();
		Car car = mapper.toCar(carDto);
		
		assertNotNull(car);
		assertEquals(carDto.getYear(), car.getYear());
		assertEquals(carDto.getLicensePlate(), car.getLicensePlate());
		assertEquals(carDto.getModel(), car.getModel());
		assertEquals(carDto.getColor(), car.getColor());
	}
	

	@Test
	void testToCarDto() {
		
		Car car = CarTestData.getCar();
		CarDto carDto = mapper.toCarDto(car);
		
		assertNotNull(carDto);
		assertEquals(carDto.getYear(), car.getYear());
		assertEquals(carDto.getLicensePlate(), car.getLicensePlate());
		assertEquals(carDto.getModel(), car.getModel());
		assertEquals(carDto.getColor(), car.getColor());
	}
	
	@Test
	void testToCarsDto() {
		List<Car> cars = new ArrayList<>();
		cars.add(CarTestData.getCar());
		List<CarDto> carsDto = mapper.toCarsDto(cars);
		

		Car car = cars.get(0);
		CarDto carDto = carsDto.get(0);
		assertEquals(carDto.getYear(), car.getYear());
		assertEquals(carDto.getLicensePlate(), car.getLicensePlate());
		assertEquals(carDto.getModel(), car.getModel());
		assertEquals(carDto.getColor(), car.getColor());
		
	}

}
