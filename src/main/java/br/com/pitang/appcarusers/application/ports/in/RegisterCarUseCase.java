package br.com.pitang.appcarusers.application.ports.in;

import br.com.pitang.appcarusers.application.domain.cars.Car;

public interface RegisterCarUseCase {

	Car register(Car car);
}
