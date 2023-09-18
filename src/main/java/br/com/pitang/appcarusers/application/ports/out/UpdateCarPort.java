package br.com.pitang.appcarusers.application.ports.out;

import br.com.pitang.appcarusers.application.domain.cars.Car;

public interface UpdateCarPort {

	Car update(Car car, Long id);
}
