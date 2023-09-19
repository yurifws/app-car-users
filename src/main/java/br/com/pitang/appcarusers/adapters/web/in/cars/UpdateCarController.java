package br.com.pitang.appcarusers.adapters.web.in.cars;

import static br.com.pitang.appcarusers.adapters.web.in.cars.mapper.CarControllerMapper.INSTANCE;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.BASE_PATH;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.CARS_BY_ID_ROUTE;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.CAR_ID;

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

import br.com.pitang.appcarusers.adapters.web.in.cars.dto.CarRequestDto;
import br.com.pitang.appcarusers.adapters.web.in.cars.dto.CarResponseDto;
import br.com.pitang.appcarusers.application.ports.in.UpdateCarUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(BASE_PATH)
@Validated
public class UpdateCarController {

	private final UpdateCarUseCase useCase;
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping(path=CARS_BY_ID_ROUTE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	public CarResponseDto update(@Valid @RequestBody CarRequestDto carDto,
			@PathVariable(value = CAR_ID) Long id) {
		return INSTANCE.toCarReponseDto(useCase.update(INSTANCE.toCar(carDto), id));
	}
}
