package br.com.pitang.appcarusers.adapters.auth.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;

import br.com.pitang.appcarusers.adapters.persistence.entity.UserEntity;
import br.com.pitang.appcarusers.common.exception.UnauthorizedInvalidSessionException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TokenService {

	@Value("${algorithm.secret}")
	private String secret;

	public String generateToken(UserEntity userEntity) throws UsernameNotFoundException {
		return JWT.create()
				.withIssuer("Cars")
				.withSubject(userEntity.getLogin())
				.withClaim("id", userEntity.getId())
				.withExpiresAt(LocalDateTime.now()
						.plusSeconds(60)
						.toInstant(ZoneOffset.of("-03:00")))
				.sign(Algorithm.HMAC256(secret));

	}


	public String getSubject(String token) {
		try {
			return JWT.require(Algorithm.HMAC256(secret))
					.withIssuer("Cars")
					.build()
					.verify(token)
					.getSubject();
			
		}catch (TokenExpiredException e) {
			throw new UnauthorizedInvalidSessionException("Unauthorized - invalid session");
		}
	}

}
