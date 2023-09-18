package br.com.pitang.appcarusers.adapters.web.in.cars;

import static br.com.pitang.appcarusers.adapters.web.in.cars.mapper.CarControllerMapper.INSTANCE;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.BASE_PATH;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.CARS_BY_ID_ROUTE;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.CARS_ROUTE;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.CAR_ID;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.pitang.appcarusers.adapters.web.in.cars.dto.CarResponseDto;
import br.com.pitang.appcarusers.application.ports.in.SearchCarUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(BASE_PATH)
@Validated
public class SearchCarController {

	private final SearchCarUseCase useCase;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path=CARS_ROUTE, produces = MediaType.APPLICATION_JSON_VALUE )
	public List<CarResponseDto> search() {
		return INSTANCE.toCarsResponseDto(useCase.searchAll());
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path=CARS_BY_ID_ROUTE, produces = MediaType.APPLICATION_JSON_VALUE )
	public CarResponseDto search(@PathVariable(value = CAR_ID) Long id) {
		return INSTANCE.toCarReponseDto(useCase.searchById(id));
	}
}
