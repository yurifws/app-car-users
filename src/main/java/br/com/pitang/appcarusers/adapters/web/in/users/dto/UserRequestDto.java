package br.com.pitang.appcarusers.adapters.web.in.users.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.pitang.appcarusers.adapters.web.in.cars.dto.CarRequestDto;
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
public class UserRequestDto {
	
	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@NotBlank
	private String email;

	@NotNull
	private LocalDate birthday;
	
	@NotBlank
	private String login;

	@NotBlank
	private String password;

	@NotBlank
	private String phone;
	private List<CarRequestDto> cars;

}
