package br.com.pitang.appcarusers.adapters.web.in.cars;

import static br.com.pitang.appcarusers.adapters.web.routes.Routes.BASE_PATH;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.CARS_BY_ID_ROUTE;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.CAR_ID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.pitang.appcarusers.application.ports.in.RemoveCarUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(BASE_PATH)
@Validated
public class RemoveCarController {
	
	private final RemoveCarUseCase useCase;

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(path=CARS_BY_ID_ROUTE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void remove(@PathVariable(value = CAR_ID) Long id) {
		useCase.removeById(id);
	}
}
