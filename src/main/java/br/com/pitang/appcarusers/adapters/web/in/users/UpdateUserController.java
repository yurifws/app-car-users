package br.com.pitang.appcarusers.adapters.web.in.users;

import static br.com.pitang.appcarusers.adapters.web.in.users.mapper.UserControllerMapper.INSTANCE;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.BASE_PATH;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.USERS_BY_ID_ROUTE;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.USER_ID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.pitang.appcarusers.adapters.web.in.users.dto.UserDto;
import br.com.pitang.appcarusers.application.ports.in.UpdateUserUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(BASE_PATH)
@Validated
public class UpdateUserController {

	private final UpdateUserUseCase useCase;
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping(path=USERS_BY_ID_ROUTE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	public UserDto update(@Valid @RequestBody UserDto userDto,
			@PathVariable(value = USER_ID) Long id) {
		return INSTANCE.toUserDto(useCase.update(INSTANCE.toUser(userDto), id));
	}
}
