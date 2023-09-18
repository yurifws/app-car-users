package br.com.pitang.appcarusers.application.domain.users;

import java.time.LocalDate;
import java.util.List;

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
public class User {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private LocalDate birthday;
	private String login;
	private String password;
	private String phone;
	private List<Car> cars;

}
