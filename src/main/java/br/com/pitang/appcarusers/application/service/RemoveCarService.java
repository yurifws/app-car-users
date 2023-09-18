package br.com.pitang.appcarusers.application.service;

import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;

import org.springframework.stereotype.Component;

import br.com.pitang.appcarusers.application.ports.in.RemoveCarUseCase;
import br.com.pitang.appcarusers.application.ports.in.SearchCarUseCase;
import br.com.pitang.appcarusers.application.ports.out.RemoveCarPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class RemoveCarService implements RemoveCarUseCase {

	private final RemoveCarPort port;
	private final SearchCarUseCase searchCarUseCase;
	
	@Override
	public void removeById(Long id) {
		if(isNotEmpty(searchCarUseCase.searchById(id))) {
			port.removeById(id);
		}
	}
}
