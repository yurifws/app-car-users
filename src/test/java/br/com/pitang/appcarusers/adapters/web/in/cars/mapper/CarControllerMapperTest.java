package br.com.pitang.appcarusers.adapters.web.in.cars.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.pitang.appcarusers.adapters.web.in.cars.dto.CarRequestDto;
import br.com.pitang.appcarusers.adapters.web.in.cars.dto.CarResponseDto;
import br.com.pitang.appcarusers.application.domain.cars.Car;
import br.com.pitang.appcarusers.testdata.CarDtoTestData;
import br.com.pitang.appcarusers.testdata.CarTestData;

class CarControllerMapperTest {
	
	CarControllerMapper mapper = CarControllerMapper.INSTANCE;

	@Test
	void testToCar() {
		
		CarRequestDto carRequestDto = CarDtoTestData.getCarDto();
		Car car = mapper.toCar(carRequestDto);
		
		assertNotNull(car);
		assertEquals(carRequestDto.getYear(), car.getYear());
		assertEquals(carRequestDto.getLicensePlate(), car.getLicensePlate());
		assertEquals(carRequestDto.getModel(), car.getModel());
		assertEquals(carRequestDto.getColor(), car.getColor());
	}
	

	@Test
	void testToCarDto() {
		
		Car car = CarTestData.getCar();
		CarResponseDto carResponseDto = mapper.toCarReponseDto(car);
		
		assertNotNull(carResponseDto);
		assertEquals(carResponseDto.getYear(), car.getYear());
		assertEquals(carResponseDto.getLicensePlate(), car.getLicensePlate());
		assertEquals(carResponseDto.getModel(), car.getModel());
		assertEquals(carResponseDto.getColor(), car.getColor());
	}
	
	@Test
	void testToCarsDto() {
		List<Car> cars = new ArrayList<>();
		cars.add(CarTestData.getCar());
		List<CarResponseDto> carsResponseDto = mapper.toCarsResponseDto(cars);
		

		Car car = cars.get(0);
		CarResponseDto carResponseDto = carsResponseDto.get(0);
		assertEquals(carResponseDto.getYear(), car.getYear());
		assertEquals(carResponseDto.getLicensePlate(), car.getLicensePlate());
		assertEquals(carResponseDto.getModel(), car.getModel());
		assertEquals(carResponseDto.getColor(), car.getColor());
		
	}

}
