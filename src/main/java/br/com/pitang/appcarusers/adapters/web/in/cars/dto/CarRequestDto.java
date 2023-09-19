package br.com.pitang.appcarusers.adapters.web.in.cars.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
public class CarRequestDto {

	@NotNull
	private Integer year;

	@NotBlank
	private String licensePlate;

	@NotBlank
	private String model;

	@NotBlank
	private String color;

}
	