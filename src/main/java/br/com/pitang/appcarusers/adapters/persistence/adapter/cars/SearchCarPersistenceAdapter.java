package br.com.pitang.appcarusers.adapters.persistence.adapter.cars;

import static br.com.pitang.appcarusers.adapters.persistence.adapter.cars.mapper.CarPersistenceMapper.INSTANCE;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.pitang.appcarusers.adapters.persistence.entity.CarEntity;
import br.com.pitang.appcarusers.adapters.persistence.service.cars.ICarService;
import br.com.pitang.appcarusers.application.domain.cars.Car;
import br.com.pitang.appcarusers.application.ports.out.SearchCarPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class SearchCarPersistenceAdapter implements SearchCarPort {

	private final ICarService service;
	
	@Override
	public List<Car> searchAll() {
		return INSTANCE.toCars(service.findAll());
	}

	@Override
	public Optional<Car> searchById(Long id) {
		Optional<CarEntity> optionalCarEntity = service.findById(id);
		if(optionalCarEntity.isPresent()) {
			return Optional.of(INSTANCE.toCar(optionalCarEntity.get()));
		}
		return Optional.empty();
	}

}
