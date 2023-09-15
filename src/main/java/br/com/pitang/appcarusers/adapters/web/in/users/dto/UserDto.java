package br.com.pitang.appcarusers.adapters.web.in.users.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.pitang.appcarusers.application.domain.cars.Car;
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
public class UserDto {

	private String firstName;
	private String lastName;
	private String email;
	private Date birthday;
	private String login;
	private String password;
	private String phone;
	private List<Car> cars;
}
