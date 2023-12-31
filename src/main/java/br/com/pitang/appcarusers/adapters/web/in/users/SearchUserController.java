package br.com.pitang.appcarusers.adapters.web.in.users;

import static br.com.pitang.appcarusers.adapters.web.in.users.mapper.UserControllerMapper.INSTANCE;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.BASE_PATH;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.USERS_BY_ID_ROUTE;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.USERS_ROUTE;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.USER_ID;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.pitang.appcarusers.adapters.web.in.users.dto.UserResponseDto;
import br.com.pitang.appcarusers.application.ports.in.SearchUserUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(BASE_PATH)
@Validated
public class SearchUserController {

	private final SearchUserUseCase useCase;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path=USERS_ROUTE, produces = MediaType.APPLICATION_JSON_VALUE )
	public List<UserResponseDto> search() {
		return INSTANCE.toUsersResponseDtoDto(useCase.searchAll());
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path=USERS_BY_ID_ROUTE, produces = MediaType.APPLICATION_JSON_VALUE )
	public UserResponseDto search(@PathVariable(value = USER_ID) Long id) {
		return INSTANCE.toUserResponseDto(useCase.searchById(id));
	}
	
}
