package br.com.pitang.appcarusers.adapters.web.in.cars.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import br.com.pitang.appcarusers.adapters.web.in.cars.dto.CarDto;
import br.com.pitang.appcarusers.application.domain.cars.Car;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface CarControllerMapper {

	CarControllerMapper INSTANCE = Mappers.getMapper(CarControllerMapper.class);

	public Car toCar(CarDto carDto);
	public CarDto toCarDto(Car car);

	public List<CarDto> toCarsDto(List<Car> cars);
}
