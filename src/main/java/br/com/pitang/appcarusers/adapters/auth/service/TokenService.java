package br.com.pitang.appcarusers.adapters.auth.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.pitang.appcarusers.adapters.persistence.entity.UserEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TokenService {

	public String generateToken(UserEntity userEntity) throws UsernameNotFoundException {
		return JWT.create()
				.withIssuer("Car")
				.withSubject(userEntity.getLogin())
				.withClaim("id", userEntity.getId())
				.withExpiresAt(LocalDateTime.now().plusMinutes(15).toInstant(ZoneOffset.of("-03:00")))
				.sign(Algorithm.HMAC256("secret"));
				
	}

}
