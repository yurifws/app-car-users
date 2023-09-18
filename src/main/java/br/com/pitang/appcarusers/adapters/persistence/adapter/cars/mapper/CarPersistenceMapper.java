package br.com.pitang.appcarusers.adapters.persistence.adapter.cars.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import br.com.pitang.appcarusers.adapters.persistence.entity.CarEntity;
import br.com.pitang.appcarusers.application.domain.cars.Car;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface CarPersistenceMapper {

	CarPersistenceMapper INSTANCE = Mappers.getMapper(CarPersistenceMapper.class);

	CarEntity toCarEntity(Car car);
	Car toCar(CarEntity carEntity);

	List<Car> toCars(List<CarEntity> carEntities);

	@Mapping(target = "id", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void update(@MappingTarget CarEntity carEntity, Car car);
	
}
