package br.com.pitang.appcarusers.adapters.persistence.adapter.cars;

import org.springframework.stereotype.Component;

import br.com.pitang.appcarusers.adapters.persistence.service.cars.ICarService;
import br.com.pitang.appcarusers.application.ports.out.RemoveCarPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class RemoveCarPersistenceAdapter implements RemoveCarPort {

	private final ICarService service;
	
	@Override
	public void removeById(Long id) {
		service.removeById(id);
	}

}
