package br.com.pitang.appcarusers.application.service;

import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;

import org.springframework.stereotype.Component;

import br.com.pitang.appcarusers.application.ports.in.RemoveUserUseCase;
import br.com.pitang.appcarusers.application.ports.out.RemoveUserPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class RemoveUserService implements RemoveUserUseCase {

	private final RemoveUserPort port;
	private final SearchUserService searchUserService;
	
	@Override
	public void removeById(Long id) {
		if(isNotEmpty(searchUserService.searchById(id))) {
			port.removeById(id);
		}
	}

}
