package br.com.pitang.appcarusers.adapters.web.in.users;

import static br.com.pitang.appcarusers.adapters.web.in.users.mapper.UserControllerMapper.INSTANCE;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.BASE_PATH;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.USERS_BY_ID_ROUTE;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.USERS_ROUTE;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pitang.appcarusers.adapters.web.in.users.dto.UserDto;
import br.com.pitang.appcarusers.application.service.SearchUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RestController
@RequestMapping(BASE_PATH)
@Validated
public class SearchUserController {

	private static final String USER_ID = "user_id";
	
	private final SearchUserService useCase;

	@GetMapping(path=USERS_ROUTE, produces = MediaType.APPLICATION_JSON_VALUE )
	public List<UserDto> search() {
		return INSTANCE.toUsersDto(useCase.searchAll());
	}
	
	@GetMapping(path=USERS_BY_ID_ROUTE, produces = MediaType.APPLICATION_JSON_VALUE )
	public List<UserDto> search(@PathVariable(value = USER_ID) Long id) {
		return INSTANCE.toUsersDto(useCase.searchAll());
	}
	
}
