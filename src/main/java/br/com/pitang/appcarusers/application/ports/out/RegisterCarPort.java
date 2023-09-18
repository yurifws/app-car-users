package br.com.pitang.appcarusers.application.ports.out;

import br.com.pitang.appcarusers.application.domain.cars.Car;

public interface RegisterCarPort {

	Car register(Car car);

}
