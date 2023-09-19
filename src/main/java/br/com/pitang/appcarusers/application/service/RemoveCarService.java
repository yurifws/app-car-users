package br.com.pitang.appcarusers.application.service;

import org.springframework.stereotype.Component;

import br.com.pitang.appcarusers.application.ports.in.RemoveCarUseCase;
import br.com.pitang.appcarusers.application.ports.in.SearchUserUseCase;
import br.com.pitang.appcarusers.application.ports.out.RemoveCarPort;
import br.com.pitang.appcarusers.application.ports.out.SearchCarPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class RemoveCarService implements RemoveCarUseCase {

	private final RemoveCarPort port;
	private final SearchCarPort searchCarPort;
	private final SearchUserUseCase searchUserUseCase;
	
	@Override
	public void removeById(Long id) {
		if(searchCarPort.searchByIdAndUserId(id, searchUserUseCase.searchByLoggedUser().getId()).isPresent()) {
			port.removeById(id);
		}
	}
}
