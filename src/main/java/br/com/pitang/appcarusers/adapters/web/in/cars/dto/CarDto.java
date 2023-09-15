package br.com.pitang.appcarusers.adapters.web.in.cars.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.pitang.appcarusers.application.domain.users.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarDto {

	private Long id;
	private Integer year;
	private String licensePlate;
	private String model;
	private String color;
	private User user;

}
	