package br.com.pitang.appcarusers.configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.pitang.appcarusers.adapters.auth.service.TokenService;
import br.com.pitang.appcarusers.adapters.persistence.entity.UserEntity;
import br.com.pitang.appcarusers.adapters.persistence.service.users.IUserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class FilterToken extends OncePerRequestFilter {

	private final TokenService tokenService;
	private final IUserService userService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String authorizationHeader = request.getHeader("Authorization");
		
		if(ObjectUtils.isNotEmpty(authorizationHeader)) {
			String token = authorizationHeader.replace("Bearer ", "");
			String subject = tokenService.getSubject(token);

			UserEntity userEntity = userService.findByLogin(subject);

			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
					new UsernamePasswordAuthenticationToken(userEntity, null, userEntity.getAuthorities());

			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		}

		filterChain.doFilter(request, response);
	}

}
