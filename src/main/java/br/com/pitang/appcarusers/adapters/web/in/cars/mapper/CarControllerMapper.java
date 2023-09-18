package br.com.pitang.appcarusers.adapters.web.in.cars.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import br.com.pitang.appcarusers.adapters.web.in.cars.dto.CarRequestDto;
import br.com.pitang.appcarusers.adapters.web.in.cars.dto.CarResponseDto;
import br.com.pitang.appcarusers.application.domain.cars.Car;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface CarControllerMapper {

	CarControllerMapper INSTANCE = Mappers.getMapper(CarControllerMapper.class);

	public Car toCar(CarRequestDto carDto);
	public CarResponseDto toCarReponseDto(Car car);

	public List<CarResponseDto> toCarsResponseDto(List<Car> cars);
}
