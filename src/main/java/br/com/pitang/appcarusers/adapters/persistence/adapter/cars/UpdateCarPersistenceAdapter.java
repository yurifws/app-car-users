package br.com.pitang.appcarusers.adapters.persistence.adapter.cars;

import static br.com.pitang.appcarusers.adapters.persistence.adapter.cars.mapper.CarPersistenceMapper.INSTANCE;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.pitang.appcarusers.adapters.persistence.entity.CarEntity;
import br.com.pitang.appcarusers.adapters.persistence.service.cars.ICarService;
import br.com.pitang.appcarusers.application.domain.cars.Car;
import br.com.pitang.appcarusers.application.ports.out.UpdateCarPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class UpdateCarPersistenceAdapter implements UpdateCarPort {

	private final ICarService service;
	
	@Override
	public Car update(Car car, Long id) {
		Optional<CarEntity> optionalCar = service.findById(id);
		if(optionalCar.isPresent()) {
			CarEntity userEntity = optionalCar.get();
			INSTANCE.update(userEntity, car);
			return INSTANCE.toCar(service.save(userEntity));
		}
		return null;
	}

}
