package br.com.pitang.appcarusers.adapters.web.in.login;

import static br.com.pitang.appcarusers.adapters.web.routes.Routes.BASE_PATH;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.SIGNIN_ROUTE;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.pitang.appcarusers.adapters.auth.service.TokenService;
import br.com.pitang.appcarusers.adapters.persistence.entity.UserEntity;
import br.com.pitang.appcarusers.adapters.web.in.login.dto.LoginDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(BASE_PATH)
public class LoginController {
	
	private final AuthenticationManager authenticationManager;
	
	private final TokenService tokenService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(path=SIGNIN_ROUTE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String login(@Valid @RequestBody LoginDto loginDto) {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginDto.getLogin(), loginDto.getPassword());
		Authentication authenticate = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		
		UserEntity userEntity = (UserEntity) authenticate.getPrincipal();
		return tokenService.generateToken(userEntity);
	}
	

}
