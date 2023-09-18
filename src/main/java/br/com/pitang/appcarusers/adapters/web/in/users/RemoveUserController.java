package br.com.pitang.appcarusers.adapters.web.in.users;

import static br.com.pitang.appcarusers.adapters.web.routes.Routes.BASE_PATH;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.USERS_BY_ID_ROUTE;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.USER_ID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.pitang.appcarusers.application.ports.in.RemoveUserUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(BASE_PATH)
@Validated
public class RemoveUserController {
	
	private final RemoveUserUseCase useCase;

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(path=USERS_BY_ID_ROUTE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void remove(@PathVariable(value = USER_ID) Long id) {
		useCase.removeById(id);
	}
}
