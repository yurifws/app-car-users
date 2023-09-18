package br.com.pitang.appcarusers.adapters.web.in.cars;

import static br.com.pitang.appcarusers.adapters.web.in.cars.mapper.CarControllerMapper.INSTANCE;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.BASE_PATH;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.CARS_ROUTE;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.pitang.appcarusers.adapters.web.in.cars.dto.CarRequestDto;
import br.com.pitang.appcarusers.adapters.web.in.cars.dto.CarResponseDto;
import br.com.pitang.appcarusers.application.ports.in.RegisterCarUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(BASE_PATH)
@Validated
public class RegisterCarController {

	private final RegisterCarUseCase useCase;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(path=CARS_ROUTE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	public CarResponseDto register(@Valid @RequestBody CarRequestDto carDto) {
		return INSTANCE.toCarReponseDto(useCase.register(INSTANCE.toCar(carDto)));
	}
}
