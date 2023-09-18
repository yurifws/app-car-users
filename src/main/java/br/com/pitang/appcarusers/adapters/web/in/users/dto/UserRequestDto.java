package br.com.pitang.appcarusers.adapters.web.in.users.dto;

import java.time.LocalDate;
import java.util.List;

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

	private String firstName;
	private String lastName;
	private String email;
	private LocalDate birthday;
	private String login;
	private String password;
	private String phone;
	private List<CarRequestDto> cars;
}
