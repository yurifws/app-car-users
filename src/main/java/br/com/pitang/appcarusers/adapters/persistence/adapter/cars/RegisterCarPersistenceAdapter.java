package br.com.pitang.appcarusers.adapters.persistence.adapter.cars;

import static br.com.pitang.appcarusers.adapters.persistence.adapter.cars.mapper.CarPersistenceMapper.INSTANCE;

import org.springframework.stereotype.Component;

import br.com.pitang.appcarusers.adapters.persistence.service.cars.ICarService;
import br.com.pitang.appcarusers.application.domain.cars.Car;
import br.com.pitang.appcarusers.application.ports.out.RegisterCarPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class RegisterCarPersistenceAdapter implements RegisterCarPort {

	private final ICarService service;

	@Override
	public Car register(Car car) {
		return INSTANCE.toCar(service.save(INSTANCE.toCarEntity(car)));
	}

}
